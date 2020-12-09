package com.irosu.iroscraft.tools.entherite;

import com.irosu.iroscraft.Iroscraft;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntheriteAxe extends AxeItem {

    private static final EntheriteItemTier tier = EntheriteItemTier.ENTHERITE;
    private static final float attackDamage = 5.5F;
    private static final float attackSpeed = -3.0F;
    private static final Properties properties = new Properties().group(Iroscraft.TAB);

    public EntheriteAxe() {
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
