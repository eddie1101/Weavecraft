package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.modifier.SpellModifier;

public class PushSpellEffect extends SpellEffect {

    public PushSpellEffect() {
        super(3, 3);
    }

    @Override
    protected void declareAcceptedModifiers() {
        acceptedModifiers.add(SpellModifier.INTENSITY);
    }

    @Override
    public int calcManaCost() {
        return baseManaCost * getModifierLevel(SpellModifier.INTENSITY);
    }

    @Override
    public int calcCastDelay() {
        return baseCastDelay + getModifierLevel(SpellModifier.INTENSITY);
    }

    @Override
    public void onHitEntity(EntityHitResult hit, CastingContext ctx) {
        Vec3 force = ctx.caster.getLookAngle().normalize().scale(getModifierLevel(SpellModifier.INTENSITY));
        hit.getEntity().setDeltaMovement(hit.getEntity().getDeltaMovement().add(force));
        hit.getEntity().hurtMarked = true;
    }

    @Override
    public void onHitBlock(BlockHitResult hit, CastingContext ctx) {
        //Nothin'
    }

}
