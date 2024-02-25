package xyz.eddie.weavecraft.common.spell.target;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;

import java.util.ArrayList;
import java.util.List;

public class Reflex implements ITargetGatherer {

    @Override
    public List<HitResult> gatherTargets(CastingContext ctx) {
        return List.of(new EntityHitResult(ctx.caster));
    }

}
