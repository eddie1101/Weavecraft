package xyz.eddie.weavecraft.common.spell.aspect.aspects;

import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.aspect.KineticAspect;

public class StationaryKineticAspect extends KineticAspect {

    public StationaryKineticAspect() {
        super(0, 0);
    }

    @Override
    public Vec3 calculateAcceleration(CastingContext ctx) {
        return new Vec3(0, 0, 0);
    }

}
