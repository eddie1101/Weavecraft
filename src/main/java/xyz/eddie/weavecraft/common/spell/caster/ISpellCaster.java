package xyz.eddie.weavecraft.common.spell.caster;

import xyz.eddie.weavecraft.common.spell.CastingContext;

import java.io.Serializable;

public interface ISpellCaster extends Serializable {

    void cast(CastingContext ctx);

}
