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
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.modifier.SpellEffectModifier;

import java.util.Arrays;
import java.util.List;

public class IgnitionSpellEffect extends SpellEffect {

    public IgnitionSpellEffect() {
        super(5, 5);
    }

    @Override
    protected void addAcceptedModifiers() {
        this.acceptedModifiers.add(SpellEffectModifier.DURATION);
    }

    @Override
    public int calcManaCost() {
        return baseManaCost + getModifierLevel(SpellEffectModifier.DURATION);
    }

    @Override
    public int calcCastDelay() {
        return baseCastDelay;
    }

    @Override
    public void onHitBlock(BlockHitResult hit, CastingContext ctx) {
        Direction direction = hit.getDirection();
        BlockPos firePos = hit.getBlockPos().offset(direction.getNormal());
        if(ctx.level.getBlockState(firePos).is(Blocks.AIR)) {
            ctx.level.setBlock(firePos, Blocks.FIRE.defaultBlockState(), 0);
        }
    }

    @Override
    public void onHitEntity(EntityHitResult hit, CastingContext ctx) {
        Entity entity = hit.getEntity();
        int durationSeconds = 5;
        int durationLevel = getModifierLevel(SpellEffectModifier.DURATION);
        durationSeconds += (Math.ceil((SpellEffectModifier.DURATION.maxLevel / (float) durationLevel) * durationSeconds));
        if(entity instanceof LivingEntity le) {
            le.setSecondsOnFire(durationSeconds);
        }
    }

}
