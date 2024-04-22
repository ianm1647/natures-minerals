package com.ianm1647.naturesminerals.item.equipment.tools;

import com.ianm1647.naturesminerals.item.ItemList;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class ModKnifeItem extends KnifeItem {

    public ModKnifeItem(ToolMaterial material, FabricItemSettings settings) {
        super(material,.5f, -1.8f, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (this == ItemList.THOUNITE_KNIFE) {
            LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(target.getWorld());
            lightning.move(MovementType.SELF, target.getPos());
            target.getWorld().spawnEntity(lightning);
        }
        if (this == ItemList.UVAROVITE_KNIFE) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 800, 0));
        }
        if (this == ItemList.KUNZITE_KNIFE) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 250, (int) (target.getHealth() / 5), false, false, false));
        }
        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity) {
            Hand hand = ((PlayerEntity) entity).getActiveHand();
            ItemStack mainStack = ((PlayerEntity) entity).getStackInHand(hand);
            if (mainStack.isOf(ItemList.ASTRITE_KNIFE)) {
                if (entity.isSneaking()) {
                    ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 0, 2, false, false, false));
                }
                ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 0, 1, false, false, false));
            }
            if (mainStack.isOf(ItemList.THOUNITE_KNIFE)) {
                if (world.isThundering()) {
                    ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 0, 3, false, false, false));
                }
            }
            if (mainStack.isOf(ItemList.STIBNITE_KNIFE)) {
                if (world.getDimension().ultrawarm()) {
                    ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 0, 1, false, false, false));
                    ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 0, 2, false, false, false));
                }
            }
            if (mainStack.isOf(ItemList.THOUNITE_KNIFE)) {
                if (world.isThundering()) {
                    ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 0, 3, false, false, false));
                }
            }
        }
    }
}
