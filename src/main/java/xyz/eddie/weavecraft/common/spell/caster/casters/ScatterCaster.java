package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;

public class ScatterCaster extends SingleCaster {

    int frags;

    public ScatterCaster(int frags, ISpellShape shape, SpellSequence sequence) {
        super(shape, sequence);
        this.frags = frags;
    }

    @Override
    public void cast(CastingContext ctx) {
        for(int i = 0; i < frags; i++) {
            shape.create(ctx, sequence, 1 + (2 * (frags - 1)), 0f, 0f);
        }
    }

}
