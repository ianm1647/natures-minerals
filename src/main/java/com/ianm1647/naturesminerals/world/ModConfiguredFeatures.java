package com.ianm1647.naturesminerals.world;

import com.ianm1647.naturesminerals.NaturesMinerals;
import com.ianm1647.naturesminerals.block.BlockList;
import com.ianm1647.naturesminerals.world.feature.FeatureList;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    private static int UVARVEIN = NaturesMinerals.CONFIG.veinSizeU;
    private static int KUNZITEVEIN = NaturesMinerals.CONFIG.veinSizeK;
    private static int STIBNITEVEIN = NaturesMinerals.CONFIG.veinSizeS;
    private static int ASTRITEVEIN = NaturesMinerals.CONFIG.veinSizeA;

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endStoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> uvaroviteOres = List.of(
                OreFeatureConfig.createTarget(stoneReplaceables, BlockList.UVAROVITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, BlockList.DEEPSLATE_UVAROVITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> kunziteOres = List.of(
                OreFeatureConfig.createTarget(stoneReplaceables, BlockList.KUNZITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, BlockList.DEEPSLATE_KUNZITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> stibniteOres = List.of(
                OreFeatureConfig.createTarget(netherrackReplaceables, BlockList.STIBNITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> astriteOres = List.of(
                OreFeatureConfig.createTarget(endStoneReplaceables, BlockList.ASTRITE_ORE.getDefaultState()));

        registerConfiguredFeature(context, FeatureList.UVAROVITE_ORE, Feature.ORE, new OreFeatureConfig(uvaroviteOres, UVARVEIN));
        registerConfiguredFeature(context, FeatureList.KUNZITE_ORE, Feature.ORE, new OreFeatureConfig(kunziteOres, KUNZITEVEIN));
        registerConfiguredFeature(context, FeatureList.STIBNITE_ORE, Feature.ORE, new OreFeatureConfig(stibniteOres, STIBNITEVEIN));
        registerConfiguredFeature(context, FeatureList.ASTRITE_ORE, Feature.ORE, new OreFeatureConfig(astriteOres, ASTRITEVEIN));

    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void registerConfiguredFeature(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                                    RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
