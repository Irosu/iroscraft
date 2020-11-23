package com.irosu.iroscraft.items;

import com.irosu.iroscraft.Iroscraft;
import com.irosu.iroscraft.tools.weather.WeatherToolItem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Herramienta que permite parar la lluvia con cierta probabilidad y
 * lanzar rayos con una probabilidad menor.
 */
public class SunStick extends WeatherToolItem {

    public static final double CLEAR_PROB = 15.0;
    public static final double LIGHTNING_PROB = 1.0;

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
            double x = lookingAt.getHitVec().getX();
            double y = lookingAt.getHitVec().getY();
            double z = lookingAt.getHitVec().getZ();

            LightningBoltEntity lightning = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, worldIn);
            lightning.setPosition(x, y, z);
            worldIn.addEntity(lightning);
        }
    }
}
