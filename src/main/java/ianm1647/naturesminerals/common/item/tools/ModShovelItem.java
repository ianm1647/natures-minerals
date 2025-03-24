package ianm1647.naturesminerals.common.item.tools;

import ianm1647.naturesminerals.common.item.NMTiers;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;

public class ModShovelItem extends ShovelItem {
    public ModShovelItem(NMTiers tier, Properties properties) {
        super(tier, properties.attributes(createAttributes(tier, tier.getAttackDamageBonus() - 4, -3.0f)));
    }
}
