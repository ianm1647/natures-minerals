package ianm1647.naturesminerals.data;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class NMItemModelProvider extends ItemModelProvider {
    public NMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NaturesMinerals.MODID, existingFileHelper);
    }

    @Override
    public void registerModels() {

    }
}
