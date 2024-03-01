package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.caster.SpellCaster;

public class SingleSpellCaster extends SpellCaster {

    public void cast(CastingContext ctx, SpellSequence sequence) {
        shape.create(ctx, sequence);
    }

}
