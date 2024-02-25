package xyz.eddie.weavecraft.common.spell.component;

import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.target.ITargetGatherer;

public abstract class SpellComponent implements ISpellComponent {

    /*

    TODO Target Gatherers

     */

    protected ISpellEffect effect;
    protected ITargetGatherer targetGatherer;

    protected SpellComponent(ITargetGatherer targetGatherer) {
        this.targetGatherer = targetGatherer;
    }

    public void setEffect(ISpellEffect effect) {
        this.effect = effect;
    }

}
