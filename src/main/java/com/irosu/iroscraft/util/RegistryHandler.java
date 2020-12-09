package com.irosu.iroscraft.util;

import com.google.common.collect.Lists;
import com.irosu.iroscraft.Iroscraft;
import com.irosu.iroscraft.blocks.*;
import com.irosu.iroscraft.blocks.cakes.AppleCake;
import com.irosu.iroscraft.blocks.cakes.BerryCake;
import com.irosu.iroscraft.blocks.cakes.BirthdayCake;
import com.irosu.iroscraft.blocks.cakes.CarrotCake;
import com.irosu.iroscraft.items.ItemBase;
import com.irosu.iroscraft.items.RainStick;
import com.irosu.iroscraft.items.SunStick;
import com.irosu.iroscraft.tools.entherite.*;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.potion.Effects;
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
    public static final RegistryObject<Item> FULGURITE = ITEMS.register("fulgurite", ItemBase::new);
    public static final RegistryObject<Item> ENTHERITE_INGOT = ITEMS.register("entherite_ingot", ItemBase::new);
    public static final RegistryObject<Item> SERANDITE = ITEMS.register("serandite", ItemBase::new);

    public static final RegistryObject<Item> RAIN_STICK = ITEMS.register("rain_stick", RainStick::new);
    public static final RegistryObject<Item> RAIN_STICK_DRY = ITEMS.register("rain_stick_dry", ItemBase::new);
    public static final RegistryObject<Item> SUN_STICK = ITEMS.register("sun_stick", SunStick::new);

    //Blocks
    public static final RegistryObject<Block> SERANDITE_BLOCK = BLOCKS.register("serandite_block", SeranditeBlock::new);
    public static final RegistryObject<Block> SERANDITE_ORE = BLOCKS.register("serandite_ore", SeranditeOre::new);
    public static final RegistryObject<Block> FULGURITE_ORE = BLOCKS.register("fulgurite_ore", FulguriteOre::new);
    public static final RegistryObject<Block> APPLE_CAKE = BLOCKS.register("apple_cake",
            () -> new AppleCake(Effects.SATURATION, 50));
    public static final RegistryObject<Block> GOLDEN_APPLE_CAKE = BLOCKS.register("golden_apple_cake",
            () -> new AppleCake(Lists.newArrayList(Effects.REGENERATION, Effects.ABSORPTION), 500));
    public static final RegistryObject<Block> CARROT_CAKE = BLOCKS.register("carrot_cake",
            () -> new CarrotCake(Effects.HEALTH_BOOST, 500));
    public static final RegistryObject<Block> BERRY_CAKE = BLOCKS.register("berry_cake",
            () -> new BerryCake(Lists.newArrayList(Effects.STRENGTH, Effects.HASTE), 500));
    public static final RegistryObject<Block> BIRTHDAY_CAKE = BLOCKS.register("birthday_cake",
            () -> new BirthdayCake(Lists.newArrayList(Effects.HERO_OF_THE_VILLAGE, Effects.GLOWING), 500));

    //Block Items
    public static final RegistryObject<Item> SERANDITE_BLOCK_BI = ITEMS.register("serandite_block", () -> new BlockItemBase(SERANDITE_BLOCK.get()));
    public static final RegistryObject<Item> SERANDITE_ORE_BI = ITEMS.register("serandite_ore", () -> new BlockItemBase(SERANDITE_ORE.get()));
    public static final RegistryObject<Item> FULGURITE_ORE_BI = ITEMS.register("fulgurite_ore", () -> new BlockItemBase(FULGURITE_ORE.get()));
    public static final RegistryObject<Item> APPLE_CAKE_BI = ITEMS.register("apple_cake", () -> new BlockItemBase(APPLE_CAKE.get()));
    public static final RegistryObject<Item> GOLDEN_APPLE_CAKE_BI = ITEMS.register("golden_apple_cake", () -> new BlockItemBase(GOLDEN_APPLE_CAKE.get()));
    public static final RegistryObject<Item> CARROT_CAKE_BI = ITEMS.register("carrot_cake", () -> new BlockItemBase(CARROT_CAKE.get()));
    public static final RegistryObject<Item> BERRY_CAKE_BI = ITEMS.register("berry_cake", () -> new BlockItemBase(BERRY_CAKE.get()));
    public static final RegistryObject<Item> BIRTHDAY_CAKE_BI = ITEMS.register("birthday_cake", () -> new BlockItemBase(BIRTHDAY_CAKE.get()));

    //Tools
    public static final RegistryObject<AxeItem> ENTHERITE_AXE = ITEMS.register("entherite_axe",
            () -> new EntheriteAxe(EntheriteItemTier.ENTHERITE, 5.5F, -3.0F,
                    new Item.Properties().group(Iroscraft.TAB)));

    public static final RegistryObject<HoeItem> ENTHERITE_HOE = ITEMS.register("entherite_hoe",
            () -> new EntheriteHoe(EntheriteItemTier.ENTHERITE, -4, 0.0F,
                    new Item.Properties().group(Iroscraft.TAB)));

    public static final RegistryObject<EntheritePickaxe> ENTHERITE_PICKAXE = ITEMS.register("entherite_pickaxe",
            () -> new EntheritePickaxe(EntheriteItemTier.ENTHERITE, 1, -2.7F,
                    new Item.Properties().group(Iroscraft.TAB)));

    public static final RegistryObject<ShovelItem> ENTHERITE_SHOVEL = ITEMS.register("entherite_shovel",
            () -> new EntheriteShovel(EntheriteItemTier.ENTHERITE, 1.8F, -3.0F,
                    new Item.Properties().group(Iroscraft.TAB)));

    public static final RegistryObject<SwordItem> ENTHERITE_SWORD = ITEMS.register("entherite_sword",
            () -> new EntheriteSword(EntheriteItemTier.ENTHERITE, 4, -2.8f,
                    new Item.Properties().group(Iroscraft.TAB)));
}
