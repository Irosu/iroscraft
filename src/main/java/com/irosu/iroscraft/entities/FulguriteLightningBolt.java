package com.irosu.iroscraft.entities;

import com.irosu.iroscraft.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FulguriteLightningBolt extends LightningBoltEntity {

    public FulguriteLightningBolt(EntityType<? extends LightningBoltEntity> p_i231491_1_, World world) {
        super(p_i231491_1_, world);
    }

    /**
     * Comprueba si el rayo ha caído sobre un bloque de arena y, si es así, lo reemplaza por una mena de fulgurita.
     */
    public void generateFulgurite() {

        BlockPos blockPos = this.getPosition();
        BlockState blockState = this.world.getBlockState(blockPos);
        Block block = blockState.getBlock();

        if(block == Blocks.SAND) {
            world.removeBlock(blockPos, false);
            world.setBlockState(blockPos, RegistryHandler.FULGURITE_ORE.get().getDefaultState());
        }
    }
}
