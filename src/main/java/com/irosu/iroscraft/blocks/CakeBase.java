package com.irosu.iroscraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Clase con la funcionalidad compartida de todas las tartas
 */
public class CakeBase extends CakeBlock {

    public CakeBase() {
        super(AbstractBlock.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH));
    }
}
