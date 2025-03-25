package ianm1647.naturesminerals.integration.mekanism;

import ianm1647.naturesminerals.common.item.NMTiers;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import mekanism.api.MekanismItemAbilities;
import mekanism.tools.common.ToolsTags;
import mekanism.tools.common.item.ItemMekanismPaxel;
import mekanism.tools.common.material.IPaxelMaterial;
import mekanism.tools.common.material.MaterialCreator;
import mekanism.tools.common.material.VanillaPaxelMaterialCreator;
import mekanism.tools.common.util.ToolsUtils;
import net.minecraft.Util;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Set;

@ParametersAreNonnullByDefault
public class ModPaxelItem extends DiggerItem {
    private static final Set PAXEL_ACTIONS = Util.make(new ReferenceOpenHashSet(), (actions) -> {
        actions.add(MekanismItemAbilities.PAXEL_DIG);
        actions.addAll(ItemAbilities.DEFAULT_PICKAXE_ACTIONS);
        actions.addAll(ItemAbilities.DEFAULT_SHOVEL_ACTIONS);
        actions.addAll(ItemAbilities.DEFAULT_AXE_ACTIONS);
    });

    public ModPaxelItem(NMTiers tier, Item.Properties properties) {
        super(tier, ToolsTags.Blocks.MINEABLE_WITH_PAXEL, properties.attributes(createAttributes(tier, 1.5f, -2.4f)));
    }

    public void appendHoverText(@NotNull ItemStack stack, @NotNull Item.@NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);
        ToolsUtils.addDurability(tooltip, stack);
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility action) {
        return PAXEL_ACTIONS.contains(action);
    }

    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState blockstate = world.getBlockState(blockpos);
        BlockState resultToSet = this.useAsAxe(blockstate, context);
        if (resultToSet == null) {
            if (context.getClickedFace() == Direction.DOWN) {
                return InteractionResult.PASS;
            }

            BlockState foundResult = blockstate.getToolModifiedState(context, ItemAbilities.SHOVEL_FLATTEN, false);
            if (foundResult != null && world.isEmptyBlock(blockpos.above())) {
                world.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                resultToSet = foundResult;
            } else {
                resultToSet = blockstate.getToolModifiedState(context, ItemAbilities.SHOVEL_DOUSE, false);
                if (resultToSet != null && !world.isClientSide) {
                    world.levelEvent((Player)null, 1009, blockpos, 0);
                }
            }

            if (resultToSet == null) {
                return InteractionResult.PASS;
            }
        }

        if (!world.isClientSide) {
            ItemStack stack = context.getItemInHand();
            if (player instanceof ServerPlayer) {
                ServerPlayer serverPlayer = (ServerPlayer)player;
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockpos, stack);
            }

            world.setBlock(blockpos, resultToSet, 11);
            world.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, resultToSet));
            if (player != null) {
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
            }
        }

        return InteractionResult.sidedSuccess(world.isClientSide);
    }

    private @Nullable BlockState useAsAxe(BlockState state, UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState resultToSet = state.getToolModifiedState(context, ItemAbilities.AXE_STRIP, false);
        if (resultToSet != null) {
            world.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return resultToSet;
        } else {
            resultToSet = state.getToolModifiedState(context, ItemAbilities.AXE_SCRAPE, false);
            if (resultToSet != null) {
                world.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.levelEvent(player, 3005, pos, 0);
                return resultToSet;
            } else {
                resultToSet = state.getToolModifiedState(context, ItemAbilities.AXE_WAX_OFF, false);
                if (resultToSet != null) {
                    world.playSound(player, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.levelEvent(player, 3004, pos, 0);
                    return resultToSet;
                } else {
                    return null;
                }
            }
        }
    }
}
