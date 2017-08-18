package com.mylimo.miraculous.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityShot extends EntityThrowable
{
    private static final DataParameter<String> SHOTTYPE = EntityDataManager.<String>createKey(EntityShot.class, DataSerializers.STRING);
    private EntityLivingBase shooter;
    private int ticksInWorld;

    public EntityShot(World world)
    {
        super(world);
        this.ticksInWorld = 0;
    }

    public EntityShot(World world, EntityLivingBase shooter)
    {
        super(world, shooter);
        this.shooter = shooter;
        this.ticksInWorld = 0;

    }

    public EntityShot(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    public void onUpdate()
    {
        super.onUpdate();

        if (this.ticksInWorld >= 4)
        {
            this.setDead();
        }

        if (this.getDataManager().get(SHOTTYPE).equals("Blaze"))
        {
            this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        ++this.ticksInWorld;
    }


    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 0;
            if (this.getDataManager().get(SHOTTYPE).equals("Salt"))
            {
                if (result.entityHit.equals(shooter))
                {
                    i = 0;
                }
                else if (result.entityHit instanceof EntityLivingBase)
                {
                    i = 2;
                }
            }
            else if (this.getDataManager().get(SHOTTYPE).equals("Iron"))
            {
                if (result.entityHit.equals(shooter))
                {
                    i = 0;
                }
                else if (result.entityHit instanceof EntityLivingBase)
                {
                    i = 8;
                }
            }
            else if (this.getDataManager().get(SHOTTYPE).equals("Cremains"))
            {
                if (result.entityHit.equals(shooter))
                {
                    i = 0;
                }
            }
            else if (this.getDataManager().get(SHOTTYPE).equals("Blaze"))
            {
                if (result.entityHit.equals(shooter))
                {
                    i = 0;
                }
                else if (result.entityHit instanceof EntityLivingBase)
                {
                    i = 4;
                    result.entityHit.setFire(4);
                }
            }

            result.entityHit.attackEntityFrom(DamageSource.causeIndirectDamage(this, this.getThrower()), (float)i - ticksInWorld + 1);
        }

        if (!this.world.isRemote && !(result.entityHit == shooter))
        {
            if (this.getDataManager().get(SHOTTYPE).equals("Blaze"))
            {
                this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
            }
            else
            {
                this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
            }
            this.ticksInWorld = 0;
            this.setDead();

        }
    }

    protected void entityInit()
    {
        this.getDataManager().register(SHOTTYPE, "Null");
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        this.getDataManager().set(SHOTTYPE, compound.getString("shotType"));
    }
}
