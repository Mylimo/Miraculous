package com.mylimo.miraculous.client.render;

import com.mylimo.miraculous.client.model.ModelDemon;
import com.mylimo.miraculous.entity.EntityMangleDemon;
import com.mylimo.miraculous.entity.EntityWitherDemon;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;


public class RenderMangleDemon extends RenderLiving<EntityMangleDemon>
{
    private ResourceLocation texture = new ResourceLocation("miraculous:textures/entity/mangle_demon.png");

    public static final Factory FACTORY = new Factory();

    public RenderMangleDemon(RenderManager managerIn)
    {
        super(managerIn, new ModelDemon(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture (@Nonnull EntityMangleDemon entity)
    {
        return texture;
    }

    protected void preRenderCallback(EntityMangleDemon entityMangleDemon, float partialTickTime)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    public static class Factory implements IRenderFactory<EntityMangleDemon>
    {
        @Override
        public Render<? super EntityMangleDemon> createRenderFor(RenderManager manager)
        {
            return new RenderMangleDemon(manager);
        }
    }

}
