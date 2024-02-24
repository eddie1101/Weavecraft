package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;
import xyz.eddie.weavecraft.common.spell.modifier.SpellModifier;

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

        SpellEffect cachedEffect;

        Spell spell;
        SpellComponent root;
        public SpellBuilder(boolean isReflexive) {
            spell = new Spell();
            if(isReflexive) {
                root = new ReflexiveSpellComponent();
            } else {
                root = new ExpulsiveSpellComponent();
            }
            cachedEffect = null;
        }

        public SpellBuilder() {
            this(true);
        }

        public SpellBuilder targetModifier(SpellModifier modifier, int level) {
            this.root.applyModifier(modifier, level);
            return this;
        }

        public SpellBuilder targetModifier(SpellModifier modifier) {
            return targetModifier(modifier, 1);
        }

        public SpellBuilder effect(SpellEffect effect) {
            this.cachedEffect = effect;
            return this;
        }

        public SpellBuilder effectModifier(SpellModifier modifier, int level) {
            if(cachedEffect == null) {
                throw new IllegalStateException("Tried to apply a modifier to an effect, but there is no effect. Call effect() before effectModifier().");
            }
            this.cachedEffect.applyModifier(modifier, level);
            return this;
        }

        public SpellBuilder effectModifier(SpellModifier modifier) {
            return effectModifier(modifier, 1);
        }

        public Spell build() {
            this.root.setEffect(cachedEffect);
            spell.setRootComponent(root);
            return spell;
        }

    }

}
