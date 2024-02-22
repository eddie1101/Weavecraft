package xyz.eddie.weavecraft.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import xyz.eddie.weavecraft.common.entity.SpellEntity;

public class SpellRenderer extends EntityRenderer<SpellEntity> {

    public SpellRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(SpellEntity spellEntity) {
        return null;
    }

    @Override
    public void render(SpellEntity boomerang, float entityYaw, float partialTick, @NotNull PoseStack matrix, @NotNull MultiBufferSource renderer, int light) {

    }

}
