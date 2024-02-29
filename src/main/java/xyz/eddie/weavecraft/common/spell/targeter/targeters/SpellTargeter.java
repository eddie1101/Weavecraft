package xyz.eddie.weavecraft.common.spell.targeter.targeters;

import xyz.eddie.weavecraft.common.spell.amplifier.AmplifiableSpellDeductible;
import xyz.eddie.weavecraft.common.spell.targeter.ISpellTargeter;

public abstract class SpellTargeter extends AmplifiableSpellDeductible implements ISpellTargeter {

    public static ISpellTargeter REFLEX = new ReflexSpellTargeter();
    public static ISpellTargeter TOUCH = new TouchSpellTargeter();
    public static ISpellTargeter AOE = new AOESpellTargeter();

    public SpellTargeter(int manaCost, int castDelay) {
        super(manaCost, castDelay);
    }

}
