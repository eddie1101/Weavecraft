package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.effects.BlankSpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.ISpellEffect;
import xyz.eddie.weavecraft.common.spell.caster.ISpellCaster;
import xyz.eddie.weavecraft.common.spell.type.ISpellType;

import java.util.List;

public class MultiCaster implements ISpellCaster {

    protected List<ISpellType> type;
    protected List<ISpellEffect> effects;

    public MultiCaster(List<ISpellType> type, List<ISpellEffect> effects) {
        this.type = type;
        this.effects = effects;
    }

    @Override
    public void cast(CastingContext ctx) {
        for(int i = 0; i < type.size(); i++) {
            ISpellEffect effect = new BlankSpellEffect();
            if(i < effects.size()) {
                effect = effects.get(i);
            }
            type.get(i).create(ctx, effect);
        }
    }
}
