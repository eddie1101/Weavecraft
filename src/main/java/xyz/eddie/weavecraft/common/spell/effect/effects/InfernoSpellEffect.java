package xyz.eddie.weavecraft.common.spell.effect.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffectDecorator;

public class InfernoSpellEffect extends SpellEffectDecorator {

    public InfernoSpellEffect(ISpellEffect effect) {
        super(effect, 5, 5);
    }

    @Override
    public void onHitBlock(BlockHitResult hit, final CastingContext ctx) {
        super.onHitBlock(hit, ctx);
        BlockPos hitPos = hit.getBlockPos();
        BlockPos ignitePos = hitPos.relative(hit.getDirection());
        ctx.getLevel().playSound(null, ignitePos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, ctx.getLevel().getRandom().nextFloat() * 0.4F + 0.8F);
        BlockState blockState = BaseFireBlock.getState(ctx.getLevel(), ignitePos);
        ctx.getLevel().setBlock(ignitePos, blockState, 11);
        ctx.getLevel().gameEvent(ctx.getCaster(), GameEvent.BLOCK_PLACE, hitPos);
    }

    @Override
    public void onHitEntity(EntityHitResult hit, final CastingContext ctx) {
        super.onHitEntity(hit, ctx);
        Entity entity = hit.getEntity();
        int durationSeconds = 4 + getAmplifierLevel(Amplifier.DURATION) * 2;
        if(entity instanceof LivingEntity le) {
            le.setSecondsOnFire(durationSeconds);
        } else if(entity instanceof ItemEntity ie) {
            ie.setSecondsOnFire(durationSeconds);
        }
    }
}
