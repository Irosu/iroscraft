package com.irosu.iroscraft.tools.weather;

import com.google.common.collect.Sets;
import com.irosu.iroscraft.Iroscraft;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Set;

public abstract class WeatherToolItem extends ToolItem {

    public static final int ATTACK_DMG = 0;
    public static final int ATTACK_SPEED = 1;
    public static final IItemTier ITEM_TIER = WeatherItemTier.WEATHER;
    public static final Set<Block> EFFECT_BLOCKS = Sets.newHashSet();
    public static final Properties PROPERTIES = new Properties();

    public static final int DMG_AMOUNT = 1;

    public WeatherToolItem() {
        super(ATTACK_DMG, ATTACK_SPEED, ITEM_TIER, EFFECT_BLOCKS, PROPERTIES);
    }

    @Override
    public abstract ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn);
}
