package com.irosu.iroscraft.items;

import com.irosu.iroscraft.Iroscraft;
import com.irosu.iroscraft.entities.FulguriteLightningBolt;
import com.irosu.iroscraft.tools.weather.WeatherToolItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

/**
 * Herramienta que permite parar la lluvia con cierta probabilidad y
 * lanzar rayos con una probabilidad menor.
 */
public class SunStick extends WeatherToolItem {

    public static final double CLEAR_PROB = 15.0;
    public static final double LIGHTNING_PROB = 100.0;

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        double prob = Math.random()*100;
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if(prob <= CLEAR_PROB) {
            worldIn.getWorldInfo().setRaining(false);
        }

        if(prob <= LIGHTNING_PROB) {
            thunderStruck(worldIn);
        }

        itemstack.damageItem(DMG_AMOUNT, playerIn, (entity) -> entity.sendBreakAnimation(EquipmentSlotType.MAINHAND));

        return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
    }

    /**
     * Lanza un rayo en la ubicación a la que está apuntando el jugador.
     * @param worldIn
     */
    private void thunderStruck(World worldIn) {

        RayTraceResult lookingAt = Minecraft.getInstance().objectMouseOver;

        if (lookingAt != null) {
            Vector3d notAirPos = getFirstNotAirBlockBellow(worldIn, lookingAt.getHitVec());
            FulguriteLightningBolt lightning = new FulguriteLightningBolt(EntityType.LIGHTNING_BOLT, worldIn);
            lightning.setPosition(notAirPos.x, notAirPos.y, notAirPos.z);
            worldIn.addEntity(lightning);
            lightning.generateFulgurite();
        }
    }

    /**
     * Busca el primer bloque no de Air debajo del punto dado.
     *
     * @param world mundo
     * @param lookingAt vector3D con el punto al que mira el player.
     * @return el vector actualizado
     */
    private Vector3d getFirstNotAirBlockBellow(final World world, Vector3d lookingAt) {

        BlockPos blockPos = new BlockPos(lookingAt);
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();

        while(block == Blocks.AIR) {
            blockPos = blockPos.down(1);
            blockState = world.getBlockState(blockPos);
            block = blockState.getBlock();

            lookingAt = lookingAt.add(0, -1, 0);
        }

        return lookingAt;
    }
}
