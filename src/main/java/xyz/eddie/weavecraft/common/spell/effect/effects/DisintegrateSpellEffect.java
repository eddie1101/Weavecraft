package xyz.eddie.weavecraft.common.spell.effect.effects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;

public class DisintegrateSpellEffect extends SpellEffect {

    public DisintegrateSpellEffect(ISpellEffect effect) {
        super(effect, 10, 3);
    }

    @Override
    public void onHitEntity(EntityHitResult hit, final CastingContext ctx) {
        super.onHitEntity(hit, ctx);
        hit.getEntity().hurt(ctx.getLevel().damageSources().magic(), getAmplifier(Amplifier.INTENSITY));
        if(hit.getEntity() instanceof LivingEntity le) {
            le.addEffect(new MobEffectInstance(MobEffects.WITHER, 20 + (getAmplifier(Amplifier.DURATION) * 40)));
        }
    }

    @Override
    public void onHitBlock(BlockHitResult hit, final CastingContext ctx) {
        super.onHitBlock(hit, ctx);
        ctx.getLevel().destroyBlock(hit.getBlockPos(), false);
    }

}
