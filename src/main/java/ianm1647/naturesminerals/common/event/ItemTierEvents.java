package ianm1647.naturesminerals.common.event;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import static ianm1647.naturesminerals.common.item.NMTiers.*;

@EventBusSubscriber(modid = NaturesMinerals.MODID)
public class ItemTierEvents {

    @SubscribeEvent
    public static void onPlayerHoldItem(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        InteractionHand hand = event.getEntity().getUsedItemHand();
        ItemStack stack = event.getEntity().getItemInHand(hand);
        Level level = event.getEntity().level();
        if (stack.getItem() instanceof TieredItem item) {
            switch (item.getTier()) {
                case UVAROVITE -> {
                }
                case KUNZITE -> {
                }
                case STIBNITE -> {
                    if (level.dimensionType().ultraWarm()) {
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 0, 1, false ,false, false));
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 0, 1, false, false ,false));
                    }
                }
                case ASTRITE -> {
                    if (player.isCrouching()) {
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 0, 1, false, false ,false));
                    }
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 0, 1, false, false ,false));
                }
                case THOUNITE -> {
                    if (level.isThundering()) {
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 0, 1, false ,false, false));
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 0, 1, false, false ,false));
                    }
                }
                default -> {}
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        Player player = event.getEntity();
        Entity target = event.getTarget();
        InteractionHand hand = event.getEntity().getUsedItemHand();
        ItemStack stack = event.getEntity().getItemInHand(hand);
        Level level = event.getEntity().level();
        if (stack.getItem() instanceof TieredItem item && target instanceof LivingEntity living) {
            switch (item.getTier()) {
                case UVAROVITE -> {
                    living.addEffect(new MobEffectInstance(MobEffects.POISON, 800, 1, false, false, false));
                }
                case KUNZITE -> {
                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 250, (int) (living.getHealth() / 5), false, false, false));
                }
                case STIBNITE -> {
                }
                case ASTRITE -> {
                }
                case THOUNITE -> {
                    LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(living.level());
                    lightningBolt.move(MoverType.SELF, living.position());
                    level.addFreshEntity(lightningBolt);
                }
                default -> {}
            }
        }
    }
}
