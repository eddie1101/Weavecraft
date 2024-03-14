package xyz.eddie.weavecraft.common.spell.effect.effects;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;

public class HarvestSpellEffect extends SpellEffect {

    @Override
    public void onHitBlock(BlockHitResult hit, final CastingContext ctx) {
        ctx.getLevel().destroyBlock(hit.getBlockPos(), true);
    }

}
