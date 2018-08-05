package com.mylimo.miraculous.proxy;


import com.mylimo.miraculous.client.model.ModelBlock;
import com.mylimo.miraculous.client.model.ModelItem;
import com.mylimo.miraculous.client.render.RenderMagicBowl;
import com.mylimo.miraculous.client.render.RenderMagicStand;
import com.mylimo.miraculous.client.render.RenderShot;
import com.mylimo.miraculous.entity.EntityBullet;
import com.mylimo.miraculous.entity.EntityShot;
import com.mylimo.miraculous.tileentity.TileEntityMagicBowl;
import com.mylimo.miraculous.tileentity.TileEntityMagicStand;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.ClientRegistry;
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

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicStand.class, new RenderMagicStand());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicBowl.class, new RenderMagicBowl());
    }
}
