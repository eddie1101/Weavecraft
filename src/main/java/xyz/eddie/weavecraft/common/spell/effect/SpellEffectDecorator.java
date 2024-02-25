package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.ISpellComponent;

public abstract class SpellEffectDecorator implements ISpellEffect {
    protected ISpellEffect effect;

    public SpellEffectDecorator(ISpellEffect effect) {
        this.effect = effect;
    }

    @Override
    public int calcManaCost() {
        return (int) (effect.calcManaCost() * 1.5);
    }

    @Override
    public int calcCastDelay() {
        return (int) (effect.calcCastDelay() * 1.5);
    }

    @Override
    public void onHitEntity(EntityHitResult hit, CastingContext ctx) {
        effect.onHitEntity(hit, ctx);
    }

    @Override
    public void onHitBlock(BlockHitResult hit, CastingContext ctx) {
        effect.onHitBlock(hit, ctx);
    }
}
