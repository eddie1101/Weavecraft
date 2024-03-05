package xyz.eddie.weavecraft.common.spell.caster;

import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.caster.casters.DualCaster;
import xyz.eddie.weavecraft.common.spell.caster.casters.ScatterSpellCaster;
import xyz.eddie.weavecraft.common.spell.caster.casters.SingleSpellCaster;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;
import xyz.eddie.weavecraft.common.spell.shape.SpellShape;

public abstract class SpellCaster {

    public static ISpellCaster SINGLE(ISpellShape shape, SpellSequence sequence) {return new SingleSpellCaster(shape, sequence);}
    public static ISpellCaster SCATTER(int frags, ISpellShape shape, SpellSequence sequence) {return new ScatterSpellCaster(frags, shape, sequence);}
    public static ISpellCaster DUAL_CAST(ISpellShape shape1, ISpellShape shape2, SpellSequence sequence1, SpellSequence sequence2) {return new DualCaster(shape1, shape2, sequence1, sequence2);}

}
