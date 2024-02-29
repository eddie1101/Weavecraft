package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.expulsive.ExpulsiveSpell;
import xyz.eddie.weavecraft.common.spell.expulsive.aspect.ExpulsiveAspect;
import xyz.eddie.weavecraft.common.spell.expulsive.aspect.KineticAspect;
import xyz.eddie.weavecraft.common.spell.targeter.ISpellTargeter;

import java.io.Serializable;
import java.util.function.Function;

public abstract class Spell implements Serializable {

    protected SpellSequence spellSequence;

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

        protected Spell spell;
        protected SpellSequence spellSequence;

        protected SpellBuilder(Spell spell) {
            this.spell = spell;
            this.spellSequence = spell.spellSequence;
        }

        public SpellBuilder() {
            this.spell = new ReflexiveSpell();
            this.spellSequence = spell.spellSequence;
        }

        public SpellBuilder targeter(ISpellTargeter targeter) {
            this.spellSequence.setTargeter(targeter);
            return this;
        }

        public SpellBuilder amplifyTargeter(Amplifier amp, int level) {
            this.spellSequence.getTargeter().amplify(amp, level);
            return this;
        }

        public SpellBuilder effect(Function<ISpellEffect, ISpellEffect> supplier) {
            this.spellSequence.setEffect(supplier.apply(this.spellSequence.getEffect()));
            return this;
        }

        public SpellBuilder amplifyEffect(Amplifier amp, int level) {
            this.spellSequence.getEffect().amplify(amp, level);
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

    public static class ExpulsiveSpellBuilder extends SpellBuilder {

        public ExpulsiveSpellBuilder() {
            super(new ExpulsiveSpell());
        }

        public ExpulsiveSpellBuilder kineticAspect(KineticAspect kineticAspect) {
            ((ExpulsiveSpell) spell).setKineticAspect(kineticAspect);
            return this;
        }

        public ExpulsiveSpellBuilder amplifyKineticAspect(Amplifier amplifier, int level) {
            ((ExpulsiveSpell) spell).getKineticAspect().amplify(amplifier, level);
            return this;
        }

        public ExpulsiveSpellBuilder expulsiveAspect(ExpulsiveAspect expulsiveAspect) {
            ((ExpulsiveSpell) spell).setExpulsiveAspect(expulsiveAspect);
            return this;
        }

    }
}
