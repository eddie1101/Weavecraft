package xyz.eddie.weavecraft.common.spell.aspect.aspects;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.aspect.ExpulsiveAspect;

public class ConstantExpulsiveAspect extends ExpulsiveAspect {

    public ConstantExpulsiveAspect(Spell spell) {
        super(1, 40, spell);
    }

    @Override
    public boolean shouldCast(CastingContext ctx) {
        return true;
    }

    @Override
    public void cast(CastingContext ctx) {
        this.spell.cast(ctx);
    }
}
