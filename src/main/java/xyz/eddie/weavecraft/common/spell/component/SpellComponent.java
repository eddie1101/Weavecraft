package xyz.eddie.weavecraft.common.spell.component;

import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.target.ITargeter;

public abstract class SpellComponent implements ISpellComponent {

    protected ISpellEffect effect;
    protected ITargeter targeter;

    public void setTargeter(ITargeter targeter) {
        this.targeter = targeter;
    }

    public void setEffect(ISpellEffect effect) {
        this.effect = effect;
    }

}
