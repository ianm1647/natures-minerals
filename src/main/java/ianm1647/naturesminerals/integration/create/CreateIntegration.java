package ianm1647.naturesminerals.integration.create;

import com.simibubi.create.AllCreativeModeTabs;
import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CreateIntegration {
    public static void register(IEventBus bus) {
        CreateIntegration.Items.CREATEITEM.register(bus);;
    }

    public class Items {
        public static DeferredRegister<Item> CREATEITEM;

        public static Supplier<Item> UVAROVITE_SHEET;
        public static Supplier<Item> KUNZITE_SHEET;
        public static Supplier<Item> STIBNITE_SHEET;
        public static Supplier<Item> ASTRITE_SHEET;
        public static Supplier<Item> THOUNITE_SHEET;

        static {
            CREATEITEM = DeferredRegister.create(Registries.ITEM, NaturesMinerals.MODID);

            UVAROVITE_SHEET = CREATEITEM.register("uvarovite_sheet", () -> new Item(basicItem()));

            KUNZITE_SHEET = CREATEITEM.register("kunzite_sheet", () -> new Item(basicItem()));

            STIBNITE_SHEET = CREATEITEM.register("stibnite_sheet", () -> new Item(basicItem()));

            ASTRITE_SHEET = CREATEITEM.register("astrite_sheet", () -> new Item(basicItem()));

            THOUNITE_SHEET = CREATEITEM.register("thounite_sheet", () -> new Item(basicItem()));
        }
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        List<Item> entries = CreateIntegration.Items.CREATEITEM.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toList());
        if (event.getTab() == AllCreativeModeTabs.BASE_CREATIVE_TAB.get()) {
            entries.stream().forEach(event::accept);
        }
    }

    private static Item.Properties basicItem() {
        return (new Item.Properties());
    }
}
