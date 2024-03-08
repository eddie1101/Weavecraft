package xyz.eddie.weavecraft.common.spell.targeter.targeters;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.targeter.ISpellTargeter;
import xyz.eddie.weavecraft.common.spell.targeter.SpellTargeter;

import java.util.List;

public class ReflexSpellTargeter implements ISpellTargeter {

    @Override
    public List<HitResult> gatherTargets(CastingContext ctx) {
        return List.of(new EntityHitResult(ctx.getCaster()));
    }

}
