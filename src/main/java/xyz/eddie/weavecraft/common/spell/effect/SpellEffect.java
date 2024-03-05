package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.effect.effects.*;

import java.util.function.Function;

public abstract class SpellEffect implements ISpellEffect {

    public static final ISpellEffect DETONATE = new DetonateSpellEffect();
    public static final ISpellEffect INFERNO = new InfernoSpellEffect();
    public static final ISpellEffect DISINTEGRATE = new DisintegrateSpellEffect();
    public static final ISpellEffect HARVEST = new HarvestSpellEffect();
    public static final ISpellEffect PUSH = new PushSpellEffect();

}
