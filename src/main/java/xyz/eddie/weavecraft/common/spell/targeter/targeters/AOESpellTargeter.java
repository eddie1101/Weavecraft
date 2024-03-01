package xyz.eddie.weavecraft.common.spell.targeter.targeters;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.targeter.SpellTargeter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AOESpellTargeter extends SpellTargeter {

    public AOESpellTargeter() {
        super(25, 40);
    }

    @Override
    public List<HitResult> gatherTargets(CastingContext ctx) {
        AABB area = new AABB(new BlockPos((int) ctx.getLocation().x, (int) ctx.getLocation().y, (int) ctx.getLocation().z))
                .expandTowards(0, 1, 0)
                .inflate(getAmplifier(Amplifier.RANGE));
        List<HitResult> retVal = new ArrayList<>(getBlocksInArea(area, ctx.getLevel()));
        ctx.getLevel().getEntities(ctx.getCaster(), area).forEach(e -> retVal.add(new EntityHitResult(e)));
        return retVal;
    }

    private List<BlockHitResult> getBlocksInArea(AABB area, Level level) {
        Iterator<Direction> directions = Direction.allShuffled(level.random).iterator();
        List<BlockHitResult> blocks = new ArrayList<>();
        for(int x = (int) area.minX; x <= area.maxX; x++) {
            for(int y = (int) area.minY; y <= area.maxY; y++) {
                for(int z = (int) area.minZ; z <= area.maxZ; z++) {
                    if(!directions.hasNext())
                        directions = Direction.allShuffled(level.random).iterator();
                    Direction dir = directions.next();
                    Vec3 location = new Vec3(x, y, z);
                    BlockPos pos = new BlockPos(x, y, z);
                    if(!(level.getBlockState(pos).isAir())) {
                        blocks.add(new BlockHitResult(
                                location,
                                dir,
                                pos,
                                false
                        ));
                    }
                }
            }
        }
        return blocks;
    }
}
