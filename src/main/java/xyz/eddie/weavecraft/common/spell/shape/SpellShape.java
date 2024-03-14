package xyz.eddie.weavecraft.common.spell.shape;

import xyz.eddie.weavecraft.common.spell.shape.shapes.AOESpellShape;
import xyz.eddie.weavecraft.common.spell.shape.shapes.HitSpellShape;
import xyz.eddie.weavecraft.common.spell.shape.shapes.ReflexSpellShape;
import xyz.eddie.weavecraft.common.spell.shape.shapes.TouchSpellShape;

public abstract class SpellShape implements ISpellShape {

    public static ISpellShape REFLEX = new ReflexSpellShape();
    public static ISpellShape TOUCH = new TouchSpellShape();
    public static ISpellShape AOE = new AOESpellShape();
    public static ISpellShape HIT = new HitSpellShape();

}
