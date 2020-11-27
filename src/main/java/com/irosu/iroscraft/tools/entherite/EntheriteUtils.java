package com.irosu.iroscraft.tools.entherite;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

/**
 * Clase de utilidades para las herramientas de Entherite
 */
public class EntheriteUtils {

    /**
     * Al picar un bloque se meterá automáticamente en el enderchest del jugador si no está lleno.
     * Si lo está simplemente aparecerá en el suelo como de costumbre.
     */
    public static void saveItemOnEnderchest(World worldIn, BlockState state, BlockPos pos, PlayerEntity player) {

        EnderChestInventory enderChest = player.getInventoryEnderChest();
        List<ItemStack> items = Block.getDrops(state, (ServerWorld)worldIn, pos, null );

        if(!items.isEmpty()) {
            ItemStack itemStackRes = enderChest.addItem(items.get(0));

            if (itemStackRes.isEmpty()) {
                worldIn.removeBlock(pos, false);
            }
        }
    }
}
