package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.caster.ISpellCaster;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;

public class SingleSpellCaster implements ISpellCaster {

    protected ISpellShape shape;
    protected SpellSequence sequence;

    public SingleSpellCaster(ISpellShape shape, SpellSequence sequence) {
        this.shape = shape;
        this.sequence = sequence;
    }

    @Override
    public void cast(CastingContext ctx) {
        shape.create(ctx, sequence);
    }

}
