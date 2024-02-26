package xyz.eddie.weavecraft.common.spell.targeter.targeters;

import xyz.eddie.weavecraft.common.spell.targeter.ISpellTargeter;

public class SpellTargeters {

    public static ISpellTargeter REFLEX = new ReflexSpellTargeter();
    public static ISpellTargeter TOUCH = new TouchSpellTargeter();
    public static ISpellTargeter AOE = new AOESpellTargeter();

}
