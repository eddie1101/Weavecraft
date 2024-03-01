package xyz.eddie.weavecraft.common.spell.caster;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;
import xyz.eddie.weavecraft.common.spell.shape.SpellShape;

import java.io.Serializable;

public interface ISpellCaster extends Serializable {

    void cast(CastingContext ctx, SpellSequence sequence);

    void setShape(ISpellShape shape);
    ISpellShape getShape();

}
