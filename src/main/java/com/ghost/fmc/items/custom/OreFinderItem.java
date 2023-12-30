package com.ghost.fmc.items.custom;

import com.ghost.fmc.block.ModBlocks;
import com.ghost.fmc.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class OreFinderItem extends Item {
    public OreFinderItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            BlockPos posClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;
//            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(pContext.getLevel());
//            lightningBolt.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(posClicked.getX(), posClicked.getY(), posClicked.getZ())));;
//            pContext.getLevel().addFreshEntity(lightningBolt);

            for (int i = 0; i <= posClicked.getY() + 64; i++){
                BlockState blockState = pContext.getLevel().getBlockState(posClicked.below(i));

                if(isStormiteBlock(blockState)){
                    outputStormiteCoords(posClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    break;
                }
//                if (!foundBlock){
//                    outputNotFound(player);
//                }
            }
        }



        return InteractionResult.SUCCESS;
    }


//    @Override
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//
//        if (pLevel.isRaining()){
//
//        }
//
//
//        return super.use(pLevel, pPlayer, pUsedHand);
//    }

    private void outputNotFound(Player player) {
        player.sendSystemMessage(Component.translatable("item_fmc.ore_finder.no_tempestite"));
    }

    private void outputStormiteCoords(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Sormite Found: " + I18n.get(block.getDescriptionId())
        + " at (" + below.getX()+", "+below.getY()+", "+below.getZ()+")"));
    }

    private boolean isStormiteBlock(BlockState blockState) {
        return blockState.is(ModTags.Blocks.STORMITE_FINDER_VALUABLES);
    }
}
