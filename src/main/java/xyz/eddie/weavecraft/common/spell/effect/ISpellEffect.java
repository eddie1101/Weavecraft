package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public interface ISpellEffect {

    void onHit(HitResult hit, Level level);
    void onHitEntity(EntityHitResult hit, Level level);
    void onHitBlock(BlockHitResult hit, Level level);

}
