package xyz.eddie.weavecraft.common.spell.targeter.targeters;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;

import java.util.List;

public class ReflexSpellTargeter extends SpellTargeter {

    public ReflexSpellTargeter() {
        super(1, 1);
    }

    @Override
    public List<HitResult> gatherTargets(CastingContext ctx) {
        return List.of(new EntityHitResult(ctx.getCaster()));
    }

}
