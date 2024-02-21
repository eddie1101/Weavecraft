package xyz.eddie.weavecraft.common.registration;

import static xyz.eddie.weavecraft.WeaveCraft.MODID;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;


public class DeferredBlockRegister {

    private final List<DeferredBlock<Block>> allBlocks = new ArrayList<>();

    private final DeferredRegister.Blocks internal = DeferredRegister.createBlocks(MODID);

    public DeferredBlockRegister() {}

    public DeferredBlock<Block> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends Block> sup, BlockBehaviour.Properties props) {
        DeferredBlock<Block> registeredBlock = internal.registerBlock(name, sup, props);
        allBlocks.add(registeredBlock);
        return registeredBlock;
    }

    public void register(IEventBus bus) {
        internal.register(bus);
    }

    public List<DeferredBlock<Block>> getAllBlocks() {
        return allBlocks;
    }

}