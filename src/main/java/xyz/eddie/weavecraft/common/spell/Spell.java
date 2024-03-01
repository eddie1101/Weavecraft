package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.caster.ISpellCaster;
import xyz.eddie.weavecraft.common.spell.caster.SpellCaster;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.aspect.ExpulsiveAspect;
import xyz.eddie.weavecraft.common.spell.aspect.KineticAspect;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;
import xyz.eddie.weavecraft.common.spell.targeter.ISpellTargeter;

import java.io.Serializable;
import java.util.function.Function;

public class Spell implements Serializable {

    protected SpellSequence spellSequence;
    protected ISpellCaster caster;

    protected Spell(ISpellCaster caster, SpellSequence sequence) {
        this.spellSequence = sequence;
        this.caster = caster;
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

    public void cast(CastingContext ctx) {
        caster.cast(ctx, spellSequence);
    }

    public static class SpellBuilder {

        protected Spell spell;
        protected SpellSequence spellSequence;
        protected ISpellCaster caster;

        public SpellBuilder() {
            this.spellSequence = new SpellSequence();
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

        public SpellBuilder caster(ISpellCaster caster) {
            this.caster = caster;
            return this;
        }

        public SpellBuilder shape(ISpellShape shape) {
            this.caster.setShape(shape);
            return this;
        }

        public Spell build() {
            spell = new Spell(caster, spellSequence);
            return spell;
        }
    }
}
