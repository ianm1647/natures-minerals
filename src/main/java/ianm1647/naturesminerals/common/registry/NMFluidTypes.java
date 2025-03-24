package ianm1647.naturesminerals.common.registry;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class NMFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES;

    public static Supplier<FluidType> MOLTEN_UVAROVITE;
    public static Supplier<FluidType> MOLTEN_KUNZITE;
    public static Supplier<FluidType> MOLTEN_STIBNITE;
    public static Supplier<FluidType> MOLTEN_ASTRITE;
    public static Supplier<FluidType> MOLTEN_THOUNITE;

    static {
        FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, NaturesMinerals.MODID);

        MOLTEN_UVAROVITE = FLUID_TYPES.register("molten_uvarovite",
                () -> new FluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.molten_uvarovite")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .lightLevel(15).density(3000).viscosity(6000).temperature(1300)));

        MOLTEN_KUNZITE = FLUID_TYPES.register("molten_kunzite",
                () -> new FluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.molten_kunzite")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .lightLevel(15).density(3000).viscosity(6000).temperature(1300)));

        MOLTEN_STIBNITE = FLUID_TYPES.register("molten_stibnite",
                () -> new FluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.molten_stibnite")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .lightLevel(15).density(3000).viscosity(6000).temperature(1300)));

        MOLTEN_ASTRITE = FLUID_TYPES.register("molten_astrite",
                () -> new FluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.molten_astrite")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .lightLevel(15).density(3000).viscosity(6000).temperature(1300)));

        MOLTEN_THOUNITE = FLUID_TYPES.register("molten_thounite",
                () -> new FluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.molten_thounite")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .lightLevel(15).density(3000).viscosity(6000).temperature(1300)));

    }

}
