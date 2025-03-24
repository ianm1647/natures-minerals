package ianm1647.naturesminerals.common.registry;

import com.google.common.collect.Sets;
import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.item.NMMaterials;
import ianm1647.naturesminerals.common.item.tools.*;
import ianm1647.naturesminerals.common.item.NMTiers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class NMItems {

    public static DeferredRegister<Item> ITEMS;
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS;

    public static Supplier<Item> UVAROVITE_ORE;
    public static Supplier<Item> DEEPSLATE_UVAROVITE_ORE;
    public static Supplier<Item> RAW_UVAROVITE_BLOCK;
    public static Supplier<Item> UVAROVITE_BLOCK;
    public static Supplier<Item> KUNZITE_ORE;
    public static Supplier<Item> DEEPSLATE_KUNZITE_ORE;
    public static Supplier<Item> RAW_KUNZITE_BLOCK;
    public static Supplier<Item> KUNZITE_BLOCK;
    public static Supplier<Item> STIBNITE_ORE;
    public static Supplier<Item> RAW_STIBNITE_BLOCK;
    public static Supplier<Item> STIBNITE_BLOCK;
    public static Supplier<Item> ASTRITE_ORE;
    public static Supplier<Item> RAW_ASTRITE_BLOCK;
    public static Supplier<Item> ASTRITE_BLOCK;
    public static Supplier<Item> THOUNITE_BLOCK;

    public static Supplier<Item> RAW_UVAROVITE;
    public static Supplier<Item> UVAROVITE_INGOT;
    public static Supplier<Item> UVAROVITE_NUGGET;
    public static Supplier<Item> RAW_KUNZITE;
    public static Supplier<Item> KUNZITE_INGOT;
    public static Supplier<Item> KUNZITE_NUGGET;
    public static Supplier<Item> RAW_STIBNITE;
    public static Supplier<Item> STIBNITE_INGOT;
    public static Supplier<Item> STIBNITE_NUGGET;
    public static Supplier<Item> RAW_ASTRITE;
    public static Supplier<Item> ASTRITE_INGOT;
    public static Supplier<Item> ASTRITE_NUGGET;
    public static Supplier<Item> THOUNITE_INGOT;
    public static Supplier<Item> THOUNITE_NUGGET;

    public static Supplier<Item> UVAROVITE_APPLE;
    public static Supplier<Item> KUNZITE_APPLE;
    public static Supplier<Item> STIBNITE_APPLE;
    public static Supplier<Item> ASTRITE_APPLE;
    public static Supplier<Item> THOUNITE_APPLE;

    public static Supplier<Item> UVAROVITE_SWORD;
    public static Supplier<Item> UVAROVITE_SHOVEL;
    public static Supplier<Item> UVAROVITE_PICKAXE;
    public static Supplier<Item> UVAROVITE_AXE;
    public static Supplier<Item> UVAROVITE_HOE;

    public static Supplier<Item> KUNZITE_SWORD;
    public static Supplier<Item> KUNZITE_SHOVEL;
    public static Supplier<Item> KUNZITE_PICKAXE;
    public static Supplier<Item> KUNZITE_AXE;
    public static Supplier<Item> KUNZITE_HOE;

    public static Supplier<Item> STIBNITE_SWORD;
    public static Supplier<Item> STIBNITE_SHOVEL;
    public static Supplier<Item> STIBNITE_PICKAXE;
    public static Supplier<Item> STIBNITE_AXE;
    public static Supplier<Item> STIBNITE_HOE;

    public static Supplier<Item> ASTRITE_SWORD;
    public static Supplier<Item> ASTRITE_SHOVEL;
    public static Supplier<Item> ASTRITE_PICKAXE;
    public static Supplier<Item> ASTRITE_AXE;
    public static Supplier<Item> ASTRITE_HOE;

    public static Supplier<Item> THOUNITE_SWORD;
    public static Supplier<Item> THOUNITE_SHOVEL;
    public static Supplier<Item> THOUNITE_PICKAXE;
    public static Supplier<Item> THOUNITE_AXE;
    public static Supplier<Item> THOUNITE_HOE;

    public static Supplier<Item> UVAROVITE_HELMET;
    public static Supplier<Item> UVAROVITE_CHESTPLATE;
    public static Supplier<Item> UVAROVITE_LEGGINGS;
    public static Supplier<Item> UVAROVITE_BOOTS;

    public static Supplier<Item> KUNZITE_HELMET;
    public static Supplier<Item> KUNZITE_CHESTPLATE;
    public static Supplier<Item> KUNZITE_LEGGINGS;
    public static Supplier<Item> KUNZITE_BOOTS;

    public static Supplier<Item> STIBNITE_HELMET;
    public static Supplier<Item> STIBNITE_CHESTPLATE;
    public static Supplier<Item> STIBNITE_LEGGINGS;
    public static Supplier<Item> STIBNITE_BOOTS;

    public static Supplier<Item> ASTRITE_HELMET;
    public static Supplier<Item> ASTRITE_CHESTPLATE;
    public static Supplier<Item> ASTRITE_LEGGINGS;
    public static Supplier<Item> ASTRITE_BOOTS;

    public static Supplier<Item> THOUNITE_HELMET;
    public static Supplier<Item> THOUNITE_CHESTPLATE;
    public static Supplier<Item> THOUNITE_LEGGINGS;
    public static Supplier<Item> THOUNITE_BOOTS;

    public static Supplier<Item> BLOOD_LAVA_BUCKET;
    public static Supplier<Item> SCORCHING_BLOOD_BUCKET;
    public static Supplier<Item> MOLTEN_UVAROVITE_BUCKET;
    public static Supplier<Item> MOLTEN_KUNZITE_BUCKET;
    public static Supplier<Item> MOLTEN_STIBNITE_BUCKET;
    public static Supplier<Item> MOLTEN_ASTRITE_BUCKET;
    public static Supplier<Item> MOLTEN_THOUNITE_BUCKET;

    //common items
    public static Supplier<Item> UVAROVITE_DUST;
    public static Supplier<Item> KUNZITE_DUST;
    public static Supplier<Item> STIBNITE_DUST;
    public static Supplier<Item> ASTRITE_DUST;
    public static Supplier<Item> THOUNITE_DUST;

    public static Supplier<Item> UVAROVITE_GEAR;
    public static Supplier<Item> KUNZITE_GEAR;
    public static Supplier<Item> STIBNITE_GEAR;
    public static Supplier<Item> ASTRITE_GEAR;
    public static Supplier<Item> THOUNITE_GEAR;

    public static Supplier<Item> UVAROVITE_PLATE;
    public static Supplier<Item> KUNZITE_PLATE;
    public static Supplier<Item> STIBNITE_PLATE;
    public static Supplier<Item> ASTRITE_PLATE;
    public static Supplier<Item> THOUNITE_PLATE;

    public static Supplier<Item> UVAROVITE_ROD;
    public static Supplier<Item> KUNZITE_ROD;
    public static Supplier<Item> STIBNITE_ROD;
    public static Supplier<Item> ASTRITE_ROD;
    public static Supplier<Item> THOUNITE_ROD;

    static {
        ITEMS = DeferredRegister.create(Registries.ITEM, NaturesMinerals.MODID);
        CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

        UVAROVITE_ORE = registerWithTab("uvarovite_ore", () -> new BlockItem(NMBlocks.UVAROVITE_ORE.get(), basicItem()));
        DEEPSLATE_UVAROVITE_ORE = registerWithTab("deepslate_uvarovite_ore", () -> new BlockItem(NMBlocks.DEEPSLATE_UVAROVITE_ORE.get(), basicItem()));
        RAW_UVAROVITE_BLOCK = registerWithTab("raw_uvarovite_block", () -> new BlockItem(NMBlocks.RAW_UVAROVITE_BLOCK.get(), basicItem()));
        UVAROVITE_BLOCK = registerWithTab("uvarovite_block", () -> new BlockItem(NMBlocks.UVAROVITE_BLOCK.get(), basicItem()));
        KUNZITE_ORE = registerWithTab("kunzite_ore", () -> new BlockItem(NMBlocks.KUNZITE_ORE.get(), basicItem()));
        DEEPSLATE_KUNZITE_ORE = registerWithTab("deepslate_kunzite_ore", () -> new BlockItem(NMBlocks.DEEPSLATE_KUNZITE_ORE.get(), basicItem()));
        RAW_KUNZITE_BLOCK = registerWithTab("raw_kunzite_block", () -> new BlockItem(NMBlocks.RAW_KUNZITE_BLOCK.get(), basicItem()));
        KUNZITE_BLOCK = registerWithTab("kunzite_block", () -> new BlockItem(NMBlocks.KUNZITE_BLOCK.get(), basicItem()));
        STIBNITE_ORE = registerWithTab("stibnite_ore", () -> new BlockItem(NMBlocks.STIBNITE_ORE.get(), basicItem()));
        RAW_STIBNITE_BLOCK = registerWithTab("raw_stibnite_block", () -> new BlockItem(NMBlocks.RAW_STIBNITE_BLOCK.get(), basicItem()));
        STIBNITE_BLOCK = registerWithTab("stibnite_block", () -> new BlockItem(NMBlocks.STIBNITE_BLOCK.get(), basicItem()));
        ASTRITE_ORE = registerWithTab("astrite_ore", () -> new BlockItem(NMBlocks.ASTRITE_ORE.get(), basicItem()));
        RAW_ASTRITE_BLOCK = registerWithTab("raw_astrite_block", () -> new BlockItem(NMBlocks.RAW_ASTRITE_BLOCK.get(), basicItem()));
        ASTRITE_BLOCK = registerWithTab("astrite_block", () -> new BlockItem(NMBlocks.ASTRITE_BLOCK.get(), basicItem()));
        THOUNITE_BLOCK = registerWithTab("thounite_block", () -> new BlockItem(NMBlocks.THOUNITE_BLOCK.get(), basicItem()));

        RAW_UVAROVITE = registerWithTab("raw_uvarovite", () -> new Item(basicItem()));
        UVAROVITE_INGOT = registerWithTab("uvarovite_ingot", () -> new Item(basicItem()));
        UVAROVITE_NUGGET = registerWithTab("uvarovite_nugget", () -> new Item(basicItem()));
        RAW_KUNZITE = registerWithTab("raw_kunzite", () -> new Item(basicItem()));
        KUNZITE_INGOT = registerWithTab("kunzite_ingot", () -> new Item(basicItem()));
        KUNZITE_NUGGET = registerWithTab("kunzite_nugget", () -> new Item(basicItem()));
        RAW_STIBNITE = registerWithTab("raw_stibnite", () -> new Item(basicItem()));
        STIBNITE_INGOT = registerWithTab("stibnite_ingot", () -> new Item(basicItem()));
        STIBNITE_NUGGET = registerWithTab("stibnite_nugget", () -> new Item(basicItem()));
        RAW_ASTRITE = registerWithTab("raw_astrite", () -> new Item(basicItem()));
        ASTRITE_INGOT = registerWithTab("astrite_ingot", () -> new Item(basicItem()));
        ASTRITE_NUGGET = registerWithTab("astrite_nugget", () -> new Item(basicItem()));
        THOUNITE_INGOT = registerWithTab("thounite_ingot", () -> new Item(basicItem()));
        THOUNITE_NUGGET = registerWithTab("thounite_nugget", () -> new Item(basicItem()));

        UVAROVITE_SWORD = registerWithTab("uvarovite_sword", () -> new ModSwordItem(NMTiers.UVAROVITE, basicItem()));
        UVAROVITE_SHOVEL = registerWithTab("uvarovite_shovel", () -> new ModShovelItem(NMTiers.UVAROVITE, basicItem()));
        UVAROVITE_PICKAXE = registerWithTab("uvarovite_pickaxe", () -> new ModPickaxeItem(NMTiers.UVAROVITE, basicItem()));
        UVAROVITE_AXE = registerWithTab("uvarovite_axe", () -> new ModAxeItem(NMTiers.UVAROVITE, basicItem()));
        UVAROVITE_HOE = registerWithTab("uvarovite_hoe", () -> new ModHoeItem(NMTiers.UVAROVITE, basicItem()));

        KUNZITE_SWORD = registerWithTab("kunzite_sword", () -> new ModSwordItem(NMTiers.KUNZITE, basicItem()));
        KUNZITE_SHOVEL = registerWithTab("kunzite_shovel", () -> new ModShovelItem(NMTiers.KUNZITE, basicItem()));
        KUNZITE_PICKAXE = registerWithTab("kunzite_pickaxe", () -> new ModPickaxeItem(NMTiers.KUNZITE, basicItem()));
        KUNZITE_AXE = registerWithTab("kunzite_axe", () -> new ModAxeItem(NMTiers.KUNZITE, basicItem()));
        KUNZITE_HOE = registerWithTab("kunzite_hoe", () -> new ModHoeItem(NMTiers.KUNZITE, basicItem()));

        STIBNITE_SWORD = registerWithTab("stibnite_sword", () -> new ModSwordItem(NMTiers.STIBNITE, basicItem()));
        STIBNITE_SHOVEL = registerWithTab("stibnite_shovel", () -> new ModShovelItem(NMTiers.STIBNITE, basicItem()));
        STIBNITE_PICKAXE = registerWithTab("stibnite_pickaxe", () -> new ModPickaxeItem(NMTiers.STIBNITE, basicItem()));
        STIBNITE_AXE = registerWithTab("stibnite_axe", () -> new ModAxeItem(NMTiers.STIBNITE, basicItem()));
        STIBNITE_HOE = registerWithTab("stibnite_hoe", () -> new ModHoeItem(NMTiers.STIBNITE, basicItem()));

        ASTRITE_SWORD = registerWithTab("astrite_sword", () -> new ModSwordItem(NMTiers.ASTRITE, basicItem()));
        ASTRITE_SHOVEL = registerWithTab("astrite_shovel", () -> new ModShovelItem(NMTiers.ASTRITE, basicItem()));
        ASTRITE_PICKAXE = registerWithTab("astrite_pickaxe", () -> new ModPickaxeItem(NMTiers.ASTRITE, basicItem()));
        ASTRITE_AXE = registerWithTab("astrite_axe", () -> new ModAxeItem(NMTiers.ASTRITE, basicItem()));
        ASTRITE_HOE = registerWithTab("astrite_hoe", () -> new ModHoeItem(NMTiers.ASTRITE, basicItem()));

        THOUNITE_SWORD = registerWithTab("thounite_sword", () -> new ModSwordItem(NMTiers.THOUNITE, basicItem()));
        THOUNITE_SHOVEL = registerWithTab("thounite_shovel", () -> new ModShovelItem(NMTiers.THOUNITE, basicItem()));
        THOUNITE_PICKAXE = registerWithTab("thounite_pickaxe", () -> new ModPickaxeItem(NMTiers.THOUNITE, basicItem()));
        THOUNITE_AXE = registerWithTab("thounite_axe", () -> new ModAxeItem(NMTiers.THOUNITE, basicItem()));
        THOUNITE_HOE = registerWithTab("thounite_hoe", () -> new ModHoeItem(NMTiers.THOUNITE, basicItem()));

        UVAROVITE_HELMET = registerWithTab("uvarovite_helmet", () -> new ArmorItem(NMMaterials.UVAROVITE, ArmorItem.Type.HELMET, basicItem()));
        UVAROVITE_CHESTPLATE = registerWithTab("uvarovite_chestplate", () -> new ArmorItem(NMMaterials.UVAROVITE, ArmorItem.Type.CHESTPLATE, basicItem()));
        UVAROVITE_LEGGINGS = registerWithTab("uvarovite_leggings", () -> new ArmorItem(NMMaterials.UVAROVITE, ArmorItem.Type.LEGGINGS, basicItem()));
        UVAROVITE_BOOTS = registerWithTab("uvarovite_boots", () -> new ArmorItem(NMMaterials.UVAROVITE, ArmorItem.Type.BOOTS, basicItem()));

        KUNZITE_HELMET = registerWithTab("kunzite_helmet", () -> new ArmorItem(NMMaterials.KUNZITE, ArmorItem.Type.HELMET, basicItem()));
        KUNZITE_CHESTPLATE = registerWithTab("kunzite_chestplate", () -> new ArmorItem(NMMaterials.KUNZITE, ArmorItem.Type.CHESTPLATE, basicItem()));
        KUNZITE_LEGGINGS = registerWithTab("kunzite_leggings", () -> new ArmorItem(NMMaterials.KUNZITE, ArmorItem.Type.LEGGINGS, basicItem()));
        KUNZITE_BOOTS = registerWithTab("kunzite_boots", () -> new ArmorItem(NMMaterials.KUNZITE, ArmorItem.Type.BOOTS, basicItem()));

        STIBNITE_HELMET = registerWithTab("stibnite_helmet", () -> new ArmorItem(NMMaterials.STIBNITE, ArmorItem.Type.HELMET, basicItem()));
        STIBNITE_CHESTPLATE = registerWithTab("stibnite_chestplate", () -> new ArmorItem(NMMaterials.STIBNITE, ArmorItem.Type.CHESTPLATE, basicItem()));
        STIBNITE_LEGGINGS = registerWithTab("stibnite_leggings", () -> new ArmorItem(NMMaterials.STIBNITE, ArmorItem.Type.LEGGINGS, basicItem()));
        STIBNITE_BOOTS = registerWithTab("stibnite_boots", () -> new ArmorItem(NMMaterials.STIBNITE, ArmorItem.Type.BOOTS, basicItem()));

        ASTRITE_HELMET = registerWithTab("astrite_helmet", () -> new ArmorItem(NMMaterials.ASTRITE, ArmorItem.Type.HELMET, basicItem()));
        ASTRITE_CHESTPLATE = registerWithTab("astrite_chestplate", () -> new ArmorItem(NMMaterials.ASTRITE, ArmorItem.Type.CHESTPLATE, basicItem()));
        ASTRITE_LEGGINGS = registerWithTab("astrite_leggings", () -> new ArmorItem(NMMaterials.ASTRITE, ArmorItem.Type.LEGGINGS, basicItem()));
        ASTRITE_BOOTS = registerWithTab("astrite_boots", () -> new ArmorItem(NMMaterials.ASTRITE, ArmorItem.Type.BOOTS, basicItem()));

        THOUNITE_HELMET = registerWithTab("thounite_helmet", () -> new ArmorItem(NMMaterials.THOUNITE, ArmorItem.Type.HELMET, basicItem()));
        THOUNITE_CHESTPLATE = registerWithTab("thounite_chestplate", () -> new ArmorItem(NMMaterials.THOUNITE, ArmorItem.Type.CHESTPLATE, basicItem()));
        THOUNITE_LEGGINGS = registerWithTab("thounite_leggings", () -> new ArmorItem(NMMaterials.THOUNITE, ArmorItem.Type.LEGGINGS, basicItem()));
        THOUNITE_BOOTS = registerWithTab("thounite_boots", () -> new ArmorItem(NMMaterials.THOUNITE, ArmorItem.Type.BOOTS, basicItem()));

        BLOOD_LAVA_BUCKET = registerWithTab("blood_lava_bucket", () -> new BucketItem(NMFluids.BLOOD_LAVA.get(),
                new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        SCORCHING_BLOOD_BUCKET = registerWithTab("scorching_blood_bucket", () -> new BucketItem(NMFluids.SCORCHING_BLOOD.get(),
                new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        MOLTEN_UVAROVITE_BUCKET = registerWithTab("molten_uvarovite_bucket", () -> new BucketItem(NMFluids.MOLTEN_UVAROVITE.get(),
                new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        MOLTEN_KUNZITE_BUCKET = registerWithTab("molten_kunzite_bucket", () -> new BucketItem(NMFluids.MOLTEN_KUNZITE.get(),
                new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        MOLTEN_STIBNITE_BUCKET = registerWithTab("molten_stibnite_bucket", () -> new BucketItem(NMFluids.MOLTEN_STIBNITE.get(),
                new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        MOLTEN_ASTRITE_BUCKET = registerWithTab("molten_astrite_bucket", () -> new BucketItem(NMFluids.MOLTEN_ASTRITE.get(),
                new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        MOLTEN_THOUNITE_BUCKET = registerWithTab("molten_thounite_bucket", () -> new BucketItem(NMFluids.MOLTEN_THOUNITE.get(),
                new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    }

    private static Supplier<Item> registerWithTab(String name, Supplier<Item> supplier) {
        Supplier<Item> item = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(item);
        return item;
    }

    private static Item.Properties basicItem() {
        return (new Item.Properties());
    }
}
