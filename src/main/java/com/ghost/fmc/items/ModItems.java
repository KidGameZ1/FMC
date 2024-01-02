package com.ghost.fmc.items;

import com.ghost.fmc.FMCMod;
import com.ghost.fmc.items.custom.ElementalAxeItem;
import com.ghost.fmc.items.custom.ElementalFuelItem;
import com.ghost.fmc.items.custom.ElementalItem;
import com.ghost.fmc.items.custom.ElementalSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FMCMod.MOD_ID);
    public static final RegistryObject<Item> TEMPESTITE = ITEMS.register("tempestite",
            ()-> new ElementalItem(new Item.Properties(),0));
    public static final RegistryObject<Item> RAW_TEMPESTITE = ITEMS.register("raw_tempestite",
            () -> new ElementalItem(new Item.Properties(),0));
    public static final RegistryObject<Item> SYLVANITE = ITEMS.register("sylvanite",
            ()-> new ElementalItem(new Item.Properties(),4));
    public static final RegistryObject<Item> STORM_COAL = ITEMS.register("storm_coal",
            () -> new ElementalFuelItem(new Item.Properties(), 0));
    public static final RegistryObject<Item> FOREST_COAL = ITEMS.register("forest_coal",
            () -> new ElementalFuelItem(new Item.Properties(), 4));
    public static final RegistryObject<Item> TEMPESTITE_SWORD = ITEMS.register("tempestite_sword",
            () -> new ElementalSwordItem(Tiers.NETHERITE,3,-2.4F,new Item.Properties().fireResistant(),
                    0));
    public static final RegistryObject<Item> SYLVANITE_AXE = ITEMS.register("sylvanite_axe",
            () -> new ElementalAxeItem(Tiers.NETHERITE,5,5,new Item.Properties().fireResistant(),
                    4));


    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
