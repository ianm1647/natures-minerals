package ianm1647.naturesminerals.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

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

        //nuggets
        public static final TagKey<Item> NUGGETS_UVAROVITE = itemTag("nuggets/uvarovite");
        public static final TagKey<Item> NUGGETS_KUNZITE = itemTag("nuggets/kunzite");
        public static final TagKey<Item> NUGGETS_STIBNITE = itemTag("nuggets/stibnite");
        public static final TagKey<Item> NUGGETS_ASTRITE = itemTag("nuggets/astrite");
        public static final TagKey<Item> NUGGETS_THOUNITE = itemTag("nuggets/thounite");

        //gears
        public static final TagKey<Item> GEARS_UVAROVITE = itemTag("gears/uvarovite");
        public static final TagKey<Item> GEARS_KUNZITE = itemTag("gears/kunzite");
        public static final TagKey<Item> GEARS_STIBNITE = itemTag("gears/stibnite");
        public static final TagKey<Item> GEARS_ASTRITE = itemTag("gears/astrite");
        public static final TagKey<Item> GEARS_THOUNITE = itemTag("gears/thounite");

        //plates
        public static final TagKey<Item> PLATES_UVAROVITE = itemTag("plates/uvarovite");
        public static final TagKey<Item> PLATES_KUNZITE = itemTag("plates/kunzite");
        public static final TagKey<Item> PLATES_STIBNITE = itemTag("plates/stibnite");
        public static final TagKey<Item> PLATES_ASTRITE = itemTag("plates/astrite");
        public static final TagKey<Item> PLATES_THOUNITE = itemTag("plates/thounite");

        //rods
        public static final TagKey<Item> RODS_UVAROVITE = itemTag("rods/uvarovite");
        public static final TagKey<Item> RODS_KUNZITE = itemTag("rods/kunzite");
        public static final TagKey<Item> RODS_STIBNITE = itemTag("rods/stibnite");
        public static final TagKey<Item> RODS_ASTRITE = itemTag("rods/astrite");
        public static final TagKey<Item> RODS_THOUNITE = itemTag("rods/thounite");

        //dusts
        public static final TagKey<Item> DUSTS_UVAROVITE = itemTag("dusts/uvarovite");
        public static final TagKey<Item> DUSTS_KUNZITE = itemTag("dusts/kunzite");
        public static final TagKey<Item> DUSTS_STIBNITE = itemTag("dusts/stibnite");
        public static final TagKey<Item> DUSTS_ASTRITE = itemTag("dusts/astrite");
        public static final TagKey<Item> DUSTS_THOUNITE = itemTag("dusts/thounite");

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

    public class Fluids {

        public static final TagKey<Fluid> BLOOD_LAVA = fluidTag("blood_lava");
        public static final TagKey<Fluid> SCORCHING_BLOOD = fluidTag("scorching_blood");

        public static final TagKey<Fluid> MOLTEN_UVAROVITE = fluidTag("molten_uvarovite");
        public static final TagKey<Fluid> MOLTEN_KUNZITE = fluidTag("molten_kunzite");
        public static final TagKey<Fluid> MOLTEN_STIBNITE = fluidTag("molten_stibnite");
        public static final TagKey<Fluid> MOLTEN_ASTRITE = fluidTag("molten_astrite");
        public static final TagKey<Fluid> MOLTEN_THOUNITE = fluidTag("molten_thounite");

    }

    private static TagKey<Block> blockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }

    private static TagKey<Item> itemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }

    private static TagKey<Fluid> fluidTag(String path) {
        return FluidTags.create(ResourceLocation.fromNamespaceAndPath("c", path));

    }
}
