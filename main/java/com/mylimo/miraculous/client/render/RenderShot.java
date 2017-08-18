package com.mylimo.miraculous.client.render;


import com.mylimo.miraculous.init.ModItems;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

@SideOnly(Side.CLIENT)
public class RenderShot<T extends Entity> extends Render<T>
{
    protected final Item item;
    private final RenderItem itemRenderer;

    public RenderShot(RenderManager renderManager, RenderItem itemRenderer)
    {
        super(renderManager);
        this.item = ModItems.SHOTDUMMY;
        this.itemRenderer = itemRenderer;
    }

    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        Random random = new Random();

        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat());
        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

        if(this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }

        this.itemRenderer.renderItem(this.getStackToRender(entity), ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(T entity)
    {
        return new ItemStack(this.item);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }


}
