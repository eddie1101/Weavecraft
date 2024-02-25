package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;

public class BaseSpellEffect implements ISpellEffect {

    private final int baseManaCost, baseCastDelay;
    public BaseSpellEffect(int baseManaCost, int baseCastDelay) {
        this.baseManaCost = baseManaCost;
        this.baseCastDelay = baseCastDelay;
    }

    @Override
    public int calcManaCost() {
        return baseManaCost;
    }

    public int calcCastDelay() {
        return baseCastDelay;
    }

    @Override
    public void onHitBlock(BlockHitResult hit, CastingContext ctx) {

    }

    @Override
    public void onHitEntity(EntityHitResult hit, CastingContext ctx) {

    }

    @Override
    public int getAmplifierLevel(EffectAmplifier amplifier) {
        return 0;
    }

    @Override
    public void setAmplifierLevel(EffectAmplifier amplifier, int level) {

    }
}
