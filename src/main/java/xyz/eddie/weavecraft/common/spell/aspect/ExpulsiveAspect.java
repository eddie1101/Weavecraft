package xyz.eddie.weavecraft.common.spell.aspect;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.amplifier.AmplifiableSpellDeductible;
import xyz.eddie.weavecraft.common.spell.aspect.aspects.ConstantExpulsiveAspect;

import javax.annotation.Nullable;

public abstract class ExpulsiveAspect extends AmplifiableSpellDeductible {

    public static ExpulsiveAspect CONSTANT(Spell spell) {return new ConstantExpulsiveAspect(spell);}
    @Nullable
    public static ExpulsiveAspect NULL() {return null;}

    protected Spell spell;

    public ExpulsiveAspect(int manaCost, int castDelay, Spell spell) {
        super(manaCost, castDelay);
        this.spell = spell;
    }

    public abstract boolean shouldCast(CastingContext ctx);
    public abstract void cast(CastingContext ctx);

}
