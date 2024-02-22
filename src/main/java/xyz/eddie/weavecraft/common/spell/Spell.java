package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;

public class Spell {

    SpellComponent rootComponent;

    private Spell() {}

    private void setRootComponent(SpellComponent root) {
        rootComponent = root;
    }

    public void cast(Entity caster, Level level, ItemStack proklitia) {
        rootComponent.cast(new CastingContext(caster, level, proklitia));
    }

    public static class SpellBuilder {

        Spell spell;
        SpellComponent root;
        public SpellBuilder(boolean isReflexive) {
            spell = new Spell();
            if(isReflexive) {
                root = new ReflexiveSpellComponent();
            } else {
                root = new ExpulsiveSpellComponent();
            }

        }

        public SpellBuilder() {
            this(true);
        }

        public SpellBuilder effect(SpellEffect effect) {
            root.setEffect(effect);
            return this;
        }

        public Spell build() {
            spell.setRootComponent(root);
            return spell;
        }

    }

}
