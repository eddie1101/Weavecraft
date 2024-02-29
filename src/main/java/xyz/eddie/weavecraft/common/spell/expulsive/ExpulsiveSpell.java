package xyz.eddie.weavecraft.common.spell.expulsive;

import xyz.eddie.weavecraft.common.entity.SpellEntity;
import xyz.eddie.weavecraft.common.registries.WeavecraftEntities;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.expulsive.aspect.ExpulsiveAspect;
import xyz.eddie.weavecraft.common.spell.expulsive.aspect.KineticAspect;

import javax.annotation.Nullable;

public class ExpulsiveSpell extends Spell {

    protected KineticAspect kineticAspect = KineticAspect.STATIONARY;
    @Nullable
    protected ExpulsiveAspect expulsiveAspect = null;

    public ExpulsiveSpell() {
        super();
    }

    @Override
    public void cast(CastingContext ctx) {
        SpellEntity entity = new SpellEntity(WeavecraftEntities.SPELL_ENTITY.get(), ctx.getLevel(), spellSequence, ctx, kineticAspect, expulsiveAspect, ctx.getLocation());
        ctx.getLevel().addFreshEntity(entity);
    }

    public void setKineticAspect(KineticAspect aspect) {
        this.kineticAspect = aspect;
    }

    public void setExpulsiveAspect(ExpulsiveAspect aspect) {
        this.expulsiveAspect = aspect;
    }

    public KineticAspect getKineticAspect() {
        return kineticAspect;
    }

    @Nullable
    public ExpulsiveAspect getExpulsiveAspect() {
        return expulsiveAspect;
    }

}
