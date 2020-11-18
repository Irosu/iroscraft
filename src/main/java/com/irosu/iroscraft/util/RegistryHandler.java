package com.irosu.iroscraft.util;

import com.irosu.iroscraft.Iroscraft;
import com.irosu.iroscraft.blocks.BlockItemBase;
import com.irosu.iroscraft.blocks.SeranditeOre;
import com.irosu.iroscraft.items.ItemBase;
import com.irosu.iroscraft.tools.EntheriteItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
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
    public static final RegistryObject<Item> ENTHERITE_INGOT = ITEMS.register("entherite_ingot", ItemBase::new);

    //Blocks
    public static final RegistryObject<Block> SERANDITE_ORE = BLOCKS.register("serandite_ore", SeranditeOre::new);
    public static final RegistryObject<Block> SERANDITE_BLOCK = BLOCKS.register("serandite_block", SeranditeOre::new);

    //Block Items
    public static final RegistryObject<Item> SERANDITE_ORE_BI = ITEMS.register("serandite_ore", () -> new BlockItemBase(SERANDITE_ORE.get()));
    public static final RegistryObject<Item> SERANDITE_BLOCK_BI = ITEMS.register("serandite_block", () -> new BlockItemBase(SERANDITE_BLOCK.get()));

    //Tools
    public static final  RegistryObject<PickaxeItem> ENTHERITE_PICKAXE = ITEMS.register("entherite_pickaxe",
            () -> new PickaxeItem(EntheriteItemTier.ENTHERITE, 0, -2.0f,
                    new Item.Properties().group(Iroscraft.TAB)));
}
