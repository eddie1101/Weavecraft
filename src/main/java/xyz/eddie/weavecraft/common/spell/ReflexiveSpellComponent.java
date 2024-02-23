package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.phys.EntityHitResult;

public class ReflexiveSpellComponent extends SpellComponent {

    public ReflexiveSpellComponent() {
        super();
    }

    @Override
    public void cast(CastingContext ctx) {
        this.effect.onHit(new EntityHitResult(ctx.caster), ctx);
    }
}
