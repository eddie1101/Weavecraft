package xyz.eddie.weavecraft.common.registries;

import static xyz.eddie.weavecraft.WeaveCraft.MODID;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class WeaveCraftCreativeModeTabs {
    
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WEAVECRAFT__MAIN_TAB = CREATIVE_MODE_TABS.register("weavecraft_main_tab", () ->  CreativeModeTab.builder()
        .title(Component.translatable("tab.weavecraft.weavecraft_main_tab"))
        .icon(() -> WeaveCraftItems.ANCIENT_VAULT_WALL.get().getDefaultInstance())
        .displayItems((parameters, output) -> {
            WeaveCraftItems.ITEMS.getAllItems().forEach(output::accept);
            WeaveCraftBlocks.BLOCKS.getAllBlocks().forEach(output::accept);
        }).build());

}
