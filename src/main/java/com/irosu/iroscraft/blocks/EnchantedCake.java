package com.irosu.iroscraft.blocks;

import com.google.common.collect.Lists;
import com.irosu.iroscraft.Iroscraft;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

/**
 * Clase con la funcionalidad compartida de todas las tartas
 */
public class EnchantedCake extends CakeBlock {

    private final List<Effect> effects = Lists.newArrayList();
    private int duration;

    public EnchantedCake() {
        super(AbstractBlock.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH));
        setShapes();
    }

    public EnchantedCake(Effect effect, int duration) {
        this(Lists.newArrayList(effect), duration);
    }

    public EnchantedCake(List<Effect> effects, int duration) {
        this();
        this.effects.addAll(effects);
        this.duration = duration;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        Arrays.stream(CakeBlock.SHAPES).forEach(Iroscraft.LOGGER::info);
        effects.forEach(effect -> player.addPotionEffect(new EffectInstance(effect, duration)));
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    /**
     * Modificamos las VoxelShape para que se ajusten al tamaño del real de la tarta.
     */
    private void setShapes() {
        for(int i=0; i< SHAPES.length; i++) {
            SHAPES[i] = Block.makeCuboidShape(2*i + 1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D);
        }
    }
}
