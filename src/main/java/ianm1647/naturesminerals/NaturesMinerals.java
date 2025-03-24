package ianm1647.naturesminerals;

import ianm1647.naturesminerals.common.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
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

        NMBlocks.BLOCKS.register(bus);
        NMFluidTypes.FLUID_TYPES.register(bus);
        NMFluids.FLUIDS.register(bus);
        NMItems.ITEMS.register(bus);

        NMTabs.CREATIVE_TABS.register(bus);
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
