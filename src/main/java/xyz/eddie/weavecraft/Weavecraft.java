package xyz.eddie.weavecraft;

import com.mojang.logging.LogUtils;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import xyz.eddie.weavecraft.client.WeavecraftClient;
import xyz.eddie.weavecraft.common.registries.WeavecraftBlocks;
import xyz.eddie.weavecraft.common.registries.WeavecraftCreativeModeTabs;
import xyz.eddie.weavecraft.common.registries.WeavecraftEntities;
import xyz.eddie.weavecraft.common.registries.WeavecraftItems;
import xyz.eddie.weavecraft.data.WeavecraftDataGenerator;

import org.slf4j.Logger;


@Mod(Weavecraft.MODID)
public class Weavecraft
{
    public static final String MODID = "weavecraft";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Weavecraft(IEventBus modEventBus) {

        modEventBus.register(new WeavecraftDataGenerator());
        modEventBus.register(WeavecraftClient.class);

        LOGGER.info("WeaveCraft: Registering Blocks...");
        WeavecraftBlocks.BLOCKS.register(modEventBus);
        LOGGER.info("WeaveCraft: Registering Items...");
        WeavecraftItems.ITEMS.register(modEventBus);
        WeavecraftEntities.ENTITIES.register(modEventBus);
        WeavecraftCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static ResourceLocation weaveLoc(String path) {
        return new ResourceLocation("weavecraft", path);
    }

    /*
    TODO Requirements
        What do I actually want from this spell system?
        -
        The ability to customize low-level aspects and behaviors of a spell in a maintainable and extensible way which
        allows for lots of emergent, dynamic, and powerful combinations
        -
        Trigger idea: When a projectile is cast, the projectile entity becomes the caster in the CastingContext
     */

}
