package ianm1647.naturesminerals.common.util;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

import java.util.function.Supplier;

public class NMFoodProperties {

    public static FoodProperties UVAROVITE_APPLE = foodComponent()
            .effect(instance(MobEffects.ABSORPTION, 750, 1), 1.0f)
            .effect(instance(MobEffects.DAMAGE_BOOST, 750, 1), 1.0f)
            .alwaysEdible()
            .build();

    public static FoodProperties KUNZITE_APPLE = foodComponent()
            .effect(instance(MobEffects.ABSORPTION, 750, 1), 1.0f)
            .effect(instance(MobEffects.DAMAGE_RESISTANCE, 750, 1), 1.0f)
            .alwaysEdible()
            .build();

    public static FoodProperties STIBNITE_APPLE = foodComponent()
            .effect(instance(MobEffects.ABSORPTION, 750, 1), 1.0f)
            .effect(instance(MobEffects.FIRE_RESISTANCE, 750, 1), 1.0f)
            .effect(instance(MobEffects.JUMP, 750, 1), 1.0f)
            .alwaysEdible()
            .build();

    public static FoodProperties ASTRITE_APPLE = foodComponent()
            .effect(instance(MobEffects.ABSORPTION, 750, 1), 1.0f)
            .effect(instance(MobEffects.DIG_SPEED, 750, 1), 1.0f)
            .effect(instance(MobEffects.MOVEMENT_SPEED, 750, 1), 1.0f)
            .alwaysEdible()
            .build();

    public static FoodProperties THOUNITE_APPLE = foodComponent()
            .effect(instance(MobEffects.ABSORPTION, 750, 1), 1.0f)
            .effect(instance(MobEffects.WATER_BREATHING, 750, 1), 1.0f)
            .effect(instance(MobEffects.SLOW_FALLING, 750, 1), 1.0f)
            .effect(instance(MobEffects.INVISIBILITY, 750, 1), 1.0f)
            .alwaysEdible()
            .build();


    private static FoodProperties.Builder foodComponent() {
        return new FoodProperties.Builder().nutrition(4).saturationModifier(1.2F);
    }

    private static Supplier<MobEffectInstance> instance(Holder<MobEffect> statusEffect, int duration, int amplifier) {
        return () -> new MobEffectInstance(statusEffect, duration, amplifier);
    }

}
