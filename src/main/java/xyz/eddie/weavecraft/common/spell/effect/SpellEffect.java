package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.Weavecraft;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.effect.effects.*;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class SpellEffect implements ISpellEffect {

    public static final SpellEffect DETONATE = new DetonateSpellEffect();
    public static final SpellEffect INFERNO = new InfernoSpellEffect();
    public static final SpellEffect DISINTEGRATE = new DisintegrateSpellEffect();
    public static final SpellEffect HARVEST = new HarvestSpellEffect();
    public static final SpellEffect PUSH = new PushSpellEffect();


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
            trigger.cast(ctx);
        }
    }

    @Override
    public void activate(CastingContext ctx) {
        if(shape != null) {
            List<HitResult> targets = gatherTargets(ctx);
            for (HitResult hit : targets) {
                onHit(hit, ctx);
            }
            if (!targets.isEmpty()) {
                castTrigger(ctx);
            }
        } else {
            Weavecraft.LOGGER.warn("Spell effect cast with no shape");
        }
    }

}
