package xyz.eddie.weavecraft.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import xyz.eddie.weavecraft.Weavecraft;
import xyz.eddie.weavecraft.common.entity.SpellEntity;

public class SpellRenderer extends EntityRenderer<SpellEntity> {

    public SpellRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull SpellEntity spellEntity) {
        return Weavecraft.weaveLoc("textures/spell/spell");
    }

    @Override
    public void render(@NotNull SpellEntity spellEntity, float entityYaw, float partialTick, @NotNull PoseStack matrix, @NotNull MultiBufferSource renderer, int light) {
        renderer.getBuffer(RenderType.entityTranslucent(getTextureLocation(spellEntity), true)).
                color(255, 255, 255, 255)
                .vertex(-10, 0, 10)
                .vertex(10, 0, 10)
                .vertex(10, 0, -10)
                .vertex(-10, 0, -10);
    }

}
