package ianm1647.naturesminerals.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class NMCompatTags {

    public class Items {

        public static final String CREATE = "create";
        public static final TagKey<Item> CRUSHED_RAW_MATERIALS = externalItemTag(CREATE,"crushed_raw_materials");

        public static final String MEKANISM = "mekanism";
        public static final TagKey<Item> CLUMPS = externalItemTag(MEKANISM,"clumps");
        public static final TagKey<Item> DIRTY_DUSTS = externalItemTag(MEKANISM,"dirty_dusts");
        public static final TagKey<Item> CRYSTALS = externalItemTag(MEKANISM,"crystals");
        public static final TagKey<Item> SHARDS = externalItemTag(MEKANISM,"shards");

    }

    public class Blocks {

    }

    public class Fluids {

    }

    private static TagKey<Block> externalBlockTag(String mod, String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(mod, path));
    }

    private static TagKey<Item> externalItemTag(String mod, String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(mod, path));
    }

    private static TagKey<Fluid> externalFluidTag(String mod, String path) {
        return FluidTags.create(ResourceLocation.fromNamespaceAndPath(mod, path));

    }
}
