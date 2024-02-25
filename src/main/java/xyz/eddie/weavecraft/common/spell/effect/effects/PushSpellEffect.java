package xyz.eddie.weavecraft.common.spell.effect.effects;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.EffectAmplifier;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffectDecorator;

public class PushSpellEffect extends SpellEffectDecorator {

    public PushSpellEffect(ISpellEffect effect) {
        super(effect);
    }


    @Override
    public int calcManaCost() {
        return super.calcManaCost() + 3;
    }

    @Override
    public int calcCastDelay() {
        return super.calcCastDelay() + 1;
    }

    @Override
    public void onHitEntity(EntityHitResult hit, CastingContext ctx) {
        super.onHitEntity(hit, ctx);
        Vec3 force = ctx.caster.getLookAngle().normalize().scale(getAmplifierLevel(EffectAmplifier.INTENSITY));
        hit.getEntity().setDeltaMovement(hit.getEntity().getDeltaMovement().add(force));
        hit.getEntity().hurtMarked = true;
    }

    @Override
    public void onHitBlock(BlockHitResult hit, CastingContext ctx) {
        super.onHitBlock(hit, ctx);
    }

}
