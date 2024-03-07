package xyz.eddie.weavecraft.common.spell.shape.shapes;

import xyz.eddie.weavecraft.common.entity.SpellEntity;
import xyz.eddie.weavecraft.common.registries.WeavecraftEntities;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.kinetic_formula.KineticFormula;
import xyz.eddie.weavecraft.common.spell.shape.SpellShape;

public class ProjectileSpellShape extends SpellShape {

    public void create(CastingContext ctx, SpellSequence sequence, float inaccuracy, float xAngle, float yAngle) {
        SpellEntity projectile = new SpellEntity(WeavecraftEntities.SPELL_ENTITY.get(), ctx.getLevel(), sequence, ctx, KineticFormula.LINEAR, ctx.getCaster().getEyePosition());
        projectile.shootFromRotation(ctx.getCaster(), ctx.getCaster().getXRot() + xAngle, ctx.getCaster().getYRot() + yAngle, 0.0F, 1, 1f + inaccuracy);
        ctx.getLevel().addFreshEntity(projectile);
        projectile.hurtMarked = true;
    }

}
