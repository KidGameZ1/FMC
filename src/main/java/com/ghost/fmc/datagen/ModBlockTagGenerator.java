package com.ghost.fmc.datagen;

import com.ghost.fmc.FMCMod;
import com.ghost.fmc.block.ModBlocks;
import com.ghost.fmc.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FMCMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.STORMITE_FINDER_VALUABLES)
                .add(ModBlocks.TEMPESTITE_ORE.get()).addTag(Tags.Blocks.ORES);
        this.tag(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)
                .add(Blocks.OAK_LOG)
                .add(Blocks.STRIPPED_OAK_LOG)
                .add(Blocks.DARK_OAK_LOG)
                .add(Blocks.STRIPPED_DARK_OAK_LOG)
                .add(Blocks.ACACIA_LOG)
                .add(Blocks.STRIPPED_ACACIA_LOG)
                .add(Blocks.BIRCH_LOG)
                .add(Blocks.STRIPPED_BIRCH_LOG)
                .add(Blocks.SPRUCE_LOG)
                .add(Blocks.STRIPPED_SPRUCE_LOG)
                .add(Blocks.BAMBOO_BLOCK)
                .add(Blocks.WARPED_STEM)
                .add(Blocks.STRIPPED_WARPED_STEM)
                .add(Blocks.CRIMSON_STEM)
                .add(Blocks.STRIPPED_CRIMSON_STEM)
                .add(Blocks.MANGROVE_LOG)
                .add(Blocks.STRIPPED_MANGROVE_LOG)
                .add(Blocks.JUNGLE_LOG)
                .add(Blocks.STRIPPED_JUNGLE_LOG)
                .add(Blocks.CHERRY_LOG)
                .add(Blocks.STRIPPED_CHERRY_LOG);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOCK_OF_TEMPESTITE.get(),
                        ModBlocks.TEMPESTITE_ORE.get(),
                        ModBlocks.DEEPSLATE_TEMPESTITE_ORE.get());


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_TEMPESTITE_ORE.get(),
                        ModBlocks.TEMPESTITE_ORE.get(),
                        ModBlocks.BLOCK_OF_TEMPESTITE.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
