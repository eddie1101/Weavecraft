package xyz.eddie.weavecraft.common.spell.component;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.target.ITargetGatherer;

public class ExpulsiveSpellComponent extends SpellComponent {

    public ExpulsiveSpellComponent(ITargetGatherer targetGatherer) {
        super(targetGatherer);
    }

    @Override
    public void cast(CastingContext ctx) {
        return;
    }

}
