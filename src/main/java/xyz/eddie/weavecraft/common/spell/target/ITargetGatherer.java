package xyz.eddie.weavecraft.common.spell.target;

import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.ISpellDeductible;
import xyz.eddie.weavecraft.common.spell.amplifier.IAmplifiable;

import java.util.List;

public interface ITargetGatherer extends IAmplifiable, ISpellDeductible {

    List<HitResult> gatherTargets(CastingContext ctx);

}
