package com.irosu.iroscraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

/**
 * Clase con la funcionalidad compartida de todas las tartas
 */
public class EnchantedCake extends CakeBlock {

    private Effect effect;
    private int duration;

    public EnchantedCake() {
        super(AbstractBlock.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH));
    }

    public EnchantedCake(Effect effect, int duration) {
        super(AbstractBlock.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH));
        this.effect = effect;
        this.duration = duration;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(effect != null) {
            player.addPotionEffect(new EffectInstance(effect, duration));
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
