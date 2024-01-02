package com.ghost.fmc.registry;

import com.ghost.fmc.items.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ItemLike;

public enum ElementalTiers {
    STORMS(0,"Storm", ModItems.TEMPESTITE.get(),200, 999,2, Rarity.create("storm", ChatFormatting.DARK_AQUA),ChatFormatting.DARK_AQUA),
    FLAMES(1,"Flames", ModItems.TEMPESTITE.get(),600,2,2,Rarity.create("flames",ChatFormatting.DARK_RED),ChatFormatting.DARK_RED),
    FROST(2,"Frost", ModItems.TEMPESTITE.get(),100,2,2,Rarity.create("frost", ChatFormatting.AQUA),ChatFormatting.AQUA),
    HYDRO(3,"Hydro",ModItems.TEMPESTITE.get(),0,2,2,Rarity.create("hydro", ChatFormatting.DARK_BLUE),ChatFormatting.DARK_BLUE),
    FORESTS(4,"Forest", ModItems.SYLVANITE.get(),100,2,2,Rarity.create("forest",ChatFormatting.DARK_GREEN),ChatFormatting.DARK_GREEN),
    GALE(5,"Gale",ModItems.TEMPESTITE.get(),200, 2,2,Rarity.create("gale",ChatFormatting.WHITE),ChatFormatting.WHITE);
    private final int tierId;
    private final String tierName;
    private final ItemLike item;
    private final int burnTime;
    private final int pAttackDamageModifier;
    private final float pAttackSpeedModifier;
    private final Rarity rarity;
    private final ChatFormatting tierColor;



    ElementalTiers(int id, String name, ItemLike item, int burnTime, int pAttackDamageModifier, float pAttackSpeedModifier, Rarity rarity, ChatFormatting tierColor) {
        this.tierId = id;
        this.tierName = name;
        this.item = item;
        this.burnTime = burnTime;
        this.pAttackDamageModifier = pAttackDamageModifier;
        this.pAttackSpeedModifier = pAttackSpeedModifier;
        this.rarity = rarity;
        this.tierColor = tierColor;
    }

    public Rarity getRarity() {
        return rarity;
    }
    public int getpAttackDamageModifier() {
        return pAttackDamageModifier;
    }

    public ChatFormatting getTierColor() {
        return tierColor;
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


    public float getpAttackSpeedModifier() {
        return pAttackSpeedModifier;
    }
}
