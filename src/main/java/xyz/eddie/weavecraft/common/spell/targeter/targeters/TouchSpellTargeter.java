package xyz.eddie.weavecraft.common.spell.targeter.targeters;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.targeter.SpellTargeter;

import java.util.List;

public class TouchSpellTargeter extends SpellTargeter {

    @Override
    public List<HitResult> gatherTargets(CastingContext ctx) {
        Entity caster = ctx.getCaster();
        for (Entity e : ctx.getLevel().getEntities(caster, caster.getBoundingBox().inflate(4.5F))) {
            Vec3 casterViewAngle = caster.getViewVector(1.0F).normalize();
            Vec3 directionToEntity = new Vec3(e.getX() - caster.getX(), e.getEyeY() - caster.getEyeY(), e.getZ() - caster.getZ());
            double distanceToEntity = directionToEntity.length();
            directionToEntity = directionToEntity.normalize();
            double angleSimilarity = casterViewAngle.dot(directionToEntity);

            boolean hasLineOfSight = caster.pick(distanceToEntity, 0, false).getType() == HitResult.Type.MISS;

            if (angleSimilarity > 1.0 - 0.075 / distanceToEntity && hasLineOfSight) {
                ctx.setLocation(e.position());
                return List.of(new EntityHitResult(e));
            }
        }
        HitResult hit = caster.pick(4.5f, 0f, false);
        ctx.setLocation(hit.getLocation());
        return List.of(hit);
    }

}
