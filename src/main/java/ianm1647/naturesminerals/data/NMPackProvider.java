package ianm1647.naturesminerals.data;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.world.NMBiomeModifiers;
import ianm1647.naturesminerals.common.world.NMConfiguredFeatures;
import ianm1647.naturesminerals.common.world.NMPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class NMPackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER;

    public NMPackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(NaturesMinerals.MODID));
    }

    static {
        BUILDER = new RegistrySetBuilder();
        BUILDER.add(Registries.CONFIGURED_FEATURE, NMConfiguredFeatures::bootstrap);
        BUILDER.add(Registries.PLACED_FEATURE, NMPlacedFeatures::bootstrap);
        BUILDER.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, NMBiomeModifiers::bootstrap);
    }
}
