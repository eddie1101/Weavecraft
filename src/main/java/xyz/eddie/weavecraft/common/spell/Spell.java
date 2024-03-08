package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.caster.ISpellCaster;

import java.io.Serializable;

public class Spell implements Serializable {

    protected ISpellCaster caster;

    public Spell(ISpellCaster caster) {
        this.caster = caster;
    }

    public void cast(Entity caster, Level level, ItemStack proklitia, Vec3 position) {
        cast(new CastingContext(caster, level, proklitia, position));
    }

    public void cast(Entity caster, Level level, ItemStack proklitia) {
       cast(new CastingContext(caster, level, proklitia, caster.position()));
    }

    public void cast(CastingContext ctx) {
        caster.cast(ctx);
    }

    public ISpellCaster getCaster() {
        return caster;
    }
}
