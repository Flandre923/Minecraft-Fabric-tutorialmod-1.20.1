package net.flandre923.tutorialmod.item;

import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    TANZANITE(5,1800,7.0f,7.0f,25,
            ()->Ingredient.ofItems(ModItems.RUBY));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final  int enchantability;
    private final Supplier<Ingredient> repaairIngredient;

    private ModToolMaterial(int miningLevel,int itemDurability,float miningSpeed,float attackDamage,
                            int enchantability,Supplier<Ingredient> repairIngredient){
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repaairIngredient = repairIngredient;
    }


    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repaairIngredient.get();
    }
}
