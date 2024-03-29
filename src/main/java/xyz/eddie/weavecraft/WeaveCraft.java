package xyz.eddie.weavecraft;

import com.mojang.logging.LogUtils;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import xyz.eddie.weavecraft.common.registries.WeavecraftBlocks;
import xyz.eddie.weavecraft.common.registries.WeavecraftCreativeModeTabs;
import xyz.eddie.weavecraft.common.registries.WeavecraftItems;
import xyz.eddie.weavecraft.data.WeavecraftDataGenerator;

import org.slf4j.Logger;


@Mod(Weavecraft.MODID)
public class Weavecraft
{
    public static final String MODID = "weavecraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Weavecraft(IEventBus modEventBus) {

        modEventBus.register(new WeavecraftDataGenerator());

        LOGGER.info("WeaveCraft: Registering Blocks...");
        WeavecraftBlocks.BLOCKS.register(modEventBus);
        LOGGER.info("WeaveCraft: Registering Items...");
        WeavecraftItems.ITEMS.register(modEventBus);
        WeavecraftCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static ResourceLocation wcLoc(String path) {
        return new ResourceLocation("weavecraft", path);
    }

}
