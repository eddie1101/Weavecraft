package xyz.eddie.weavecraft.common.spell.caster.casters;

import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.caster.ISpellCaster;
import xyz.eddie.weavecraft.common.spell.shape.ISpellShape;

import java.util.ArrayList;
import java.util.List;

public class MultiCaster implements ISpellCaster {

    protected int casts;
    protected List<ISpellShape> shapes;
    protected List<SpellSequence> sequences;

    protected MultiCaster(int casts) {
        this.casts = casts;
        shapes = new ArrayList<>();
        sequences = new ArrayList<>();
    }

    protected final void shapes(ISpellShape... shapes) {
        this.shapes = new ArrayList<>(List.of(shapes));
    }

    protected final void sequences(SpellSequence... sequences) {
        this.sequences = new ArrayList<>(List.of(sequences));
    }

    @Override
    public void cast(CastingContext ctx) {
        for(int i = 0; i < casts; i++) {
            shapes.get(i).create(ctx, sequences.get(i));
        }
    }
}
