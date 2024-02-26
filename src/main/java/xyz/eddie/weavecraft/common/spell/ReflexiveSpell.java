package xyz.eddie.weavecraft.common.spell;

public class ReflexiveSpell extends Spell {

    public ReflexiveSpell() {
        super();
    }

    @Override
    public void cast(CastingContext ctx) {
        spellSequence.activate(ctx);
    }

}
