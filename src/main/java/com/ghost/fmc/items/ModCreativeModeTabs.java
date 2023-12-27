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

    public static final RegistryObject<CreativeModeTab> FMC_TAB = CREATIVE_MODE_TABS.register("fmc_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.BLOCK_OF_STORMITE.get())).title(Component.translatable("creativetab.fmc_tab")).displayItems(((itemDisplayParameters, output) ->
                    {
                        //Items
                        output.accept(ModItems.RAW_STORMITE.get());
                        output.accept(ModItems.STORMITE.get());

                        //Blocks
                        output.accept(ModBlocks.BLOCK_OF_STORMITE.get());
                        output.accept(ModBlocks.DEEPSLATE_STORMITE_ORE.get());
                        output.accept(ModBlocks.STORMITE_ORE.get());

                    })).build());



    public static void register(IEventBus bus){
        CREATIVE_MODE_TABS.register(bus);
    }
}
