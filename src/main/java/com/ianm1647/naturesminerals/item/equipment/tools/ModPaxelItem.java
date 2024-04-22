package com.ianm1647.naturesminerals.item.equipment.tools;


import com.brand.adapaxels.content.paxels.base.PaxelItem;
import com.ianm1647.naturesminerals.item.ItemList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ModPaxelItem extends PaxelItem {

    public ModPaxelItem(ToolMaterial material, Settings settings) {
        super(material, 1, -2.8F, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity) {
            Hand hand = ((PlayerEntity) entity).getActiveHand();
            ItemStack mainStack = ((PlayerEntity) entity).getStackInHand(hand);
            if (mainStack.isOf(ItemList.ASTRITE_PAXEL)) {
                if (entity.isSneaking()) {
                    ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 0, 2, false, false, false));
                }
                ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 0, 1, false, false, false));
            }
            if (mainStack.isOf(ItemList.THOUNITE_PAXEL)) {
                if (world.isThundering()) {
                    ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 0, 3, false, false, false));
                }
            }
            if (mainStack.isOf(ItemList.STIBNITE_PAXEL)) {
                if (world.getDimension().ultrawarm()) {
                    ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 0, 1, false, false, false));
                }
            }
        }
    }
}
