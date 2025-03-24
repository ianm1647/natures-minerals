package ianm1647.naturesminerals.common.world;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.registry.NMBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class NMConfiguredFeatures {

    public static ResourceKey<ConfiguredFeature<?, ?>> UVAROVITE_ORE;
    public static ResourceKey<ConfiguredFeature<?, ?>> KUNZITE_ORE;
    public static ResourceKey<ConfiguredFeature<?, ?>> STIBNITE_ORE;
    public static ResourceKey<ConfiguredFeature<?, ?>> ASTRITE_ORE;

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endStoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> uvaroviteOres = List.of(
                OreConfiguration.target(stoneReplaceables, NMBlocks.UVAROVITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, NMBlocks.DEEPSLATE_UVAROVITE_ORE.get().defaultBlockState()));
        context.register(UVAROVITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(uvaroviteOres, 3)));

        List<OreConfiguration.TargetBlockState> kunziteOres = List.of(
                OreConfiguration.target(stoneReplaceables, NMBlocks.KUNZITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, NMBlocks.DEEPSLATE_KUNZITE_ORE.get().defaultBlockState()));
        context.register(KUNZITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(kunziteOres, 3)));

        context.register(STIBNITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(netherrackReplacables, NMBlocks.STIBNITE_ORE.get().defaultBlockState())), 3)));
        context.register(ASTRITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(endStoneReplaceables, NMBlocks.ASTRITE_ORE.get().defaultBlockState())), 3)));
    }

    static {
        UVAROVITE_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "uvarovite_ore"));
        KUNZITE_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "kunzite_ore"));
        STIBNITE_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "stibnite_ore"));
        ASTRITE_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "astrite_ore"));
    }
}
