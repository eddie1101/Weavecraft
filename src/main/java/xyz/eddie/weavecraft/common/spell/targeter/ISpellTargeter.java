package xyz.eddie.weavecraft.common.spell.targeter;

import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;

import java.util.List;

public interface ISpellTargeter {

    List<HitResult> gatherTargets(CastingContext ctx);

}
