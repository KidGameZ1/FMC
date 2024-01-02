package com.ghost.fmc.items.custom;

import com.ghost.fmc.registry.ElementalTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ElementalFuelItem extends Item{

    private int tierId;

    private final ElementalTiers tiers = ElementalTiers.getTierById(tierId);



    private final int burnTime = tiers.getBurnTime();
    public ElementalFuelItem(Properties properties, int tierId) {
        super(properties.rarity(ElementalTiers.getTierById(tierId).getRarity()));
//        properties.rarity(tiers.getRarity());
//        this.burnTime = burnTime;
        this.tierId = tierId;
    }



    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {

        return this.burnTime;
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> components, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()){
            components.add(Component.literal("Element Tier: "+ElementalTiers.getTierById(this.tierId).getTierName()));
        }


        super.appendHoverText(pStack, pLevel, components, pIsAdvanced);

    }
//    @Override
//    public Rarity getRarity(ItemStack pStack) {
//        return tiers.getRarity();
//    }
}
