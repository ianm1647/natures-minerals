package com.ianm1647.naturesminerals.registry;

import com.ianm1647.naturesminerals.NaturesMinerals;
import com.ianm1647.naturesminerals.item.FoodComponents;
import com.ianm1647.naturesminerals.item.ItemList;
import com.ianm1647.naturesminerals.item.equipment.NaturesArmorMaterials;
import com.ianm1647.naturesminerals.item.equipment.NaturesToolMaterials;
import com.ianm1647.naturesminerals.item.equipment.tools.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistry {
    private static final int durabilityMultiplier = NaturesMinerals.CONFIG.durabilityMultiplier;

    public static void registerItems() {
        ItemList.SCORCHED_COAL = item("scorched_coal");

        ItemList.RAW_UVAROVITE = item("raw_uvarovite");
        ItemList.UVAROVITE_INGOT = item("uvarovite_ingot");
        ItemList.UVAROVITE_NUGGET = item("uvarovite_nugget");
        ItemList.RAW_KUNZITE = item("raw_kunzite");
        ItemList.KUNZITE_INGOT = item("kunzite_ingot");
        ItemList.KUNZITE_NUGGET = item("kunzite_nugget");
        ItemList.RAW_STIBNITE = item("raw_stibnite");
        ItemList.STIBNITE_INGOT = item("stibnite_ingot");
        ItemList.STIBNITE_NUGGET = item("stibnite_nugget");
        ItemList.RAW_ASTRITE = item("raw_astrite");
        ItemList.ASTRITE_INGOT = item("astrite_ingot");
        ItemList.ASTRITE_NUGGET = item("astrite_nugget");
        ItemList.THOUNITE_INGOT = item("thounite_ingot");
        ItemList.THOUNITE_NUGGET = item("thounite_nugget");

        ItemList.UVAROVITE_APPLE = foodItem("uvarovite_apple", FoodComponents.UVAROVITE_APPLE);
        ItemList.KUNZITE_APPLE = foodItem("kunzite_apple", FoodComponents.KUNZITE_APPLE);
        ItemList.STIBNITE_APPLE = foodItem("stibnite_apple", FoodComponents.STIBNITE_APPLE);
        ItemList.ASTRITE_APPLE = foodItem("astrite_apple", FoodComponents.ASTRITE_APPLE);
        ItemList.THOUNITE_APPLE = foodItem("thounite_apple", FoodComponents.THOUNITE_APPLE);

        if (!FabricLoader.getInstance().isModLoaded("tconstruct")) {
            ItemList.UVAROVITE_SWORD = swordItem("uvarovite", NaturesToolMaterials.UVAROVITE);
            ItemList.KUNZITE_SWORD = swordItem("kunzite", NaturesToolMaterials.KUNZITE);
            ItemList.STIBNITE_SWORD = swordItem("stibnite", NaturesToolMaterials.STIBNITE);
            ItemList.ASTRITE_SWORD = swordItem("astrite", NaturesToolMaterials.ASTRITE);
            ItemList.THOUNITE_SWORD = swordItem("thounite", NaturesToolMaterials.THOUNITE);

            ItemList.UVAROVITE_SHOVEL = shovelItem("uvarovite", NaturesToolMaterials.UVAROVITE);
            ItemList.KUNZITE_SHOVEL = shovelItem("kunzite", NaturesToolMaterials.KUNZITE);
            ItemList.STIBNITE_SHOVEL = shovelItem("stibnite", NaturesToolMaterials.STIBNITE);
            ItemList.ASTRITE_SHOVEL = shovelItem("astrite", NaturesToolMaterials.ASTRITE);
            ItemList.THOUNITE_SHOVEL = shovelItem("thounite", NaturesToolMaterials.THOUNITE);

            ItemList.UVAROVITE_PICKAXE = pickaxeItem("uvarovite", NaturesToolMaterials.UVAROVITE);
            ItemList.KUNZITE_PICKAXE = pickaxeItem("kunzite", NaturesToolMaterials.KUNZITE);
            ItemList.STIBNITE_PICKAXE = pickaxeItem("stibnite", NaturesToolMaterials.STIBNITE);
            ItemList.ASTRITE_PICKAXE = pickaxeItem("astrite", NaturesToolMaterials.ASTRITE);
            ItemList.THOUNITE_PICKAXE = pickaxeItem("thounite", NaturesToolMaterials.THOUNITE);

            ItemList.UVAROVITE_AXE = axeItem("uvarovite", NaturesToolMaterials.UVAROVITE);
            ItemList.KUNZITE_AXE = axeItem("kunzite", NaturesToolMaterials.KUNZITE);
            ItemList.STIBNITE_AXE = axeItem("stibnite", NaturesToolMaterials.STIBNITE);
            ItemList.ASTRITE_AXE = axeItem("astrite", NaturesToolMaterials.ASTRITE);
            ItemList.THOUNITE_AXE = axeItem("thounite", NaturesToolMaterials.THOUNITE);

            ItemList.UVAROVITE_HOE = hoeItem("uvarovite", NaturesToolMaterials.UVAROVITE);
            ItemList.KUNZITE_HOE = hoeItem("kunzite", NaturesToolMaterials.KUNZITE);
            ItemList.STIBNITE_HOE = hoeItem("stibnite", NaturesToolMaterials.STIBNITE);
            ItemList.ASTRITE_HOE = hoeItem("astrite", NaturesToolMaterials.ASTRITE);
            ItemList.THOUNITE_HOE = hoeItem("thounite", NaturesToolMaterials.THOUNITE);

            if (FabricLoader.getInstance().isModLoaded("farmersdelight")) {
                ItemList.UVAROVITE_KNIFE = knifeItem("uvarovite", NaturesToolMaterials.UVAROVITE);
                ItemList.KUNZITE_KNIFE = knifeItem("kunzite", NaturesToolMaterials.KUNZITE);
                ItemList.STIBNITE_KNIFE = knifeItem("stibnite", NaturesToolMaterials.STIBNITE);
                ItemList.ASTRITE_KNIFE = knifeItem("astrite", NaturesToolMaterials.ASTRITE);
                ItemList.THOUNITE_KNIFE = knifeItem("thounite", NaturesToolMaterials.THOUNITE);
            }

            if (!FabricLoader.getInstance().isModLoaded("vanilla-hammers")) {
                ItemList.WOODEN_HAMMER = vanillaHammerItem("wooden", ToolMaterials.WOOD,
                        new FabricItemSettings().maxDamage(ToolMaterials.WOOD.getDurability() * durabilityMultiplier));
                ItemList.STONE_HAMMER = vanillaHammerItem("stone", ToolMaterials.STONE,
                        new FabricItemSettings().maxDamage(ToolMaterials.STONE.getDurability() * durabilityMultiplier));
                ItemList.IRON_HAMMER = vanillaHammerItem("iron", ToolMaterials.IRON,
                        new FabricItemSettings().maxDamage(ToolMaterials.IRON.getDurability() * durabilityMultiplier));
                ItemList.GOLDEN_HAMMER = vanillaHammerItem("golden", ToolMaterials.GOLD,
                        new FabricItemSettings().maxDamage(ToolMaterials.GOLD.getDurability() * durabilityMultiplier));
                ItemList.DIAMOND_HAMMER = vanillaHammerItem("diamond", ToolMaterials.DIAMOND,
                        new FabricItemSettings().maxDamage(ToolMaterials.DIAMOND.getDurability() * durabilityMultiplier));
                ItemList.NETHERITE_HAMMER = vanillaHammerItem("netherite", ToolMaterials.NETHERITE,
                        new FabricItemSettings().maxDamage(ToolMaterials.NETHERITE.getDurability() * durabilityMultiplier));
            }

            if (!FabricLoader.getInstance().isModLoaded("vanillaexcavators")) {
                ItemList.WOODEN_EXCAVATOR = vanillaExcavatorItem("wooden", ToolMaterials.WOOD,
                        new FabricItemSettings().maxDamage(ToolMaterials.WOOD.getDurability() * durabilityMultiplier));
                ItemList.STONE_EXCAVATOR = vanillaExcavatorItem("stone", ToolMaterials.STONE,
                        new FabricItemSettings().maxDamage(ToolMaterials.STONE.getDurability() * durabilityMultiplier));
                ItemList.IRON_EXCAVATOR = vanillaExcavatorItem("iron", ToolMaterials.IRON,
                        new FabricItemSettings().maxDamage(ToolMaterials.IRON.getDurability() * durabilityMultiplier));
                ItemList.GOLDEN_EXCAVATOR = vanillaExcavatorItem("golden", ToolMaterials.GOLD,
                        new FabricItemSettings().maxDamage(ToolMaterials.GOLD.getDurability() * durabilityMultiplier));
                ItemList.DIAMOND_EXCAVATOR = vanillaExcavatorItem("diamond", ToolMaterials.DIAMOND,
                        new FabricItemSettings().maxDamage(ToolMaterials.DIAMOND.getDurability() * durabilityMultiplier));
                ItemList.NETHERITE_EXCAVATOR = vanillaExcavatorItem("netherite", ToolMaterials.NETHERITE,
                        new FabricItemSettings().maxDamage(ToolMaterials.NETHERITE.getDurability() * durabilityMultiplier));
            }

            ItemList.UVAROVITE_HAMMER = hammerItem("uvarovite", NaturesToolMaterials.UVAROVITE,
                    new FabricItemSettings().maxDamage(NaturesToolMaterials.UVAROVITE.getDurability() * durabilityMultiplier));
            ItemList.KUNZITE_HAMMER = hammerItem("kunzite", NaturesToolMaterials.KUNZITE,
                    new FabricItemSettings().maxDamage(NaturesToolMaterials.KUNZITE.getDurability() * durabilityMultiplier));
            ItemList.STIBNITE_HAMMER = hammerItem("stibnite", NaturesToolMaterials.STIBNITE,
                    new FabricItemSettings().maxDamage(NaturesToolMaterials.STIBNITE.getDurability() * durabilityMultiplier));
            ItemList.ASTRITE_HAMMER = hammerItem("astrite", NaturesToolMaterials.ASTRITE,
                    new FabricItemSettings().maxDamage(NaturesToolMaterials.ASTRITE.getDurability() * durabilityMultiplier));
            ItemList.THOUNITE_HAMMER = hammerItem("thounite", NaturesToolMaterials.THOUNITE,
                    new FabricItemSettings().maxDamage(NaturesToolMaterials.THOUNITE.getDurability() * durabilityMultiplier));

            ItemList.UVAROVITE_EXCAVATOR = excavatorItem("uvarovite", NaturesToolMaterials.UVAROVITE,
                    new FabricItemSettings().maxDamage(NaturesToolMaterials.UVAROVITE.getDurability() * durabilityMultiplier));
            ItemList.KUNZITE_EXCAVATOR = excavatorItem("kunzite", NaturesToolMaterials.KUNZITE,
                    new FabricItemSettings().maxDamage(NaturesToolMaterials.KUNZITE.getDurability() * durabilityMultiplier));
            ItemList.STIBNITE_EXCAVATOR = excavatorItem("stibnite", NaturesToolMaterials.STIBNITE,
                    new FabricItemSettings().maxDamage(NaturesToolMaterials.STIBNITE.getDurability() * durabilityMultiplier));
            ItemList.ASTRITE_EXCAVATOR = excavatorItem("astrite", NaturesToolMaterials.ASTRITE,
                    new FabricItemSettings().maxDamage(NaturesToolMaterials.ASTRITE.getDurability() * durabilityMultiplier));
            ItemList.THOUNITE_EXCAVATOR = excavatorItem("thounite", NaturesToolMaterials.THOUNITE,
                    new FabricItemSettings().maxDamage(NaturesToolMaterials.THOUNITE.getDurability() * durabilityMultiplier));

            if (FabricLoader.getInstance().isModLoaded("adapaxels")) {
                ItemList.UVAROVITE_PAXEL = paxelItem("uvarovite", NaturesToolMaterials.UVAROVITE);
                ItemList.KUNZITE_PAXEL = paxelItem("kunzite", NaturesToolMaterials.KUNZITE);
                ItemList.STIBNITE_PAXEL = paxelItem("stibnite", NaturesToolMaterials.STIBNITE);
                ItemList.ASTRITE_PAXEL = paxelItem("astrite", NaturesToolMaterials.ASTRITE);
                ItemList.THOUNITE_PAXEL = paxelItem("thounite", NaturesToolMaterials.THOUNITE);
            }

            ItemList.UVAROVITE_HEAD = armorItem("uvarovite_head", NaturesArmorMaterials.UVAROVITE, ArmorItem.Type.HELMET);
            ItemList.KUNZITE_HEAD = armorItem("kunzite_head", NaturesArmorMaterials.KUNZITE, ArmorItem.Type.HELMET);
            ItemList.STIBNITE_HEAD = armorItem("stibnite_head", NaturesArmorMaterials.STIBNITE, ArmorItem.Type.HELMET);
            ItemList.ASTRITE_HEAD = armorItem("astrite_head", NaturesArmorMaterials.ASTRITE, ArmorItem.Type.HELMET);
            ItemList.THOUNITE_HEAD = armorItem("thounite_head", NaturesArmorMaterials.THOUNITE, ArmorItem.Type.HELMET);

            ItemList.UVAROVITE_CHEST = armorItem("uvarovite_chest", NaturesArmorMaterials.UVAROVITE, ArmorItem.Type.CHESTPLATE);
            ItemList.KUNZITE_CHEST = armorItem("kunzite_chest", NaturesArmorMaterials.KUNZITE, ArmorItem.Type.CHESTPLATE);
            ItemList.STIBNITE_CHEST = armorItem("stibnite_chest", NaturesArmorMaterials.STIBNITE, ArmorItem.Type.CHESTPLATE);
            ItemList.ASTRITE_CHEST = armorItem("astrite_chest", NaturesArmorMaterials.ASTRITE, ArmorItem.Type.CHESTPLATE);
            ItemList.THOUNITE_CHEST = armorItem("thounite_chest", NaturesArmorMaterials.THOUNITE, ArmorItem.Type.CHESTPLATE);

            ItemList.UVAROVITE_LEGS = armorItem("uvarovite_legs", NaturesArmorMaterials.UVAROVITE, ArmorItem.Type.LEGGINGS);
            ItemList.KUNZITE_LEGS = armorItem("kunzite_legs", NaturesArmorMaterials.KUNZITE, ArmorItem.Type.LEGGINGS);
            ItemList.STIBNITE_LEGS = armorItem("stibnite_legs", NaturesArmorMaterials.STIBNITE, ArmorItem.Type.LEGGINGS);
            ItemList.ASTRITE_LEGS = armorItem("astrite_legs", NaturesArmorMaterials.ASTRITE, ArmorItem.Type.LEGGINGS);
            ItemList.THOUNITE_LEGS = armorItem("thounite_legs", NaturesArmorMaterials.THOUNITE, ArmorItem.Type.LEGGINGS);

            ItemList.UVAROVITE_FEET = armorItem("uvarovite_feet", NaturesArmorMaterials.UVAROVITE, ArmorItem.Type.BOOTS);
            ItemList.KUNZITE_FEET = armorItem("kunzite_feet", NaturesArmorMaterials.KUNZITE, ArmorItem.Type.BOOTS);
            ItemList.STIBNITE_FEET = armorItem("stibnite_feet", NaturesArmorMaterials.STIBNITE, ArmorItem.Type.BOOTS);
            ItemList.ASTRITE_FEET = armorItem("astrite_feet", NaturesArmorMaterials.ASTRITE, ArmorItem.Type.BOOTS);
            ItemList.THOUNITE_FEET = armorItem("thounite_feet", NaturesArmorMaterials.THOUNITE, ArmorItem.Type.BOOTS);
        }
    }

    private static Item item(String name) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name),
                new Item(new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item foodItem(String name, FoodComponent foodComponent) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name),
                new Item(new FabricItemSettings().food(foodComponent)));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item swordItem(String name, ToolMaterial material) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name + "_sword"),
                new ModSwordItem(material, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item shovelItem(String name, ToolMaterial material) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name + "_shovel"),
                new ModShovelItem(material, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item pickaxeItem(String name, ToolMaterial material) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name + "_pickaxe"),
                new ModPickaxeItem(material, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item axeItem(String name, ToolMaterial material) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name + "_axe"),
                new ModAxeItem(material, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item hoeItem(String name, ToolMaterial material) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name + "_hoe"),
                new ModHoeItem(material, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item hammerItem(String name, ToolMaterial material, Item.Settings settings) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name + "_hammer"),
                new ModHammerItem(material, settings));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item vanillaHammerItem(String name, ToolMaterial material, Item.Settings settings) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name + "_hammer"),
                new ModHammerItem(material, settings));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addBefore(Items.BUCKET, item));
        return item;
    }

    private static Item excavatorItem(String name, ToolMaterial material, Item.Settings settings) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name + "_excavator"),
                new ModExcavatorItem(material, settings));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item vanillaExcavatorItem(String name, ToolMaterial material, Item.Settings settings) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name + "_excavator"),
                new ModExcavatorItem(material, settings));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addBefore(Items.BUCKET, item));
        return item;
    }

    private static Item paxelItem(String name, ToolMaterial material) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name + "_paxel"),
                new ModPaxelItem(material, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item knifeItem(String name, ToolMaterial material) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name + "_knife"),
                new ModKnifeItem(material, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }

    public static Item armorItem(String name, ArmorMaterial material, ArmorItem.Type type) {
        Item item = Registry.register(Registries.ITEM, new Identifier(NaturesMinerals.MODID, name),
                new ArmorItem(material, type, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(NaturesMinerals.GROUP).register(entries -> entries.add(item));
        return item;
    }
}
