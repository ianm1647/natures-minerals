package ianm1647.naturesminerals.common.item.tools;

import ianm1647.naturesminerals.common.item.NMTiers;
import net.minecraft.world.item.AxeItem;

public class ModAxeItem extends AxeItem {
    public ModAxeItem(NMTiers tier, Properties properties) {
        super(tier, properties.attributes(createAttributes(tier, 6f, -3.0f)));
    }
}
