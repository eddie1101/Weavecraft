package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.effect.BaseSpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;
import xyz.eddie.weavecraft.common.spell.targeter.ISpellTargeter;
import xyz.eddie.weavecraft.common.spell.targeter.SpellTargeter;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.List;

public class SpellSequence implements Serializable {

    protected ISpellEffect effect;
    protected ISpellTargeter targeter;
    @Nullable
    protected Spell trigger;

    public SpellSequence() {
        this(new BaseSpellEffect(), SpellTargeter.REFLEX);
    }

    public SpellSequence(ISpellEffect effect, ISpellTargeter targeter) {
        this(effect, targeter, null);
    }

    public SpellSequence(ISpellEffect effect, ISpellTargeter targeter, @Nullable Spell trigger) {
        this.effect = effect;
        this.targeter = targeter;
        this.trigger = trigger;
    }

    public void activate(CastingContext ctx) {
        List<HitResult> targets = targeter.gatherTargets(ctx);

        boolean success = false;
        for(HitResult target: targets) {
            success = this.effect.onHit(target, ctx) || success;
        }

        if(trigger != null && success) {
            trigger.cast(ctx);
        }
    }

    public ISpellTargeter getTargeter() {
        return targeter;
    }

    public ISpellEffect getEffect() {
        return effect;
    }

    @Nullable
    public Spell getTrigger() {
        return trigger;
    }

    public void setTrigger(Spell trigger) {
        this.trigger = trigger;
    }

}
