package com.mylimo.miraculous.client.model;

import com.mylimo.miraculous.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ModelItem
{
    public static void register()
    {
        registerItem(ModItems.SALT);
        registerItem(ModItems.SALT_SHOT_SHELL);
        registerItem(ModItems.SHOTGUN);
    }

    private static void registerItem(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
