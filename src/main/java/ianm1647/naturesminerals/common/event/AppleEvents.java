package ianm1647.naturesminerals.common.event;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.registry.NMItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

import java.util.List;

@EventBusSubscriber(modid = NaturesMinerals.MODID)
public class AppleEvents {

    @SubscribeEvent
    public static void onFinishEating(LivingEntityUseItemEvent.Finish event) {
        LivingEntity living = event.getEntity();
        InteractionHand hand = event.getEntity().getUsedItemHand();
        ItemStack stack = event.getEntity().getItemInHand(hand);
        Level level = event.getEntity().level();
        if (level instanceof ServerLevel server) {
            if (stack.is(NMItems.UVAROVITE_APPLE.get())) {
                List<LivingEntity> mobs = level.getEntitiesOfClass(LivingEntity.class, living.getBoundingBox().inflate(6, 3, 6));
                for (LivingEntity mob : mobs) {
                    if (!(mob.isAlliedTo(living)) && mob instanceof Monster) {
                        mob.addEffect(new MobEffectInstance(MobEffects.POISON, 800, 1, false, false, false));
                    }
                }
            }
            if (stack.is(NMItems.KUNZITE_APPLE.get())) {
                List<LivingEntity> mobs = level.getEntitiesOfClass(LivingEntity.class, living.getBoundingBox().inflate(12, 6, 12));
                for (LivingEntity mob : mobs) {
                    if ((mob.isAlliedTo(living)) || mob instanceof Animal) {
                        mob.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1200, 1, false, false, false));
                    }
                }
            }
            if (stack.is(NMItems.STIBNITE_APPLE.get())) {
                if (living.isOnFire() || level.dimensionType().ultraWarm()) {
                    living.extinguishFire();
                    living.clearFire();
                }
            }
            if (stack.is(NMItems.ASTRITE_APPLE.get())) {
                List<LivingEntity> mobs = level.getEntitiesOfClass(LivingEntity.class, living.getBoundingBox().inflate(6, 3, 6));
                for (LivingEntity mob : mobs) {
                    if (!(mob.isAlliedTo(living)) && mob instanceof Monster) {
                        double d0 = mob.getX() - living.getX();
                        double d1 = mob.getZ() - living.getZ();
                        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                        mob.push(d0 / d2 * 5.0, 0.2, d1 / d2 * 5.0);
                    }
                }
            }
            if (stack.is(NMItems.THOUNITE_APPLE.get())) {
                server.setWeatherParameters(0, 1200, true, true);
            }
        }

    }

}
