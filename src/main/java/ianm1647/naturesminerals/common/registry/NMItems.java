package ianm1647.naturesminerals.common.registry;

import com.google.common.collect.Sets;
import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class NMItems {

    public static DeferredRegister<Item> ITEMS;
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS;

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

    public static Supplier<Item> MOLTEN_UVAROVITE_BUCKET;
    public static Supplier<Item> MOLTEN_KUNZITE_BUCKET;
    public static Supplier<Item> MOLTEN_STIBNITE_BUCKET;
    public static Supplier<Item> MOLTEN_ASTRITE_BUCKET;
    public static Supplier<Item> MOLTEN_THOUNITE_BUCKET;

    static {
        ITEMS = DeferredRegister.create(Registries.ITEM, NaturesMinerals.MODID);
        CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

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
