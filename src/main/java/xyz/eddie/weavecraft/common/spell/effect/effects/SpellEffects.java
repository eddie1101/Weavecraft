package xyz.eddie.weavecraft.common.spell.effect.effects;

import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;

import java.util.function.Function;

public class SpellEffects {

    public static final Function<ISpellEffect, ISpellEffect> DETONATE = DetonateSpellEffect::new;
    public static final Function<ISpellEffect, ISpellEffect> INFERNO = InfernoSpellEffect::new;
    public static final Function<ISpellEffect, ISpellEffect> DISINTEGRATE = DisintegrateSpellEffect::new;
    public static final Function<ISpellEffect, ISpellEffect> HARVEST = HarvestSpellEffect::new;
    public static final Function<ISpellEffect, ISpellEffect> PUSH = PushSpellEffect::new;

}
