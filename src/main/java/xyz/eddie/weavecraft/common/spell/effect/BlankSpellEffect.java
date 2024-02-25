package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;

public class BlankSpellEffect implements ISpellEffect {

    @Override
    public int calcManaCost() {
        return 5;
    }

    public int calcCastDelay() {
        return 5;
    }

    @Override
    public void onHitBlock(BlockHitResult hit, CastingContext ctx) {

    }

    @Override
    public void onHitEntity(EntityHitResult hit, CastingContext ctx) {

    }

}
