package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.IAmplifiable;
import xyz.eddie.weavecraft.common.spell.ISpellDeductible;

public interface ISpellEffect extends IAmplifiable, ISpellDeductible {

    default void onHit(HitResult hit, CastingContext ctx) {
        if(hit.getType() == HitResult.Type.ENTITY) {
            onHitEntity((EntityHitResult) hit, ctx);
        } else if(hit.getType() == HitResult.Type.BLOCK) {
            onHitBlock((BlockHitResult) hit, ctx);
        }
    }
    void onHitEntity(EntityHitResult hit, CastingContext ctx);
    void onHitBlock(BlockHitResult hit, CastingContext ctx);

}
