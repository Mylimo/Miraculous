package com.mylimo.miraculous.entity;

import com.mylimo.miraculous.reference.Reference;
import net.minecraft.entity.SharedMonsterAttributes;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityWitherDemon extends EntityMob
{
    public EntityWitherDemon(World world)
    {
        super(world);
        this.setSize(0.7f,2.4f);
        this.isImmuneToFire = true;
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
    }

    @Nullable
    protected ResourceLocation getLootTable() {return new ResourceLocation(Reference.MOD_ID, "wither_demon");}

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_DEATH;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.13D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    public void onLivingUpdate()
    {
        if (this.world.isRemote);
        for (int i = 0; i < 1; ++i)
        {
            this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        super.onLivingUpdate();
    }
}
