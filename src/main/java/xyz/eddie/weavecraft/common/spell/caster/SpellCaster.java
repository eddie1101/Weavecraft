package xyz.eddie.weavecraft.common.spell.caster;

import xyz.eddie.weavecraft.common.spell.caster.casters.ScatterSpellCaster;
import xyz.eddie.weavecraft.common.spell.caster.casters.SingleSpellCaster;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;
import xyz.eddie.weavecraft.common.spell.shape.SpellShape;

public abstract class SpellCaster implements ISpellCaster {

    public static ISpellCaster SINGLE() {return new SingleSpellCaster();}
    public static ISpellCaster SCATTER(int frags) {return new ScatterSpellCaster(frags);}

    protected ISpellShape shape;

    public SpellCaster() {
        this.shape = SpellShape.NO_SHAPE;
    }

    public ISpellShape getShape() {
        return shape;
    }

    public void setShape(ISpellShape shape) {
        this.shape = shape;
    }

}
