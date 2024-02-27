package xyz.eddie.weavecraft.common.spell;

import xyz.eddie.weavecraft.common.entity.SpellEntity;
import xyz.eddie.weavecraft.common.registries.WeavecraftEntities;

public class ExpulsiveSpell extends Spell {

    public ExpulsiveSpell() {
        super();
    }

    @Override
    public void cast(CastingContext ctx) {
        SpellEntity entity = new SpellEntity(WeavecraftEntities.SPELL_ENTITY.get(), ctx.getLevel(), spellSequence, ctx.getLocation());
        ctx.getLevel().addFreshEntity(entity);
    }

}
