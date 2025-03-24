package ianm1647.naturesminerals.common.util;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class NMFluidType extends FluidType {
    private final String texture;

    public NMFluidType(Properties properties, String texture) {
        super(properties);
        this.texture = texture;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            private final ResourceLocation UNDER_FLUID = ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "block/fluid/" + texture + "_still.png");
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
        });
    }

}
