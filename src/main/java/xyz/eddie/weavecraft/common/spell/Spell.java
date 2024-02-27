package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.targeter.ISpellTargeter;

import java.io.Serializable;
import java.util.function.Function;

public abstract class Spell implements Serializable {

    SpellSequence spellSequence;

    protected Spell() {
        spellSequence = new SpellSequence();
    }

    private void setSpellSequence(SpellSequence root) {
        spellSequence = root;
    }

    public void cast(Entity caster, Level level, ItemStack proklitia, Vec3 position) {
        cast(new CastingContext(caster, level, proklitia, position));
    }

    public void cast(Entity caster, Level level, ItemStack proklitia) {
       cast(new CastingContext(caster, level, proklitia, caster.position()));
    }

    public abstract void cast(CastingContext ctx);

    public static class SpellBuilder {

        Spell spell;
        SpellSequence spellSequence;

        private SpellBuilder(Spell spell) {
            this.spell = spell;
            this.spellSequence = spell.spellSequence;
        }

        public static SpellBuilder reflexive() {
            return new SpellBuilder(new ReflexiveSpell());
        }

        public static SpellBuilder expulsive() {
            return new SpellBuilder(new ExpulsiveSpell());
        }

        public SpellBuilder targeter(ISpellTargeter targeter) {
            this.spellSequence.setTargeter(targeter);
            return this;
        }

        public SpellBuilder amplifyTargeter(Amplifier amp, int level) {
            this.spellSequence.getTargeter().setAmplifierLevel(amp, level);
            return this;
        }

        public SpellBuilder effect(Function<ISpellEffect, ISpellEffect> supplier) {
            this.spellSequence.setEffect(supplier.apply(this.spellSequence.getEffect()));
            return this;
        }

        public SpellBuilder amplifyEffect(Amplifier amp, int level) {
            this.spellSequence.getEffect().setAmplifierLevel(amp, level);
            return this;
        }

        public SpellBuilder addTrigger(Spell spell) {
            this.spellSequence.setTrigger(spell);
            return this;
        }

        public Spell build() {
            spell.setSpellSequence(spellSequence);
            return spell;
        }
    }
}
