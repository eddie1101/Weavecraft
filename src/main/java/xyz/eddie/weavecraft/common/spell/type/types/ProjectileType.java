package xyz.eddie.weavecraft.common.spell.type.types;

import xyz.eddie.weavecraft.common.entity.SpellEntity;
import xyz.eddie.weavecraft.common.registries.WeavecraftEntities;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.kinematic_profile.IKinematicProfile;
import xyz.eddie.weavecraft.common.spell.type.ISpellType;

public class ProjectileType implements ISpellType {

    protected IKinematicProfile kp;
    public ProjectileType(IKinematicProfile kp) {
        this.kp = kp;
    }

    public void create(CastingContext ctx, ISpellEffect effect, float inaccuracy, float xAngle, float yAngle) {
        SpellEntity projectile = new SpellEntity(WeavecraftEntities.SPELL_ENTITY.get(), ctx.getLevel(), effect, ctx, kp, ctx.getCaster().getEyePosition());
        projectile.shootFromRotation(ctx.getCaster(), ctx.getCaster().getXRot() + xAngle, ctx.getCaster().getYRot() + yAngle, 0.0F, 0.5f, 1f + inaccuracy);
        ctx.getLevel().addFreshEntity(projectile);
        projectile.hurtMarked = true;
    }

}
