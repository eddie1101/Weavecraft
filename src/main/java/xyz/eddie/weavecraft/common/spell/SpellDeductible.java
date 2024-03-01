package xyz.eddie.weavecraft.common.spell;

import xyz.eddie.weavecraft.common.spell.ISpellDeductible;
import xyz.eddie.weavecraft.common.spell.shape.SpellShape;

public abstract class SpellDeductible implements ISpellDeductible {

    protected int manaCost;
    protected int castDelay;

    public SpellDeductible(int manaCost, int castDelay) {
        this.manaCost = manaCost;
        this.castDelay = castDelay;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }

    @Override
    public int getCastDelay() {
        return castDelay;
    }

}
