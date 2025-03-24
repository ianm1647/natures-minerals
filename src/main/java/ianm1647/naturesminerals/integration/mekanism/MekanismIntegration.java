package ianm1647.naturesminerals.integration.mekanism;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.item.NMTiers;
import mekanism.api.chemical.Chemical;
import mekanism.common.registration.impl.ChemicalDeferredRegister;
import mekanism.common.registration.impl.SlurryRegistryObject;
import mekanism.common.registries.MekanismCreativeTabs;
import mekanism.tools.common.registries.ToolsCreativeTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class MekanismIntegration {

    public static void register(IEventBus bus) {
        Items.MEKITEM.register(bus);
        Chemicals.MEKCHEM.register(bus);
    }

    public class Items {
        public static DeferredRegister<Item> MEKITEM;

        public static Supplier<Item> UVAROVITE_SHARD;
        public static Supplier<Item> UVAROVITE_CLUMP;
        public static Supplier<Item> UVAROVITE_DIRTY_DUST;
        public static Supplier<Item> UVAROVITE_CRYSTAL;

        public static Supplier<Item> KUNZITE_SHARD;
        public static Supplier<Item> KUNZITE_CLUMP;
        public static Supplier<Item> KUNZITE_DIRTY_DUST;
        public static Supplier<Item> KUNZITE_CRYSTAL;

        public static Supplier<Item> STIBNITE_SHARD;
        public static Supplier<Item> STIBNITE_CLUMP;
        public static Supplier<Item> STIBNITE_DIRTY_DUST;
        public static Supplier<Item> STIBNITE_CRYSTAL;

        public static Supplier<Item> ASTRITE_SHARD;
        public static Supplier<Item> ASTRITE_CLUMP;
        public static Supplier<Item> ASTRITE_DIRTY_DUST;
        public static Supplier<Item> ASTRITE_CRYSTAL;

        public static Supplier<Item> UVAROVITE_PAXEL;
        public static Supplier<Item> KUNZITE_PAXEL;
        public static Supplier<Item> STIBNITE_PAXEL;
        public static Supplier<Item> ASTRITE_PAXEL;
        public static Supplier<Item> THOUNITE_PAXEL;

        static {
            MEKITEM = DeferredRegister.create(Registries.ITEM, NaturesMinerals.MODID);

            UVAROVITE_SHARD = MEKITEM.register("uvarovite_shard", () -> new Item(basicItem()));
            UVAROVITE_CLUMP = MEKITEM.register("uvarovite_clump", () -> new Item(basicItem()));
            UVAROVITE_DIRTY_DUST = MEKITEM.register("uvarovite_dirty_dust", () -> new Item(basicItem()));
            UVAROVITE_CRYSTAL = MEKITEM.register("uvarovite_crystal", () -> new Item(basicItem()));

            KUNZITE_SHARD = MEKITEM.register("kunzite_shard", () -> new Item(basicItem()));
            KUNZITE_CLUMP = MEKITEM.register("kunzite_clump", () -> new Item(basicItem()));
            KUNZITE_DIRTY_DUST = MEKITEM.register("kunzite_dirty_dust", () -> new Item(basicItem()));
            KUNZITE_CRYSTAL = MEKITEM.register("kunzite_crystal", () -> new Item(basicItem()));

            STIBNITE_SHARD = MEKITEM.register("stibnite_shard", () -> new Item(basicItem()));
            STIBNITE_CLUMP = MEKITEM.register("stibnite_clump", () -> new Item(basicItem()));
            STIBNITE_DIRTY_DUST = MEKITEM.register("stibnite_dirty_dust", () -> new Item(basicItem()));
            STIBNITE_CRYSTAL = MEKITEM.register("stibnite_crystal", () -> new Item(basicItem()));

            ASTRITE_SHARD = MEKITEM.register("astrite_shard", () -> new Item(basicItem()));
            ASTRITE_CLUMP = MEKITEM.register("astrite_clump", () -> new Item(basicItem()));
            ASTRITE_DIRTY_DUST = MEKITEM.register("astrite_dirty_dust", () -> new Item(basicItem()));
            ASTRITE_CRYSTAL = MEKITEM.register("astrite_crystal", () -> new Item(basicItem()));

            if (ModList.get().isLoaded("mekanismtools")) {
                UVAROVITE_PAXEL = MEKITEM.register("uvarovite_paxel", () -> new ModPaxelItem(NMTiers.UVAROVITE, basicItem()));
                KUNZITE_PAXEL = MEKITEM.register("kunzite_paxel", () -> new ModPaxelItem(NMTiers.KUNZITE, basicItem()));
                STIBNITE_PAXEL = MEKITEM.register("stibnite_paxel", () -> new ModPaxelItem(NMTiers.STIBNITE, basicItem()));
                ASTRITE_PAXEL = MEKITEM.register("astrite_paxel", () -> new ModPaxelItem(NMTiers.ASTRITE, basicItem()));
                THOUNITE_PAXEL = MEKITEM.register("thounite_paxel", () -> new ModPaxelItem(NMTiers.THOUNITE, basicItem()));
            }
        }
    }

    public class Chemicals {
        public static ChemicalDeferredRegister MEKCHEM;

        public static SlurryRegistryObject<Chemical, Chemical> UVAROVITE;
        public static SlurryRegistryObject<Chemical, Chemical> KUNZITE;
        public static SlurryRegistryObject<Chemical, Chemical> STIBNITE;
        public static SlurryRegistryObject<Chemical, Chemical> ASTRITE;

        static {
            MEKCHEM = new ChemicalDeferredRegister(NaturesMinerals.MODID);

            UVAROVITE = MEKCHEM.registerSlurry("uvarovite", b -> b.tint(FastColor.ARGB32.color(48, 213, 19)));
            KUNZITE = MEKCHEM.registerSlurry("kunzite", b -> b.tint(FastColor.ARGB32.color(207, 98, 132)));
            STIBNITE = MEKCHEM.registerSlurry("stibnite", b -> b.tint(FastColor.ARGB32.color(183, 195, 222)));
            ASTRITE = MEKCHEM.registerSlurry("astrite", b -> b.tint(FastColor.ARGB32.color(255, 50, 34)));
        }

    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        List<Item> entries = Items.MEKITEM.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toList());
        if (event.getTab() == ToolsCreativeTabs.TOOLS.get()) {
            entries.stream()
                    .filter((item) -> (item.asItem() instanceof ModPaxelItem))
                    .forEach(event::accept);
        } else if (event.getTab() == MekanismCreativeTabs.MEKANISM.get()) {
            entries.stream()
                    .filter((item) -> !(item.asItem() instanceof ModPaxelItem))
                    .forEach(event::accept);
        }
    }

    private static Item.Properties basicItem() {
        return (new Item.Properties());
    }
}
