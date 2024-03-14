package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.caster.ISpellCaster;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.type.ISpellType;

public class BifurcatedCaster implements ISpellCaster {

    ISpellType type;
    ISpellEffect effect1;
    ISpellEffect effect2;

    public BifurcatedCaster(ISpellType type, ISpellEffect effect1, ISpellEffect effect2) {
        this.type = type;
        this.effect1 = effect1;
        this.effect2 = effect2;
    }

    public void cast(CastingContext ctx) {
        type.create(ctx, effect1, 1, 0, -20);
        type.create(ctx, effect2, 1, 0, 20);
    }

}
