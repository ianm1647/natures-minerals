package ianm1647.naturesminerals.integration.farmersdelight;

import net.minecraft.world.item.Tier;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class ModKnifeItem extends KnifeItem {
    public ModKnifeItem(Tier tier, Properties properties) {
        super(tier, properties.attributes(KnifeItem.createAttributes(tier, 0.5F, -2.0F)));
    }
}
