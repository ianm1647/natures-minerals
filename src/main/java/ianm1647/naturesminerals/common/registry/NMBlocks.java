package ianm1647.naturesminerals.common.registry;

import ianm1647.naturesminerals.NaturesMinerals;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NMBlocks {

    public static final DeferredRegister<Block> BLOCKS;
    public static final DeferredRegister<Block> FLUIDS;

    public static Supplier<Block> UVAROVITE_ORE;
    public static Supplier<Block> DEEPSLATE_UVAROVITE_ORE;
    public static Supplier<Block> RAW_UVAROVITE_BLOCK;
    public static Supplier<Block> UVAROVITE_BLOCK;
    public static Supplier<Block> KUNZITE_ORE;
    public static Supplier<Block> DEEPSLATE_KUNZITE_ORE;
    public static Supplier<Block> RAW_KUNZITE_BLOCK;
    public static Supplier<Block> KUNZITE_BLOCK;
    public static Supplier<Block> STIBNITE_ORE;
    public static Supplier<Block> RAW_STIBNITE_BLOCK;
    public static Supplier<Block> STIBNITE_BLOCK;
    public static Supplier<Block> ASTRITE_ORE;
    public static Supplier<Block> RAW_ASTRITE_BLOCK;
    public static Supplier<Block> ASTRITE_BLOCK;
    public static Supplier<Block> THOUNITE_BLOCK;

    public static Supplier<LiquidBlock> MOLTEN_UVAROVITE;
    public static Supplier<LiquidBlock> MOLTEN_KUNZITE;
    public static Supplier<LiquidBlock> MOLTEN_STIBNITE;
    public static Supplier<LiquidBlock> MOLTEN_ASTRITE;
    public static Supplier<LiquidBlock> MOLTEN_THOUNITE;

    static {
        BLOCKS = DeferredRegister.create(Registries.BLOCK, NaturesMinerals.MODID);
        FLUIDS = DeferredRegister.create(Registries.BLOCK, NaturesMinerals.MODID);

        UVAROVITE_ORE = BLOCKS.register("uvarovite_ore", () -> new Block(settings(Blocks.STONE, 4.0F, 6.0F, SoundType.STONE)));
        DEEPSLATE_UVAROVITE_ORE = BLOCKS.register("deepslate_uvarovite_ore", () -> new Block(settings(Blocks.STONE, 4.0F, 6.0F, SoundType.STONE)));
        RAW_UVAROVITE_BLOCK = BLOCKS.register("raw_uvarovite_block", () -> new Block(settings(Blocks.RAW_IRON_BLOCK, 4.0F, 6.0F, SoundType.STONE)));
        UVAROVITE_BLOCK = BLOCKS.register("uvarovite_block", () -> new Block(settings(Blocks.IRON_BLOCK, 4.0F, 6.0F, SoundType.METAL)));
        KUNZITE_ORE = BLOCKS.register("kunzite_ore", () -> new Block(settings(Blocks.STONE, 6.0F, 6.0F, SoundType.STONE)));
        DEEPSLATE_KUNZITE_ORE = BLOCKS.register("deepslate_kunzite_ore", () -> new Block(settings(Blocks.STONE, 6.0F, 6.0F, SoundType.STONE)));
        RAW_KUNZITE_BLOCK = BLOCKS.register("raw_kunzite_block", () -> new Block(settings(Blocks.RAW_IRON_BLOCK, 6.0F, 6.0F, SoundType.STONE)));
        KUNZITE_BLOCK = BLOCKS.register("kunzite_block", () -> new Block(settings(Blocks.IRON_BLOCK, 6.0F, 6.0F, SoundType.METAL)));
        STIBNITE_ORE = BLOCKS.register("stibnite_ore", () -> new Block(settings(Blocks.STONE, 7.0F, 8.0F, SoundType.STONE)));
        RAW_STIBNITE_BLOCK = BLOCKS.register("raw_stibnite_block", () -> new Block(settings(Blocks.RAW_IRON_BLOCK, 7.0F, 8.0F, SoundType.STONE)));
        STIBNITE_BLOCK = BLOCKS.register("stibnite_block", () -> new Block(settings(Blocks.IRON_BLOCK, 7.0F, 8.0F, SoundType.NETHERITE_BLOCK)));
        ASTRITE_ORE = BLOCKS.register("astrite_ore", () -> new Block(settings(Blocks.STONE, 8.0F, 9.0F, SoundType.STONE)));
        RAW_ASTRITE_BLOCK = BLOCKS.register("raw_astrite_block", () -> new Block(settings(Blocks.RAW_IRON_BLOCK, 8.0F, 9.0F, SoundType.STONE)));
        ASTRITE_BLOCK = BLOCKS.register("astrite_block", () -> new Block(settings(Blocks.IRON_BLOCK, 8.0F, 9.0F, SoundType.NETHERITE_BLOCK)));
        THOUNITE_BLOCK = BLOCKS.register("thounite_block", () -> new Block(settings(Blocks.IRON_BLOCK, 10.0F, 12.0F, SoundType.NETHERITE_BLOCK)));

        MOLTEN_UVAROVITE = FLUIDS.register("molten_uvarovite", () -> new LiquidBlock(NMFluids.MOLTEN_UVAROVITE.get(),
                BlockBehaviour.Properties.of().replaceable().pushReaction(PushReaction.DESTROY).liquid().noCollission().strength(100.0F)
                        .mapColor(DyeColor.GREEN).noLootTable()));
        MOLTEN_KUNZITE = FLUIDS.register("molten_kunzite", () -> new LiquidBlock(NMFluids.MOLTEN_KUNZITE.get(),
                BlockBehaviour.Properties.of().replaceable().pushReaction(PushReaction.DESTROY).liquid().noCollission().strength(100.0F)
                        .mapColor(DyeColor.PINK).noLootTable()));
        MOLTEN_STIBNITE= FLUIDS.register("molten_stibnite", () -> new LiquidBlock(NMFluids.MOLTEN_STIBNITE.get(),
                BlockBehaviour.Properties.of().replaceable().pushReaction(PushReaction.DESTROY).liquid().noCollission().strength(100.0F)
                        .mapColor(DyeColor.LIGHT_BLUE).noLootTable()));
        MOLTEN_ASTRITE = FLUIDS.register("molten_astrite", () -> new LiquidBlock(NMFluids.MOLTEN_ASTRITE.get(),
                BlockBehaviour.Properties.of().replaceable().pushReaction(PushReaction.DESTROY).liquid().noCollission().strength(100.0F)
                        .mapColor(DyeColor.RED).noLootTable()));
        MOLTEN_THOUNITE = FLUIDS.register("molten_thounite", () -> new LiquidBlock(NMFluids.MOLTEN_THOUNITE.get(),
                BlockBehaviour.Properties.of().replaceable().pushReaction(PushReaction.DESTROY).liquid().noCollission().strength(100.0F)
                        .mapColor(DyeColor.YELLOW).noLootTable()));

    }

    private static BlockBehaviour.Properties settings(Block block, float strength, float resistance, SoundType sound) {
        return BlockBehaviour.Properties.ofFullCopy(block).strength(strength, resistance).sound(sound).requiresCorrectToolForDrops();
    }
}
