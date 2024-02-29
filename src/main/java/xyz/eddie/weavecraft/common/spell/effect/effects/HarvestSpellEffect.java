package xyz.eddie.weavecraft.common.spell.effect.effects;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;

public class HarvestSpellEffect extends SpellEffect {

    public HarvestSpellEffect(ISpellEffect effect) {
        super(effect, 2, 2);
    }

    @Override
    public void onHitEntity(EntityHitResult hit, final CastingContext ctx) {
        super.onHitEntity(hit, ctx);
    }

    @Override
    public void onHitBlock(BlockHitResult hit, final CastingContext ctx) {
        super.onHitBlock(hit, ctx);
        ctx.getLevel().destroyBlock(hit.getBlockPos(), true);
    }

}
