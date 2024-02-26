package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.component.ExpulsiveSpellComponent;
import xyz.eddie.weavecraft.common.spell.component.ReflexiveSpellComponent;
import xyz.eddie.weavecraft.common.spell.component.SpellComponent;
import xyz.eddie.weavecraft.common.spell.effect.BaseSpellEffect;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.targeter.ISpellTargeter;

import java.util.function.Function;

public class Spell {

    SpellComponent rootComponent;

    private Spell() {}

    private void setRootComponent(SpellComponent root) {
        rootComponent = root;
    }

    public void cast(Entity caster, Level level, ItemStack proklitia, Vec3 position) {
        rootComponent.cast(new CastingContext(caster, level, proklitia, position));
    }

    public void cast(Entity caster, Level level, ItemStack proklitia) {
        rootComponent.cast(new CastingContext(caster, level, proklitia, caster.position()));
    }

    public void cast(CastingContext ctx) {
        rootComponent.cast(ctx);
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

            root.setEffect(new BaseSpellEffect());
        }

        public SpellBuilder() {
            this(true);
        }

        public SpellBuilder targeter(ISpellTargeter targeter) {
            this.root.setTargeter(targeter);
            return this;
        }

        public SpellBuilder amplifyTargeter(Amplifier amp, int level) {
            this.root.getTargeter().setAmplifierLevel(amp, level);
            return this;
        }

        public SpellBuilder effect(Function<ISpellEffect, ISpellEffect> supplier) {
            this.root.setEffect(supplier.apply(this.root.getEffect()));
            return this;
        }

        public SpellBuilder amplifyEffect(Amplifier amp, int level) {
            this.root.getEffect().setAmplifierLevel(amp, level);
            return this;
        }

        public SpellBuilder addTrigger(Spell spell) {
            this.root.setTrigger(spell);
            return this;
        }

        public Spell build() {
            spell.setRootComponent(root);
            return spell;
        }

    }

}
