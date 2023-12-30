package com.ghost.fmc.items;

import com.ghost.fmc.FMCMod;
import com.ghost.fmc.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FMCMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> ELEMENTAL_ORES = CREATIVE_MODE_TABS.register("elemental_ores",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.BLOCK_OF_TEMPESTITE.get())).title(Component.translatable("creativetab.elemental_ores")).displayItems(((itemDisplayParameters, output) ->
                    {
                        //Ores
                        output.accept(ModItems.RAW_TEMPESTITE.get());
                        output.accept(ModItems.TEMPESTITE.get());
                        output.accept(ModBlocks.BLOCK_OF_TEMPESTITE.get());
                        output.accept(ModBlocks.DEEPSLATE_TEMPESTITE_ORE.get());
                        output.accept(ModBlocks.TEMPESTITE_ORE.get());
                        output.accept(ModItems.SYLVANITE.get());


                    })).build());
    public static final RegistryObject<CreativeModeTab> ELEMENTAL_FUELS = CREATIVE_MODE_TABS.register("elemental_fuels",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.STORM_COAL.get())).title(Component.translatable("creativetab.elemental_fuels")).displayItems(((itemDisplayParameters, output) ->
            {
                output.accept(ModItems.STORM_COAL.get());
            })).build());
    public static final RegistryObject<CreativeModeTab> ELEMENTAL_TOOLS = CREATIVE_MODE_TABS.register("elemental_tools",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.TEMPESTITE_SWORD.get())).title(Component.translatable("creativetab.elemental_tools")).displayItems(((itemDisplayParameters, output) ->
            {
                output.accept(ModItems.TEMPESTITE_SWORD.get());
            })).build());





    public static void register(IEventBus bus){
        CREATIVE_MODE_TABS.register(bus);
    }
}
