package xyz.eddie.weavecraft.common.spell;

import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;

public class Spell {

    SpellComponent rootComponent;

    private Spell() {}

    private void setRootComponent(SpellComponent root) {
        rootComponent = root;
    }

    public static class SpellBuilder {

        Spell spell;
        SpellComponent root;
        public SpellBuilder() {
            spell = new Spell();
            root = new SpellComponent();
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
