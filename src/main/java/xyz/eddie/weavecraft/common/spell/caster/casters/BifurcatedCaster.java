package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.caster.ISpellCaster;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;

public class BifurcatedCaster implements ISpellCaster {

    ISpellShape shape;
    SpellSequence sequence1;
    SpellSequence sequence2;

    public BifurcatedCaster(ISpellShape shape, SpellSequence sequence1, SpellSequence sequence2) {
        this.shape = shape;
        this.sequence1 = sequence1;
        this.sequence2 = sequence2;
    }

    public void cast(CastingContext ctx) {
        shape.create(ctx, sequence1, 1, 0, -20);
        shape.create(ctx, sequence1, 1, 0, 20);
    }

}
