package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class IgnitionSpellEffect extends SpellEffect {

    public IgnitionSpellEffect() {
        super(5, 5);
    }

    @Override
    public void onHit(HitResult hit, Level level) {
        if(hit.getType() == HitResult.Type.ENTITY) {
            onHitEntity((EntityHitResult) hit, level);
        } else if(hit.getType() == HitResult.Type.BLOCK) {
            onHitBlock((BlockHitResult) hit, level);
        } else if(hit.getType() == HitResult.Type.MISS) {

        }
    }

    @Override
    public void onHitBlock(BlockHitResult hit, Level level) {
        Direction direction = hit.getDirection();
        BlockPos firePos = hit.getBlockPos().offset(direction.getNormal());
        if(level.getBlockState(firePos).is(Blocks.AIR)) {
            level.setBlock(firePos, Blocks.FIRE.defaultBlockState(), 0);
        }
    }

    @Override
    public void onHitEntity(EntityHitResult hit, Level level) {
        Entity entity = hit.getEntity();
        if(entity instanceof LivingEntity le) {
            le.setSecondsOnFire(6);
        }
    }

}
