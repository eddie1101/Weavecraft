package xyz.eddie.weavecraft.common.spell;

import xyz.eddie.weavecraft.common.spell.effect.BlankSpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;

public abstract class SpellComponent implements ISpellComponent {

    /*

    TODO Amplifiers and Target Gatherers

     */

    protected ISpellEffect effect;

    protected SpellComponent() {
        super();
    }



    public void setEffect(ISpellEffect effect) {
        this.effect = effect;
    }

}
