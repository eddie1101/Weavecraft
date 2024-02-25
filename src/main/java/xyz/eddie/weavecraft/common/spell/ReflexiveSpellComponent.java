package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ReflexiveSpellComponent extends SpellComponent {

    public ReflexiveSpellComponent() {
        super();
    }

    @Override
    public void cast(CastingContext ctx) {
        Entity caster = ctx.caster;
        for (Entity e : ctx.level.getEntities(caster, caster.getBoundingBox().inflate(4.5F))) {
            Vec3 casterViewAngle = caster.getViewVector(1.0F).normalize();
            Vec3 directionToEntity = new Vec3(e.getX() - caster.getX(), e.getEyeY() - caster.getEyeY(), e.getZ() - caster.getZ());
            double distanceToEntity = directionToEntity.length();
            directionToEntity = directionToEntity.normalize();
            double angleSimilarity = casterViewAngle.dot(directionToEntity);

            boolean hasLineOfSight = caster.pick(distanceToEntity, 0, false).getType() == HitResult.Type.MISS;

            if (angleSimilarity > 1.0 - 0.075 / distanceToEntity && hasLineOfSight) {
                this.effect.onHit(new EntityHitResult(e), ctx);
            }
        }

//        this.effect.onHit(new EntityHitResult(caster), ctx);
    }
}
