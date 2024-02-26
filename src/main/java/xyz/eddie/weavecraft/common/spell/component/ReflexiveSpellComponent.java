package xyz.eddie.weavecraft.common.spell.component;

import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.target.ITargeter;

import java.util.List;

public class ReflexiveSpellComponent extends SpellComponent {

    @Override
    public void cast(CastingContext ctx) {
        List<HitResult> targets = targeter.gatherTargets(ctx);

        for(HitResult target: targets) {
            this.effect.onHit(target, ctx);
        }
    }
}
