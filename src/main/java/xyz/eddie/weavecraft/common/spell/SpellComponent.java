package xyz.eddie.weavecraft.common.spell;

import xyz.eddie.weavecraft.common.spell.effect.BlankSpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;

public abstract class SpellComponent implements ISpellComponent {

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

    protected ISpellEffect effect;

    protected SpellComponent() {
        super();
    }



    public void setEffect(ISpellEffect effect) {
        this.effect = effect;
    }

}
