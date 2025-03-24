package ianm1647.naturesminerals.common.registry;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NMTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS;
    public static final Supplier<CreativeModeTab> TAB_ED;

    public NMTabs() {
    }

    static {
        CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NaturesMinerals.MODID);
        TAB_ED = CREATIVE_TABS.register(NaturesMinerals.MODID,
                () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + NaturesMinerals.MODID)).icon(
                        () -> new ItemStack(Items.DIAMOND)).displayItems((parameters, output) ->
                        NMItems.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get()))).build());
    }
}
