package xyz.eddie.weavecraft.common.spell.expulsive.aspect;

import net.minecraft.world.entity.ExperienceOrb;
import org.checkerframework.checker.units.qual.C;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.amplifier.AmplifiableSpellDeductible;

import java.io.Serializable;

public abstract class ExpulsiveAspect extends AmplifiableSpellDeductible {

    public static ExpulsiveAspect CONSTANT(Spell spell) {return new ConstantExpulsiveAspect(spell);}

    protected Spell spell;

    public ExpulsiveAspect(int manaCost, int castDelay, Spell spell) {
        super(manaCost, castDelay);
        this.spell = spell;
    }

    public abstract boolean shouldCast(CastingContext ctx);
    public abstract void cast(CastingContext ctx);

}
