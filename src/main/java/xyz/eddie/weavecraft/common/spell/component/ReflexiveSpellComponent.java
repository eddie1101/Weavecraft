package xyz.eddie.weavecraft.common.spell.component;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.target.ITargetGatherer;

import java.util.List;

public class ReflexiveSpellComponent extends SpellComponent {

    public ReflexiveSpellComponent(ITargetGatherer targetGatherer) {
        super(targetGatherer);
    }

    @Override
    public void cast(CastingContext ctx) {
        List<HitResult> targets = targetGatherer.gatherTargets(ctx);

        for(HitResult target: targets) {
            this.effect.onHit(target, ctx);
        }
    }
}
