package xyz.eddie.weavecraft.common.spell.shape;

import net.minecraft.world.phys.HitResult;
import xyz.eddie.weavecraft.common.spell.CastingContext;

import java.io.Serializable;
import java.util.List;

public interface ISpellShape extends Serializable {

    List<HitResult> gatherTargets(CastingContext ctx);

}
