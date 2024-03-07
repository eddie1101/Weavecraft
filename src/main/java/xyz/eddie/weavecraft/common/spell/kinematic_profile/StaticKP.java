package xyz.eddie.weavecraft.common.spell.kinematic_profile;

import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;

public class StaticKP implements IKinematicProfile {

    @Override
    public Vec3 calculateAcceleration(CastingContext ctx) {
        return new Vec3(0, 0, 0);
    }
}
