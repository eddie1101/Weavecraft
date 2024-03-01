package xyz.eddie.weavecraft.common.spell.amplifier;

import xyz.eddie.weavecraft.common.spell.SpellDeductible;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AmplifiableSpellDeductible extends SpellDeductible implements IAmplifiable, Serializable {

    protected int manaCost;
    protected int castDelay;

    protected Map<Amplifier, Integer> amplifiers;

    public AmplifiableSpellDeductible(int manaCost, int castDelay) {
        super(manaCost, castDelay);

        amplifiers = new HashMap<>();
        amplifiers.put(Amplifier.INTENSITY, 1);
        amplifiers.put(Amplifier.DURATION, 1);
        amplifiers.put(Amplifier.RANGE, 1);
    }

    @Override
    public int getManaCost() {
        int cost = manaCost;
        for(Amplifier amplifier: amplifiers.keySet()) {
            cost = Math.round((float) cost * ((float) Math.pow(amplifier.manaCostMultiplier(), amplifiers.get(amplifier))));
        }
        return cost;
    }

    @Override
    public int getCastDelay() {
        int delay = castDelay;
        for(Amplifier amplifier: amplifiers.keySet()) {
            delay = Math.round((float) delay * ((float) Math.pow(amplifier.castDelayMultiplier(), amplifiers.get(amplifier))));
        }
        return delay;
    }

    public final int getAmplifier(Amplifier amplifier) {
        return amplifiers.get(amplifier);
    }

    public final void amplify(Amplifier amplifier, int level) {
        amplifiers.put(amplifier, Math.max(1, Math.min(level, amplifier.maxLevel())));
    }

}
