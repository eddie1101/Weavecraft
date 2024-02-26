package xyz.eddie.weavecraft.common.spell.amplifier;

public enum Amplifier {

    INTENSITY(5, 1.15f, 1.1f),
    RANGE(5, 1.1f, 1.3f),
    DURATION(5, 1.2f, 1.1f);

    private final int maxLevel;
    private final float manaCostMult, castDelayMult;
    Amplifier(int maxLevel, float manaCostMult, float castDelayMult) {
        this.maxLevel = maxLevel;
        this.manaCostMult = manaCostMult;
        this.castDelayMult = castDelayMult;
    }

    public int maxLevel() {
        return maxLevel;
    }

    public float manaCostMultiplier() {
        return manaCostMult;
    }

    public float castDelayMultiplier() {
        return castDelayMult;
    }

}
