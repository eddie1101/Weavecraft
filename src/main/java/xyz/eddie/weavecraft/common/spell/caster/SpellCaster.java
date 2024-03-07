package xyz.eddie.weavecraft.common.spell.caster;

import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.caster.casters.*;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;

import java.util.List;

public abstract class SpellCaster {

    public static ISpellCaster SINGLE(ISpellShape shape, SpellSequence sequence) {return new SingleCaster(shape, sequence);}
    public static ISpellCaster SCATTER(int frags, ISpellShape shape, SpellSequence sequence) {return new ScatterCaster(frags, shape, sequence);}
    public static ISpellCaster MULTI_CAST(List<ISpellShape> shapes, List<SpellSequence> sequences) {return new MultiCaster(shapes, sequences);}
    public static ISpellCaster BIFURCATED(ISpellShape shape, SpellSequence sequence1, SpellSequence sequence2) {return new BifurcatedCaster(shape, sequence1, sequence2);}

}
