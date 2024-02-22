package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.modifier.SpellEffectModifier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class SpellEffect implements ISpellEffect {

    protected int baseManaCost;
    protected int baseCastDelay;

    public Set<SpellEffectModifier> acceptedModifiers;
    public Map<SpellEffectModifier, Integer> appliedModifiers;

    public SpellEffect(int baseManaCost, int baseCastDelay) {
        this.baseManaCost = baseManaCost;
        this.baseCastDelay = baseCastDelay;

        acceptedModifiers = new HashSet<>();
        appliedModifiers = new HashMap<>();

        addAcceptedModifiers();
    }

    protected abstract void addAcceptedModifiers();

    public abstract int calcManaCost();
    public abstract int calcCastDelay();

    public boolean acceptsModifier(SpellEffectModifier modifier) {
        return acceptedModifiers.contains(modifier);
    }

    public boolean applyModifier(SpellEffectModifier modifier, int level) {
        if(acceptsModifier(modifier)) {
            appliedModifiers.put(modifier, Math.min(level, modifier.maxLevel));
            return true;
        }
        return false;
    }

    public boolean hasModifier(SpellEffectModifier modifier) {
        return appliedModifiers.containsKey(modifier);
    }

    public int getModifierLevel(SpellEffectModifier modifier) {
        if(hasModifier(modifier)) {
            return appliedModifiers.get(modifier);
        }
        return 0;
    }

    @Override
    public void onHit(HitResult hit, CastingContext ctx) {
        if(hit.getType() == HitResult.Type.ENTITY) {
            onHitEntity((EntityHitResult) hit, ctx);
        } else if(hit.getType() == HitResult.Type.BLOCK) {
            onHitBlock((BlockHitResult) hit, ctx);
        }
    }

}
