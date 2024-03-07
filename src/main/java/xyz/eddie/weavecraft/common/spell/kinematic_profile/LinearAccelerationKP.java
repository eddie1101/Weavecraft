package xyz.eddie.weavecraft.common.spell.kinematic_profile;

import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;

public class LinearAccelerationKP implements IKinematicProfile {

    @Override
    public Vec3 calculateAcceleration(CastingContext ctx) {
        return ctx.getCaster().getDeltaMovement().normalize().scale(0.05000000074505806);
    }
}
