package xyz.eddie.weavecraft.common.spell.target;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.AmplifiableSpellDeductible;

import java.util.List;

public class Reflex extends AmplifiableSpellDeductible implements ITargeter {

    public Reflex() {
        super(1, 1);
    }

    @Override
    public List<HitResult> gatherTargets(CastingContext ctx) {
        return List.of(new EntityHitResult(ctx.caster));
    }

}
