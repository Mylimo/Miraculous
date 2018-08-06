package com.mylimo.miraculous.client.render;

import com.mylimo.miraculous.tileentity.TileEntityMagicStand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.animation.FastTESR;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class RenderMagicStand extends TileEntitySpecialRenderer<TileEntityMagicStand>
{
    private float angle = 0;


    @Override
    public void render(TileEntityMagicStand te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        IItemHandler itemHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        ItemStack itemStack = itemHandler.getStackInSlot(0);

        if (itemStack.isEmpty())
        {
            return;
        }

        GlStateManager.disableLighting();
        RenderHelper.enableStandardItemLighting();

        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.5f, y + 0.58f, z + 0.5f);
        GlStateManager.rotate( angle ,0.0f,1.0f,0);
        angle = angle + 1;
        if (angle == 361) angle = 0;

        Minecraft.getMinecraft().getRenderItem().renderItem(itemStack, ItemCameraTransforms.TransformType.GROUND);

        GlStateManager.popMatrix();

        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableLighting();
    }
}
