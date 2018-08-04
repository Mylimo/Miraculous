package com.mylimo.miraculous.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//import net.minecraftforge.fml.common.registry.GameData;

public class PotionMiraculous extends Potion
{
    private ResourceLocation icon;

    public PotionMiraculous(String name, boolean isBadEffect, int liquidColor)
    {
        super(isBadEffect, liquidColor);

        registerPotion(name, this);
    }

    public static void registerPotion(String name, Potion potion)
    {
        potion.setRegistryName(name);

        ForgeRegistries.POTIONS.register(potion);

    }

    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft minecraft)
    {
        super.renderInventoryEffect(x, y, effect, minecraft);

        minecraft.renderEngine.bindTexture(getIcon());

        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
    }

    @SideOnly(Side.CLIENT)
    public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft minecraft, float alpha)
    {
        super.renderHUDEffect(x, y, effect, minecraft, alpha);

        minecraft.renderEngine.bindTexture(getIcon());

        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
    }

    public ResourceLocation getIcon()
    {
        return icon;
    }

    public void setIcon(ResourceLocation icon)
    {
        this.icon = icon;
    }
}
