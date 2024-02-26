package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.SpellAmplifier;

public class BaseSpellEffect implements ISpellEffect {

    @Override
    public int getManaCost() {
        return 1;
    }

    @Override
    public int getCastDelay() {
        return 1;
    }

    @Override
    public void onHitBlock(BlockHitResult hit, CastingContext ctx) {

    }

    @Override
    public void onHitEntity(EntityHitResult hit, CastingContext ctx) {

    }

    @Override
    public int getAmplifierLevel(SpellAmplifier amplifier) {
        return 0;
    }

    @Override
    public void setAmplifierLevel(SpellAmplifier amplifier, int level) {

    }
}
