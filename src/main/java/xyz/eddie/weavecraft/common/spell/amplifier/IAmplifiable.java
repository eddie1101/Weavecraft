package xyz.eddie.weavecraft.common.spell.amplifier;

public interface IAmplifiable {

    int getAmplifierLevel(SpellAmplifier amplifier);
    void setAmplifierLevel(SpellAmplifier amplifier, int level);

}
