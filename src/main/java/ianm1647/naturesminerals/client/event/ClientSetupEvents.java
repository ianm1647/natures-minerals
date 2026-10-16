package ianm1647.naturesminerals.client.event;

import ianm1647.naturesminerals.client.renderer.NonFireLightningBoltRenderer;
import ianm1647.naturesminerals.common.registry.NMEntityTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(
        modid = "naturesminerals",
        value = {Dist.CLIENT}
)
public class ClientSetupEvents {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(NMEntityTypes.NONFIRE_LIGHTNING_BOLT.get(), NonFireLightningBoltRenderer::new);
    }
}
