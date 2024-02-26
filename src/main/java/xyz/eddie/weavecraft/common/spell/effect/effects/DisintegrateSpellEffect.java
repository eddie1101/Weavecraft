package xyz.eddie.weavecraft.common.spell.effect.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffectDecorator;

public class DisintegrateSpellEffect extends SpellEffectDecorator {

    public DisintegrateSpellEffect(ISpellEffect effect) {
        super(effect, 10, 3);
    }

    @Override
    public void onHitEntity(EntityHitResult hit, CastingContext ctx) {
        super.onHitEntity(hit, ctx);
        hit.getEntity().hurt(ctx.level.damageSources().magic(), getAmplifierLevel(Amplifier.INTENSITY));
        if(hit.getEntity() instanceof LivingEntity le) {
            le.addEffect(new MobEffectInstance(MobEffects.WITHER, 20 + (getAmplifierLevel(Amplifier.DURATION) * 40)));
        }
    }

    @Override
    public void onHitBlock(BlockHitResult hit, CastingContext ctx) {
        super.onHitBlock(hit, ctx);
        ctx.level.destroyBlock(hit.getBlockPos(), false);
    }

}
