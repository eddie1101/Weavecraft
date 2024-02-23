package xyz.eddie.weavecraft.common.spell;

import xyz.eddie.weavecraft.common.spell.modifier.SpellModifier;

public class ExpulsiveSpellComponent extends SpellComponent {

    public ExpulsiveSpellComponent() {
        super();
    }

    @Override
    protected void declareAcceptedModifiers() {
        this.acceptedModifiers.add(SpellModifier.RANGE);
    }

    @Override
    public void cast(CastingContext ctx) {
        return;
    }

}
