package xyz.eddie.weavecraft.common.spell.effect;

public abstract class SpellEffect implements ISpellEffect {

    protected int baseManaCost;
    protected int baseCastDelay;

    public SpellEffect(int baseManaCost, int baseCastDelay) {
        this.baseManaCost = baseManaCost;
        this.baseCastDelay = baseCastDelay;
    }

}
