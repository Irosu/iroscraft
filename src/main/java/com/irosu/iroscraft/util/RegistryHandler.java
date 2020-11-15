package com.irosu.iroscraft.util;

import com.irosu.iroscraft.Iroscraft;
import com.irosu.iroscraft.blocks.BlockItemBase;
import com.irosu.iroscraft.blocks.SeranditeOre;
import com.irosu.iroscraft.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Iroscraft.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Iroscraft.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items
    public static final RegistryObject<Item> SERANDITE = ITEMS.register("serandite", ItemBase::new);

    //Blocks
    public static final RegistryObject<Block> SERANDITE_ORE_BLOCK = BLOCKS.register("serandite_ore_block", SeranditeOre::new);

    //Block Items
    public static final RegistryObject<Item> SERANDITE_ORE_BLOCK_ITEM = ITEMS.register("serandite_ore_block_item", () -> new BlockItemBase(SERANDITE_ORE_BLOCK.get()));
}
