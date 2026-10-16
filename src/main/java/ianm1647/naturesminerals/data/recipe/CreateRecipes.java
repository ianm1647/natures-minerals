package ianm1647.naturesminerals.data.recipe;

import com.simibubi.create.api.data.recipe.PressingRecipeGen;
import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.registry.NMItems;
import ianm1647.naturesminerals.integration.create.CreateIntegration;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;

public class CreateRecipes {

    public static class Pressing extends PressingRecipeGen {
        {
            NMItems.ITEMS.getEntries()
                    .forEach((item) -> {
                        String name = item.getId().getPath();
                        if (name.contains("sheet")) {
                            this.create(name.replace("_sheet", "_ingot"), (b) -> (b
                                    .require(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID,
                                            name.replace("_sheet", "_ingot")))))
                                    .output(item.get()));
                        }
                    });
        }

        public Pressing(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries, NaturesMinerals.MODID);
        }
    }

}
