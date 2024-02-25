package xyz.eddie.weavecraft.common.spell.target;

import java.util.function.Supplier;

public enum TargetGatherer implements Supplier<ITargetGatherer> {

    REFLEX(new Reflex(), 1, 1),
    TOUCH(new Touch(), 15, 10);

    final int baseManaCost, baseCastDelay;
    final ITargetGatherer targetGatherer;
    TargetGatherer(ITargetGatherer targetGatherer, int baseManaCost, int baseCastDelay) {
        this.targetGatherer = targetGatherer;
        this.baseManaCost = baseManaCost;
        this.baseCastDelay = baseCastDelay;
    }

    @Override
    public ITargetGatherer get() {
        return targetGatherer;
    }

    public int baseManaCost() {
        return baseManaCost;
    }

    public int getBaseCastDelay() {
        return baseCastDelay;
    }
}
