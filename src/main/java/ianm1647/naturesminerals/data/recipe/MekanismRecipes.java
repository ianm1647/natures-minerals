package ianm1647.naturesminerals.data.recipe;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.registry.NMItems;
import ianm1647.naturesminerals.integration.mekanism.MekanismIntegration;
import mekanism.api.MekanismAPI;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.datagen.recipe.builder.*;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import mekanism.common.registries.MekanismChemicals;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

public class MekanismRecipes {

    public static void register(RecipeOutput output) {
        recipesCommon(output);
        recipesMaterials(output);
        recipesSlurries(output);
    }

    private static void recipesCommon(RecipeOutput output) {
        NMItems.ITEMS.getEntries()
                .forEach((item) -> {
                    String name = item.getId().getPath();
                    if (name.contains("ingot")) {
                        ItemStackToItemStackRecipeBuilder.crushing(
                                        IngredientCreatorAccess.item().from(item.get()),
                                        new ItemStack(BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_ingot", "") + "_dust")))
                                )
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("_ingot", "/dust") + "/from_ingot"));
                    }
                    if (name.contains("dust") && !name.contains("thounite")) {
                        ItemStackToItemStackRecipeBuilder.enriching(
                                        IngredientCreatorAccess.item().from(ItemTags.create(
                                                ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/raw_" + name.replace("_dust", "")))),
                                        new ItemStack(item.get(), 12)
                                )
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("_dust", "/dust") + "/from_raw_block"));
                        ItemStackToItemStackRecipeBuilder.enriching(
                                        IngredientCreatorAccess.item().from(ItemTags.create(
                                                ResourceLocation.fromNamespaceAndPath("c", "raw_materials/" + name.replace("_dust", ""))), 3),
                                        new ItemStack(item.get(), 4)
                                )
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("_dust", "/dust") + "/from_raw"));
                        ItemStackToItemStackRecipeBuilder.enriching(
                                        IngredientCreatorAccess.item().from(ItemTags.create(
                                                ResourceLocation.fromNamespaceAndPath("c", "ores/" + name.replace("_dust", "")))),
                                        new ItemStack(item.get())
                                )
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("_dust", "/dust") + "/from_ore"));
                        ItemStackToItemStackRecipeBuilder.enriching(
                                        IngredientCreatorAccess.item().from(ItemTags.create(
                                                ResourceLocation.fromNamespaceAndPath("c", "dirty_dusts/" + name.replace("_dust", "")))),
                                        new ItemStack(item.get())
                                )
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("_dust", "/dust") + "/from_dirty_dust"));

                    }
                });
    }

    private static void recipesMaterials(RecipeOutput output) {
        MekanismIntegration.Items.MEKITEM.getEntries()
                .forEach((item) -> {
                    String name = item.getId().getPath();
                    if (name.contains("shard")) {
                        ItemStackChemicalToItemStackRecipeBuilder.injecting(
                                IngredientCreatorAccess.item().from(
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc("raw_" + name.replace("_shard", ""))), 3),
                                IngredientCreatorAccess.chemicalStack().fromHolder(MekanismChemicals.HYDROGEN_CHLORIDE, 200),
                                new ItemStack(item.get(), 8), false)
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("_shard", "") + "/shard/from_raw"));
                        ItemStackChemicalToItemStackRecipeBuilder.injecting(
                                IngredientCreatorAccess.item().from(
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc("raw_" + name.replace("_shard", "") + "_block")), 1),
                                IngredientCreatorAccess.chemicalStack().fromHolder(MekanismChemicals.HYDROGEN_CHLORIDE, 400),
                                new ItemStack(item.get(), 24), false)
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("_shard", "") + "/shard/from_raw_block"));
                        ItemStackChemicalToItemStackRecipeBuilder.injecting(
                                IngredientCreatorAccess.item().from(ItemTags.create(
                                        ResourceLocation.fromNamespaceAndPath("c", "ores/" + name.replace("_shard", "")))),
                                IngredientCreatorAccess.chemicalStack().fromHolder(MekanismChemicals.HYDROGEN_CHLORIDE, 200),
                                new ItemStack(item.get(), 4), false)
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("_shard", "") + "/shard/from_ore"));
                        ItemStackChemicalToItemStackRecipeBuilder.injecting(
                                IngredientCreatorAccess.item().from(
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_shard", "") + "_crystal")), 1),
                                IngredientCreatorAccess.chemicalStack().fromHolder(MekanismChemicals.HYDROGEN_CHLORIDE, 200),
                                item.get().getDefaultInstance(), false)
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("_shard", "") + "/shard/from_crystal"));
                    }
                    if (name.contains("crystal")) {
                        ChemicalCrystallizerRecipeBuilder.crystallizing(
                                IngredientCreatorAccess.chemicalStack().fromHolder(
                                        MekanismAPI.CHEMICAL_REGISTRY.getHolder(NaturesMinerals.loc("clean_" + name.replace("_crystal", ""))).get(), 200),
                                item.get().getDefaultInstance())
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("_crystal", "/crystal") + "/from_slurry"));
                    }
                    if (name.contains("dirty_dust")) {
                        ItemStackToItemStackRecipeBuilder.crushing(
                                IngredientCreatorAccess.item().from(
                                        BuiltInRegistries.ITEM.get(NaturesMinerals.loc(name.replace("_dirty_dust", "") + "_clump"))),
                                new ItemStack(item.get())
                                )
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("_dirty_dust", "/dirty_dust") + "/from_clump"));
                    }
                });
    }

    private static void recipesSlurries(RecipeOutput output) {
        MekanismIntegration.Chemicals.MEKCHEM.getEntries()
                .forEach((item) -> {
                    String name = item.getId().getPath();
                    if (name.contains("clean")) {
                        FluidChemicalToChemicalRecipeBuilder.washing(
                                        IngredientCreatorAccess.fluid().from(FluidTags.WATER, 5),
                                        IngredientCreatorAccess.chemicalStack().fromHolder(
                                                MekanismAPI.CHEMICAL_REGISTRY.getHolder(NaturesMinerals.loc("dirty_" + name.replace("clean_", ""))).get(), 1),
                                        new ChemicalStack(MekanismAPI.CHEMICAL_REGISTRY.getHolder(NaturesMinerals.loc(name)).get(), 1))
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("clean_", "") + "/slurry/clean"));
                    }
                    if (name.contains("dirty")) {
                        ChemicalDissolutionRecipeBuilder.dissolution(
                                IngredientCreatorAccess.item().from(ItemTags.create(
                                    ResourceLocation.fromNamespaceAndPath("c", "ores/" + name.replace("dirty_", "")))),
                                IngredientCreatorAccess.chemicalStack().fromHolder(MekanismChemicals.SULFURIC_ACID, 1),
                                new ChemicalStack(MekanismAPI.CHEMICAL_REGISTRY.getHolder(
                                        NaturesMinerals.loc(name)).get(), 1000), true)
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("dirty_", "") + "/slurry/dirty/from_ore"));
                        ChemicalDissolutionRecipeBuilder.dissolution(
                                        IngredientCreatorAccess.item().from(
                                                BuiltInRegistries.ITEM.get(NaturesMinerals.loc("raw_" + name.replace("dirty_", ""))), 3),
                                        IngredientCreatorAccess.chemicalStack().fromHolder(MekanismChemicals.SULFURIC_ACID, 1),
                                        new ChemicalStack(MekanismAPI.CHEMICAL_REGISTRY.getHolder(
                                                NaturesMinerals.loc(name)).get(), 1000), true)
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("dirty_", "") + "/slurry/dirty/from_raw"));
                        ChemicalDissolutionRecipeBuilder.dissolution(
                                        IngredientCreatorAccess.item().from(
                                                BuiltInRegistries.ITEM.get(NaturesMinerals.loc("raw_" + name.replace("dirty_", "") + "_block"))),
                                        IngredientCreatorAccess.chemicalStack().fromHolder(MekanismChemicals.SULFURIC_ACID, 2),
                                        new ChemicalStack(MekanismAPI.CHEMICAL_REGISTRY.getHolder(
                                                NaturesMinerals.loc(name)).get(), 1000), true)
                                .addCondition(new ModLoadedCondition("mekanism"))
                                .build(output, mekLoc(name.replace("dirty_", "") + "/slurry/dirty/from_raw_block"));
                    }
                });
    }

    public static ResourceLocation mekLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "mekanism/" + path);
    }
}
