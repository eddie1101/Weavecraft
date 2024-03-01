package xyz.eddie.weavecraft.common.spell.aspect;

import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.AmplifiableSpellDeductible;
import xyz.eddie.weavecraft.common.spell.aspect.aspects.LinearKineticAspect;
import xyz.eddie.weavecraft.common.spell.aspect.aspects.StationaryKineticAspect;

public abstract class KineticAspect extends AmplifiableSpellDeductible {

    public static final LinearKineticAspect LINEAR = new LinearKineticAspect();
    public static final StationaryKineticAspect STATIONARY = new StationaryKineticAspect();

    public KineticAspect(int manaCost, int castDelay) {
        super(manaCost, castDelay);
    }

    public abstract Vec3 calculateAcceleration(CastingContext ctx);

}
