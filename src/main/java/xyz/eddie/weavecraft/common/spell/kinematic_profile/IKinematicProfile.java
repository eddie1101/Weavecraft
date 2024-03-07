package xyz.eddie.weavecraft.common.spell.kinematic_profile;

import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;

import java.io.Serializable;


public interface IKinematicProfile extends Serializable {

    Vec3 calculateAcceleration(CastingContext ctx);

}
