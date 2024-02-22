package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.effect.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;

public class ReflexiveSpellComponent extends SpellComponent {

    public ReflexiveSpellComponent() {
        super();
    }

    @Override
    public void cast(CastingContext ctx) {
        this.effect.onHit(new EntityHitResult(ctx.caster), ctx.level);
    }
}
