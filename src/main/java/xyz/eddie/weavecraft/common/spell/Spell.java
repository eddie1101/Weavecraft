package xyz.eddie.weavecraft.common.spell;

import xyz.eddie.weavecraft.common.spell.component.ConveyorComponent;
import xyz.eddie.weavecraft.common.spell.component.EffectComponent;
import xyz.eddie.weavecraft.common.spell.component.SpellComponent;
import xyz.eddie.weavecraft.common.spell.component.modifier.ConveyorModifier;
import xyz.eddie.weavecraft.common.spell.component.modifier.EffectModifier;

public class Spell {

    SpellComponent rootComponent;

    private Spell() {
        rootComponent = new SpellComponent();
    }

    public static class SpellBuilder {

        Spell spell;
        public SpellBuilder() {
            spell = new Spell();
        }

        public SpellBuilder conveyorModifier(ConveyorModifier modifier) {
            return this;
        }

        public SpellBuilder conveyor(ConveyorComponent conveyor) {
            return this;
        }

        public SpellBuilder effectModifier(EffectModifier modifier) {
            return this;
        }

        public SpellBuilder effect(EffectComponent effect) {
            return this;
        }

        public Spell build() {
            return spell;
        }

    }

}
