package com.irosu.iroscraft.blocks.cakes;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.state.IntegerProperty;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Map;

public class CakeUtils {

    public static ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                                         Hand handIn, Map<Effect, Integer> effects, IntegerProperty bites, int slices) {

        if (worldIn.isRemote) {
            ItemStack itemstack = player.getHeldItem(handIn);
            if (eatSlice(worldIn, pos, state, player, bites, slices).isSuccessOrConsume()) {
                effects.forEach((effect, duration) -> player.addPotionEffect(new EffectInstance(effect, duration)));
                return ActionResultType.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return ActionResultType.CONSUME;
            }
        }

        return eatSlice(worldIn, pos, state, player, bites, slices);
    }

    private static ActionResultType eatSlice(IWorld world, BlockPos pos, BlockState state, PlayerEntity player,
                                      IntegerProperty bites, int slices) {

        if (!player.canEat(false)) {
            return ActionResultType.PASS;
        } else {
            player.addStat(Stats.EAT_CAKE_SLICE);
            player.getFoodStats().addStats(2, 0.1F);
            int i = state.get(bites);
            if (i < slices) {
                world.setBlockState(pos, state.with(bites, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }

            return ActionResultType.SUCCESS;
        }
    }
}
