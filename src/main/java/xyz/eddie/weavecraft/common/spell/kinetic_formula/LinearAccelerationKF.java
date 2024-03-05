package xyz.eddie.weavecraft.common.spell.kinetic_formula;

import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;

public class LinearAccelerationKF implements IKineticFormula {

    @Override
    public Vec3 calculateAcceleration(CastingContext ctx) {
        Vec3 angle = ctx.getCaster().getDeltaMovement().normalize();
        double factor = Math.sqrt(Math.abs(angle.length()));
        return angle.scale(factor);
    }
}
