package com.ghost.fmc.datagen;

import com.ghost.fmc.FMCMod;
import com.ghost.fmc.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FMCMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_TEMPESTITE);
        simpleItem(ModItems.TEMPESTITE);
        simpleItem(ModItems.SYLVANITE);

        simpleItem(ModItems.STORM_COAL);

        simpleTools(ModItems.TEMPESTITE_SWORD);
//        simpleItem(ModItems.METAL_DETECTOR);
//        simpleItem(ModItems.PEAT_BRICK);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FMCMod.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleTools(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(FMCMod.MOD_ID,"item/" + item.getId().getPath()));
    }

}