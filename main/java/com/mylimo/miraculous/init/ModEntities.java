package com.mylimo.miraculous.init;

import com.mylimo.miraculous.Miraculous;
import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.entity.EntityBullet;
import com.mylimo.miraculous.entity.EntityShot;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities
{
    public static void init()
    {
        registerEntity(EntityShot.class, Reference.SHOT_PROJECTILE, 0, Miraculous.instance, 80, 1, true);
        registerEntity(EntityBullet.class, Reference.BULLET_PROJECTILE, 1, Miraculous.instance, 80, 1, true);
    }

    private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
    {
        EntityRegistry.registerModEntity(new ResourceLocation("miraculous", entityName), entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
    }

}
