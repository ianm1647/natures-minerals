package ianm1647.naturesminerals.common.item.tools;

import ianm1647.naturesminerals.common.item.NMTiers;
import net.minecraft.world.item.SwordItem;

public class ModSwordItem extends SwordItem {
    public ModSwordItem(NMTiers tier, Properties properties) {
        super(tier, properties.attributes(createAttributes(tier, 3, -2.4f)));
    }
}
