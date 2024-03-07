package xyz.eddie.weavecraft.common.spell.shape.shapes;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;
import xyz.eddie.weavecraft.common.spell.shape.SpellShape;

public class NoSpellShape implements ISpellShape {

    public void create(CastingContext ctx, SpellSequence sequence, float inaccuracy, float xAngle, float yAngle) {
        sequence.activate(ctx);
    }

}