package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.caster.ISpellCaster;
import xyz.eddie.weavecraft.common.spell.type.ISpellType;

public class SingleCaster implements ISpellCaster {

    protected ISpellType type;
    protected ISpellEffect effect;

    public SingleCaster(ISpellType type, ISpellEffect effect) {
        this.type = type;
        this.effect = effect;
    }

    @Override
    public void cast(CastingContext ctx) {
        type.create(ctx, effect);
    }

}
