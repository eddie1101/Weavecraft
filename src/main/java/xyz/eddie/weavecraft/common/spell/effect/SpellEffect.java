package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.AmplifiableSpellDeductible;
import xyz.eddie.weavecraft.common.spell.effect.effects.*;

import java.util.function.Function;

public abstract class SpellEffect extends AmplifiableSpellDeductible implements ISpellEffect {

    public static final Function<ISpellEffect, ISpellEffect> DETONATE = DetonateSpellEffect::new;
    public static final Function<ISpellEffect, ISpellEffect> INFERNO = InfernoSpellEffect::new;
    public static final Function<ISpellEffect, ISpellEffect> DISINTEGRATE = DisintegrateSpellEffect::new;
    public static final Function<ISpellEffect, ISpellEffect> HARVEST = HarvestSpellEffect::new;
    public static final Function<ISpellEffect, ISpellEffect> PUSH = PushSpellEffect::new;

    protected ISpellEffect effect;

    public SpellEffect(ISpellEffect effect, int manaCost, int castDelay) {
        super(manaCost, castDelay);
        this.effect = effect;
    }

    @Override
    public void onHitEntity(EntityHitResult hit, final CastingContext ctx) {
        effect.onHitEntity(hit, ctx);
    }

    @Override
    public void onHitBlock(BlockHitResult hit, final CastingContext ctx) {
        effect.onHitBlock(hit, ctx);
    }
}
