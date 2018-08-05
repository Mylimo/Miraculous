package com.mylimo.miraculous.client.render;

import com.mylimo.miraculous.tileentity.TileEntityMagicBowl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.animation.FastTESR;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class RenderMagicBowl extends FastTESR<TileEntityMagicBowl>
{
    private float angle = 0;

    @Override
    public void renderTileEntityFast(TileEntityMagicBowl te, double x, double y, double z, float partialTicks, int destroyStage, float partial, BufferBuilder buffer)
    {
        IItemHandler itemHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        ItemStack executor = itemHandler.getStackInSlot(0);
        ItemStack power = itemHandler.getStackInSlot(1);
        ItemStack definer = itemHandler.getStackInSlot(2);

        if (executor.isEmpty() && power.isEmpty() && definer.isEmpty()) return;

        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.365f, y + 0.2f, z + 0.578f);
        GlStateManager.scale(0.5f, 0.5f, 0.5f);
        GlStateManager.rotate( angle ,0.0f,1.0f,0.0f);
        GlStateManager.disableLighting();
        RenderHelper.enableStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().renderItem(power, ItemCameraTransforms.TransformType.GROUND);
        RenderHelper.disableStandardItemLighting();

        GlStateManager.enableLighting();
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.5f, y + 0.2f, z + 0.344f);
        GlStateManager.scale(0.5f, 0.5f, 0.5f);
        GlStateManager.rotate( angle ,0.0f,1.0f,0.0f);
        GlStateManager.disableLighting();
        RenderHelper.enableStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().renderItem(executor, ItemCameraTransforms.TransformType.GROUND);
        RenderHelper.disableStandardItemLighting();

        GlStateManager.enableLighting();
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.635f, y + 0.2f, z + 0.578f);
        GlStateManager.scale(0.5f, 0.5f, 0.5f);
        GlStateManager.rotate( angle ,0.0f,1.0f,0.0f);
        GlStateManager.disableLighting();
        RenderHelper.enableStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().renderItem(definer, ItemCameraTransforms.TransformType.GROUND);
        RenderHelper.disableStandardItemLighting();

        GlStateManager.enableLighting();
        GlStateManager.popMatrix();

        angle = angle + 1;
        if (angle == 361) angle = 0;
    }
}
