package ianm1647.naturesminerals.common.registry;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NMFluids {

    public static DeferredRegister<Fluid> FLUIDS;

    public static Supplier<BaseFlowingFluid> BLOOD_LAVA;
    public static Supplier<BaseFlowingFluid> FLOWING_BLOOD_LAVA;
    public static Supplier<BaseFlowingFluid> SCORCHING_BLOOD;
    public static Supplier<BaseFlowingFluid> FLOWING_SCORCHING_BLOOD;
    public static Supplier<BaseFlowingFluid> MOLTEN_UVAROVITE;
    public static Supplier<BaseFlowingFluid> FLOWING_MOLTEN_UVAROVITE;
    public static Supplier<BaseFlowingFluid> MOLTEN_KUNZITE;
    public static Supplier<BaseFlowingFluid> FLOWING_MOLTEN_KUNZITE;
    public static Supplier<BaseFlowingFluid> MOLTEN_STIBNITE;
    public static Supplier<BaseFlowingFluid> FLOWING_MOLTEN_STIBNITE;
    public static Supplier<BaseFlowingFluid> MOLTEN_ASTRITE;
    public static Supplier<BaseFlowingFluid> FLOWING_MOLTEN_ASTRITE;
    public static Supplier<BaseFlowingFluid> MOLTEN_THOUNITE;
    public static Supplier<BaseFlowingFluid> FLOWING_MOLTEN_THOUNITE;

    static {
        FLUIDS = DeferredRegister.create(Registries.FLUID, NaturesMinerals.MODID);

        BLOOD_LAVA = FLUIDS.register("blood_lava", () -> new BaseFlowingFluid.Source(
                new BaseFlowingFluid.Properties(NMFluidTypes.BLOOD_LAVA, BLOOD_LAVA, FLOWING_BLOOD_LAVA)
                        .bucket(NMItems.BLOOD_LAVA_BUCKET).block(NMBlocks.BLOOD_LAVA).explosionResistance(1000F).tickRate(9)));

        FLOWING_BLOOD_LAVA = FLUIDS.register("flowing_blood_lava", () -> new BaseFlowingFluid.Flowing(
                new BaseFlowingFluid.Properties(NMFluidTypes.BLOOD_LAVA, BLOOD_LAVA, FLOWING_BLOOD_LAVA)
                        .bucket(NMItems.BLOOD_LAVA_BUCKET).block(NMBlocks.BLOOD_LAVA).explosionResistance(1000F).tickRate(9)));

        SCORCHING_BLOOD = FLUIDS.register("scorching_blood", () -> new BaseFlowingFluid.Source(
                new BaseFlowingFluid.Properties(NMFluidTypes.SCORCHING_BLOOD, SCORCHING_BLOOD, FLOWING_SCORCHING_BLOOD)
                        .bucket(NMItems.SCORCHING_BLOOD_BUCKET).block(NMBlocks.SCORCHING_BLOOD).explosionResistance(1000F).tickRate(9)));

        FLOWING_SCORCHING_BLOOD = FLUIDS.register("flowing_scorching_blood", () -> new BaseFlowingFluid.Flowing(
                new BaseFlowingFluid.Properties(NMFluidTypes.SCORCHING_BLOOD, SCORCHING_BLOOD, FLOWING_SCORCHING_BLOOD)
                        .bucket(NMItems.SCORCHING_BLOOD_BUCKET).block(NMBlocks.SCORCHING_BLOOD).explosionResistance(1000F).tickRate(9)));

        MOLTEN_UVAROVITE = FLUIDS.register("molten_uvarovite", () -> new BaseFlowingFluid.Source(
                new BaseFlowingFluid.Properties(NMFluidTypes.MOLTEN_UVAROVITE, MOLTEN_UVAROVITE, FLOWING_MOLTEN_UVAROVITE)
                        .bucket(NMItems.MOLTEN_UVAROVITE_BUCKET).block(NMBlocks.MOLTEN_UVAROVITE).explosionResistance(1000F).tickRate(9)));

        FLOWING_MOLTEN_UVAROVITE = FLUIDS.register("flowing_molten_uvarovite", () -> new BaseFlowingFluid.Flowing(
                new BaseFlowingFluid.Properties(NMFluidTypes.MOLTEN_UVAROVITE, MOLTEN_UVAROVITE, FLOWING_MOLTEN_UVAROVITE)
                        .bucket(NMItems.MOLTEN_UVAROVITE_BUCKET).block(NMBlocks.MOLTEN_UVAROVITE).explosionResistance(1000F).tickRate(9)));

        MOLTEN_KUNZITE = FLUIDS.register("molten_kunzite", () -> new BaseFlowingFluid.Source(
                new BaseFlowingFluid.Properties(NMFluidTypes.MOLTEN_KUNZITE, MOLTEN_KUNZITE, FLOWING_MOLTEN_KUNZITE)
                        .bucket(NMItems.MOLTEN_KUNZITE_BUCKET).block(NMBlocks.MOLTEN_KUNZITE).explosionResistance(1000F).tickRate(9)));

        FLOWING_MOLTEN_KUNZITE = FLUIDS.register("flowing_molten_kunzite", () -> new BaseFlowingFluid.Flowing(
                new BaseFlowingFluid.Properties(NMFluidTypes.MOLTEN_KUNZITE, MOLTEN_KUNZITE, FLOWING_MOLTEN_KUNZITE)
                        .bucket(NMItems.MOLTEN_KUNZITE_BUCKET).block(NMBlocks.MOLTEN_KUNZITE).explosionResistance(1000F).tickRate(9)));

        MOLTEN_STIBNITE = FLUIDS.register("molten_stibnite", () -> new BaseFlowingFluid.Source(
                new BaseFlowingFluid.Properties(NMFluidTypes.MOLTEN_STIBNITE, MOLTEN_STIBNITE, FLOWING_MOLTEN_STIBNITE)
                        .bucket(NMItems.MOLTEN_STIBNITE_BUCKET).block(NMBlocks.MOLTEN_STIBNITE).explosionResistance(1000F).tickRate(9)));

        FLOWING_MOLTEN_STIBNITE = FLUIDS.register("flowing_molten_stibnite", () -> new BaseFlowingFluid.Flowing(
                new BaseFlowingFluid.Properties(NMFluidTypes.MOLTEN_STIBNITE, MOLTEN_STIBNITE, FLOWING_MOLTEN_STIBNITE)
                        .bucket(NMItems.MOLTEN_STIBNITE_BUCKET).block(NMBlocks.MOLTEN_STIBNITE).explosionResistance(1000F).tickRate(9)));

        MOLTEN_ASTRITE = FLUIDS.register("molten_astrite", () -> new BaseFlowingFluid.Source(
                new BaseFlowingFluid.Properties(NMFluidTypes.MOLTEN_ASTRITE, MOLTEN_ASTRITE, FLOWING_MOLTEN_ASTRITE)
                        .bucket(NMItems.MOLTEN_ASTRITE_BUCKET).block(NMBlocks.MOLTEN_ASTRITE).explosionResistance(1000F).tickRate(9)));

        FLOWING_MOLTEN_ASTRITE = FLUIDS.register("flowing_molten_astrite", () -> new BaseFlowingFluid.Flowing(
                new BaseFlowingFluid.Properties(NMFluidTypes.MOLTEN_ASTRITE, MOLTEN_ASTRITE, FLOWING_MOLTEN_ASTRITE)
                        .bucket(NMItems.MOLTEN_ASTRITE_BUCKET).block(NMBlocks.MOLTEN_ASTRITE).explosionResistance(1000F).tickRate(9)));

        MOLTEN_THOUNITE = FLUIDS.register("molten_thounite", () -> new BaseFlowingFluid.Source(
                new BaseFlowingFluid.Properties(NMFluidTypes.MOLTEN_THOUNITE, MOLTEN_THOUNITE, FLOWING_MOLTEN_THOUNITE)
                        .bucket(NMItems.MOLTEN_THOUNITE_BUCKET).block(NMBlocks.MOLTEN_THOUNITE).explosionResistance(1000F).tickRate(9)));

        FLOWING_MOLTEN_THOUNITE = FLUIDS.register("flowing_molten_thounite", () -> new BaseFlowingFluid.Flowing(
                new BaseFlowingFluid.Properties(NMFluidTypes.MOLTEN_THOUNITE, MOLTEN_THOUNITE, FLOWING_MOLTEN_THOUNITE)
                        .bucket(NMItems.MOLTEN_THOUNITE_BUCKET).block(NMBlocks.MOLTEN_THOUNITE).explosionResistance(1000F).tickRate(9)));

    }


}
