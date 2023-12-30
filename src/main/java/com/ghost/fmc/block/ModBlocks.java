package com.ghost.fmc.block;

import com.ghost.fmc.FMCMod;
import com.ghost.fmc.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FMCMod.MOD_ID);

    public static final  RegistryObject<Block> BLOCK_OF_TEMPESTITE = registryBlock("tempestite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));

    public static final  RegistryObject<Block> DEEPSLATE_TEMPESTITE_ORE = registryBlock("deepslate_tempestite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE), UniformInt.of(3,6)));

    public static final  RegistryObject<Block> TEMPESTITE_ORE = registryBlock("tempestite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(2,5)));
    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends  Block>RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
