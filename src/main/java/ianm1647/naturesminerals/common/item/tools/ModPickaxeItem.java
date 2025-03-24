package ianm1647.naturesminerals.common.item.tools;

import ianm1647.naturesminerals.common.item.NMTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.PickaxeItem;

public class ModPickaxeItem extends PickaxeItem {
    public ModPickaxeItem(NMTiers tier, Properties properties) {
        super(tier, properties.attributes(createAttributes(tier, tier.getAttackDamageBonus() - 4, -2.8f)));
    }
}
