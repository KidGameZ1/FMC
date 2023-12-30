package com.ghost.fmc.items.custom;

import com.ghost.fmc.registry.ElementalTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class ElementalItem extends Item {
    private int tierId;

    private final ElementalTiers tiers = ElementalTiers.getTierById(tierId);


    private final Rarity rarity = tiers.getRarity();



    public ElementalItem(Properties properties, int tierId) {
        super(properties.rarity(ElementalTiers.getTierById(tierId).getRarity()));
//        properties.rarity(ElementalTiers.getTierById(tierId).getRarity());
        this.tierId = tierId;

    }



//    @Override
//    public Rarity getRarity(ItemStack pStack) {
//        return rarity;
//    }
}
