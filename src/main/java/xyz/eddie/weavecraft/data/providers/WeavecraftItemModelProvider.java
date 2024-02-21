package xyz.eddie.weavecraft.data.providers;

import static xyz.eddie.weavecraft.Weavecraft.MODID;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import xyz.eddie.weavecraft.common.registries.WeavecraftItems;

public class WeavecraftItemModelProvider extends ItemModelProvider {

    public WeavecraftItemModelProvider(PackOutput output, ExistingFileHelper efh) {
        super(output, MODID, efh);
    }

    @Override
    public void registerModels() {
        
    }
    
}
