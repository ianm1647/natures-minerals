package ianm1647.naturesminerals.common.fluid;

import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public class NMFluid extends BaseFlowingFluid {
    protected NMFluid(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isSource(FluidState fluidState) {
        return false;
    }

    @Override
    public int getAmount(FluidState fluidState) {
        return 0;
    }
}
