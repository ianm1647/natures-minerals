package ianm1647.naturesminerals.data;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class NMPackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER;

    public NMPackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(NaturesMinerals.MODID));
    }

    static {
        BUILDER = new RegistrySetBuilder();
    }
}
