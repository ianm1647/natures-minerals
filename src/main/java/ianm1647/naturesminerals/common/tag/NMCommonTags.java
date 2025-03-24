package ianm1647.naturesminerals.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class NMCommonTags {

    public class Items {

        //ores
        public static final TagKey<Item> ORES_UVAROVITE = itemTag("ores/uvarovite");
        public static final TagKey<Item> ORES_KUNZITE = itemTag("ores/kunzite");
        public static final TagKey<Item> ORES_STIBNITE = itemTag("ores/stibnite");
        public static final TagKey<Item> ORES_ASTRITE = itemTag("ores/astrite");

        //storage blocks
        public static final TagKey<Item> BLOCKS_UVAROVITE = itemTag("storage_blocks/uvarovite");
        public static final TagKey<Item> BLOCKS_RAW_UVAROVITE = itemTag("storage_blocks/raw_uvarovite");
        public static final TagKey<Item> BLOCKS_KUNZITE = itemTag("storage_blocks/kunzite");
        public static final TagKey<Item> BLOCKS_RAW_KUNZITE = itemTag("storage_blocks/raw_kunzite");
        public static final TagKey<Item> BLOCKS_STIBNITE = itemTag("storage_blocks/stibnite");
        public static final TagKey<Item> BLOCKS_RAW_STIBNITE = itemTag("storage_blocks/raw_stibnite");
        public static final TagKey<Item> BLOCKS_ASTRITE = itemTag("storage_blocks/astrite");
        public static final TagKey<Item> BLOCKS_RAW_ASTRITE = itemTag("storage_blocks/raw_astrite");
        public static final TagKey<Item> BLOCKS_THOUNITE = itemTag("storage_blocks/thounite");

        //raw materials
        public static final TagKey<Item> RAW_UVAROVITE = itemTag("raw_materials/uvarovite");
        public static final TagKey<Item> RAW_KUNZITE = itemTag("raw_materials/kunzite");
        public static final TagKey<Item> RAW_STIBNITE = itemTag("raw_materials/stibnite");
        public static final TagKey<Item> RAW_ASTRITE = itemTag("raw_materials/astrite");

        //ingots
        public static final TagKey<Item> INGOTS_UVAROVITE = itemTag("ingots/uvarovite");
        public static final TagKey<Item> INGOTS_KUNZITE = itemTag("ingots/kunzite");
        public static final TagKey<Item> INGOTS_STIBNITE = itemTag("ingots/stibnite");
        public static final TagKey<Item> INGOTS_ASTRITE = itemTag("ingots/astrite");
        public static final TagKey<Item> INGOTS_THOUNITE = itemTag("ingots/thounite");

    }

    public class Blocks {

        //tools
        public static final TagKey<Block> NEEDS_UVAROVITE_TOOL = blockTag("needs_uvarovite_tool");
        public static final TagKey<Block> INCORRECT_FOR_UVAROVITE_TOOL = blockTag("incorrect_for_uvarovite_tool");
        public static final TagKey<Block> NEEDS_KUNZITE_TOOL = blockTag("needs_kunzite_tool");
        public static final TagKey<Block> INCORRECT_FOR_KUNZITE_TOOL = blockTag("incorrect_for_kunzite_tool");
        public static final TagKey<Block> NEEDS_STIBNITE_TOOL = blockTag("needs_stibnite_tool");
        public static final TagKey<Block> INCORRECT_FOR_STIBNITE_TOOL = blockTag("incorrect_for_stibnite_tool");
        public static final TagKey<Block> NEEDS_ASTRITE_TOOL = blockTag("needs_astrite_tool");
        public static final TagKey<Block> INCORRECT_FOR_ASTRITE_TOOL = blockTag("incorrect_for_astrite_tool");
        public static final TagKey<Block> NEEDS_THOUNITE_TOOL = blockTag("needs_thounite_tool");
        public static final TagKey<Block> INCORRECT_FOR_THOUNITE_TOOL = blockTag("incorrect_for_thounite_tool");

        //ores
        public static final TagKey<Block> ORES_UVAROVITE = blockTag("ores/uvarovite");
        public static final TagKey<Block> ORES_KUNZITE = blockTag("ores/kunzite");
        public static final TagKey<Block> ORES_STIBNITE = blockTag("ores/stibnite");
        public static final TagKey<Block> ORES_ASTRITE = blockTag("ores/astrite");

        //storage blocks
        public static final TagKey<Block> BLOCKS_UVAROVITE = blockTag("storage_blocks/uvarovite");
        public static final TagKey<Block> BLOCKS_RAW_UVAROVITE = blockTag("storage_blocks/raw_uvarovite");
        public static final TagKey<Block> BLOCKS_KUNZITE = blockTag("storage_blocks/kunzite");
        public static final TagKey<Block> BLOCKS_RAW_KUNZITE = blockTag("storage_blocks/raw_kunzite");
        public static final TagKey<Block> BLOCKS_STIBNITE = blockTag("storage_blocks/stibnite");
        public static final TagKey<Block> BLOCKS_RAW_STIBNITE = blockTag("storage_blocks/raw_stibnite");
        public static final TagKey<Block> BLOCKS_ASTRITE = blockTag("storage_blocks/astrite");
        public static final TagKey<Block> BLOCKS_RAW_ASTRITE = blockTag("storage_blocks/raw_astrite");
        public static final TagKey<Block> BLOCKS_THOUNITE = blockTag("storage_blocks/thounite");
    }

    private static TagKey<Block> blockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }

    private static TagKey<Item> itemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }
}
