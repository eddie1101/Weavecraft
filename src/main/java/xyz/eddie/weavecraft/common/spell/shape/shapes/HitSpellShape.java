package xyz.eddie.weavecraft.common.spell.shape.shapes;

import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;

import java.util.ArrayList;
import java.util.List;

public class HitSpellShape implements ISpellShape {

    @Override
    public List<HitResult> gatherTargets(CastingContext ctx) {
        if(ctx.getHits().isEmpty()) {
            return new ArrayList<>();
        } else {
            return ctx.getHits().get();
        }
    }
}
