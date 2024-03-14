package xyz.eddie.weavecraft.common.spell.caster;

import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.caster.casters.*;
import xyz.eddie.weavecraft.common.spell.type.ISpellType;

import java.util.List;

public abstract class SpellCaster {

    public static ISpellCaster SINGLE(ISpellType type, ISpellEffect sequence) {return new SingleCaster(type, sequence);}
    public static ISpellCaster SCATTER(int frags, ISpellType type, ISpellEffect sequence) {return new ScatterCaster(frags, type, sequence);}
    public static ISpellCaster MULTI_CAST(List<ISpellType> types, List<ISpellEffect> sequences) {return new MultiCaster(types, sequences);}
    public static ISpellCaster BIFURCATED(ISpellType type, ISpellEffect sequence1, ISpellEffect sequence2) {return new BifurcatedCaster(type, sequence1, sequence2);}

}
