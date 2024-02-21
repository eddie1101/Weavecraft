package xyz.eddie.weavecraft;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import xyz.eddie.weavecraft.common.registries.WeaveCraftBlocks;
import xyz.eddie.weavecraft.common.registries.WeaveCraftCreativeModeTabs;
import xyz.eddie.weavecraft.common.registries.WeaveCraftItems;

import org.slf4j.Logger;


@Mod(WeaveCraft.MODID)
public class WeaveCraft
{
    public static final String MODID = "weavecraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public WeaveCraft(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);

        WeaveCraftBlocks.BLOCKS.register(modEventBus);
        WeaveCraftItems.ITEMS.register(modEventBus);
        WeaveCraftCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
