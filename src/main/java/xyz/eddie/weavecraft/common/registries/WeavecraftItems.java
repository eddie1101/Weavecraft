package xyz.eddie.weavecraft.common.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import xyz.eddie.weavecraft.common.item.Proklitia;
import xyz.eddie.weavecraft.common.registration.DeferredItemRegister;

public class WeavecraftItems {

    public static final DeferredItemRegister ITEMS = new DeferredItemRegister();

    public static final DeferredItem<BlockItem> ANCIENT_VAULT_WALL = ITEMS.registerSimpleBlockItem(WeavecraftBlocks.ANCIENT_VAULT_WALL);

    public static final DeferredItem<Item> PROKLITIA = ITEMS.registerItem("proklitia", Proklitia::new);
    
}
