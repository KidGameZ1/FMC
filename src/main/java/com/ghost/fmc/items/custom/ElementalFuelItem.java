package com.ghost.fmc.items.custom;

import com.ghost.fmc.registry.ElementalTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class ElementalFuelItem extends Item{

    private int tierId;

    private ElementalTiers tiers = ElementalTiers.getTierById(tierId);

    private String rarityName = tiers.getRarityName();
    private ChatFormatting rarityColor = tiers.getRarityColor();



    private final int burnTime = tiers.getBurnTime();
    public ElementalFuelItem(Properties properties, int tierId) {
        super(properties);
        properties.rarity(Rarity.create(rarityName,rarityColor));
//        this.burnTime = burnTime;
        this.tierId = tierId;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {

        return this.burnTime;
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return Rarity.create(rarityName,rarityColor);
    }
}
