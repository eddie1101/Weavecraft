package xyz.eddie.weavecraft.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
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
        Matrix4f renderMatrix = matrix.last().pose();
        Matrix3f normalMatrix = matrix.last().normal();

        VertexConsumer vertexBuilder = renderer.getBuffer(RenderType.lightning());
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.4f, 0.4f, 0,  255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.4f, 0.4f, 0,   255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.4f, -0.4f, 0, 255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.4f, -0.4f, 0,  255, 0, 0, 180, light);

        matrix.mulPose(Axis.YP.rotationDegrees(90));
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.4f, 0.4f, 0,  255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.4f, 0.4f, 0,   255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.4f, -0.4f, 0,  255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.4f, -0.4f, 0, 255, 0, 0, 180, light);

        matrix.mulPose(Axis.YP.rotationDegrees(180));
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.4f, 0.4f, 0,  255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.4f, 0.4f, 0,   255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.4f, -0.4f, 0,  255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.4f, -0.4f, 0, 255, 0, 0, 180, light);

        matrix.mulPose(Axis.YP.rotationDegrees(270));
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.4f, 0.4f, 0,  255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.4f, 0.4f, 0,   255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.4f, -0.4f, 0,  255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.4f, -0.4f, 0, 255, 0, 0, 180, light);

        matrix.mulPose(Axis.XP.rotationDegrees(90));
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.5f, 0.5f, 0,  255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.5f, 0.5f, 0,   255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.5f, -0.5f, 0,  255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.5f, -0.5f, 0, 255, 0, 0, 180, light);

        matrix.mulPose(Axis.XP.rotationDegrees(270));
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.5f, 0.5f, 0,  255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.5f, 0.5f, 0,   255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, 0.5f, -0.5f, 0,  255, 0, 0, 180, light);
        vertex(vertexBuilder, renderMatrix, normalMatrix, -0.5f, -0.5f, 0, 255, 0, 0, 180, light);

    }

    private void vertex(VertexConsumer vertexBuilder, Matrix4f renderMatrix, Matrix3f normalMatrix, float x, float y, float z, int r, int g, int b, int a, int light) {
        vertexBuilder.vertex(renderMatrix, x, y, z).color(r, g, b, a).uv(0, 0).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(normalMatrix, 1, 1, 1).endVertex();
    }

}
