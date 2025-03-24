package ianm1647.naturesminerals.common.item.tools;

import ianm1647.naturesminerals.common.item.NMTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;

public class ModHoeItem extends HoeItem {
    public ModHoeItem(NMTiers tier, Properties properties) {
        super(tier, properties.attributes(createAttributes(tier, tier.getAttackDamageBonus() - 12, -3.0f)));
    }
}
