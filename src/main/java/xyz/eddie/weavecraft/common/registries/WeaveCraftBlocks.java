package xyz.eddie.weavecraft.common.registries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import xyz.eddie.weavecraft.common.block.AncientVaultWall;
import xyz.eddie.weavecraft.common.registration.DeferredBlockRegister;

public class WeaveCraftBlocks {

    public static final DeferredBlockRegister BLOCKS = new DeferredBlockRegister();

    public static final DeferredBlock<Block> ANCIENT_VAULT_WALL = BLOCKS.registerBlock("ancient_vault_wall", AncientVaultWall::new, BlockBehaviour.Properties.of());
    
}
