package xyz.eddie.weavecraft.common.registries;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import xyz.eddie.weavecraft.common.registration.DeferredItemRegister;

public class WeaveCraftItems {

    public static final DeferredItemRegister ITEMS = new DeferredItemRegister();

    public static final DeferredItem<BlockItem> ANCIENT_VAULT_WALL = ITEMS.registerSimpleBlockItem(WeaveCraftBlocks.ANCIENT_VAULT_WALL);
    
}
