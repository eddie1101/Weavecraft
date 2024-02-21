package xyz.eddie.weavecraft.data.providers;

import static xyz.eddie.weavecraft.Weavecraft.MODID;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import xyz.eddie.weavecraft.common.registries.WeavecraftBlocks;

public class WeavecraftBlockStateProvider extends BlockStateProvider {
    public WeavecraftBlockStateProvider(PackOutput output, ExistingFileHelper efh) {
        super(output, MODID, efh);
    }

    @Override
    public void registerStatesAndModels() {
        simpleBlockWithItem(WeavecraftBlocks.ANCIENT_VAULT_WALL.get(), cubeAll(WeavecraftBlocks.ANCIENT_VAULT_WALL.get()));
    }
}
