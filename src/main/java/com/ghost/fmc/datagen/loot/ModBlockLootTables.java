package com.ghost.fmc.datagen.loot;

import com.ghost.fmc.block.ModBlocks;
import com.ghost.fmc.items.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
//        this.dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());
        this.dropSelf(ModBlocks.BLOCK_OF_TEMPESTITE.get());

        this.add(ModBlocks.TEMPESTITE_ORE.get(),
                block -> createOreDrop(ModBlocks.TEMPESTITE_ORE.get(), ModItems.RAW_TEMPESTITE.get()));
        this.add(ModBlocks.DEEPSLATE_TEMPESTITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_TEMPESTITE_ORE.get(), ModItems.RAW_TEMPESTITE.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}