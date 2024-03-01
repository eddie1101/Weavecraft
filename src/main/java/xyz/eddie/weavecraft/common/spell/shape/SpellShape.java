package xyz.eddie.weavecraft.common.spell.shape;

import xyz.eddie.weavecraft.common.spell.SpellDeductible;
import xyz.eddie.weavecraft.common.spell.shape.shapes.NoSpellShape;
import xyz.eddie.weavecraft.common.spell.shape.shapes.ProjectileSpellShape;

public abstract class SpellShape extends SpellDeductible implements ISpellShape {

    public static final SpellShape NO_SHAPE = new NoSpellShape();
    public static final SpellShape PROJECTILE = new ProjectileSpellShape();

    public SpellShape(int manaCost, int castDelay) {
        super(manaCost, castDelay);
    }

}
