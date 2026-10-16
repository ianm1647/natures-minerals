package ianm1647.naturesminerals.integration.jade;

import ianm1647.naturesminerals.common.registry.NMItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import snownee.jade.addon.harvest.HarvestToolProvider;
import snownee.jade.addon.harvest.ToolHandler;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class NMJadePlugin implements IWailaPlugin {

    public void register(IWailaCommonRegistration registration) {
        ToolHandler toolHandler = HarvestToolProvider.TOOL_HANDLERS.get(ResourceLocation.fromNamespaceAndPath("jade", "pickaxe"));
        for (DeferredHolder<Item, ? extends Item> entry : NMItems.ITEMS.getEntries()) {
            if (entry.getId().getPath().contains("pickaxe")) {
                toolHandler.getTools().add(entry.get().getDefaultInstance());
            }
        }
    }
}
