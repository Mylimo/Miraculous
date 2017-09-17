package com.mylimo.miraculous.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable
{
    private static final DataParameter<String> BULLETTYPE = EntityDataManager.createKey(EntityBullet.class, DataSerializers.STRING);
    private EntityLivingBase shooter;
    private int ticksInWorld;

    public EntityBullet(World world)
    {
        super(world);
        this.ticksInWorld = 0;
    }

    public EntityBullet(World world, EntityLivingBase shooter)
    {
        super(world, shooter);
        this.shooter = shooter;
        this.ticksInWorld = 0;
    }

    public EntityBullet(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    public void onUpdate()
    {
        super.onUpdate();

        if (this.ticksInWorld >= 12000)
        {
            this.setDead();
        }

        this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

        ++ticksInWorld;
    }

    protected void onImpact (RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 0;
            if (this.getDataManager().get(BULLETTYPE).equals("Iron"))
            {
                if (result.entityHit.equals(shooter))
                {
                    i = 0;
                }
                else if (result.entityHit instanceof EntityLivingBase)
                {
                    i = 10;
                }
            }

            if (result.entityHit != shooter)
            {
                result.entityHit.attackEntityFrom(DamageSource.causeIndirectDamage(this, this.getThrower()), (float) i);
            }
        }

        if (!this.world.isRemote && result.entityHit != shooter)
        {
            this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            this.ticksInWorld = 0;
            this.setDead();
        }
    }

    protected void entityInit()
    {
        this.getDataManager().register(BULLETTYPE, "Null");
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        this.getDataManager().set(BULLETTYPE, compound.getString("bulletType"));
    }

}
