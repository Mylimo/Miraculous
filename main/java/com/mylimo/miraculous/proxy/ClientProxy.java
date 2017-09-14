package com.mylimo.miraculous.proxy;


import com.mylimo.miraculous.client.model.ModelBlock;
import com.mylimo.miraculous.client.model.ModelItem;
import com.mylimo.miraculous.client.render.*;
import com.mylimo.miraculous.entity.*;
import com.mylimo.miraculous.init.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerModels()
    {
       ModelItem.register();
       ModelBlock.register();
    }

    @Override
    public void registerRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityShot.class, new RenderShot<Entity>(Minecraft.getMinecraft().getRenderManager(), Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderShot<Entity>(Minecraft.getMinecraft().getRenderManager(), Minecraft.getMinecraft().getRenderItem()));
    }
}
