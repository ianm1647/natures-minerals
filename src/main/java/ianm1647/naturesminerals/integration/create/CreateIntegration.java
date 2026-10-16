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

        static {
            CREATEITEM = DeferredRegister.create(Registries.ITEM, NaturesMinerals.MODID);
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
