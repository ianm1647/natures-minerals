package ianm1647.naturesminerals.data;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(
        modid = NaturesMinerals.MODID,
        bus = EventBusSubscriber.Bus.MOD
)
public class NMDataGenerator {
    public NMDataGenerator() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        NMBlockTagProvider blockTags = new NMBlockTagProvider(output, lookupProvider, helper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new NMItemTagProvider(output, lookupProvider, blockTags.contentsGetter(), helper));
        generator.addProvider(event.includeClient(), new NMBlockStateProvider(output, helper));
        generator.addProvider(event.includeClient(), new NMItemModelProvider(output, helper));

        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(NMBlockLootProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
        generator.addProvider(event.includeServer(), new NMPackProvider(output, lookupProvider));
    }
}
