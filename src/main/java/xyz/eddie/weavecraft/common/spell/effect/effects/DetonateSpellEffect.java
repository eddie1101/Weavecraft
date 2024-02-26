package xyz.eddie.weavecraft.common.spell.effect.effects;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffectDecorator;

public class DetonateSpellEffect extends SpellEffectDecorator {

    public DetonateSpellEffect(ISpellEffect effect) {
        super(effect, 40, 40);
    }

    @Override
    public void onHitEntity(EntityHitResult hit, final CastingContext ctx) {
        super.onHitEntity(hit, ctx);
        explode(hit, ctx);
    }

    @Override
    public void onHitBlock(BlockHitResult hit, final CastingContext ctx) {
        super.onHitBlock(hit, ctx);
        explode(hit, ctx);
    }

    private void explode(HitResult hit, final CastingContext ctx) {
        ctx.getLevel().explode(null, hit.getLocation().x, hit.getLocation().y, hit.getLocation().z, 1 + getAmplifierLevel(Amplifier.INTENSITY) * 2, Level.ExplosionInteraction.BLOCK);
    }
}
