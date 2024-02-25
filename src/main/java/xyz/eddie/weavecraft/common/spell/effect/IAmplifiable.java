package xyz.eddie.weavecraft.common.spell.effect;

public interface IAmplifiable {

    int getAmplifierLevel(EffectAmplifier amplifier);
    void setAmplifierLevel(EffectAmplifier amplifier, int level);

}
