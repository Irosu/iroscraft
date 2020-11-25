package com.irosu.iroscraft.items;

import com.irosu.iroscraft.tools.weather.WeatherToolItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/**
 * Herramienta que permite hacer que llueva con cierta probabilidad
 */
public class RainStick extends WeatherToolItem {

    public static final double RAIN_PROB = 15.0;

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if(Math.random()*100 <= RAIN_PROB) {
            worldIn.getWorldInfo().setRaining(true);
        }

        itemstack.damageItem(DMG_AMOUNT, playerIn, (entity) -> entity.sendBreakAnimation(EquipmentSlotType.MAINHAND));

        return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
    }
}
