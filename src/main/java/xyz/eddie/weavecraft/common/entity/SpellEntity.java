package xyz.eddie.weavecraft.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.registries.WeavecraftItems;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;

public class SpellEntity extends Projectile {

    private final SpellSequence spellSequence;
    private boolean activated = false;
    private int creationTimestamp = 0;

    public SpellEntity(EntityType<SpellEntity> type, Level level, SpellSequence spellSequence, double x, double y, double z) {
        super(type, level);
        this.spellSequence = spellSequence;
        this.setPos(x, y, z);
        creationTimestamp = tickCount;
    }

    public SpellEntity(EntityType<SpellEntity> type, Level level, SpellSequence spellSequence, Vec3 pos) {
        this(type, level, spellSequence, pos.x, pos.y, pos.z);
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

        if(tickCount - creationTimestamp > 100) {
            activated = true;
        }

        if(activated && !level().isClientSide()) {
            spellSequence.activate(new CastingContext(this, level(), new ItemStack(WeavecraftItems.PROKLITIA.get()), position()));
            this.discard();
        }
    }

    @Override
    protected void defineSynchedData() {

    }
}
