package com.irosu.iroscraft.tools.entherite;

import com.irosu.iroscraft.Iroscraft;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntheriteSword extends SwordItem {

    private static final EntheriteItemTier tier = EntheriteItemTier.ENTHERITE;
    private static final int attackDamage = 4;
    private static final float attackSpeed = -2.8F;
    private static final Properties properties = new Properties().group(Iroscraft.TAB);

    public EntheriteSword() {
        super(tier, attackDamage, attackSpeed, properties);
    }

    /**
     * Al picar un bloque se meterá automáticamente en el enderchest del jugador si no está lleno.
     * Si lo está simplemente aparecerá en el suelo como de costumbre.
     */
    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        EntheriteUtils.saveItemOnEnderchest(worldIn, state, pos, (PlayerEntity)(entityLiving.getEntity()));
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
