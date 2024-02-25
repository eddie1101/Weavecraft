package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;

import java.util.HashMap;
import java.util.Map;

public abstract class SpellEffectDecorator implements ISpellEffect {

    protected ISpellEffect effect;
    protected Map<EffectAmplifier, Integer> amplifiers;

    public SpellEffectDecorator(ISpellEffect effect) {
        this.effect = effect;

        amplifiers = new HashMap<>();
        amplifiers.put(EffectAmplifier.INTENSITY, 1);
        amplifiers.put(EffectAmplifier.DURATION, 1);
        amplifiers.put(EffectAmplifier.RANGE, 1);
    }

    @Override
    public int calcManaCost() {
        int manaCost = effect.calcManaCost();
        for(EffectAmplifier amplifier: amplifiers.keySet()) {
            manaCost = Math.round((float) manaCost * amplifier.manaCostMultiplier());
        }
        return manaCost;
    }

    @Override
    public int calcCastDelay() {
        int castDelay = effect.calcCastDelay();
        for(EffectAmplifier amplifier: amplifiers.keySet()) {
            castDelay = Math.round((float) castDelay * amplifier.castDelayMultiplier());
        }
        return castDelay;
    }

    @Override
    public void onHitEntity(EntityHitResult hit, CastingContext ctx) {
        effect.onHitEntity(hit, ctx);
    }

    @Override
    public void onHitBlock(BlockHitResult hit, CastingContext ctx) {
        effect.onHitBlock(hit, ctx);
    }

    public final int getAmplifierLevel(EffectAmplifier amplifier) {
        return amplifiers.get(amplifier);
    }

    public final void setAmplifierLevel(EffectAmplifier amplifier, int level) {
        amplifiers.put(amplifier, Math.max(1, Math.min(level, amplifier.maxLevel())));
    }
}
