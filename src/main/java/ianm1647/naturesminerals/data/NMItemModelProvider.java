package ianm1647.naturesminerals.data;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.registry.NMItems;
import ianm1647.naturesminerals.integration.mekanism.MekanismIntegration;
import ianm1647.naturesminerals.integration.mekanism.ModPaxelItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class NMItemModelProvider extends ItemModelProvider {
    public NMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NaturesMinerals.MODID, existingFileHelper);
    }

    @Override
    public void registerModels() {
        ResourceLocation generated = ResourceLocation.withDefaultNamespace("item/generated");
        ResourceLocation handheld = ResourceLocation.withDefaultNamespace("item/handheld");

        NMItems.ITEMS.getEntries()
                .forEach((item) -> {
                    String name = item.getId().getPath();
                    if (item.get() instanceof BlockItem) {
                        this.cubeAll(name, this.bLoc(name));
                    } else if (item.get() instanceof SwordItem) {
                        this.handheldItem(NaturesMinerals.loc(name));
                    } else if (item.get() instanceof PickaxeItem) {
                        this.handheldItem(NaturesMinerals.loc(name));
                    } else if (item.get() instanceof AxeItem) {
                        this.handheldItem(NaturesMinerals.loc(name));
                    } else if (item.get() instanceof ShovelItem) {
                        this.handheldItem(NaturesMinerals.loc(name));
                    } else if (item.get() instanceof HoeItem) {
                        this.handheldItem(NaturesMinerals.loc(name));
                    } else {
                        if (!name.contains("bucket")) {
                            this.withExistingParent(name, generated).texture("layer0", this.resLoc(name));
                        }
                    }
                });


        MekanismIntegration.Items.MEKITEM.getEntries().forEach((item) -> {
            String name = item.getId().getPath();
            if (item.get() instanceof ModPaxelItem) {
                this.handheldItem(NaturesMinerals.loc(name));
            } else {
                this.withExistingParent(name, generated).texture("layer0", this.resLoc("mekanism/" + name));
            }
        });


    }

    private ResourceLocation resLoc(String name) {
        return ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "item/" + name);
    }

    private ResourceLocation bLoc(String name) {
        return ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "block/" + name);
    }
}
