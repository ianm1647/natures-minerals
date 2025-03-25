package ianm1647.naturesminerals.data.recipe;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.registry.NMItems;
import ianm1647.naturesminerals.data.recipe.builder.ConditionalShapedRecipeBuilder;
import ianm1647.naturesminerals.integration.mekanism.MekanismIntegration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

public class CraftingRecipes {

    public static void register(RecipeOutput output) {
        recipesMaterials(output);
        recipesBlocks(output);
        recipesGear(output);

        compatRecipes(output);
    }

    private static void recipesMaterials(RecipeOutput output) {
        NMItems.ITEMS.getEntries()
                .forEach((item) -> {
                    String name = item.getId().getPath();
                    if (name.contains("nugget")) {
                        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_nugget", "") + "_ingot")))
                                .requires(item.get(), 9).group("ingot")
                                .unlockedBy("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                .save(output, NaturesMinerals.loc(name.replace("_nugget", "") + "_ingot_from_nugget"));
                    }
                    if (name.contains("ingot")) {
                        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_ingot", "") + "_nugget")), 9)
                                .requires(item.get(), 1).group("nugget")
                                .unlockedBy("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                .save(output, NaturesMinerals.loc(name.replace("_ingot", "") + "_nugget_from_ingot"));
                    }
                    if (name.contains("block") && !name.contains("raw")) {
                        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_block", "") + "_ingot")), 9)
                                .requires(item.get(), 1).group("ingot")
                                .unlockedBy("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                .save(output, NaturesMinerals.loc(name.replace("_block", "") + "_ingot_from_block"));
                    }
                    if (name.contains("raw") && item.get() instanceof BlockItem) {
                        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_block", ""))), 9)
                                .requires(item.get(), 1).group("raw_material")
                                .unlockedBy("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                .save(output, NaturesMinerals.loc(name.replace("_block", "") + "_from_block"));
                    }
                });
    }

    private static void recipesBlocks(RecipeOutput output) {
        NMItems.ITEMS.getEntries()
                .forEach((item) -> {
                    String name = item.getId().getPath();
                    if (name.contains("ingot")) {
                        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                                BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_ingot", "") + "_block")))
                                .requires(item.get(), 9).group("storage_blocks")
                                .unlockedBy("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(item.get())).save(output);
                    }
                    if (name.contains("raw") && !(item.get() instanceof BlockItem)) {
                        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name + "_block")))
                                .requires(item.get(), 9).group("storage_blocks")
                                .unlockedBy("has_material", InventoryChangeTrigger.TriggerInstance.hasItems(item.get())).save(output);
                    }
                });

    }

    private static void recipesGear(RecipeOutput output) {
        NMItems.ITEMS.getEntries()
                .forEach((item) -> {
                    String name = item.getId().getPath();
                    if (name.contains("ingot")) {
                        craftPickaxe(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_ingot", "") + "_pickaxe")),
                                item.get(), output);
                        craftAxe(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_ingot", "") + "_axe")),
                                item.get(), output);
                        craftShovel(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_ingot", "") + "_shovel")),
                                item.get(), output);
                        craftSword(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_ingot", "") + "_sword")),
                                item.get(), output);
                        craftHoe(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_ingot", "") + "_hoe")),
                                item.get(), output);
                        craftHelmet(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_ingot", "") + "_helmet")),
                                item.get(), output);
                        craftChestplate(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_ingot", "") + "_chestplate")),
                                item.get(), output);
                        craftLeggings(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_ingot", "") + "_leggings")),
                                item.get(), output);
                        craftBoots(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_ingot", "") + "_boots")),
                                item.get(), output);
                    }
                });
    }

    private static void compatRecipes(RecipeOutput output) {
        MekanismIntegration.Items.MEKITEM.getEntries()
                .forEach((item) -> {
                    String name = item.getId().getPath();
                    if (name.contains("paxel")) {
                        craftPaxel(item.get(),
                                BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_paxel", "") + "_axe")),
                                BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_paxel", "") + "_pickaxe")),
                                BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                        name.replace("_paxel", "") + "_shovel")), output);
                    }
                });
    }

    private static void craftAxe(ItemLike tool, ItemLike input, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tool, 1)
                .pattern("ii")
                .pattern("is")
                .pattern(" s")
                .define('i', input)
                .define('s', Items.STICK)
                .group("axe").unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(input)).save(output);
    }

    private static void craftPickaxe(ItemLike tool, ItemLike input, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tool, 1)
                .pattern("iii")
                .pattern(" s ")
                .pattern(" s ")
                .define('i', input)
                .define('s', Items.STICK)
                .group("pickaxe").unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(input)).save(output);
    }

    private static void craftShovel(ItemLike tool, ItemLike input, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tool, 1)
                .pattern("i")
                .pattern("s")
                .pattern("s")
                .define('i', input)
                .define('s', Items.STICK)
                .group("shovel").unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(input)).save(output);
    }

    private static void craftSword(ItemLike tool, ItemLike input, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tool, 1)
                .pattern("i")
                .pattern("i")
                .pattern("s")
                .define('i', input)
                .define('s', Items.STICK)
                .group("sword").unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(input)).save(output);
    }

    private static void craftHoe(ItemLike tool, ItemLike input, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tool, 1)
                .pattern("ii")
                .pattern(" s")
                .pattern(" s")
                .define('i', input)
                .define('s', Items.STICK)
                .group("hoe").unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(input)).save(output);
    }

    private static void craftHelmet(ItemLike tool, ItemLike input, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tool, 1)
                .pattern("iii")
                .pattern("i i")
                .define('i', input)
                .group("helmet").unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(input)).save(output);
    }

    private static void craftChestplate(ItemLike tool, ItemLike input, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tool, 1)
                .pattern("i i")
                .pattern("iii")
                .pattern("iii")
                .define('i', input)
                .group("chestplate").unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(input)).save(output);
    }

    private static void craftLeggings(ItemLike tool, ItemLike input, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tool, 1)
                .pattern("iii")
                .pattern("i i")
                .pattern("i i")
                .define('i', input)
                .group("leggings").unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(input)).save(output);
    }

    private static void craftBoots(ItemLike tool, ItemLike input, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tool, 1)
                .pattern("i i")
                .pattern("i i")
                .define('i', input)
                .group("boots").unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(input)).save(output);
    }

    private static void craftPaxel(ItemLike tool, ItemLike axe, ItemLike pickaxe, ItemLike shovel, RecipeOutput output) {
        ConditionalShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tool, 1)
                .pattern("aps")
                .pattern(" i ")
                .pattern(" i ")
                .define('a', axe)
                .define('p', pickaxe)
                .define('s', shovel)
                .define('i', Items.STICK)
                .group("paxel")
                .unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(axe))
                .unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(pickaxe))
                .unlockedBy("has_material",
                        InventoryChangeTrigger.TriggerInstance.hasItems(shovel))
                .conditions(new ModLoadedCondition("mekanism"))
                .save(output);
    }

}
