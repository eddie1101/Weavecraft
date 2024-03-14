package xyz.eddie.weavecraft.common.spell.effect.effects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;

public class DisintegrateSpellEffect extends SpellEffect {

    @Override
    public void onHitEntity(EntityHitResult hit, final CastingContext ctx) {
        hit.getEntity().hurt(ctx.getLevel().damageSources().magic(), 4);
        if(hit.getEntity() instanceof LivingEntity le) {
            le.addEffect(new MobEffectInstance(MobEffects.WITHER, 100));
        }
    }

    @Override
    public void onHitBlock(BlockHitResult hit, final CastingContext ctx) {
        ctx.getLevel().destroyBlock(hit.getBlockPos(), false);
    }

}
