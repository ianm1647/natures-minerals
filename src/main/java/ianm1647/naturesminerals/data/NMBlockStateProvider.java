package ianm1647.naturesminerals.data;

import ianm1647.naturesminerals.NaturesMinerals;
import ianm1647.naturesminerals.common.registry.NMBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.stream.Collectors;

public class NMBlockStateProvider extends BlockStateProvider {
    public NMBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NaturesMinerals.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        normalBlocks();
        fluidBlocks();
    }

    private void normalBlocks() {
        List<Block> entries = NMBlocks.BLOCKS.getEntries().stream().map(DeferredHolder::get)
                .filter((block) -> !(block instanceof LiquidBlock))
                .collect(Collectors.toList());
        entries.forEach(this::simpleBlock);
    }

    private void fluidBlocks() {
        simpleBlock(NMBlocks.BLOOD_LAVA.get(), models().getBuilder(BuiltInRegistries.BLOCK.getKey(NMBlocks.BLOOD_LAVA.get()).getPath())
                .texture("particle", ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, ModelProvider.BLOCK_FOLDER + "/fluid/" +
                        "blood_lava_still")));
        simpleBlock(NMBlocks.SCORCHING_BLOOD.get(), models().getBuilder(BuiltInRegistries.BLOCK.getKey(NMBlocks.SCORCHING_BLOOD.get()).getPath())
                .texture("particle", ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, ModelProvider.BLOCK_FOLDER + "/fluid/" +
                        "scorching_blood_still")));
        simpleBlock(NMBlocks.MOLTEN_UVAROVITE.get(), models().getBuilder(BuiltInRegistries.BLOCK.getKey(NMBlocks.MOLTEN_UVAROVITE.get()).getPath())
                .texture("particle", ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, ModelProvider.BLOCK_FOLDER + "/fluid/" +
                        "molten_uvarovite_still")));
        simpleBlock(NMBlocks.MOLTEN_KUNZITE.get(), models().getBuilder(BuiltInRegistries.BLOCK.getKey(NMBlocks.MOLTEN_KUNZITE.get()).getPath())
                .texture("particle", ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, ModelProvider.BLOCK_FOLDER + "/fluid/" +
                        "molten_kunzite_still")));
        simpleBlock(NMBlocks.MOLTEN_STIBNITE.get(), models().getBuilder(BuiltInRegistries.BLOCK.getKey(NMBlocks.MOLTEN_STIBNITE.get()).getPath())
                .texture("particle", ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, ModelProvider.BLOCK_FOLDER + "/fluid/" +
                        "molten_stibnite_still")));
        simpleBlock(NMBlocks.MOLTEN_ASTRITE.get(), models().getBuilder(BuiltInRegistries.BLOCK.getKey(NMBlocks.MOLTEN_ASTRITE.get()).getPath())
                .texture("particle", ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, ModelProvider.BLOCK_FOLDER + "/fluid/" +
                        "molten_astrite_still")));
        simpleBlock(NMBlocks.MOLTEN_THOUNITE.get(), models().getBuilder(BuiltInRegistries.BLOCK.getKey(NMBlocks.MOLTEN_THOUNITE.get()).getPath())
                .texture("particle", ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, ModelProvider.BLOCK_FOLDER + "/fluid/" +
                        "molten_thounite_still")));
    }

    private ResourceLocation bLoc(String name) {
        return ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "block/" + name);
    }

    private String blockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return ResourceLocation.fromNamespaceAndPath(NaturesMinerals.MODID, "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(this.resourceBlock(this.blockName(block)), this.models().existingFileHelper);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(this.resourceBlock(path), this.models().existingFileHelper);
    }
}
