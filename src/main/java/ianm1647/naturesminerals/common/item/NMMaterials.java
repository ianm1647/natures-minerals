package ianm1647.naturesminerals.common.item;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.registry.NMItems;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public class NMMaterials {
    public static DeferredRegister<ArmorMaterial> ARMOR_MATERIALS;
    public static Holder<ArmorMaterial> UVAROVITE;
    public static Holder<ArmorMaterial> KUNZITE;
    public static Holder<ArmorMaterial> STIBNITE;
    public static Holder<ArmorMaterial> ASTRITE;
    public static Holder<ArmorMaterial> THOUNITE;

    static {
        ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, NaturesMinerals.MODID);

        UVAROVITE = ARMOR_MATERIALS.register("uvarovite", () -> new ArmorMaterial(Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 4);
            map.put(ArmorItem.Type.LEGGINGS, 7);
            map.put(ArmorItem.Type.CHESTPLATE, 9);
            map.put(ArmorItem.Type.HELMET, 4);
        }), 15, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(NMItems.UVAROVITE_INGOT.get()),
                List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "uvarovite"))), 3.5f, 0.2f));

        KUNZITE = ARMOR_MATERIALS.register("kunzite", () -> new ArmorMaterial(Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 5);
            map.put(ArmorItem.Type.LEGGINGS, 8);
            map.put(ArmorItem.Type.CHESTPLATE, 10);
            map.put(ArmorItem.Type.HELMET, 5);
        }), 15, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(NMItems.KUNZITE_INGOT.get()),
                List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "kunzite"))), 4.0f, 0.3f));

        STIBNITE = ARMOR_MATERIALS.register("stibnite", () -> new ArmorMaterial(Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 6);
            map.put(ArmorItem.Type.LEGGINGS, 9);
            map.put(ArmorItem.Type.CHESTPLATE, 11);
            map.put(ArmorItem.Type.HELMET, 6);
        }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(NMItems.STIBNITE_INGOT.get()),
                List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "stibnite"))), 4.5f, 0.4f));

        ASTRITE = ARMOR_MATERIALS.register("astrite", () -> new ArmorMaterial(Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 7);
            map.put(ArmorItem.Type.LEGGINGS, 10);
            map.put(ArmorItem.Type.CHESTPLATE, 12);
            map.put(ArmorItem.Type.HELMET, 7);
        }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(NMItems.ASTRITE_INGOT.get()),
                List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "astrite"))), 5.0f, 0.5f));

        THOUNITE = ARMOR_MATERIALS.register("thounite", () -> new ArmorMaterial(Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 10);
            map.put(ArmorItem.Type.LEGGINGS, 13);
            map.put(ArmorItem.Type.CHESTPLATE, 15);
            map.put(ArmorItem.Type.HELMET, 10);
        }), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(NMItems.THOUNITE_INGOT.get()),
                List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "thounite"))), 8.0f, 0.8f));
    }
}
