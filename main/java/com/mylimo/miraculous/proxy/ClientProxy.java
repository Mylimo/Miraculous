package com.mylimo.miraculous.proxy;


import com.mylimo.miraculous.client.model.ModelBlock;
import com.mylimo.miraculous.client.model.ModelItem;
import com.mylimo.miraculous.client.render.RenderGlareDemon;
import com.mylimo.miraculous.client.render.RenderIgniteDemon;
import com.mylimo.miraculous.client.render.RenderMangleDemon;
import com.mylimo.miraculous.entity.EntityGlareDemon;
import com.mylimo.miraculous.entity.EntityIgniteDemon;
import com.mylimo.miraculous.entity.EntityMangleDemon;
import com.mylimo.miraculous.entity.EntityWitherDemon;
import com.mylimo.miraculous.client.render.RenderWitherDemon;
import net.minecraft.client.Minecraft;
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
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherDemon.class, new RenderWitherDemon(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityMangleDemon.class, new RenderMangleDemon(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityIgniteDemon.class, new RenderIgniteDemon(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityGlareDemon.class, new RenderGlareDemon(Minecraft.getMinecraft().getRenderManager()));
    }
}
