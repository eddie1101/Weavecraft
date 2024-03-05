package xyz.eddie.weavecraft.common.spell.effect.effects;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;

public class PushSpellEffect extends SpellEffect {

    @Override
    public void onHitEntity(EntityHitResult hit, final CastingContext ctx) {
        Vec3 force = hit.getEntity().position().subtract(ctx.getCaster().position()).normalize().scale(2);
        hit.getEntity().setDeltaMovement(hit.getEntity().getDeltaMovement().add(force));
        hit.getEntity().setDeltaMovement(hit.getEntity().getDeltaMovement().add(0, 0.5, 0));
        hit.getEntity().hurtMarked = true;
    }

    @Override
    public void onHitBlock(BlockHitResult hit, final CastingContext ctx) {
        super.onHitBlock(hit, ctx);
    }

}
