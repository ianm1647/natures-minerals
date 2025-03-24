package ianm1647.naturesminerals.common.registry;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.util.NMFluidType;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class NMFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES;

    public static Supplier<FluidType> BLOOD_LAVA;
    public static Supplier<FluidType> SCORCHING_BLOOD;

    public static Supplier<FluidType> MOLTEN_UVAROVITE;
    public static Supplier<FluidType> MOLTEN_KUNZITE;
    public static Supplier<FluidType> MOLTEN_STIBNITE;
    public static Supplier<FluidType> MOLTEN_ASTRITE;
    public static Supplier<FluidType> MOLTEN_THOUNITE;

    static {
        FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, NaturesMinerals.MODID);

        BLOOD_LAVA = FLUID_TYPES.register("blood_lava",
                () -> new NMFluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.blood_lava")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .canSwim(false).canDrown(false).lightLevel(15).density(3000).viscosity(6000).temperature(1250), "blood_lava"));

        SCORCHING_BLOOD = FLUID_TYPES.register("scorching_blood",
                () -> new NMFluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.scorching_blood")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .canSwim(false).canDrown(false).lightLevel(15).density(3000).viscosity(6000).temperature(3000), "scorching_blood"));

        MOLTEN_UVAROVITE = FLUID_TYPES.register("molten_uvarovite",
                () -> new NMFluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.molten_uvarovite")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .canSwim(false).canDrown(false).lightLevel(15).density(3000).viscosity(6000).temperature(1000), "molten_uvarovite"));

        MOLTEN_KUNZITE = FLUID_TYPES.register("molten_kunzite",
                () -> new NMFluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.molten_kunzite")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .canSwim(false).canDrown(false).lightLevel(15).density(3000).viscosity(6000).temperature(1500), "molten_kunzite"));

        MOLTEN_STIBNITE = FLUID_TYPES.register("molten_stibnite",
                () -> new NMFluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.molten_stibnite")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .canSwim(false).canDrown(false).density(3000).viscosity(6000).temperature(2000), "molten_stibnite"));

        MOLTEN_ASTRITE = FLUID_TYPES.register("molten_astrite",
                () -> new NMFluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.molten_astrite")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .canSwim(false).canDrown(false).density(3000).viscosity(6000).temperature(2500), "molten_astrite"));

        MOLTEN_THOUNITE = FLUID_TYPES.register("molten_thounite",
                () -> new NMFluidType(FluidType.Properties.create().descriptionId("block.naturesminerals.molten_thounite")
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .canSwim(false).canDrown(false).density(3000).viscosity(6000).temperature(2750), "molten_thounite"));

    }

}
