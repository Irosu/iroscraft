package com.irosu.iroscraft.tools.weather;

import com.google.common.collect.Sets;
import com.irosu.iroscraft.Iroscraft;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Set;

/**
 * Clase abstracta con los atributos y funcionalidad básica que las herramientas meteorológicas deben implementar.
 */
public abstract class WeatherToolItem extends ToolItem {

    public static final int ATTACK_DMG = 0;
    public static final int ATTACK_SPEED = 1;
    public static final IItemTier ITEM_TIER = WeatherItemTier.WEATHER;
    public static final Set<Block> EFFECT_BLOCKS = Sets.newHashSet();
    public static final Properties PROPERTIES = new Item.Properties().group(Iroscraft.TAB);

    public static final int DMG_AMOUNT = 1;

    public WeatherToolItem() {
        super(ATTACK_DMG, ATTACK_SPEED, ITEM_TIER, EFFECT_BLOCKS, PROPERTIES);

    }

    @Override
    public abstract ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn);
}
