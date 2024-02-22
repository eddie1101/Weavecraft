package xyz.eddie.weavecraft.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class UnbreakableBlock extends Block {

    public UnbreakableBlock(BlockBehaviour.Properties props) {
        super(props.destroyTime(Float.MAX_VALUE).explosionResistance(Float.MAX_VALUE));
    }

}
