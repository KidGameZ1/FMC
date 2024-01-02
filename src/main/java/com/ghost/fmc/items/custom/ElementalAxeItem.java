package com.ghost.fmc.items.custom;

import com.ghost.fmc.registry.ElementalTiers;
import com.ghost.fmc.util.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ElementalAxeItem extends AxeItem {

    private int tierId;
    private ElementalTiers tiers = ElementalTiers.getTierById(this.tierId);
    private final float pAttackDamageModifier = tiers.getpAttackDamageModifier();

    private final float pAttackSpeedModifier = tiers.getpAttackSpeedModifier();


    private final float attackDamageBonus;

    private static float attackDamage;
    public ElementalAxeItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, int tierId) {
        super(pTier,pAttackDamageModifier,pAttackSpeedModifier, pProperties);
        this.tierId = tierId;
        pAttackDamageModifier=this.pAttackDamageModifier;
        pAttackSpeedModifier=this.pAttackSpeedModifier;
        this.attackDamageBonus = pTier.getAttackDamageBonus();
    }


    @Override
    public Rarity getRarity(ItemStack pStack) {
        return ElementalTiers.getTierById(this.tierId).getRarity();
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (this.tierId == 4) {
                breakwood(pState,pPos,pLevel);
        }
        return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);

    }

    public static void breakwood(BlockState pState, BlockPos pPos, Level pLevel){
        for (int i = 0; i <= pPos.getY()+100; i++) {
            if (isWoodBlock(pState)) {
                if(pLevel.getBlockState(pPos.above(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                    pLevel.destroyBlock(pPos.above(i),true);
                    if(pLevel.getBlockState(pPos.above(i).east(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.above(i).east(i),true);
                    }
                    if(pLevel.getBlockState(pPos.above(i).north(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.above(i).north(i),true);
                    }
                    if(pLevel.getBlockState(pPos.above(i).west(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.above(i).west(i),true);
                    }
                    if(pLevel.getBlockState(pPos.above(i).south(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.above(i).south(i),true);
                    }
                }
                if(pLevel.getBlockState(pPos.below(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                    pLevel.destroyBlock(pPos.below(i),true);
                    if(pLevel.getBlockState(pPos.below(i).east(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.below(i).east(i),true);
                    }
                    if(pLevel.getBlockState(pPos.below(i).north(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.below(i).north(i),true);
                    }
                    if(pLevel.getBlockState(pPos.below(i).west(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.below(i).west(i),true);
                    }
                    if(pLevel.getBlockState(pPos.below(i).south(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.below(i).south(i),true);
                    }
                }

            }
        }
        for (int i = 0; i <= pPos.getX()+100; i++) {
            if (isWoodBlock(pState)) {
                if(pLevel.getBlockState(pPos.east(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                    pLevel.destroyBlock(pPos.east(i),true);
                    if(pLevel.getBlockState(pPos.east(i).above(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.east(i).above(i),true);
                    }
                    if(pLevel.getBlockState(pPos.east(i).below(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.east(i).below(i),true);
                    }
                }
                if(pLevel.getBlockState(pPos.north(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                    pLevel.destroyBlock(pPos.north(i),true);
                    if(pLevel.getBlockState(pPos.north(i).above(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.north(i).above(i),true);
                    }
                    if(pLevel.getBlockState(pPos.north(i).below(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.north(i).below(i),true);
                    }
                }
                if(pLevel.getBlockState(pPos.west(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                    pLevel.destroyBlock(pPos.west(i),true);
                    if(pLevel.getBlockState(pPos.west(i).above(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.west(i).above(i),true);
                    }
                    if(pLevel.getBlockState(pPos.west(i).below(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.west(i).below(i),true);
                    }
                }
                if(pLevel.getBlockState(pPos.south(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                    pLevel.destroyBlock(pPos.south(i),true);
                    if(pLevel.getBlockState(pPos.south(i).above(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.south(i).above(i),true);
                    }
                    if(pLevel.getBlockState(pPos.south(i).below(i)).is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD)){
                        pLevel.destroyBlock(pPos.south(i).below(i),true);
                    }
                }

            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> components, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()){

        components.add(Component.literal("Element Tier: "+ElementalTiers.getTierById(this.tierId).getTierName()));

        components.add(Component.literal("Element Tier Item: "+ElementalTiers.getTierById(this.tierId).getTierItem().toString()));
        }
        super.appendHoverText(pStack, pLevel, components, pIsAdvanced);

    }


    private static boolean isWoodBlock(BlockState blockState) {
//        pPos.above().
        return blockState.is(ModTags.Blocks.SYLVANITE_AXE_MINEABLE_WOOD);
    }
}



