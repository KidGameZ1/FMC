package com.ghost.fmc.items.custom;

import com.ghost.fmc.registry.ElementalTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class ElementalItem extends Item {
    private int tierId;

//    private final ElementalTiers tiers = ElementalTiers.getTierById(tierId);


//    private final Rarity rarity = tiers.getRarity();



    public ElementalItem(Properties properties, int tierId) {
        super(properties);
//        properties.rarity(ElementalTiers.getTierById(this.tierId).getRarity());
        this.tierId = tierId;



    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> components, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()){
            components.add(Component.literal("Element Tier: "+ElementalTiers.getTierById(this.tierId).getTierName()));
        }


        super.appendHoverText(pStack, pLevel, components, pIsAdvanced);

    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return ElementalTiers.getTierById(this.tierId).getRarity();
    }
}
