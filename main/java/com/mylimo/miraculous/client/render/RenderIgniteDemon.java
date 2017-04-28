package com.mylimo.miraculous.client.render;

import com.mylimo.miraculous.client.model.ModelDemon;
import com.mylimo.miraculous.entity.EntityIgniteDemon;
import com.mylimo.miraculous.entity.EntityWitherDemon;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;


public class RenderIgniteDemon extends RenderLiving<EntityIgniteDemon>
{
    private ResourceLocation texture = new ResourceLocation("miraculous:textures/entity/ignite_demon.png");

    public static final Factory FACTORY = new Factory();

    public RenderIgniteDemon(RenderManager managerIn)
    {
        super(managerIn, new ModelDemon(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture (@Nonnull EntityIgniteDemon entity)
    {
        return texture;
    }

    protected void preRenderCallback(EntityIgniteDemon entityWitherDemon, float partialTickTime)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    public static class Factory implements IRenderFactory<EntityIgniteDemon>
    {
        @Override
        public Render<? super EntityIgniteDemon> createRenderFor(RenderManager manager)
        {
            return new RenderIgniteDemon(manager);
        }
    }

}
