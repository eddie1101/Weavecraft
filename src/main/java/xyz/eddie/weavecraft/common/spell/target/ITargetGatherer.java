package xyz.eddie.weavecraft.common.spell.target;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;

import java.util.List;

@FunctionalInterface
public interface ITargetGatherer {

    List<HitResult> gatherTargets(CastingContext ctx);

}
