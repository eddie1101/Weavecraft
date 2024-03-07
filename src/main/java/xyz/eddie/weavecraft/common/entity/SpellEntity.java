package xyz.eddie.weavecraft.common.entity;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.SerializationUtils;
import xyz.eddie.weavecraft.common.registries.WeavecraftEntities;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.kinematic_profile.IKinematicProfile;

import static xyz.eddie.weavecraft.Weavecraft.LOGGER;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SpellEntity extends Projectile {

    private IKinematicProfile kineticFormula;

    private CastingContext ctx;
    private SpellSequence spellSequence;
    private boolean activated = false;
    private int castingTimestamp = 0;

    public SpellEntity(EntityType<SpellEntity> type, Level level, SpellSequence spellSequence, CastingContext ctx, IKinematicProfile kineticFormula, double x, double y, double z) {
        super(type, level);
        this.spellSequence = spellSequence;
        this.ctx = new CastingContext(ctx);
        this.kineticFormula = kineticFormula;
        this.setPos(x, y, z);
        castingTimestamp = tickCount;
        this.setOwner(this.ctx.getOriginalCaster());
        this.ctx.setCaster(this);
    }

    public SpellEntity(EntityType<SpellEntity> type, Level level, SpellSequence spellSequence, CastingContext ctx, IKinematicProfile kineticFormula, Vec3 pos) {
        this(type, level, spellSequence, ctx, kineticFormula, pos.x, pos.y, pos.z);
    }

    public SpellEntity(SpellEntity o) {
        super(WeavecraftEntities.SPELL_ENTITY.get(), o.level());
        this.kineticFormula = o.kineticFormula;
        this.ctx = o.ctx;
        this.spellSequence = o.spellSequence;
        this.activated = o.activated;
        this.castingTimestamp = o.castingTimestamp;
        this.ctx.setCaster(this);
    }

    private SpellEntity(EntityType<SpellEntity> type, Level level) {
        super(type, level);
        spellSequence = new SpellSequence();
    }

    public static SpellEntity getSpellEntityForRegistry(EntityType<SpellEntity> type, Level level) {
        return new SpellEntity(type, level);
    }

    @Override
    public void tick() {
        super.tick();

        this.setPos(this.position().add(this.getDeltaMovement()));

        if(!level().isClientSide) {

            HitResult hit = getImminentCollision(position(), position().add(getDeltaMovement()));
            if(hit != null) {
                onHit(hit);
            }

            if (getTimeAlive() > 200) {
                this.onHit(new EntityHitResult(this));
                activated = true;
            }

            ctx.setLocation(position());

            if (activated) {
                spellSequence.activate(ctx);
                this.discard();
            }

            this.addDeltaMovement(kineticFormula.calculateAcceleration(ctx));
        }

        Vec3 target = this.getDeltaMovement().normalize();
        Vec3 vec3 = EntityAnchorArgument.Anchor.FEET.apply(this);
        double d0 = target.x - vec3.x;
        double d1 = target.y - vec3.y;
        double d2 = target.z - vec3.z;
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        this.setXRot(Mth.wrapDegrees((float)(-(Mth.atan2(d1, d3) * 180.0 / 3.1415927410125732))));
        this.setYRot(Mth.wrapDegrees((float)(Mth.atan2(d2, d0) * 180.0 / 3.1415927410125732) - 90.0F));
        this.yRotO = this.getYRot();
        this.xRotO = this.getXRot();

    }

    public int getTimeAlive() {
        return tickCount - castingTimestamp;
    }

    public EntityHitResult findHitEntity(Vec3 pos, Vec3 vel) {
        return ProjectileUtil.getEntityHitResult(this.level(), this, pos, vel, this.getBoundingBox().expandTowards(vel).inflate(1.0), this::canHitEntity);
    }

    public HitResult getImminentCollision(Vec3 pos, Vec3 nextPos) {
        HitResult hitResult = this.level().clip(new ClipContext(pos, nextPos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        if (hitResult.getType() != HitResult.Type.MISS) {
            nextPos = hitResult.getLocation();
        }

        EntityHitResult entityHitResult = findHitEntity(this.position(), nextPos);
        if (entityHitResult != null) {
            hitResult = entityHitResult;
        }

        if (hitResult != null && hitResult.getType() == HitResult.Type.ENTITY) {
            Entity hitEntity = ((EntityHitResult) hitResult).getEntity();
            Entity ownerEntity = this.getOwner();
            if (hitEntity instanceof Player && ownerEntity instanceof Player && !((Player) ownerEntity).canHarmPlayer((Player) hitEntity) || this.ownedBy(hitEntity)) {
                hitResult = null;
            }
        }
        return hitResult;
    }

    @Override
    public void onHit(HitResult hit) {
        super.onHit(hit);
        if(hit.getType() != HitResult.Type.MISS) {
            ctx.addHit(hit);
            this.activated = true;
        }
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        double d0 = this.getBoundingBox().getSize();
        if (Double.isNaN(d0)) {
            d0 = 1.0;
        }

        d0 *= 512.0 * getViewScale();
        return distance < d0 * d0;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("timestamp", castingTimestamp);
        tag.putByteArray("spell", SerializationUtils.serialize(spellSequence));
        tag.putByteArray("kinetic", SerializationUtils.serialize(kineticFormula));
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        castingTimestamp = tag.getInt("timestamp");
        try {
            spellSequence = (SpellSequence) new ObjectInputStream(new ByteArrayInputStream(tag.getByteArray("spell"))).readObject();
            kineticFormula = (IKinematicProfile) new ObjectInputStream(new ByteArrayInputStream(tag.getByteArray("kinetic"))).readObject();
        } catch (IOException | RuntimeException | ClassNotFoundException e) {
            LOGGER.error("Could not load spell for spell entity:\n" + this);
            this.discard();
        }
        this.ctx = new CastingContext(getOwner(), this, level(), null, position());
    }

}
