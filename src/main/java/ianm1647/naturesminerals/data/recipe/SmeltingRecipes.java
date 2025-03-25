package ianm1647.naturesminerals.data.recipe;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.registry.NMItems;
import ianm1647.naturesminerals.data.recipe.builder.ConditionalCookingRecipeBuilder;
import ianm1647.naturesminerals.integration.mekanism.MekanismIntegration;
import mekanism.tools.common.item.ItemMekanismPaxel;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

public class SmeltingRecipes {

    public static void register(RecipeOutput output) {
        materialSmelting(output);
        compatSmelting(output);

        recipesNuggetSmelting(output);
        recipesNuggetBlasting(output);
    }

    private static void materialSmelting(RecipeOutput output) {
        NMItems.ITEMS.getEntries()
                .forEach((item) -> {
                    String name = item.getId().getPath();
                    if (name.contains("raw") && !(item.get() instanceof BlockItem)) {
                        SimpleCookingRecipeBuilder.smelting(Ingredient.of(item.get()), RecipeCategory.MISC,
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("raw_", "") + "_ingot")), 1.0f, 200)
                                .unlockedBy("has_raw_material", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                .save(output, NaturesMinerals.loc(name.replace("raw_", "") + "_ingot_from_smelting"));
                        SimpleCookingRecipeBuilder.blasting(Ingredient.of(item.get()), RecipeCategory.MISC,
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("raw_", "") + "_ingot")), 1.0f, 100)
                                .unlockedBy("has_raw_material", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                .save(output, NaturesMinerals.loc(name.replace("raw_", "") + "_ingot_from_blasting"));
                    }
                    if (name.contains("dust")) {
                        SimpleCookingRecipeBuilder.smelting(Ingredient.of(item.get()), RecipeCategory.MISC,
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_dust", "") + "_ingot")), 1.0f, 200)
                                .unlockedBy("has_dust", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                .save(output, NaturesMinerals.loc(name.replace("_dust", "") + "_ingot_from_dust_smelting"));
                        SimpleCookingRecipeBuilder.blasting(Ingredient.of(item.get()), RecipeCategory.MISC,
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_dust", "") + "_ingot")), 1.0f, 100)
                                .unlockedBy("has_dust", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                .save(output, NaturesMinerals.loc(name.replace("_dust", "") + "_ingot_from_dust_blasting"));
                    }
                    if (name.contains("ore")) {
                        if (name.contains("deepslate")) {
                            SimpleCookingRecipeBuilder.smelting(Ingredient.of(item.get()), RecipeCategory.MISC,
                                            BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("deepslate_", "").replace("_ore", "") + "_ingot")), 1.0f, 200)
                                    .unlockedBy("has_ore", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                    .save(output, NaturesMinerals.loc(name.replace("deepslate_", "").replace("_ore", "") + "_ingot_from_deepslate_ore_smelting"));
                            SimpleCookingRecipeBuilder.blasting(Ingredient.of(item.get()), RecipeCategory.MISC,
                                            BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("deepslate_", "").replace("_ore", "") + "_ingot")), 1.0f, 100)
                                    .unlockedBy("has_ore", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                    .save(output, NaturesMinerals.loc(name.replace("deepslate_", "").replace("_ore", "") + "_ingot_from_deepslate_ore_blasting"));
                        } else {
                            SimpleCookingRecipeBuilder.smelting(Ingredient.of(item.get()), RecipeCategory.MISC,
                                            BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_ore", "") + "_ingot")), 1.0f, 200)
                                    .unlockedBy("has_ore", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                    .save(output, NaturesMinerals.loc(name.replace("_ore", "") + "_ingot_from_ore_smelting"));
                            SimpleCookingRecipeBuilder.blasting(Ingredient.of(item.get()), RecipeCategory.MISC,
                                            BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_ore", "") + "_ingot")), 1.0f, 100)
                                    .unlockedBy("has_ore", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                    .save(output, NaturesMinerals.loc(name.replace("_ore", "") + "_ingot_from_ore_blasting"));
                        }
                    }
                    if (name.contains("raw") && item.get() instanceof BlockItem) {
                        SimpleCookingRecipeBuilder.blasting(Ingredient.of(item.get()), RecipeCategory.MISC,
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("raw_", ""))), 9.0f, 400)
                                .unlockedBy("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                .save(output, NaturesMinerals.loc(name.replace("raw_", "") + "_from_blasting"));
                    }
                });
    }

    private static void compatSmelting(RecipeOutput output) {
        if (ModList.get().isLoaded("mekanism")) {
            MekanismIntegration.Items.MEKITEM.getEntries()
                    .forEach((item) -> {
                        String name = item.getId().getPath();
                        if (name.contains("paxel")) {
                            ConditionalCookingRecipeBuilder.smelting(Ingredient.of(item.get()), RecipeCategory.MISC,
                                            BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_paxel", "") + "_nugget")),
                                            0.1f, 200)
                                    .conditions(new ModLoadedCondition("mekanism"))
                                    .unlockedBy("has_paxel", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                    .save(output, NaturesMinerals.loc(name.replace("_paxel", "") + "_nugget") + "_from_paxel");
                            ConditionalCookingRecipeBuilder.blasting(Ingredient.of(item.get()), RecipeCategory.MISC,
                                            BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_paxel", "") + "_nugget")),
                                            0.1f, 100)
                                    .conditions(new ModLoadedCondition("mekanism"))
                                    .unlockedBy("has_paxel", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                    .save(output, NaturesMinerals.loc(name.replace("_paxel", "") + "_nugget") + "_from_blasting_paxel");
                        }
                    });
        }
    }

    private static void recipesNuggetSmelting(RecipeOutput output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                NMItems.UVAROVITE_AXE.get(), NMItems.UVAROVITE_PICKAXE.get() , NMItems.UVAROVITE_SHOVEL.get(), NMItems.UVAROVITE_HOE.get(), NMItems.UVAROVITE_SWORD.get(),
                        NMItems.UVAROVITE_HELMET.get(), NMItems.UVAROVITE_CHESTPLATE.get(), NMItems.UVAROVITE_LEGGINGS.get(), NMItems.UVAROVITE_BOOTS.get()),
                        RecipeCategory.MISC, NMItems.UVAROVITE_NUGGET.get(), 0.1f, 200)
                .unlockedBy("has_gear", InventoryChangeTrigger.TriggerInstance.hasItems(NMItems.UVAROVITE_AXE.get(), NMItems.UVAROVITE_PICKAXE.get() , NMItems.UVAROVITE_SHOVEL.get(), NMItems.UVAROVITE_HOE.get(), NMItems.UVAROVITE_SWORD.get(),
                        NMItems.UVAROVITE_HELMET.get(), NMItems.UVAROVITE_CHESTPLATE.get(), NMItems.UVAROVITE_LEGGINGS.get(), NMItems.UVAROVITE_BOOTS.get()))
                .save(output, NaturesMinerals.loc("uvarovite_nugget_from_gear"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                        NMItems.KUNZITE_AXE.get(), NMItems.KUNZITE_PICKAXE.get() , NMItems.KUNZITE_SHOVEL.get(), NMItems.KUNZITE_HOE.get(), NMItems.KUNZITE_SWORD.get(),
                        NMItems.KUNZITE_HELMET.get(), NMItems.KUNZITE_CHESTPLATE.get(), NMItems.KUNZITE_LEGGINGS.get(), NMItems.KUNZITE_BOOTS.get()),
                        RecipeCategory.MISC, NMItems.KUNZITE_NUGGET.get(), 0.1f, 200)
                .unlockedBy("has_gear", InventoryChangeTrigger.TriggerInstance.hasItems(NMItems.KUNZITE_AXE.get(), NMItems.KUNZITE_PICKAXE.get() , NMItems.KUNZITE_SHOVEL.get(), NMItems.KUNZITE_HOE.get(), NMItems.KUNZITE_SWORD.get(),
                        NMItems.KUNZITE_HELMET.get(), NMItems.KUNZITE_CHESTPLATE.get(), NMItems.KUNZITE_LEGGINGS.get(), NMItems.KUNZITE_BOOTS.get()))
                .save(output, NaturesMinerals.loc("kunzite_nugget_from_gear"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                        NMItems.STIBNITE_AXE.get(), NMItems.STIBNITE_PICKAXE.get() , NMItems.STIBNITE_SHOVEL.get(), NMItems.STIBNITE_HOE.get(), NMItems.STIBNITE_SWORD.get(),
                        NMItems.STIBNITE_HELMET.get(), NMItems.STIBNITE_CHESTPLATE.get(), NMItems.STIBNITE_LEGGINGS.get(), NMItems.STIBNITE_BOOTS.get()),
                        RecipeCategory.MISC, NMItems.STIBNITE_NUGGET.get(), 0.1f, 200)
                .unlockedBy("has_gear", InventoryChangeTrigger.TriggerInstance.hasItems(NMItems.STIBNITE_AXE.get(), NMItems.STIBNITE_PICKAXE.get() , NMItems.STIBNITE_SHOVEL.get(), NMItems.STIBNITE_HOE.get(), NMItems.STIBNITE_SWORD.get(),
                        NMItems.STIBNITE_HELMET.get(), NMItems.STIBNITE_CHESTPLATE.get(), NMItems.STIBNITE_LEGGINGS.get(), NMItems.STIBNITE_BOOTS.get()))
                .save(output, NaturesMinerals.loc("stibnite_nugget_from_gear"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                        NMItems.ASTRITE_AXE.get(), NMItems.ASTRITE_PICKAXE.get() , NMItems.ASTRITE_SHOVEL.get(), NMItems.ASTRITE_HOE.get(), NMItems.ASTRITE_SWORD.get(),
                        NMItems.ASTRITE_HELMET.get(), NMItems.ASTRITE_CHESTPLATE.get(), NMItems.ASTRITE_LEGGINGS.get(), NMItems.ASTRITE_BOOTS.get()),
                        RecipeCategory.MISC, NMItems.ASTRITE_NUGGET.get(), 0.1f, 200)
                .unlockedBy("has_gear", InventoryChangeTrigger.TriggerInstance.hasItems(NMItems.ASTRITE_AXE.get(), NMItems.ASTRITE_PICKAXE.get() , NMItems.ASTRITE_SHOVEL.get(), NMItems.ASTRITE_HOE.get(), NMItems.ASTRITE_SWORD.get(),
                        NMItems.ASTRITE_HELMET.get(), NMItems.ASTRITE_CHESTPLATE.get(), NMItems.ASTRITE_LEGGINGS.get(), NMItems.ASTRITE_BOOTS.get()))
                .save(output, NaturesMinerals.loc("astrite_nugget_from_gear"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                        NMItems.THOUNITE_AXE.get(), NMItems.THOUNITE_PICKAXE.get() , NMItems.THOUNITE_SHOVEL.get(), NMItems.THOUNITE_HOE.get(), NMItems.THOUNITE_SWORD.get(),
                        NMItems.THOUNITE_HELMET.get(), NMItems.THOUNITE_CHESTPLATE.get(), NMItems.THOUNITE_LEGGINGS.get(), NMItems.THOUNITE_BOOTS.get()),
                        RecipeCategory.MISC, NMItems.THOUNITE_NUGGET.get(), 0.1f, 200)
                .unlockedBy("has_gear", InventoryChangeTrigger.TriggerInstance.hasItems(NMItems.THOUNITE_AXE.get(), NMItems.THOUNITE_PICKAXE.get() , NMItems.THOUNITE_SHOVEL.get(), NMItems.THOUNITE_HOE.get(), NMItems.THOUNITE_SWORD.get(),
                        NMItems.THOUNITE_HELMET.get(), NMItems.THOUNITE_CHESTPLATE.get(), NMItems.THOUNITE_LEGGINGS.get(), NMItems.THOUNITE_BOOTS.get()))
                .save(output, NaturesMinerals.loc("thounite_nugget_from_gear"));
    }

    private static void recipesNuggetBlasting(RecipeOutput output) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                        NMItems.UVAROVITE_AXE.get(), NMItems.UVAROVITE_PICKAXE.get() , NMItems.UVAROVITE_SHOVEL.get(), NMItems.UVAROVITE_HOE.get(), NMItems.UVAROVITE_SWORD.get(),
                        NMItems.UVAROVITE_HELMET.get(), NMItems.UVAROVITE_CHESTPLATE.get(), NMItems.UVAROVITE_LEGGINGS.get(), NMItems.UVAROVITE_BOOTS.get()),
                        RecipeCategory.MISC, NMItems.UVAROVITE_NUGGET.get(), 0.1f, 100)
                .unlockedBy("has_gear", InventoryChangeTrigger.TriggerInstance.hasItems(NMItems.UVAROVITE_AXE.get(), NMItems.UVAROVITE_PICKAXE.get() , NMItems.UVAROVITE_SHOVEL.get(), NMItems.UVAROVITE_HOE.get(), NMItems.UVAROVITE_SWORD.get(),
                        NMItems.UVAROVITE_HELMET.get(), NMItems.UVAROVITE_CHESTPLATE.get(), NMItems.UVAROVITE_LEGGINGS.get(), NMItems.UVAROVITE_BOOTS.get()))
                .save(output, NaturesMinerals.loc("uvarovite_nugget_from_blasting_gear"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                        NMItems.KUNZITE_AXE.get(), NMItems.KUNZITE_PICKAXE.get() , NMItems.KUNZITE_SHOVEL.get(), NMItems.KUNZITE_HOE.get(), NMItems.KUNZITE_SWORD.get(),
                        NMItems.KUNZITE_HELMET.get(), NMItems.KUNZITE_CHESTPLATE.get(), NMItems.KUNZITE_LEGGINGS.get(), NMItems.KUNZITE_BOOTS.get()),
                        RecipeCategory.MISC, NMItems.KUNZITE_NUGGET.get(), 0.1f, 100)
                .unlockedBy("has_gear", InventoryChangeTrigger.TriggerInstance.hasItems(NMItems.KUNZITE_AXE.get(), NMItems.KUNZITE_PICKAXE.get() , NMItems.KUNZITE_SHOVEL.get(), NMItems.KUNZITE_HOE.get(), NMItems.KUNZITE_SWORD.get(),
                        NMItems.KUNZITE_HELMET.get(), NMItems.KUNZITE_CHESTPLATE.get(), NMItems.KUNZITE_LEGGINGS.get(), NMItems.KUNZITE_BOOTS.get()))
                .save(output, NaturesMinerals.loc("kunzite_nugget_from_blasting_gear"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                        NMItems.STIBNITE_AXE.get(), NMItems.STIBNITE_PICKAXE.get() , NMItems.STIBNITE_SHOVEL.get(), NMItems.STIBNITE_HOE.get(), NMItems.STIBNITE_SWORD.get(),
                        NMItems.STIBNITE_HELMET.get(), NMItems.STIBNITE_CHESTPLATE.get(), NMItems.STIBNITE_LEGGINGS.get(), NMItems.STIBNITE_BOOTS.get()),
                        RecipeCategory.MISC, NMItems.STIBNITE_NUGGET.get(), 0.1f, 100)
                .unlockedBy("has_gear", InventoryChangeTrigger.TriggerInstance.hasItems(NMItems.STIBNITE_AXE.get(), NMItems.STIBNITE_PICKAXE.get() , NMItems.STIBNITE_SHOVEL.get(), NMItems.STIBNITE_HOE.get(), NMItems.STIBNITE_SWORD.get(),
                        NMItems.STIBNITE_HELMET.get(), NMItems.STIBNITE_CHESTPLATE.get(), NMItems.STIBNITE_LEGGINGS.get(), NMItems.STIBNITE_BOOTS.get()))
                .save(output, NaturesMinerals.loc("stibnite_nugget_from_blasting_gear"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                        NMItems.ASTRITE_AXE.get(), NMItems.ASTRITE_PICKAXE.get() , NMItems.ASTRITE_SHOVEL.get(), NMItems.ASTRITE_HOE.get(), NMItems.ASTRITE_SWORD.get(),
                        NMItems.ASTRITE_HELMET.get(), NMItems.ASTRITE_CHESTPLATE.get(), NMItems.ASTRITE_LEGGINGS.get(), NMItems.ASTRITE_BOOTS.get()),
                        RecipeCategory.MISC, NMItems.ASTRITE_NUGGET.get(), 0.1f, 100)
                .unlockedBy("has_gear", InventoryChangeTrigger.TriggerInstance.hasItems(NMItems.ASTRITE_AXE.get(), NMItems.ASTRITE_PICKAXE.get() , NMItems.ASTRITE_SHOVEL.get(), NMItems.ASTRITE_HOE.get(), NMItems.ASTRITE_SWORD.get(),
                        NMItems.ASTRITE_HELMET.get(), NMItems.ASTRITE_CHESTPLATE.get(), NMItems.ASTRITE_LEGGINGS.get(), NMItems.ASTRITE_BOOTS.get()))
                .save(output, NaturesMinerals.loc("astrite_nugget_from_blasting_gear"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(
                        NMItems.THOUNITE_AXE.get(), NMItems.THOUNITE_PICKAXE.get() , NMItems.THOUNITE_SHOVEL.get(), NMItems.THOUNITE_HOE.get(), NMItems.THOUNITE_SWORD.get(),
                        NMItems.THOUNITE_HELMET.get(), NMItems.THOUNITE_CHESTPLATE.get(), NMItems.THOUNITE_LEGGINGS.get(), NMItems.THOUNITE_BOOTS.get()),
                        RecipeCategory.MISC, NMItems.THOUNITE_NUGGET.get(), 0.1f, 100)
                .unlockedBy("has_gear", InventoryChangeTrigger.TriggerInstance.hasItems(NMItems.THOUNITE_AXE.get(), NMItems.THOUNITE_PICKAXE.get() , NMItems.THOUNITE_SHOVEL.get(), NMItems.THOUNITE_HOE.get(), NMItems.THOUNITE_SWORD.get(),
                        NMItems.THOUNITE_HELMET.get(), NMItems.THOUNITE_CHESTPLATE.get(), NMItems.THOUNITE_LEGGINGS.get(), NMItems.THOUNITE_BOOTS.get()))
                .save(output, NaturesMinerals.loc("thounite_nugget_from_blasting_gear"));
    }
}
