package ianm1647.naturesminerals.common.world;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class NMBiomeModifiers {
    public static final ResourceKey<BiomeModifier> UVAROVITE_ORE;
    public static final ResourceKey<BiomeModifier> KUNZITE_ORE;
    public static final ResourceKey<BiomeModifier> STIBNITE_ORE;
    public static final ResourceKey<BiomeModifier> ASTRITE_ORE;

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(UVAROVITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(NMPlacedFeatures.UVAROVITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(KUNZITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(NMPlacedFeatures.KUNZITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(STIBNITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NMPlacedFeatures.STIBNITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ASTRITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NMPlacedFeatures.ASTRITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

    }

    static {
        UVAROVITE_ORE = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "uvarovite_ore"));
        KUNZITE_ORE = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "kunzite_ore"));
        STIBNITE_ORE = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "stibnite_ore"));
        ASTRITE_ORE = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "astrite_ore"));
    }
}
