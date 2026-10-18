package ianm1647.naturesminerals.common.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.awt.*;
import java.util.function.Consumer;

public class NMFluidType extends FluidType {
    private final String texture;
    private final Vector3f color;

    public NMFluidType(Properties properties, String texture, int color) {
        super(properties);
        this.texture = texture;
        Color colorObject = new Color(color);
        this.color = new Vector3f(colorObject.getRed() / 255f, colorObject.getGreen() / 255f, colorObject.getBlue() / 255f);
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            private final ResourceLocation UNDER_FLUID = ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "textures/block/fluid/" + texture + "_still.png");
            private final ResourceLocation FLUID_STILL = ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "block/fluid/" + texture + "_still");
            private final ResourceLocation FLUID_FLOW = ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "block/fluid/" + texture + "_flowing");
            private final ResourceLocation FLUID_OVERLAY = ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "block/fluid/" + texture + "_still");

            public ResourceLocation getStillTexture() {
                return FLUID_STILL;
            }

            public ResourceLocation getFlowingTexture() {
                return FLUID_FLOW;
            }

            public @Nullable ResourceLocation getOverlayTexture() {
                return FLUID_OVERLAY;
            }

            public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
                return UNDER_FLUID;
            }

            public void renderOverlay(Minecraft mc, PoseStack poseStack) {
                ResourceLocation texture = this.getRenderOverlayTexture(mc);
                if (texture != null)
                    ScreenEffectRenderer.renderFluid(mc, poseStack, texture);
            }

            @Override
            public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return color;
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(0.1f);
                RenderSystem.setShaderFogEnd(1.5f);
            }
        });
    }
}
