package ianm1647.naturesminerals.data;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.registry.NMItems;
import ianm1647.naturesminerals.common.tag.NMCommonTags;
import ianm1647.naturesminerals.common.tag.NMCompatTags;
import ianm1647.naturesminerals.integration.farmersdelight.FarmersDelightIntegration;
import ianm1647.naturesminerals.integration.farmersdelight.ModKnifeItem;
import ianm1647.naturesminerals.integration.mekanism.MekanismIntegration;
import ianm1647.naturesminerals.integration.mekanism.ModPaxelItem;
import mekanism.common.tags.MekanismTags;
import mekanism.tools.common.ToolsTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class NMItemTagProvider extends ItemTagsProvider {
    public NMItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, NaturesMinerals.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        itemTags();
        itemBlockTags();
        toolTags();
        armorTags();
        mekTags();
        fdTags();
    }

    private void itemTags() {
        tag(Tags.Items.RAW_MATERIALS).addTags(
                NMCommonTags.Items.RAW_UVAROVITE,
                NMCommonTags.Items.RAW_KUNZITE,
                NMCommonTags.Items.RAW_STIBNITE,
                NMCommonTags.Items.RAW_ASTRITE
        );
        tag(NMCommonTags.Items.RAW_UVAROVITE).add(NMItems.RAW_UVAROVITE.get());
        tag(NMCommonTags.Items.RAW_KUNZITE).add(NMItems.RAW_KUNZITE.get());
        tag(NMCommonTags.Items.RAW_STIBNITE).add(NMItems.RAW_STIBNITE.get());
        tag(NMCommonTags.Items.RAW_ASTRITE).add(NMItems.RAW_ASTRITE.get());

        tag(Tags.Items.INGOTS).addTags(
                NMCommonTags.Items.INGOTS_UVAROVITE,
                NMCommonTags.Items.INGOTS_KUNZITE,
                NMCommonTags.Items.INGOTS_STIBNITE,
                NMCommonTags.Items.INGOTS_ASTRITE,
                NMCommonTags.Items.INGOTS_THOUNITE
        );
        tag(NMCommonTags.Items.INGOTS_UVAROVITE).add(NMItems.UVAROVITE_INGOT.get());
        tag(NMCommonTags.Items.INGOTS_KUNZITE).add(NMItems.KUNZITE_INGOT.get());
        tag(NMCommonTags.Items.INGOTS_STIBNITE).add(NMItems.STIBNITE_INGOT.get());
        tag(NMCommonTags.Items.INGOTS_ASTRITE).add(NMItems.ASTRITE_INGOT.get());
        tag(NMCommonTags.Items.INGOTS_THOUNITE).add(NMItems.THOUNITE_INGOT.get());

        tag(Tags.Items.NUGGETS).addTags(
                NMCommonTags.Items.NUGGETS_UVAROVITE,
                NMCommonTags.Items.NUGGETS_KUNZITE,
                NMCommonTags.Items.NUGGETS_STIBNITE,
                NMCommonTags.Items.NUGGETS_ASTRITE,
                NMCommonTags.Items.NUGGETS_THOUNITE
        );
        tag(NMCommonTags.Items.NUGGETS_UVAROVITE).add(NMItems.UVAROVITE_NUGGET.get());
        tag(NMCommonTags.Items.NUGGETS_KUNZITE).add(NMItems.KUNZITE_NUGGET.get());
        tag(NMCommonTags.Items.NUGGETS_STIBNITE).add(NMItems.STIBNITE_NUGGET.get());
        tag(NMCommonTags.Items.NUGGETS_ASTRITE).add(NMItems.ASTRITE_NUGGET.get());
        tag(NMCommonTags.Items.NUGGETS_THOUNITE).add(NMItems.THOUNITE_NUGGET.get());

        tag(Tags.Items.DUSTS).addTags(
                NMCommonTags.Items.DUSTS_UVAROVITE,
                NMCommonTags.Items.DUSTS_KUNZITE,
                NMCommonTags.Items.DUSTS_STIBNITE,
                NMCommonTags.Items.DUSTS_ASTRITE,
                NMCommonTags.Items.DUSTS_THOUNITE
        );
        tag(NMCommonTags.Items.DUSTS_UVAROVITE).add(NMItems.UVAROVITE_DUST.get());
        tag(NMCommonTags.Items.DUSTS_KUNZITE).add(NMItems.KUNZITE_DUST.get());
        tag(NMCommonTags.Items.DUSTS_STIBNITE).add(NMItems.STIBNITE_DUST.get());
        tag(NMCommonTags.Items.DUSTS_ASTRITE).add(NMItems.ASTRITE_DUST.get());
        tag(NMCommonTags.Items.DUSTS_THOUNITE).add(NMItems.THOUNITE_DUST.get());
    }

    private void itemBlockTags() {
        tag(Tags.Items.ORES).addTags(
                NMCommonTags.Items.ORES_UVAROVITE,
                NMCommonTags.Items.ORES_KUNZITE,
                NMCommonTags.Items.ORES_STIBNITE,
                NMCommonTags.Items.ORES_ASTRITE
        );
        tag(NMCommonTags.Items.ORES_UVAROVITE).add(NMItems.UVAROVITE_ORE.get(), NMItems.DEEPSLATE_UVAROVITE_ORE.get());
        tag(NMCommonTags.Items.ORES_KUNZITE).add(NMItems.KUNZITE_ORE.get(), NMItems.DEEPSLATE_KUNZITE_ORE.get());
        tag(NMCommonTags.Items.ORES_STIBNITE).add(NMItems.STIBNITE_ORE.get());
        tag(NMCommonTags.Items.ORES_ASTRITE).add(NMItems.ASTRITE_ORE.get());

        tag(Tags.Items.STORAGE_BLOCKS).addTags(
                NMCommonTags.Items.BLOCKS_UVAROVITE,
                NMCommonTags.Items.BLOCKS_KUNZITE,
                NMCommonTags.Items.BLOCKS_STIBNITE,
                NMCommonTags.Items.BLOCKS_ASTRITE,
                NMCommonTags.Items.BLOCKS_THOUNITE,
                NMCommonTags.Items.BLOCKS_RAW_UVAROVITE,
                NMCommonTags.Items.BLOCKS_RAW_KUNZITE,
                NMCommonTags.Items.BLOCKS_RAW_STIBNITE,
                NMCommonTags.Items.BLOCKS_RAW_ASTRITE
        );
        tag(NMCommonTags.Items.BLOCKS_UVAROVITE).add(NMItems.UVAROVITE_BLOCK.get());
        tag(NMCommonTags.Items.BLOCKS_KUNZITE).add(NMItems.KUNZITE_BLOCK.get());
        tag(NMCommonTags.Items.BLOCKS_STIBNITE).add(NMItems.STIBNITE_BLOCK.get());
        tag(NMCommonTags.Items.BLOCKS_ASTRITE).add(NMItems.ASTRITE_BLOCK.get());
        tag(NMCommonTags.Items.BLOCKS_THOUNITE).add(NMItems.THOUNITE_BLOCK.get());
        tag(NMCommonTags.Items.BLOCKS_RAW_UVAROVITE).add(NMItems.RAW_UVAROVITE_BLOCK.get());
        tag(NMCommonTags.Items.BLOCKS_RAW_KUNZITE).add(NMItems.RAW_KUNZITE_BLOCK.get());
        tag(NMCommonTags.Items.BLOCKS_RAW_STIBNITE).add(NMItems.RAW_STIBNITE_BLOCK.get());
        tag(NMCommonTags.Items.BLOCKS_RAW_ASTRITE).add(NMItems.RAW_ASTRITE_BLOCK.get());

    }

    private void toolTags() {
        NMItems.ITEMS.getEntries()
                .forEach((item) -> {
                    if (item.get() instanceof SwordItem) {
                        tag(ItemTags.SWORDS).add(item.get());
                    }
                    if (item.get() instanceof PickaxeItem) {
                        tag(ItemTags.PICKAXES).add(item.get());
                    }
                    if (item.get() instanceof AxeItem) {
                        tag(ItemTags.AXES).add(item.get());
                    }
                    if (item.get() instanceof ShovelItem) {
                        tag(ItemTags.SHOVELS).add(item.get());
                    }
                    if (item.get() instanceof HoeItem) {
                        tag(ItemTags.HOES).add(item.get());
                    }
                }
        );
    }

    private void armorTags() {
        NMItems.ITEMS.getEntries()
                .forEach((item) -> {
                    String name = item.getId().getPath();
                    if (name.contains("helmet")) {
                        tag(ItemTags.HEAD_ARMOR).add(item.get());
                    }
                    if (name.contains("chestplate")) {
                        tag(ItemTags.CHEST_ARMOR).add(item.get());
                    }
                    if (name.contains("leggings")) {
                        tag(ItemTags.LEG_ARMOR).add(item.get());
                    }
                    if (name.contains("boots")) {
                        tag(ItemTags.FOOT_ARMOR).add(item.get());
                    }
                });
    }

    private void mekTags() {
        MekanismIntegration.Items.MEKITEM.getEntries()
                .forEach((item) -> {
                    if (item.get() instanceof ModPaxelItem) {
                        tag(ToolsTags.Items.TOOLS_PAXEL).add(item.get());
                    }
                });

        tag(NMCompatTags.Items.CLUMPS).addOptionalTags(
                NMCommonTags.Items.UVAROVITE_CLUMP,
                NMCommonTags.Items.KUNZITE_CLUMP,
                NMCommonTags.Items.STIBNITE_CLUMP,
                NMCommonTags.Items.ASTRITE_CLUMP
        );
        tag(NMCommonTags.Items.CLUMPS).addOptionalTags(
                NMCommonTags.Items.UVAROVITE_CLUMP,
                NMCommonTags.Items.KUNZITE_CLUMP,
                NMCommonTags.Items.STIBNITE_CLUMP,
                NMCommonTags.Items.ASTRITE_CLUMP
        );
        tag(NMCommonTags.Items.UVAROVITE_CLUMP).addOptional(loc(MekanismIntegration.Items.UVAROVITE_CLUMP.get()));
        tag(NMCommonTags.Items.KUNZITE_CLUMP).addOptional(loc(MekanismIntegration.Items.KUNZITE_CLUMP.get()));
        tag(NMCommonTags.Items.STIBNITE_CLUMP).addOptional(loc(MekanismIntegration.Items.STIBNITE_CLUMP.get()));
        tag(NMCommonTags.Items.ASTRITE_CLUMP).addOptional(loc(MekanismIntegration.Items.ASTRITE_CLUMP.get()));

        tag(NMCompatTags.Items.CRYSTALS).addOptionalTags(
                NMCommonTags.Items.UVAROVITE_CRYSTAL,
                NMCommonTags.Items.KUNZITE_CRYSTAL,
                NMCommonTags.Items.STIBNITE_CRYSTAL,
                NMCommonTags.Items.ASTRITE_CRYSTAL
        );
        tag(NMCommonTags.Items.CRYSTALS).addOptionalTags(
                NMCommonTags.Items.UVAROVITE_CRYSTAL,
                NMCommonTags.Items.KUNZITE_CRYSTAL,
                NMCommonTags.Items.STIBNITE_CRYSTAL,
                NMCommonTags.Items.ASTRITE_CRYSTAL
        );
        tag(NMCommonTags.Items.UVAROVITE_CRYSTAL).addOptional(loc(MekanismIntegration.Items.UVAROVITE_CRYSTAL.get()));
        tag(NMCommonTags.Items.KUNZITE_CRYSTAL).addOptional(loc(MekanismIntegration.Items.KUNZITE_CRYSTAL.get()));
        tag(NMCommonTags.Items.STIBNITE_CRYSTAL).addOptional(loc(MekanismIntegration.Items.STIBNITE_CRYSTAL.get()));
        tag(NMCommonTags.Items.ASTRITE_CRYSTAL).addOptional(loc(MekanismIntegration.Items.ASTRITE_CRYSTAL.get()));

        tag(NMCompatTags.Items.DIRTY_DUSTS).addOptionalTags(
                NMCommonTags.Items.UVAROVITE_DIRTY_DUST,
                NMCommonTags.Items.KUNZITE_DIRTY_DUST,
                NMCommonTags.Items.STIBNITE_DIRTY_DUST,
                NMCommonTags.Items.ASTRITE_DIRTY_DUST
        );
        tag(NMCommonTags.Items.DIRTY_DUSTS).addOptionalTags(
                NMCommonTags.Items.UVAROVITE_DIRTY_DUST,
                NMCommonTags.Items.KUNZITE_DIRTY_DUST,
                NMCommonTags.Items.STIBNITE_DIRTY_DUST,
                NMCommonTags.Items.ASTRITE_DIRTY_DUST
        );
        tag(NMCommonTags.Items.UVAROVITE_DIRTY_DUST).addOptional(loc(MekanismIntegration.Items.UVAROVITE_DIRTY_DUST.get()));
        tag(NMCommonTags.Items.KUNZITE_DIRTY_DUST).addOptional(loc(MekanismIntegration.Items.KUNZITE_DIRTY_DUST.get()));
        tag(NMCommonTags.Items.STIBNITE_DIRTY_DUST).addOptional(loc(MekanismIntegration.Items.STIBNITE_DIRTY_DUST.get()));
        tag(NMCommonTags.Items.ASTRITE_DIRTY_DUST).addOptional(loc(MekanismIntegration.Items.ASTRITE_DIRTY_DUST.get()));

        tag(NMCompatTags.Items.SHARDS).addOptionalTags(
                NMCommonTags.Items.UVAROVITE_SHARD,
                NMCommonTags.Items.KUNZITE_SHARD,
                NMCommonTags.Items.STIBNITE_SHARD,
                NMCommonTags.Items.ASTRITE_SHARD
        );
        tag(NMCommonTags.Items.SHARDS).addOptionalTags(
                NMCommonTags.Items.UVAROVITE_SHARD,
                NMCommonTags.Items.KUNZITE_SHARD,
                NMCommonTags.Items.STIBNITE_SHARD,
                NMCommonTags.Items.ASTRITE_SHARD
        );
        tag(NMCommonTags.Items.UVAROVITE_SHARD).addOptional(loc(MekanismIntegration.Items.UVAROVITE_SHARD.get()));
        tag(NMCommonTags.Items.KUNZITE_SHARD).addOptional(loc(MekanismIntegration.Items.KUNZITE_SHARD.get()));
        tag(NMCommonTags.Items.STIBNITE_SHARD).addOptional(loc(MekanismIntegration.Items.STIBNITE_SHARD.get()));
        tag(NMCommonTags.Items.ASTRITE_SHARD).addOptional(loc(MekanismIntegration.Items.ASTRITE_SHARD.get()));

    }

    private void fdTags() {
        FarmersDelightIntegration.Items.DELITEM.getEntries()
                .forEach((item) -> {
                    if (item.get() instanceof ModKnifeItem) {
                        tag(ModTags.KNIVES).add(item.get());
                    }
                });
    }

    private ResourceLocation loc(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
