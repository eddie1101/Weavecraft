package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.projectile.Projectile;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;

public class SpellComponent {

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

    public SpellComponent() {}

    public void setEffect(SpellEffect effect) {
        this.effect = effect;
    }

}
