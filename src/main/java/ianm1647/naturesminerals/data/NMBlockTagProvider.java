package ianm1647.naturesminerals.data;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.registry.NMBlocks;
import ianm1647.naturesminerals.common.tag.NMCommonTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.LiquidBlock;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class NMBlockTagProvider extends BlockTagsProvider {
    public NMBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NaturesMinerals.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        blockTags();
        blockToolTags();
    }

    private void blockTags() {
        tag(Tags.Blocks.ORES).addTags(
                NMCommonTags.Blocks.ORES_UVAROVITE,
                NMCommonTags.Blocks.ORES_KUNZITE,
                NMCommonTags.Blocks.ORES_STIBNITE,
                NMCommonTags.Blocks.ORES_ASTRITE
        );
        tag(NMCommonTags.Blocks.ORES_UVAROVITE).add(NMBlocks.UVAROVITE_ORE.get(), NMBlocks.DEEPSLATE_UVAROVITE_ORE.get());
        tag(NMCommonTags.Blocks.ORES_KUNZITE).add(NMBlocks.KUNZITE_ORE.get(), NMBlocks.DEEPSLATE_KUNZITE_ORE.get());
        tag(NMCommonTags.Blocks.ORES_STIBNITE).add(NMBlocks.STIBNITE_ORE.get());
        tag(NMCommonTags.Blocks.ORES_ASTRITE).add(NMBlocks.ASTRITE_ORE.get());

        tag(Tags.Blocks.STORAGE_BLOCKS).addTags(
                NMCommonTags.Blocks.BLOCKS_UVAROVITE,
                NMCommonTags.Blocks.BLOCKS_KUNZITE,
                NMCommonTags.Blocks.BLOCKS_STIBNITE,
                NMCommonTags.Blocks.BLOCKS_ASTRITE,
                NMCommonTags.Blocks.BLOCKS_THOUNITE,
                NMCommonTags.Blocks.BLOCKS_RAW_UVAROVITE,
                NMCommonTags.Blocks.BLOCKS_RAW_KUNZITE,
                NMCommonTags.Blocks.BLOCKS_RAW_STIBNITE,
                NMCommonTags.Blocks.BLOCKS_RAW_ASTRITE
        );
        tag(NMCommonTags.Blocks.BLOCKS_UVAROVITE).add(NMBlocks.UVAROVITE_BLOCK.get());
        tag(NMCommonTags.Blocks.BLOCKS_KUNZITE).add(NMBlocks.KUNZITE_BLOCK.get());
        tag(NMCommonTags.Blocks.BLOCKS_STIBNITE).add(NMBlocks.STIBNITE_BLOCK.get());
        tag(NMCommonTags.Blocks.BLOCKS_ASTRITE).add(NMBlocks.ASTRITE_BLOCK.get());
        tag(NMCommonTags.Blocks.BLOCKS_THOUNITE).add(NMBlocks.THOUNITE_BLOCK.get());
        tag(NMCommonTags.Blocks.BLOCKS_RAW_UVAROVITE).add(NMBlocks.RAW_UVAROVITE_BLOCK.get());
        tag(NMCommonTags.Blocks.BLOCKS_RAW_KUNZITE).add(NMBlocks.RAW_KUNZITE_BLOCK.get());
        tag(NMCommonTags.Blocks.BLOCKS_RAW_STIBNITE).add(NMBlocks.RAW_STIBNITE_BLOCK.get());
        tag(NMCommonTags.Blocks.BLOCKS_RAW_ASTRITE).add(NMBlocks.RAW_ASTRITE_BLOCK.get());

    }

    private void blockToolTags() {
        NMBlocks.BLOCKS.getEntries().stream()
                .filter((block) -> !(block.get() instanceof LiquidBlock))
                .forEach((block) -> {
                    tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get());
                });
        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).addTags(
                NMCommonTags.Blocks.NEEDS_UVAROVITE_TOOL,
                NMCommonTags.Blocks.NEEDS_KUNZITE_TOOL,
                NMCommonTags.Blocks.NEEDS_STIBNITE_TOOL,
                NMCommonTags.Blocks.NEEDS_ASTRITE_TOOL,
                NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL
        );
        tag(BlockTags.INCORRECT_FOR_STONE_TOOL).addTags(
                NMCommonTags.Blocks.NEEDS_UVAROVITE_TOOL,
                NMCommonTags.Blocks.NEEDS_KUNZITE_TOOL,
                NMCommonTags.Blocks.NEEDS_STIBNITE_TOOL,
                NMCommonTags.Blocks.NEEDS_ASTRITE_TOOL,
                NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL
        );
        tag(BlockTags.INCORRECT_FOR_IRON_TOOL).addTags(
                NMCommonTags.Blocks.NEEDS_UVAROVITE_TOOL,
                NMCommonTags.Blocks.NEEDS_KUNZITE_TOOL,
                NMCommonTags.Blocks.NEEDS_STIBNITE_TOOL,
                NMCommonTags.Blocks.NEEDS_ASTRITE_TOOL,
                NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL
        );
        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL).addTags(
                NMCommonTags.Blocks.NEEDS_UVAROVITE_TOOL,
                NMCommonTags.Blocks.NEEDS_KUNZITE_TOOL,
                NMCommonTags.Blocks.NEEDS_STIBNITE_TOOL,
                NMCommonTags.Blocks.NEEDS_ASTRITE_TOOL,
                NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL
        );
        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL).addTags(
                NMCommonTags.Blocks.NEEDS_UVAROVITE_TOOL,
                NMCommonTags.Blocks.NEEDS_KUNZITE_TOOL,
                NMCommonTags.Blocks.NEEDS_STIBNITE_TOOL,
                NMCommonTags.Blocks.NEEDS_ASTRITE_TOOL,
                NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL
        );
        tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL).addTags(
                NMCommonTags.Blocks.NEEDS_UVAROVITE_TOOL,
                NMCommonTags.Blocks.NEEDS_KUNZITE_TOOL,
                NMCommonTags.Blocks.NEEDS_STIBNITE_TOOL,
                NMCommonTags.Blocks.NEEDS_ASTRITE_TOOL,
                NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL
        );
        tag(NMCommonTags.Blocks.INCORRECT_FOR_UVAROVITE_TOOL).addTags(
                NMCommonTags.Blocks.NEEDS_KUNZITE_TOOL,
                NMCommonTags.Blocks.NEEDS_STIBNITE_TOOL,
                NMCommonTags.Blocks.NEEDS_ASTRITE_TOOL,
                NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL
        );
        tag(NMCommonTags.Blocks.INCORRECT_FOR_KUNZITE_TOOL).addTags(
                NMCommonTags.Blocks.NEEDS_STIBNITE_TOOL,
                NMCommonTags.Blocks.NEEDS_ASTRITE_TOOL,
                NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL
        );
        tag(NMCommonTags.Blocks.INCORRECT_FOR_STIBNITE_TOOL).addTags(
                NMCommonTags.Blocks.NEEDS_ASTRITE_TOOL,
                NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL
        );
        tag(NMCommonTags.Blocks.INCORRECT_FOR_ASTRITE_TOOL).addTag(
                NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL
        );
        tag(NMCommonTags.Blocks.INCORRECT_FOR_THOUNITE_TOOL);
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(
                NMBlocks.UVAROVITE_BLOCK.get(),
                NMBlocks.RAW_UVAROVITE_BLOCK.get(),
                NMBlocks.UVAROVITE_ORE.get(),
                NMBlocks.DEEPSLATE_UVAROVITE_ORE.get()
        );
        tag(NMCommonTags.Blocks.NEEDS_UVAROVITE_TOOL).add(
                NMBlocks.KUNZITE_BLOCK.get(),
                NMBlocks.RAW_KUNZITE_BLOCK.get(),
                NMBlocks.KUNZITE_ORE.get(),
                NMBlocks.DEEPSLATE_KUNZITE_ORE.get()
        );
        tag(NMCommonTags.Blocks.NEEDS_KUNZITE_TOOL).add(
                NMBlocks.STIBNITE_BLOCK.get(),
                NMBlocks.RAW_STIBNITE_BLOCK.get(),
                NMBlocks.STIBNITE_ORE.get()
        );
        tag(NMCommonTags.Blocks.NEEDS_STIBNITE_TOOL).add(
                NMBlocks.ASTRITE_BLOCK.get(),
                NMBlocks.RAW_ASTRITE_BLOCK.get(),
                NMBlocks.ASTRITE_ORE.get()
        );
        tag(NMCommonTags.Blocks.NEEDS_ASTRITE_TOOL).add(
                NMBlocks.THOUNITE_BLOCK.get()
        );
        tag(NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL);
    }
}
