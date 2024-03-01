package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.caster.SpellCaster;

public class ScatterSpellCaster extends SpellCaster {

    int frags;

    public ScatterSpellCaster(int frags) {
        super();
        this.frags = frags;
    }

    public void cast(CastingContext ctx, SpellSequence sequence) {
        for(int i = 0; i < frags; i++) {
            shape.create(ctx, sequence, 0.3f * frags, 0f, 0f);
        }
    }

}
