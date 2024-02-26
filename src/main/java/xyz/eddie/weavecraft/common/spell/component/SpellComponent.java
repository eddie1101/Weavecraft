package xyz.eddie.weavecraft.common.spell.component;

import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.target.ITargetGatherer;

public abstract class SpellComponent implements ISpellComponent {

    protected ISpellEffect effect;
    protected ITargetGatherer targetGatherer;

    public void setTargetGatherer(ITargetGatherer targetGatherer) {
        this.targetGatherer = targetGatherer;
    }

    public void setEffect(ISpellEffect effect) {
        this.effect = effect;
    }

}
