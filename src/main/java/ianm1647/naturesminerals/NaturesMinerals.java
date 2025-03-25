package ianm1647.naturesminerals;

import ianm1647.naturesminerals.common.item.NMMaterials;
import ianm1647.naturesminerals.common.registry.*;
import ianm1647.naturesminerals.integration.farmersdelight.FarmersDelightIntegration;
import ianm1647.naturesminerals.integration.mekanism.MekanismIntegration;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NaturesMinerals.MODID)
public class NaturesMinerals {
    public static final String MODID = "naturesminerals";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public NaturesMinerals(IEventBus bus) {
        NeoForge.EVENT_BUS.register(this);

        NMFluidTypes.FLUID_TYPES.register(bus);
        NMFluids.FLUIDS.register(bus);
        NMBlocks.BLOCKS.register(bus);
        NMItems.ITEMS.register(bus);
        NMMaterials.ARMOR_MATERIALS.register(bus);

        NMTabs.CREATIVE_TABS.register(bus);

        if (ModList.get().isLoaded("mekanism")) {
            MekanismIntegration.register(bus);
            bus.addListener(MekanismIntegration::addCreative);
        }

        if (ModList.get().isLoaded("farmersdelight")) {
            FarmersDelightIntegration.register(bus);
            bus.addListener(FarmersDelightIntegration::addCreative);
        }
    }

    public static ResourceLocation loc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Natures Minerals is starting...");
    }
}
