package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.effect.BaseSpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.targeter.ISpellTargeter;

import java.util.List;

public class SpellComponent implements ISpellComponent {

    protected ISpellEffect effect;
    protected ISpellTargeter targeter;
    protected Spell trigger;

    public SpellComponent() {
        setEffect(new BaseSpellEffect());
    }

    public void activate(CastingContext ctx) {
        List<HitResult> targets = targeter.gatherTargets(ctx);

        boolean success = false;
        for(HitResult target: targets) {
            success = success || this.effect.onHit(target, ctx);
        }

        if(trigger != null && success) {
            trigger.cast(ctx);
        }
    }

    public void setTargeter(ISpellTargeter targeter) {
        this.targeter = targeter;
    }

    public void setEffect(ISpellEffect effect) {
        this.effect = effect;
    }

    public void setTrigger(Spell spell) {
        this.trigger = spell;
    }

    public ISpellTargeter getTargeter() {
        return targeter;
    }

    public ISpellEffect getEffect() {
        return effect;
    }

    public Spell getTrigger() {
        return trigger;
    }

}
