package com.ghost.fmc.items.custom;

import com.ghost.fmc.registry.ElementalTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class ElementalSwordItem extends SwordItem {

    private int tierId;
    private ElementalTiers tiers = ElementalTiers.getTierById(tierId);
    private final int pAttackDamageModifier = tiers.getpAttackDamageModifier();

    private Tier pTier;

    private final float attackDamageBonus;

//    private final float attackDamage

    public ElementalSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, int tierId) {
        super(pTier,pAttackDamageModifier,pAttackSpeedModifier, pProperties);
        this.tierId = tierId;
        this.attackDamageBonus = pTier.getAttackDamageBonus();
    }


    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        if(this.tierId == 0){
            stormAbility1(entity.level(), entity);
        } else if (this.tierId == 1) {
            entity.kill();
        }
        return retval;
    }

    @Override
    public float getDamage() {
        return (float)this.pAttackDamageModifier + this.attackDamageBonus;
    }

    public static void stormAbility1(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _level) {
            LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
            entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())));
            entityToSpawn.setVisualOnly(true);
            _level.addFreshEntity(entityToSpawn);
        }
        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LIGHTNING_BOLT)), 5);
        entity.setSecondsOnFire(10);
    }
}



