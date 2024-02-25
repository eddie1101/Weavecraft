package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.eddie.weavecraft.common.spell.component.ExpulsiveSpellComponent;
import xyz.eddie.weavecraft.common.spell.component.ReflexiveSpellComponent;
import xyz.eddie.weavecraft.common.spell.component.SpellComponent;
import xyz.eddie.weavecraft.common.spell.effect.BaseSpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.EffectAmplifier;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.target.ITargetGatherer;
import xyz.eddie.weavecraft.common.spell.target.TargetGatherer;

import java.util.function.Function;
import java.util.function.Supplier;

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

        public SpellBuilder(boolean isReflexive, ITargetGatherer targetGatherer, int baseManaCost, int baseCastDelay) {
            spell = new Spell();
            if(isReflexive) {
                root = new ReflexiveSpellComponent(targetGatherer);
            } else {
                root = new ExpulsiveSpellComponent(targetGatherer);
            }
            cachedEffect = new BaseSpellEffect(baseManaCost, baseCastDelay);
        }

        public SpellBuilder(boolean isReflexive, TargetGatherer targetGatherer) {
            spell = new Spell();
            if(isReflexive) {
                root = new ReflexiveSpellComponent(targetGatherer.get());
            } else {
                root = new ExpulsiveSpellComponent(targetGatherer.get());
            }
            cachedEffect = new BaseSpellEffect(targetGatherer.baseManaCost(), targetGatherer.getBaseCastDelay());
        }

        public SpellBuilder(TargetGatherer targetGatherer) {
            this(true, targetGatherer);
        }

        public SpellBuilder() {
            this(true, TargetGatherer.REFLEX);
        }

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
