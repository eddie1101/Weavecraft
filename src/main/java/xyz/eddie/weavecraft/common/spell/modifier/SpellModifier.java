package xyz.eddie.weavecraft.common.spell.modifier;

public enum SpellModifier implements IModifiable {

    //Typically effect modifiers
    DURATION("Duration", 5),
    INTENSITY("Intensity", 5),

    //Typically target modifiers
    TOUCH("Touch", 1),
    RANGE("Range", 5);

    public String name;
    public int maxLevel;

    SpellModifier(String name, int level) {
        this.name = name;
        this.maxLevel = level;
    }

}
