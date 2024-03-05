package xyz.eddie.weavecraft.common.spell.kinetic_formula;

import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.entity.SpellEntity;
import xyz.eddie.weavecraft.common.spell.CastingContext;

public class LinearKF implements IKineticFormula {

    @Override
    public Vec3 calculateAcceleration(CastingContext ctx) {
        return new Vec3(0, 0, 0);
    }
}
