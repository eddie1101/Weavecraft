package xyz.eddie.weavecraft.common.spell.amplifier;

import xyz.eddie.weavecraft.common.spell.ISpellDeductible;

import java.util.HashMap;
import java.util.Map;

public class AmplifiableSpellDeductible implements ISpellDeductible, IAmplifiable {

    protected int manaCost;
    protected int castDelay;

    protected Map<SpellAmplifier, Integer> amplifiers;

    public AmplifiableSpellDeductible(int manaCost, int castDelay) {
        this.manaCost = manaCost;
        this.castDelay = castDelay;

        amplifiers = new HashMap<>();
        amplifiers.put(SpellAmplifier.INTENSITY, 1);
        amplifiers.put(SpellAmplifier.DURATION, 1);
        amplifiers.put(SpellAmplifier.RANGE, 1);
    }

    @Override
    public int getManaCost() {
        int cost = manaCost;
        for(SpellAmplifier amplifier: amplifiers.keySet()) {
            cost = Math.round((float) cost * ((float) Math.pow(amplifier.manaCostMultiplier(), amplifiers.get(amplifier))));
        }
        return cost;
    }

    @Override
    public int getCastDelay() {
        int delay = castDelay;
        for(SpellAmplifier amplifier: amplifiers.keySet()) {
            delay = Math.round((float) delay * ((float) Math.pow(amplifier.castDelayMultiplier(), amplifiers.get(amplifier))));
        }
        return delay;
    }

    public final int getAmplifierLevel(SpellAmplifier amplifier) {
        return amplifiers.get(amplifier);
    }

    public final void setAmplifierLevel(SpellAmplifier amplifier, int level) {
        amplifiers.put(amplifier, Math.max(1, Math.min(level, amplifier.maxLevel())));
    }

}
