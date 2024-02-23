package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;

public interface ISpellEffect {

    void onHit(HitResult hit, CastingContext ctx);
    void onHitEntity(EntityHitResult hit, CastingContext ctx);
    void onHitBlock(BlockHitResult hit, CastingContext ctx);

    int calcManaCost();
    int calcCastDelay();

}
