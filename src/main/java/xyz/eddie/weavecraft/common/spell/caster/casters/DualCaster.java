package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;

public class DualCaster extends MultiCaster {

    public DualCaster(ISpellShape shape1, ISpellShape shape2, SpellSequence sequence1, SpellSequence sequence2) {
        super(2);
        shapes(shape1, shape2);
        sequences(sequence1, sequence2);
    }

}
