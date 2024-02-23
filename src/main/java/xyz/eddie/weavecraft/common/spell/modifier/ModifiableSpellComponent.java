package xyz.eddie.weavecraft.common.spell.modifier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class ModifiableSpellComponent {

    protected Set<SpellModifier> acceptedModifiers;
    protected Map<SpellModifier, Integer> appliedModifiers;

    public ModifiableSpellComponent() {
        acceptedModifiers = new HashSet<>();
        appliedModifiers = new HashMap<>();

        declareAcceptedModifiers();
    }

    protected abstract void declareAcceptedModifiers();

    public boolean acceptsModifier(SpellModifier modifier) {
        return acceptedModifiers.contains(modifier);
    }

    public boolean applyModifier(SpellModifier modifier, int level) {
        if(acceptsModifier(modifier)) {
            appliedModifiers.put(modifier, Math.min(Math.max(1, level), modifier.maxLevel));
            return true;
        }
        return false;
    }

    public boolean hasModifier(SpellModifier modifier) {
        return appliedModifiers.containsKey(modifier);
    }

    public int getModifierLevel(SpellModifier modifier) {
        if(hasModifier(modifier)) {
            return appliedModifiers.get(modifier);
        }
        return 0;
    }

}
