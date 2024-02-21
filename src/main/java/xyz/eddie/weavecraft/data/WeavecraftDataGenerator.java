package xyz.eddie.weavecraft.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import xyz.eddie.weavecraft.data.providers.WeavecraftBlockStateProvider;
import xyz.eddie.weavecraft.data.providers.WeavecraftItemModelProvider;
import xyz.eddie.weavecraft.data.providers.WeavecraftLanguageProvider;

public class WeavecraftDataGenerator {
    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper efh = event.getExistingFileHelper();
        PackOutput output = gen.getPackOutput();

        gen.addProvider(event.includeClient(), new WeavecraftLanguageProvider(output));
        gen.addProvider(event.includeClient(), new WeavecraftBlockStateProvider(output, efh));
        gen.addProvider(event.includeClient(), new WeavecraftItemModelProvider(output, efh));
        
    }
    
}
