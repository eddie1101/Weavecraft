package xyz.eddie.weavecraft.common.spell.kinetic_formula;

import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;

import java.io.Serializable;


public interface IKineticFormula extends Serializable {

    Vec3 calculateAcceleration(CastingContext ctx);

}
