package com.ghost.fmc.util;

import com.ghost.fmc.FMCMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static class Items{
        public static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(FMCMod.MOD_ID,name));
        }
        private static TagKey<Item> forgeTag(String name){
            return ItemTags.create(new ResourceLocation("forge",name));
        }
    }
    public static class Blocks{
        public static final  TagKey<Block> STORMITE_FINDER_VALUABLES = tag("find_tempestite");
        public static final  TagKey<Block> SYLVANITE_AXE_MINEABLE_WOOD = tag("sylvantie_axe_mineable_wood");

        public static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(FMCMod.MOD_ID,name));
        }
        private static TagKey<Block> forgeTag(String name){
            return BlockTags.create(new ResourceLocation("forge",name));
        }
    }
}
