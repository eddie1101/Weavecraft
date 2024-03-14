package xyz.eddie.weavecraft.common.spell.type;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;

import java.io.Serializable;

public interface ISpellType extends Serializable {

    default void create(CastingContext ctx, ISpellEffect effect) {
        create(ctx, effect, 0f, 0f, 0f);
    }

    void create(CastingContext ctx, ISpellEffect effect, float inaccuracy, float xAngle, float yAngle);

}
