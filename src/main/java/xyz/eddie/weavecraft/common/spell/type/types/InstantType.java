package xyz.eddie.weavecraft.common.spell.type.types;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.type.ISpellType;

public class InstantType implements ISpellType {

    public void create(CastingContext ctx, ISpellEffect effect, float inaccuracy, float xAngle, float yAngle) {
        effect.activate(ctx);
    }

}