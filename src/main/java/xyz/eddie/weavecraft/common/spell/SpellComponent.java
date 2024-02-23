package xyz.eddie.weavecraft.common.spell;

import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;
import xyz.eddie.weavecraft.common.spell.modifier.ModifiableSpellComponent;

public abstract class SpellComponent extends ModifiableSpellComponent {

    /*

    Spell can have multiple effects
    Effects can trigger more spells
    Reflexive spells are given the target
    Expulsive spells collect targets
    effects apply default behaviors
    modifiers override those behaviors

    onHit
    onHitBlock
    onHitEntity

     */

    protected SpellEffect effect;

    protected SpellComponent() {
        super();
    }



    public void setEffect(SpellEffect effect) {
        this.effect = effect;
    }
    public abstract void cast(CastingContext ctx);

}
