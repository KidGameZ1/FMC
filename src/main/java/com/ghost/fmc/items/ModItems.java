package com.ghost.fmc.items;

import com.ghost.fmc.FMCMod;
import com.ghost.fmc.items.custom.ElementalFuelItem;
import com.ghost.fmc.items.custom.ElementalSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FMCMod.MOD_ID);


    public static final RegistryObject<Item> TEMPESTITE = ITEMS.register("tempestite",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> RAW_TEMPESTITE = ITEMS.register("raw_tempestite",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.RARE)));
//    public static final RegistryObject<Item> ORE_FINDER = ITEMS.register("ore_finder",
//            () -> new OreFinderItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> STORM_COAL = ITEMS.register("storm_coal",
            () -> new ElementalFuelItem(new Item.Properties(), 0));
    public static final RegistryObject<Item> TEMPESTITE_SWORD = ITEMS.register("tempestite_sword",
            () -> new ElementalSwordItem(Tiers.NETHERITE,0,5,new Item.Properties(), 0));

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
