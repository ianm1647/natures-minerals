package ianm1647.naturesminerals.common.event;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = NaturesMinerals.MODID)
public class ArmorMaterialEvents {

    @SubscribeEvent
    public static void onPlayerHoldItem(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        InteractionHand hand = event.getEntity().getUsedItemHand();
        Level level = event.getEntity().level();
        if (hasFullSuit(player)) {

        }
    }

    private static boolean hasRightSet(Holder<ArmorMaterial> material, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == material && leggings.getMaterial() == material
                && chestplate.getMaterial() == material && helmet.getMaterial() == material;
    }

    private static boolean hasFullSuit(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }

}
