package ianm1647.naturesminerals.common.registry;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.entity.NonFireLightningBolt;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NMEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITIES;

    public static Supplier<EntityType<NonFireLightningBolt>> NONFIRE_LIGHTNING_BOLT;

    static {
        ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, NaturesMinerals.MODID);

        NONFIRE_LIGHTNING_BOLT = ENTITIES.register("nonfire_lightning_bolt",
                () -> EntityType.Builder.of(NonFireLightningBolt::new, MobCategory.MISC).clientTrackingRange(10).build(NaturesMinerals.MODID + ":nonfire_lightning_bolt"));
    }

}
