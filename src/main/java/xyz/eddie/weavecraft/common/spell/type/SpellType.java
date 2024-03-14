package xyz.eddie.weavecraft.common.spell.type;

import xyz.eddie.weavecraft.common.spell.kinematic_profile.IKinematicProfile;
import xyz.eddie.weavecraft.common.spell.type.types.InstantType;
import xyz.eddie.weavecraft.common.spell.type.types.ProjectileType;

public abstract class SpellType {

    public static final ISpellType INSTANT = new InstantType();
    public static ISpellType PROJECTILE(IKinematicProfile kf) { return new ProjectileType(kf); }

}
