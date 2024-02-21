package xyz.eddie.weavecraft.common.registration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import net.minecraft.core.Holder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static xyz.eddie.weavecraft.WeaveCraft.MODID;

public class DeferredItemRegister {

    private final List<DeferredItem<Item>> allItems = new ArrayList<>();

    private final DeferredRegister.Items internal = DeferredRegister.createItems(MODID);

    public DeferredItemRegister() {}

    public DeferredItem<Item> registerBlock(String name, Function<Item.Properties, ? extends Item> sup) {
        DeferredItem<Item> registeredItem = internal.registerItem(name, sup);
        allItems.add(registeredItem);
        return registeredItem;
    }

    public DeferredItem<BlockItem> registerSimpleBlockItem(Holder<Block> block) {
        return internal.registerSimpleBlockItem(block);
    }

    public void register(IEventBus bus) {
        internal.register(bus);
    }

    public List<DeferredItem<Item>> getAllBlocks() {
        return allItems;
    }

}