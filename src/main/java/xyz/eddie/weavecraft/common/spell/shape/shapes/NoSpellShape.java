package xyz.eddie.weavecraft.common.spell.shape.shapes;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.shape.SpellShape;

public class NoSpellShape extends SpellShape {

    public NoSpellShape() {
        super(0, 0);
    }

    public void create(CastingContext ctx, SpellSequence sequence, float inaccuracy, float xAngle, float yAngle) {
        sequence.activate(ctx);
    }

}