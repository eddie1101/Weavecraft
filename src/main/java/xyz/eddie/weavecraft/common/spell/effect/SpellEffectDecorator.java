package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.AmplifiableSpellDeductible;

public abstract class SpellEffectDecorator extends AmplifiableSpellDeductible implements ISpellEffect {

    protected ISpellEffect effect;

    public SpellEffectDecorator(ISpellEffect effect, int manaCost, int castDelay) {
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
