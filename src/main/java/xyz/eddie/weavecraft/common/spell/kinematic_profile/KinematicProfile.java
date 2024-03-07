package xyz.eddie.weavecraft.common.spell.kinematic_profile;

public class KinematicProfile {

    public static final IKinematicProfile LINEAR = new LinearKP();
    public static final IKinematicProfile LINEAR_ACCELERATION = new LinearAccelerationKP();
    public static final IKinematicProfile STATIC = new StaticKP();
    public static final IKinematicProfile ARCH = new ArchKP();

}
