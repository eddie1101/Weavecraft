package xyz.eddie.weavecraft.common.spell.shape.shapes;

import xyz.eddie.weavecraft.common.entity.SpellEntity;
import xyz.eddie.weavecraft.common.registries.WeavecraftEntities;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.aspect.ExpulsiveAspect;
import xyz.eddie.weavecraft.common.spell.aspect.KineticAspect;
import xyz.eddie.weavecraft.common.spell.shape.SpellShape;

public class ProjectileSpellShape extends SpellShape {

    public ProjectileSpellShape() {
        super(25, 10);
    }

    public void create(CastingContext ctx, SpellSequence sequence, float inaccuracy, float xAngle, float yAngle) {
        SpellEntity projectile = new SpellEntity(WeavecraftEntities.SPELL_ENTITY.get(), ctx.getLevel(), sequence, ctx, KineticAspect.LINEAR, ExpulsiveAspect.NULL(), ctx.getLocation());
        projectile.shootFromRotation(ctx.getCaster(), ctx.getCaster().getXRot() + xAngle, ctx.getCaster().getYRot() + yAngle, 0.0F, 1, inaccuracy == 0 ? 0.01f : inaccuracy);
    }

}
