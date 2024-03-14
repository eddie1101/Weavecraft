package xyz.eddie.weavecraft.common.spell.shape.shapes;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;

import java.util.List;

public class ReflexSpellShape implements ISpellShape {

    @Override
    public List<HitResult> gatherTargets(CastingContext ctx) {
        return List.of(new EntityHitResult(ctx.getCaster()));
    }

}
