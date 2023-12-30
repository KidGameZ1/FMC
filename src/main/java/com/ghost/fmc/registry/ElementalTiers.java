package com.ghost.fmc.registry;

import com.ghost.fmc.items.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.world.level.ItemLike;

public enum ElementalTiers {
    STORMS(0,"storm", ModItems.TEMPESTITE.get(),200, "storm", ChatFormatting.DARK_AQUA,2,2),
    FLAMES(1,"flames", ModItems.TEMPESTITE.get(),600, "flame", ChatFormatting.RED,2,2),
    FROST(2,"frost", ModItems.TEMPESTITE.get(),100,"frost", ChatFormatting.AQUA,2,2),
    FORESTS(3,"forest", ModItems.TEMPESTITE.get(),100,"forest", ChatFormatting.DARK_GREEN,2,2);
    private final int tierId;
    private final String tierName;
    private final ItemLike item;
    private final int burnTime;
    private final String rarityName;
    private final ChatFormatting rarityColor;
    private final int pAttackDamageModifier;



    ElementalTiers(int id, String name, ItemLike item, int burnTime, String rarityName, ChatFormatting rarityColor, int pAttackDamageModifier, float pAttackSpeedModifier) {
        this.tierId = id;
        this.tierName = name;
        this.item = item;
        this.burnTime = burnTime;
        this.rarityName = rarityName;
        this.rarityColor = rarityColor;
        this.pAttackDamageModifier = pAttackDamageModifier;
    }

    public ChatFormatting getRarityColor() {return rarityColor;}
    public String getRarityName() {return rarityName;}
    public int getpAttackDamageModifier() {
        return pAttackDamageModifier;
    }


    public int getTierId() {
        return tierId;
    }

    public int getBurnTime() {
        return burnTime;
    }

    public String getTierName() {
        return tierName;
    }


//    public static Item getFluidBucketItem(ElementalTiers tier) {
//        return tier.fluidItem;
//    }

    public static ElementalTiers getTierById(int i) {
        for (ElementalTiers tier : values()) {
            if(tier.getTierId() == i) {
                return tier;
            }
        }

        return null;
    }

    public ItemLike getTierItem() {
        return item;
    }


}
