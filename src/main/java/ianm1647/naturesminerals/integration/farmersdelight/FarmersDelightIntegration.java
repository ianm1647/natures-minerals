package ianm1647.naturesminerals.integration.farmersdelight;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.item.NMTiers;
import ianm1647.naturesminerals.integration.mekanism.MekanismIntegration;
import ianm1647.naturesminerals.integration.mekanism.ModPaxelItem;
import mekanism.common.registries.MekanismCreativeTabs;
import mekanism.tools.common.registries.ToolsCreativeTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FarmersDelightIntegration {

    public static void register(IEventBus bus) {
        Items.DELITEM.register(bus);;
    }

    public class Items {
        public static DeferredRegister<Item> DELITEM;

        public static Supplier<Item> UVAROVITE_KNIFE;
        public static Supplier<Item> KUNZITE_KNIFE;
        public static Supplier<Item> STIBNITE_KNIFE;
        public static Supplier<Item> ASTRITE_KNIFE;
        public static Supplier<Item> THOUNITE_KNIFE;

        static {
            DELITEM = DeferredRegister.create(Registries.ITEM, NaturesMinerals.MODID);

            UVAROVITE_KNIFE = DELITEM.register("uvarovite_knife", () -> new ModKnifeItem(NMTiers.UVAROVITE, basicItem()));
            KUNZITE_KNIFE = DELITEM.register("kunzite_knife", () -> new ModKnifeItem(NMTiers.KUNZITE, basicItem()));
            STIBNITE_KNIFE = DELITEM.register("stibnite_knife", () -> new ModKnifeItem(NMTiers.STIBNITE, basicItem()));
            ASTRITE_KNIFE = DELITEM.register("astrite_knife", () -> new ModKnifeItem(NMTiers.ASTRITE, basicItem()));
            THOUNITE_KNIFE = DELITEM.register("thounite_knife", () -> new ModKnifeItem(NMTiers.THOUNITE, basicItem()));
        }
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        List<Item> entries = Items.DELITEM.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toList());
        if (event.getTab() == ModCreativeTabs.TAB_FARMERS_DELIGHT.get()) {
            entries.stream().forEach(event::accept);
        }
    }

    private static Item.Properties basicItem() {
        return (new Item.Properties());
    }

}
