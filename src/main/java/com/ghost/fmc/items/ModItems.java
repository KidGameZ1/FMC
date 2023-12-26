package com.ghost.fmc.items;

import com.ghost.fmc.FMCMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FMCMod.MOD_ID);


    public static final RegistryObject<Item> GHOSTS_HORN = ITEMS.register("ghosts_horn",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.RARE)));


    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
