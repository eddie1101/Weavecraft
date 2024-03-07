package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.caster.ISpellCaster;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;

import java.util.List;

public class MultiCaster implements ISpellCaster {

    protected List<ISpellShape> shapes;
    protected List<SpellSequence> sequences;

    public MultiCaster(List<ISpellShape> shapes, List<SpellSequence> sequences) {
        this.shapes = shapes;
        this.sequences = sequences;
    }

    @Override
    public void cast(CastingContext ctx) {
        for(int i = 0; i < shapes.size(); i++) {
            SpellSequence sequence = new SpellSequence();
            if(i < sequences.size()) {
                sequence = sequences.get(i);
            }
            shapes.get(i).create(ctx, sequence);
        }
    }
}
