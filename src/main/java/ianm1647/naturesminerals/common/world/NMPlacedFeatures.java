package ianm1647.naturesminerals.common.world;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class NMPlacedFeatures {

    public static ResourceKey<PlacedFeature> UVAROVITE_ORE;
    public static ResourceKey<PlacedFeature> KUNZITE_ORE;
    public static ResourceKey<PlacedFeature> STIBNITE_ORE;
    public static ResourceKey<PlacedFeature> ASTRITE_ORE;

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(UVAROVITE_ORE, new PlacedFeature(configuredFeatures.getOrThrow(NMConfiguredFeatures.UVAROVITE_ORE),
                OrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(10)))));
        context.register(KUNZITE_ORE, new PlacedFeature(configuredFeatures.getOrThrow(NMConfiguredFeatures.KUNZITE_ORE),
                OrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(-20)))));
        context.register(STIBNITE_ORE, new PlacedFeature(configuredFeatures.getOrThrow(NMConfiguredFeatures.STIBNITE_ORE),
                OrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)))));
        context.register(ASTRITE_ORE, new PlacedFeature(configuredFeatures.getOrThrow(NMConfiguredFeatures.ASTRITE_ORE),
                OrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)))));

    }

    static {
        UVAROVITE_ORE = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "uvarovite_ore"));
        KUNZITE_ORE = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "kunzite_ore"));
        STIBNITE_ORE = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "stibnite_ore"));
        ASTRITE_ORE = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "astrite_ore"));
    }
}
