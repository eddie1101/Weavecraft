package xyz.eddie.weavecraft.common.spell.aspect.aspects;

import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.aspect.KineticAspect;

public class LinearKineticAspect extends KineticAspect {

    public LinearKineticAspect() {
        super(5, 1);
    }

    public Vec3 calculateAcceleration(CastingContext ctx) {
        return ctx.getCaster().getLookAngle().scale(this.getAmplifier(Amplifier.INTENSITY)).scale(0.05);
    }

}
