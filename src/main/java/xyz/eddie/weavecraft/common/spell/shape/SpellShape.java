package xyz.eddie.weavecraft.common.spell.shape;

import xyz.eddie.weavecraft.common.spell.kinematic_profile.IKinematicProfile;
import xyz.eddie.weavecraft.common.spell.shape.shapes.NoSpellShape;
import xyz.eddie.weavecraft.common.spell.shape.shapes.ProjectileSpellShape;

public abstract class SpellShape {

    public static final ISpellShape NO_SHAPE = new NoSpellShape();
    public static ISpellShape PROJECTILE(IKinematicProfile kf) { return new ProjectileSpellShape(kf); }

}
