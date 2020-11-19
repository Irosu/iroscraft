package com.irosu.iroscraft.tools;

import com.irosu.iroscraft.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum EntheriteItemTier implements IItemTier {

    ENTHERITE(3, 100, 10.0f, 0.0f, 12, () -> {
        return Ingredient.fromItems(
                RegistryHandler.ENTHERITE_AXE.get(),
                RegistryHandler.ENTHERITE_HOE.get(),
                RegistryHandler.ENTHERITE_PICKAXE.get(),
                RegistryHandler.ENTHERITE_SHOVEL.get(),
                RegistryHandler.ENTHERITE_SWORD.get());
    });

    private final int HARVEST_LEVEL;
    private final int MAX_USES;
    private final float EFFICIENCY;
    private final float ATTACK_DAMAGE;
    private final int ENCHANTABILITY;
    private final Supplier<Ingredient> REPAIR_MATERIAL;

    EntheriteItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
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
