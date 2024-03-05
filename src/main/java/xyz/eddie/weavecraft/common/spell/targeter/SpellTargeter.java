package xyz.eddie.weavecraft.common.spell.targeter;

import xyz.eddie.weavecraft.common.spell.targeter.targeters.AOESpellTargeter;
import xyz.eddie.weavecraft.common.spell.targeter.targeters.HitSpellTargeter;
import xyz.eddie.weavecraft.common.spell.targeter.targeters.ReflexSpellTargeter;
import xyz.eddie.weavecraft.common.spell.targeter.targeters.TouchSpellTargeter;

public abstract class SpellTargeter implements ISpellTargeter {

    public static ISpellTargeter REFLEX = new ReflexSpellTargeter();
    public static ISpellTargeter TOUCH = new TouchSpellTargeter();
    public static ISpellTargeter AOE = new AOESpellTargeter();
    public static ISpellTargeter HIT = new HitSpellTargeter();

}
