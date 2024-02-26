package xyz.eddie.weavecraft.common.spell.component;

import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;

import java.util.List;

public class ReflexiveSpellComponent extends SpellComponent {

    @Override
    public void cast(CastingContext ctx) {
        List<HitResult> targets = targeter.gatherTargets(ctx);

        boolean success = false;
        for(HitResult target: targets) {
            success = this.effect.onHit(target, ctx);
        }

        if(trigger != null && success) {
            trigger.cast(ctx);
        }
    }
}
