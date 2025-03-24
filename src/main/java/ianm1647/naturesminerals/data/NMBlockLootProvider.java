package ianm1647.naturesminerals.data;

import ianm1647.naturesminerals.common.registry.NMBlocks;
import ianm1647.naturesminerals.common.registry.NMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashSet;
import java.util.Set;

public class NMBlockLootProvider extends BlockLootSubProvider {
    private final Set<Block> generatedLootTables = new HashSet();

    protected NMBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    protected void generate() {
        NMBlocks.BLOCKS.getEntries().stream()
                .filter((block) -> !(block.get() instanceof LiquidBlock))
                .filter((block) -> {
                    String name = block.getId().getPath();
                    return !name.contains("ore");
                })
                .forEach((block) -> {
                    dropSelf(block.get());
                });

        this.add(NMBlocks.UVAROVITE_ORE.get(), block -> createOreDrop(block, NMItems.RAW_UVAROVITE.get()));
        this.add(NMBlocks.DEEPSLATE_UVAROVITE_ORE.get(), block -> createOreDrop(block, NMItems.RAW_UVAROVITE.get()));
        this.add(NMBlocks.KUNZITE_ORE.get(), block -> createOreDrop(block, NMItems.RAW_KUNZITE.get()));
        this.add(NMBlocks.DEEPSLATE_KUNZITE_ORE.get(), block -> createOreDrop(block, NMItems.RAW_KUNZITE.get()));
        this.add(NMBlocks.STIBNITE_ORE.get(), block -> createOreDrop(block, NMItems.RAW_STIBNITE.get()));
        this.add(NMBlocks.ASTRITE_ORE.get(), block -> createOreDrop(block, NMItems.RAW_ASTRITE.get()));
    }

    protected void add(Block block, LootTable.Builder builder) {
        this.generatedLootTables.add(block);
        this.map.put(block.getLootTable(), builder);
    }

    protected Iterable<Block> getKnownBlocks() {
        return this.generatedLootTables;
    }
}
