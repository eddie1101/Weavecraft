package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.Weavecraft;
import xyz.eddie.weavecraft.common.entity.TriggerEntity;
import xyz.eddie.weavecraft.common.registries.WeavecraftEntities;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class SpellEffect implements ISpellEffect {

    @Nullable
    private  ISpellShape shape = null;
    @Nullable
    private Spell trigger = null;


    public SpellEffect setShape(ISpellShape shape) {
        this.shape = shape;
        return this;
    }

    public SpellEffect setTrigger(Spell trigger) {
        this.trigger = trigger;
        return this;
    }


    protected final List<HitResult> gatherTargets(CastingContext ctx) {
        if(shape != null)
            return this.shape.gatherTargets(ctx);
        return new ArrayList<>();
    }

    protected final void castTrigger(CastingContext ctx) {
        if(trigger != null) {
            if(!ctx.getLevel().isClientSide())
                ctx.getLevel().addFreshEntity(new TriggerEntity(WeavecraftEntities.TRIGGER_ENTITY.get(), ctx, trigger));
        }
    }

    @Override
    public void activate(CastingContext ctx) {
        if(shape != null) {
            boolean miss = true;
            List<HitResult> targets = gatherTargets(ctx);
            for (HitResult hit : targets) {
                onHit(hit, ctx);
                if(hit.getType() != HitResult.Type.MISS) {
                    miss = false;
                }
            }
            if (!miss) {
                castTrigger(ctx);
            }
        } else {
            Weavecraft.LOGGER.warn("Spell effect cast with no shape");
        }
    }

}
