package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.type.ISpellType;

public class ScatterCaster extends SingleCaster {

    int frags;

    public ScatterCaster(int frags, ISpellType type, ISpellEffect effect) {
        super(type, effect);
        this.frags = frags;
    }

    @Override
    public void cast(CastingContext ctx) {
        for(int i = 0; i < frags; i++) {
            type.create(ctx, effect, 1 + (2 * (frags - 1)), 0f, 0f);
        }
    }

}
