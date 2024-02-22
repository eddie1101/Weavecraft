package xyz.eddie.weavecraft.common.spell.modifier;

public enum SpellEffectModifier {

    DURATION("Duration", 5),
    INTENSITY("Intensity", 5);

    public String name;
    public int maxLevel;

    SpellEffectModifier(String name, int level) {
        this.name = name;
        this.maxLevel = level;
    }

}
