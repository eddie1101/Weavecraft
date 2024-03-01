package xyz.eddie.weavecraft.common.spell.shape;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.ISpellDeductible;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.amplifier.IAmplifiable;

import java.io.Serializable;

public interface ISpellShape extends Serializable, ISpellDeductible {

    default void create(CastingContext ctx, SpellSequence sequence) {
        create(ctx, sequence, 0f, 0f, 0f);
    }

    void create(CastingContext ctx, SpellSequence sequence, float inaccuracy, float xAngle, float yAngle);

}
