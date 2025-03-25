package ianm1647.naturesminerals.data;

import ianm1647.naturesminerals.data.recipe.CraftingRecipes;
import ianm1647.naturesminerals.data.recipe.MekanismRecipes;
import ianm1647.naturesminerals.data.recipe.SmeltingRecipes;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NMRecipeProvider extends RecipeProvider {
    public NMRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected void buildRecipes(RecipeOutput output) {
        CraftingRecipes.register(output);
        SmeltingRecipes.register(output);

        MekanismRecipes.register(output);
    }
}
