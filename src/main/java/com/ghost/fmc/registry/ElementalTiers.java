package com.ghost.fmc.registry;

import com.ghost.fmc.items.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ItemLike;

public enum ElementalTiers {
    STORMS(0,"storm", ModItems.TEMPESTITE.get(),200, 2,2, Rarity.create("storm", ChatFormatting.DARK_AQUA)),
    FLAMES(1,"flames", ModItems.TEMPESTITE.get(),600,2,2,Rarity.create("flames",ChatFormatting.DARK_RED)),
    FROST(2,"frost", ModItems.TEMPESTITE.get(),100,2,2,Rarity.create("frost", ChatFormatting.AQUA)),
    FORESTS(3,"forest", ModItems.SYLVANITE.get(),100,2,2,Rarity.create("forest",ChatFormatting.DARK_GREEN));
    private final int tierId;
    private final String tierName;
    private final ItemLike item;
    private final int burnTime;
    private final int pAttackDamageModifier;
    private final Rarity rarity;



    ElementalTiers(int id, String name, ItemLike item, int burnTime, int pAttackDamageModifier, float pAttackSpeedModifier, Rarity rarity) {
        this.tierId = id;
        this.tierName = name;
        this.item = item;
        this.burnTime = burnTime;
        this.pAttackDamageModifier = pAttackDamageModifier;
        this.rarity = rarity;
    }

    public Rarity getRarity() {
        return rarity;
    }
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
