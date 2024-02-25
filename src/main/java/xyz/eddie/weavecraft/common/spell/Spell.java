package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.eddie.weavecraft.common.spell.effect.BaseSpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.EffectAmplifier;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;

import java.util.function.Function;

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

        ISpellEffect cachedEffect;

        Spell spell;
        SpellComponent root;
        public SpellBuilder(boolean isReflexive) {
            spell = new Spell();
            if(isReflexive) {
                root = new ReflexiveSpellComponent();
            } else {
                root = new ExpulsiveSpellComponent();
            }
            cachedEffect = new BaseSpellEffect();
        }

        public SpellBuilder() {
            this(true);
        }

//        public SpellBuilder targetModifier(SpellModifier modifier, int level) {
//            this.root.applyModifier(modifier, level);
//            return this;
//        }
//
//        public SpellBuilder targetModifier(SpellModifier modifier) {
//            return targetModifier(modifier, 1);
//        }

        public SpellBuilder effect(Function<ISpellEffect, ISpellEffect> supplier) {
            this.cachedEffect = supplier.apply(cachedEffect);
            return this;
        }

        public SpellBuilder amplifyEffect(EffectAmplifier amplifier, int level) {
            this.cachedEffect.setAmplifierLevel(amplifier, level);
            return this;
        }

        public Spell build() {
            this.root.setEffect(cachedEffect);
            spell.setRootComponent(root);
            return spell;
        }

    }

}
