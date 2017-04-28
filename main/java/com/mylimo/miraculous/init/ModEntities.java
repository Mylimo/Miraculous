package com.mylimo.miraculous.init;

import com.mylimo.miraculous.Miraculous;
import com.mylimo.miraculous.entity.EntityGlareDemon;
import com.mylimo.miraculous.entity.EntityIgniteDemon;
import com.mylimo.miraculous.entity.EntityMangleDemon;
import com.mylimo.miraculous.entity.EntityWitherDemon;
import com.mylimo.miraculous.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities
{
    public static void init()
    {
        registerEntity(EntityWitherDemon.class, Reference.WITHER_DEMON, 0, Miraculous.instance, 80, 1,true);
        registerEntity(EntityMangleDemon.class, Reference.MANGLE_DEMON, 1, Miraculous.instance, 80, 1, true);
        registerEntity(EntityIgniteDemon.class, Reference.IGNITE_DEMON, 2, Miraculous.instance, 80, 1,true);
        registerEntity(EntityGlareDemon.class, Reference.GLARE_DEMON, 3, Miraculous.instance, 80, 1, true);
    }

    private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
    {
        EntityRegistry.registerModEntity(new ResourceLocation("miraculous", entityName), entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
    }

}
