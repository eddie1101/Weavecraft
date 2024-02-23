package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.modifier.SpellModifier;

public class ReflexiveSpellComponent extends SpellComponent {

    public ReflexiveSpellComponent() {
        super();
    }

    @Override
    protected void declareAcceptedModifiers() {
        this.acceptedModifiers.add(SpellModifier.TOUCH);
    }

    @Override
    public void cast(CastingContext ctx) {
        if(this.hasModifier(SpellModifier.TOUCH)) {
            this.effect.onHit(ctx.caster.pick(ctx.caster.getPickRadius(), 0f, false), ctx);
        } else {
            this.effect.onHit(new EntityHitResult(ctx.caster), ctx);
        }
    }
}
