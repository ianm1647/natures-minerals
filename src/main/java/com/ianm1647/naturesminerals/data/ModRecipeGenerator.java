package com.ianm1647.naturesminerals.data;

import com.ianm1647.naturesminerals.block.BlockList;
import com.ianm1647.naturesminerals.item.ItemList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.SCORCHED_COAL, RecipeCategory.DECORATIONS, BlockList.SCORCHED_COAL_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.UVAROVITE_INGOT, RecipeCategory.DECORATIONS, BlockList.UVAROVITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.UVAROVITE_NUGGET, RecipeCategory.MISC, ItemList.UVAROVITE_INGOT,
                "uvarovite_ingot_from_nugget", null, "uvarovite_nugget_from_ingot", null);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.RAW_UVAROVITE, RecipeCategory.DECORATIONS, BlockList.RAW_UVAROVITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.KUNZITE_INGOT, RecipeCategory.DECORATIONS, BlockList.KUNZITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.KUNZITE_NUGGET, RecipeCategory.MISC, ItemList.KUNZITE_INGOT,
                "kunzite_ingot_from_nugget", null, "kunzite_nugget_from_ingot", null);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.RAW_KUNZITE, RecipeCategory.DECORATIONS, BlockList.RAW_KUNZITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.STIBNITE_INGOT, RecipeCategory.DECORATIONS, BlockList.STIBNITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.STIBNITE_NUGGET, RecipeCategory.MISC, ItemList.STIBNITE_INGOT,
                "stibnite_ingot_from_nugget", null, "stibnite_nugget_from_ingot", null);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.RAW_STIBNITE, RecipeCategory.DECORATIONS, BlockList.RAW_STIBNITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.ASTRITE_INGOT, RecipeCategory.DECORATIONS, BlockList.ASTRITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.ASTRITE_NUGGET, RecipeCategory.MISC, ItemList.ASTRITE_INGOT,
                "astrite_ingot_from_nugget", null, "astrite_nugget_from_ingot", null);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.RAW_ASTRITE, RecipeCategory.DECORATIONS, BlockList.RAW_ASTRITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.THOUNITE_INGOT, RecipeCategory.DECORATIONS, BlockList.THOUNITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ItemList.THOUNITE_NUGGET, RecipeCategory.MISC, ItemList.THOUNITE_INGOT,
                "thounite_ingot_from_nugget", null, "thounite_nugget_from_ingot", null);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BlockList.NETHERITE_BRICKS, 4)
                .pattern("BB")
                .pattern("BB")
                .input('B', Items.NETHERITE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(BlockList.NETHERITE_BRICKS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemList.SCORCHED_COAL, 4)
                .pattern("BCB")
                .pattern("CLC")
                .pattern("BCB")
                .input('B', Items.BLAZE_ROD)
                .input('C', Items.COAL)
                .input('L', Items.LAVA_BUCKET)
                .criterion(FabricRecipeProvider.hasItem(Items.BLAZE_ROD),
                        FabricRecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
                .criterion(FabricRecipeProvider.hasItem(Items.COAL),
                        FabricRecipeProvider.conditionsFromItem(Items.COAL))
                .criterion(FabricRecipeProvider.hasItem(Items.LAVA_BUCKET),
                        FabricRecipeProvider.conditionsFromItem(Items.LAVA_BUCKET))
                .offerTo(exporter, "scorched_coal_from_crafting");

        offerSmelting(exporter, List.of(
                ItemList.UVAROVITE_AXE, ItemList.UVAROVITE_PICKAXE, ItemList.UVAROVITE_HOE, ItemList.UVAROVITE_SWORD, ItemList.UVAROVITE_SHOVEL,
                ItemList.UVAROVITE_HEAD, ItemList.UVAROVITE_CHEST, ItemList.UVAROVITE_LEGS, ItemList.UVAROVITE_FEET), RecipeCategory.MISC,
                ItemList.UVAROVITE_NUGGET, 0.1f, 200, "uvarovite_nugget_from_smelting");
        offerSmelting(exporter, List.of(
                ItemList.KUNZITE_AXE, ItemList.KUNZITE_PICKAXE, ItemList.KUNZITE_HOE, ItemList.KUNZITE_SWORD, ItemList.KUNZITE_SHOVEL,
                ItemList.KUNZITE_HEAD, ItemList.KUNZITE_CHEST, ItemList.KUNZITE_LEGS, ItemList.KUNZITE_FEET), RecipeCategory.MISC,
                ItemList.KUNZITE_NUGGET, 0.1f, 200, "kunzite_nugget_from_smelting");
        offerSmelting(exporter, List.of(
                ItemList.STIBNITE_AXE, ItemList.STIBNITE_PICKAXE, ItemList.STIBNITE_HOE, ItemList.STIBNITE_SWORD, ItemList.STIBNITE_SHOVEL,
                ItemList.STIBNITE_HEAD, ItemList.STIBNITE_CHEST, ItemList.STIBNITE_LEGS, ItemList.STIBNITE_FEET), RecipeCategory.MISC,
                ItemList.STIBNITE_NUGGET, 0.1f, 200, "stibnite_nugget_from_smelting");
        offerSmelting(exporter, List.of(
                ItemList.ASTRITE_AXE, ItemList.ASTRITE_PICKAXE, ItemList.ASTRITE_HOE, ItemList.ASTRITE_SWORD, ItemList.ASTRITE_SHOVEL,
                ItemList.ASTRITE_HEAD, ItemList.ASTRITE_CHEST, ItemList.ASTRITE_LEGS, ItemList.ASTRITE_FEET), RecipeCategory.MISC,
                ItemList.ASTRITE_NUGGET, 0.1f, 200, "astrite_nugget_from_smelting");
        offerSmelting(exporter, List.of(
                ItemList.THOUNITE_AXE, ItemList.THOUNITE_PICKAXE, ItemList.THOUNITE_HOE, ItemList.THOUNITE_SWORD, ItemList.THOUNITE_SHOVEL,
                ItemList.THOUNITE_HEAD, ItemList.THOUNITE_CHEST, ItemList.THOUNITE_LEGS, ItemList.THOUNITE_FEET), RecipeCategory.MISC,
                ItemList.THOUNITE_NUGGET, 0.1f, 200, "thounite_nugget_from_smelting");

        offerBlasting(exporter, List.of(
                        ItemList.UVAROVITE_AXE, ItemList.UVAROVITE_PICKAXE, ItemList.UVAROVITE_HOE, ItemList.UVAROVITE_SWORD, ItemList.UVAROVITE_SHOVEL,
                        ItemList.UVAROVITE_HEAD, ItemList.UVAROVITE_CHEST, ItemList.UVAROVITE_LEGS, ItemList.UVAROVITE_FEET), RecipeCategory.MISC,
                ItemList.UVAROVITE_NUGGET, 0.1f, 100, "uvarovite_nugget_from_blasting");
        offerBlasting(exporter, List.of(
                        ItemList.KUNZITE_AXE, ItemList.KUNZITE_PICKAXE, ItemList.KUNZITE_HOE, ItemList.KUNZITE_SWORD, ItemList.KUNZITE_SHOVEL,
                        ItemList.KUNZITE_HEAD, ItemList.KUNZITE_CHEST, ItemList.KUNZITE_LEGS, ItemList.KUNZITE_FEET), RecipeCategory.MISC,
                ItemList.KUNZITE_NUGGET, 0.1f, 100, "kunzite_nugget_from_blasting");
        offerBlasting(exporter, List.of(
                        ItemList.STIBNITE_AXE, ItemList.STIBNITE_PICKAXE, ItemList.STIBNITE_HOE, ItemList.STIBNITE_SWORD, ItemList.STIBNITE_SHOVEL,
                        ItemList.STIBNITE_HEAD, ItemList.STIBNITE_CHEST, ItemList.STIBNITE_LEGS, ItemList.STIBNITE_FEET), RecipeCategory.MISC,
                ItemList.STIBNITE_NUGGET, 0.1f, 100, "stibnite_nugget_from_blasting");
        offerBlasting(exporter, List.of(
                        ItemList.ASTRITE_AXE, ItemList.ASTRITE_PICKAXE, ItemList.ASTRITE_HOE, ItemList.ASTRITE_SWORD, ItemList.ASTRITE_SHOVEL,
                        ItemList.ASTRITE_HEAD, ItemList.ASTRITE_CHEST, ItemList.ASTRITE_LEGS, ItemList.ASTRITE_FEET), RecipeCategory.MISC,
                ItemList.ASTRITE_NUGGET, 0.1f, 100, "astrite_nugget_from_blasting");
        offerBlasting(exporter, List.of(
                        ItemList.THOUNITE_AXE, ItemList.THOUNITE_PICKAXE, ItemList.THOUNITE_HOE, ItemList.THOUNITE_SWORD, ItemList.THOUNITE_SHOVEL,
                        ItemList.THOUNITE_HEAD, ItemList.THOUNITE_CHEST, ItemList.THOUNITE_LEGS, ItemList.THOUNITE_FEET), RecipeCategory.MISC,
                ItemList.THOUNITE_NUGGET, 0.1f, 100, "thounite_nugget_from_blasting");

        craftSword(exporter, ItemList.UVAROVITE_SWORD, ItemList.UVAROVITE_INGOT);
        craftSword(exporter, ItemList.KUNZITE_SWORD, ItemList.KUNZITE_INGOT);
        craftSword(exporter, ItemList.STIBNITE_SWORD, ItemList.STIBNITE_INGOT);
        craftSword(exporter, ItemList.ASTRITE_SWORD, ItemList.ASTRITE_INGOT);
        craftSword(exporter, ItemList.THOUNITE_SWORD, ItemList.THOUNITE_INGOT);

        craftPickaxe(exporter, ItemList.UVAROVITE_PICKAXE, ItemList.UVAROVITE_INGOT);
        craftPickaxe(exporter, ItemList.KUNZITE_PICKAXE, ItemList.KUNZITE_INGOT);
        craftPickaxe(exporter, ItemList.STIBNITE_PICKAXE, ItemList.STIBNITE_INGOT);
        craftPickaxe(exporter, ItemList.ASTRITE_PICKAXE, ItemList.ASTRITE_INGOT);
        craftPickaxe(exporter, ItemList.THOUNITE_PICKAXE, ItemList.THOUNITE_INGOT);

        craftAxe(exporter, ItemList.UVAROVITE_AXE, ItemList.UVAROVITE_INGOT);
        craftAxe(exporter, ItemList.KUNZITE_AXE, ItemList.KUNZITE_INGOT);
        craftAxe(exporter, ItemList.STIBNITE_AXE, ItemList.STIBNITE_INGOT);
        craftAxe(exporter, ItemList.ASTRITE_AXE, ItemList.ASTRITE_INGOT);
        craftAxe(exporter, ItemList.THOUNITE_AXE, ItemList.THOUNITE_INGOT);

        craftShovel(exporter, ItemList.UVAROVITE_SHOVEL, ItemList.UVAROVITE_INGOT);
        craftShovel(exporter, ItemList.KUNZITE_SHOVEL, ItemList.KUNZITE_INGOT);
        craftShovel(exporter, ItemList.STIBNITE_SHOVEL, ItemList.STIBNITE_INGOT);
        craftShovel(exporter, ItemList.ASTRITE_SHOVEL, ItemList.ASTRITE_INGOT);
        craftShovel(exporter, ItemList.THOUNITE_SHOVEL, ItemList.THOUNITE_INGOT);

        craftHoe(exporter, ItemList.UVAROVITE_HOE, ItemList.UVAROVITE_INGOT);
        craftHoe(exporter, ItemList.KUNZITE_HOE, ItemList.KUNZITE_INGOT);
        craftHoe(exporter, ItemList.STIBNITE_HOE, ItemList.STIBNITE_INGOT);
        craftHoe(exporter, ItemList.ASTRITE_HOE, ItemList.ASTRITE_INGOT);
        craftHoe(exporter, ItemList.THOUNITE_HOE, ItemList.THOUNITE_INGOT);

        craftHelmet(exporter, ItemList.UVAROVITE_HEAD, ItemList.UVAROVITE_INGOT);
        craftHelmet(exporter, ItemList.KUNZITE_HEAD, ItemList.KUNZITE_INGOT);
        craftHelmet(exporter, ItemList.STIBNITE_HEAD, ItemList.STIBNITE_INGOT);
        craftHelmet(exporter, ItemList.ASTRITE_HEAD, ItemList.ASTRITE_INGOT);
        craftHelmet(exporter, ItemList.THOUNITE_HEAD, ItemList.THOUNITE_INGOT);

        craftChestplate(exporter, ItemList.UVAROVITE_CHEST, ItemList.UVAROVITE_INGOT);
        craftChestplate(exporter, ItemList.KUNZITE_CHEST, ItemList.KUNZITE_INGOT);
        craftChestplate(exporter, ItemList.STIBNITE_CHEST, ItemList.STIBNITE_INGOT);
        craftChestplate(exporter, ItemList.ASTRITE_CHEST, ItemList.ASTRITE_INGOT);
        craftChestplate(exporter, ItemList.THOUNITE_CHEST, ItemList.THOUNITE_INGOT);

        craftLeggings(exporter, ItemList.UVAROVITE_LEGS, ItemList.UVAROVITE_INGOT);
        craftLeggings(exporter, ItemList.KUNZITE_LEGS, ItemList.KUNZITE_INGOT);
        craftLeggings(exporter, ItemList.STIBNITE_LEGS, ItemList.STIBNITE_INGOT);
        craftLeggings(exporter, ItemList.ASTRITE_LEGS, ItemList.ASTRITE_INGOT);
        craftLeggings(exporter, ItemList.THOUNITE_LEGS, ItemList.THOUNITE_INGOT);

        craftBoots(exporter, ItemList.UVAROVITE_FEET, ItemList.UVAROVITE_INGOT);
        craftBoots(exporter, ItemList.KUNZITE_FEET, ItemList.KUNZITE_INGOT);
        craftBoots(exporter, ItemList.STIBNITE_FEET, ItemList.STIBNITE_INGOT);
        craftBoots(exporter, ItemList.ASTRITE_FEET, ItemList.ASTRITE_INGOT);
        craftBoots(exporter, ItemList.THOUNITE_FEET, ItemList.THOUNITE_INGOT);

        craftApple(exporter, ItemList.UVAROVITE_APPLE, ItemList.UVAROVITE_INGOT);
        craftApple(exporter, ItemList.KUNZITE_APPLE, ItemList.KUNZITE_INGOT);
        craftApple(exporter, ItemList.STIBNITE_APPLE, ItemList.STIBNITE_INGOT);
        craftApple(exporter, ItemList.ASTRITE_APPLE, ItemList.ASTRITE_INGOT);
        craftApple(exporter, ItemList.THOUNITE_APPLE, ItemList.THOUNITE_INGOT);

        craftPaxel(exporter, ItemList.UVAROVITE_PAXEL, ItemList.UVAROVITE_AXE, ItemList.UVAROVITE_PICKAXE, ItemList.UVAROVITE_SHOVEL);
        craftPaxel(exporter, ItemList.KUNZITE_PAXEL, ItemList.KUNZITE_AXE, ItemList.KUNZITE_PICKAXE, ItemList.KUNZITE_SHOVEL);
        craftPaxel(exporter, ItemList.STIBNITE_PAXEL, ItemList.STIBNITE_AXE, ItemList.STIBNITE_PICKAXE, ItemList.STIBNITE_SHOVEL);
        craftPaxel(exporter, ItemList.ASTRITE_PAXEL, ItemList.ASTRITE_AXE, ItemList.ASTRITE_PICKAXE, ItemList.ASTRITE_SHOVEL);
        craftPaxel(exporter, ItemList.THOUNITE_PAXEL, ItemList.THOUNITE_AXE, ItemList.THOUNITE_PICKAXE, ItemList.THOUNITE_SHOVEL);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemList.WOODEN_HAMMER)
                .pattern("BIB")
                .pattern(" T ")
                .pattern(" T ")
                .input('B', ItemTags.LOGS)
                .input('I', ItemTags.PLANKS)
                .input('T', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(Items.OAK_PLANKS),
                        FabricRecipeProvider.conditionsFromTag(ItemTags.PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.OAK_LOG),
                        FabricRecipeProvider.conditionsFromTag(ItemTags.LOGS))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ItemList.WOODEN_HAMMER)));

        craftHammer(exporter, ItemList.STONE_HAMMER, Items.STONE, Items.COBBLESTONE);
        craftHammer(exporter, ItemList.IRON_HAMMER, Items.IRON_BLOCK, Items.IRON_INGOT);
        craftHammer(exporter, ItemList.GOLDEN_HAMMER, Items.GOLD_BLOCK, Items.GOLD_INGOT);
        craftHammer(exporter, ItemList.DIAMOND_HAMMER, Items.DIAMOND_BLOCK, Items.DIAMOND);
        craftHammer(exporter, ItemList.NETHERITE_HAMMER, Items.NETHERITE_BLOCK, Items.NETHERITE_INGOT);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemList.WOODEN_EXCAVATOR)
                .pattern(" I ")
                .pattern("BTB")
                .pattern(" T ")
                .input('B', ItemTags.LOGS)
                .input('I', ItemTags.PLANKS)
                .input('T', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(Items.OAK_PLANKS),
                        FabricRecipeProvider.conditionsFromTag(ItemTags.PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.OAK_LOG),
                        FabricRecipeProvider.conditionsFromTag(ItemTags.LOGS))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ItemList.WOODEN_EXCAVATOR)));

        craftExcavator(exporter, ItemList.STONE_EXCAVATOR, Items.STONE, Items.COBBLESTONE);
        craftExcavator(exporter, ItemList.IRON_EXCAVATOR, Items.IRON_BLOCK, Items.IRON_INGOT);
        craftExcavator(exporter, ItemList.GOLDEN_EXCAVATOR, Items.GOLD_BLOCK, Items.GOLD_INGOT);
        craftExcavator(exporter, ItemList.DIAMOND_EXCAVATOR, Items.DIAMOND_BLOCK, Items.DIAMOND);
        craftExcavator(exporter, ItemList.NETHERITE_EXCAVATOR, Items.NETHERITE_BLOCK, Items.NETHERITE_INGOT);

        craftHammer(exporter, ItemList.UVAROVITE_HAMMER, BlockList.UVAROVITE_BLOCK.asItem(), ItemList.UVAROVITE_INGOT);
        craftHammer(exporter, ItemList.KUNZITE_HAMMER, BlockList.KUNZITE_BLOCK.asItem(), ItemList.KUNZITE_INGOT);
        craftHammer(exporter, ItemList.STIBNITE_HAMMER, BlockList.STIBNITE_BLOCK.asItem(), ItemList.STIBNITE_INGOT);
        craftHammer(exporter, ItemList.ASTRITE_HAMMER, BlockList.ASTRITE_BLOCK.asItem(), ItemList.ASTRITE_INGOT);
        craftHammer(exporter, ItemList.THOUNITE_HAMMER, BlockList.THOUNITE_BLOCK.asItem(), ItemList.THOUNITE_INGOT);

        craftExcavator(exporter, ItemList.UVAROVITE_EXCAVATOR, BlockList.UVAROVITE_BLOCK.asItem(), ItemList.UVAROVITE_INGOT);
        craftExcavator(exporter, ItemList.KUNZITE_EXCAVATOR, BlockList.KUNZITE_BLOCK.asItem(), ItemList.KUNZITE_INGOT);
        craftExcavator(exporter, ItemList.STIBNITE_EXCAVATOR, BlockList.STIBNITE_BLOCK.asItem(), ItemList.STIBNITE_INGOT);
        craftExcavator(exporter, ItemList.ASTRITE_EXCAVATOR, BlockList.ASTRITE_BLOCK.asItem(), ItemList.ASTRITE_INGOT);
        craftExcavator(exporter, ItemList.THOUNITE_EXCAVATOR, BlockList.THOUNITE_BLOCK.asItem(), ItemList.THOUNITE_INGOT);

        craftKnife(exporter, ItemList.UVAROVITE_KNIFE, ItemList.UVAROVITE_INGOT);
        craftKnife(exporter, ItemList.KUNZITE_KNIFE, ItemList.KUNZITE_INGOT);
        craftKnife(exporter, ItemList.STIBNITE_KNIFE, ItemList.STIBNITE_INGOT);
        craftKnife(exporter, ItemList.ASTRITE_KNIFE, ItemList.ASTRITE_INGOT);
        craftKnife(exporter, ItemList.THOUNITE_KNIFE, ItemList.THOUNITE_INGOT);

    }

    private void craftSword(Consumer<RecipeJsonProvider> exporter, Item output, Item input1) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("S")
                .pattern("S")
                .pattern("T")
                .input('S', input1)
                .input('T', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    private void craftPickaxe(Consumer<RecipeJsonProvider> exporter, Item output, Item input1) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("SSS")
                .pattern(" T ")
                .pattern(" T ")
                .input('S', input1)
                .input('T', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    private void craftAxe(Consumer<RecipeJsonProvider> exporter, Item output, Item input1) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("SS")
                .pattern("ST")
                .pattern(" T")
                .input('S', input1)
                .input('T', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    private void craftShovel(Consumer<RecipeJsonProvider> exporter, Item output, Item input1) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("S")
                .pattern("T")
                .pattern("T")
                .input('S', input1)
                .input('T', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    private void craftHoe(Consumer<RecipeJsonProvider> exporter, Item output, Item input1) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("SS")
                .pattern(" T")
                .pattern(" T")
                .input('S', input1)
                .input('T', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    private void craftHelmet(Consumer<RecipeJsonProvider> exporter, Item output, Item input1) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("SSS")
                .pattern("S S")
                .input('S', input1)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    private void craftChestplate(Consumer<RecipeJsonProvider> exporter, Item output, Item input1) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', input1)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    private void craftLeggings(Consumer<RecipeJsonProvider> exporter, Item output, Item input1) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', input1)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    private void craftBoots(Consumer<RecipeJsonProvider> exporter, Item output, Item input1) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("S S")
                .pattern("S S")
                .input('S', input1)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    private void craftApple(Consumer<RecipeJsonProvider> exporter, Item output, Item input1) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .input('S', input1)
                .input('A', Items.APPLE)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    private void craftPaxel(Consumer<RecipeJsonProvider> exporter, Item output, Item input1, Item input2, Item input3) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("APS")
                .pattern(" T ")
                .pattern(" T ")
                .input('A', input1)
                .input('P', input2)
                .input('S', input3)
                .input('T', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .criterion(FabricRecipeProvider.hasItem(input2),
                        FabricRecipeProvider.conditionsFromItem(input2))
                .criterion(FabricRecipeProvider.hasItem(input3),
                        FabricRecipeProvider.conditionsFromItem(input3))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    private void craftHammer(Consumer<RecipeJsonProvider> exporter, Item output, Item input1, Item input2) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("BIB")
                .pattern(" T ")
                .pattern(" T ")
                .input('B', input1)
                .input('I', input2)
                .input('T', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .criterion(FabricRecipeProvider.hasItem(input2),
                        FabricRecipeProvider.conditionsFromItem(input2))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));

    }

    private void craftExcavator(Consumer<RecipeJsonProvider> exporter, Item output, Item input1, Item input2) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern(" I ")
                .pattern("BTB")
                .pattern(" T ")
                .input('B', input1)
                .input('I', input2)
                .input('T', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .criterion(FabricRecipeProvider.hasItem(input2),
                        FabricRecipeProvider.conditionsFromItem(input2))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));

    }

    private void craftKnife(Consumer<RecipeJsonProvider> exporter, Item output, Item input1) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("I")
                .pattern("S")
                .input('I', input1)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(input1),
                        FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));

    }
}
