package xyz.eddie.weavecraft.common.spell.effect.effects;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;

public class DetonateSpellEffect extends SpellEffect {

    @Override
    public void onHitEntity(EntityHitResult hit, final CastingContext ctx) {
        explode(hit, ctx);
    }

    @Override
    public void onHitBlock(BlockHitResult hit, final CastingContext ctx) {
        explode(hit, ctx);
    }

    private void explode(HitResult hit, final CastingContext ctx) {
        ctx.getLevel().explode(null, hit.getLocation().x, hit.getLocation().y, hit.getLocation().z, 3, Level.ExplosionInteraction.BLOCK);
    }
}
