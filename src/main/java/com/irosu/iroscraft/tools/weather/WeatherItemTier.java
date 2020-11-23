package com.irosu.iroscraft.tools.weather;

import com.irosu.iroscraft.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum WeatherItemTier implements IItemTier {

    WEATHER(0, 100, 0.0f, 0.0f, 0, () -> {
        return Ingredient.fromItems(
                RegistryHandler.RAIN_STICK.get(),
                RegistryHandler.SUN_STICK.get());
    });

    private final int HARVEST_LEVEL;
    private final int MAX_USES;
    private final float EFFICIENCY;
    private final float ATTACK_DAMAGE;
    private final int ENCHANTABILITY;
    private final Supplier<Ingredient> REPAIR_MATERIAL;

    WeatherItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.HARVEST_LEVEL = harvestLevel;
        this.MAX_USES = maxUses;
        this.EFFICIENCY = efficiency;
        this.ATTACK_DAMAGE = attackDamage;
        this.ENCHANTABILITY = enchantability;
        this.REPAIR_MATERIAL = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return MAX_USES;
    }

    @Override
    public float getEfficiency() {
        return EFFICIENCY;
    }

    @Override
    public float getAttackDamage() {
        return ATTACK_DAMAGE;
    }

    @Override
    public int getHarvestLevel() {
        return HARVEST_LEVEL;
    }

    @Override
    public int getEnchantability() {
        return ENCHANTABILITY;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return REPAIR_MATERIAL.get();
    }
}
