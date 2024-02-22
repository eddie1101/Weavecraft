package xyz.eddie.weavecraft.data.providers;

import static xyz.eddie.weavecraft.Weavecraft.MODID;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import xyz.eddie.weavecraft.common.registries.WeavecraftItems;

public class WeavecraftLanguageProvider extends LanguageProvider {

    public WeavecraftLanguageProvider(PackOutput output) {
        super(output, MODID, "en_us");
    }

    @Override
    public void addTranslations() {
        add(WeavecraftItems.ANCIENT_VAULT_WALL.get(), "Ancient Vault Wall");
        add(WeavecraftItems.PROKLITIA.get(), "Proklitia");
        add("tab.weavecraft.weavecraft_main_tab", "Weavecraft");
    }
    
}
