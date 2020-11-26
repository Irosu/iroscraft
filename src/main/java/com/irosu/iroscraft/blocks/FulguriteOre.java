package com.irosu.iroscraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class FulguriteOre extends Block {

    public FulguriteOre() {
        super(Properties.create(Material.SAND)
                .hardnessAndResistance(0.5F)
                .sound(SoundType.SAND)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL)
        );
    }
}
