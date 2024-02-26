package xyz.eddie.weavecraft.common.spell.targeter.targeters;

import xyz.eddie.weavecraft.common.spell.amplifier.AmplifiableSpellDeductible;
import xyz.eddie.weavecraft.common.spell.targeter.ISpellTargeter;

public abstract class SpellTargeter extends AmplifiableSpellDeductible implements ISpellTargeter {

    public SpellTargeter(int manaCost, int castDelay) {
        super(manaCost, castDelay);
    }

}
