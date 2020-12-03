package com.irosu.iroscraft.blocks.cakes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * Clase con la funcionalidad a implementar por todas las tartas
 */
public interface ICustomCake {

    ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit);
    void fillStateContainer(StateContainer.Builder<Block, BlockState> builder);
    VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context);
}
