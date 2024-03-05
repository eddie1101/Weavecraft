package xyz.eddie.weavecraft.common.spell.targeter.targeters;

import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.targeter.SpellTargeter;

import java.util.ArrayList;
import java.util.List;

public class HitSpellTargeter extends SpellTargeter {

    @Override
    public List<HitResult> gatherTargets(CastingContext ctx) {
        if(ctx.getHits().isEmpty()) {
            return new ArrayList<>();
        } else {
            return ctx.getHits().get();
        }
    }
}
