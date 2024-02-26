package xyz.eddie.weavecraft.common.spell.component;

import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.targeter.ISpellTargeter;

public abstract class SpellComponent implements ISpellComponent {

    protected ISpellEffect effect;
    protected ISpellTargeter targeter;
    protected Spell trigger;

    public void setTargeter(ISpellTargeter targeter) {
        this.targeter = targeter;
    }

    public void setEffect(ISpellEffect effect) {
        this.effect = effect;
    }

    public void setTrigger(Spell spell) {
        this.trigger = spell;
    }

    public ISpellEffect getEffect() {
        return effect;
    }

    public ISpellTargeter getTargeter() {
        return targeter;
    }

    public Spell getTrigger() {
        return trigger;
    }

}
