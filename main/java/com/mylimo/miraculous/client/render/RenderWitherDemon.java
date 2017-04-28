package com.mylimo.miraculous.client.render;

import com.mylimo.miraculous.client.model.ModelDemon;
import com.mylimo.miraculous.entity.EntityWitherDemon;
import net.minecraft.client.renderer.GlStateManager;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;


public class RenderWitherDemon extends RenderLiving<EntityWitherDemon>
{
    private ResourceLocation texture = new ResourceLocation("miraculous:textures/entity/wither_demon.png");

    public static final Factory FACTORY = new Factory();

    public RenderWitherDemon(RenderManager managerIn)
    {
        super(managerIn, new ModelDemon(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture (@Nonnull EntityWitherDemon entity)
    {
        return texture;
    }

    protected void preRenderCallback(EntityWitherDemon entityWitherDemon, float partialTickTime)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    public static class Factory implements IRenderFactory<EntityWitherDemon>
    {
        @Override
        public Render<? super EntityWitherDemon> createRenderFor(RenderManager manager)
        {
            return new RenderWitherDemon(manager);
        }
    }

}
