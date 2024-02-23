package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.modifier.ModifiableSpellComponent;

public abstract class SpellEffect extends ModifiableSpellComponent implements ISpellEffect {

    protected int baseManaCost;
    protected int baseCastDelay;

    public SpellEffect(int baseManaCost, int baseCastDelay) {
        super();
        this.baseManaCost = baseManaCost;
        this.baseCastDelay = baseCastDelay;
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
