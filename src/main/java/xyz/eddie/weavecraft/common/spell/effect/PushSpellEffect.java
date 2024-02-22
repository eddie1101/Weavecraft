package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.modifier.SpellEffectModifier;

public class PushSpellEffect extends SpellEffect {

    public PushSpellEffect() {
        super(3, 3);
    }

    @Override
    protected void addAcceptedModifiers() {
        acceptedModifiers.add(SpellEffectModifier.INTENSITY);
    }

    @Override
    public int calcManaCost() {
        return baseManaCost * getModifierLevel(SpellEffectModifier.INTENSITY);
    }

    @Override
    public int calcCastDelay() {
        return baseCastDelay + getModifierLevel(SpellEffectModifier.INTENSITY);
    }

    @Override
    public void onHitEntity(EntityHitResult hit, CastingContext ctx) {
        Vec3 angle = ctx.caster.getLookAngle().normalize().scale(getModifierLevel(SpellEffectModifier.INTENSITY));
        hit.getEntity().push(angle.x, angle.y, angle.z);
    }

    @Override
    public void onHitBlock(BlockHitResult hit, CastingContext ctx) {
        //Nothin'
    }

}
