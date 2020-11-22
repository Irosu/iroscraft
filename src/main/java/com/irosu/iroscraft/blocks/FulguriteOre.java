package com.irosu.iroscraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class FulguriteOre extends Block {

    public FulguriteOre() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.SAND)
                .harvestLevel(4)
                .harvestTool(ToolType.SHOVEL)
        );
    }
}
