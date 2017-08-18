package com.mylimo.miraculous.client.model;

import com.mylimo.miraculous.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ModelItem
{
    public static void register()
    {
        registerItem(ModItems.SHOTGUN);
        registerItem(ModItems.SHOTDUMMY);
        registerItem(ModItems.IRON_SHOT_SHELL);
        registerItem(ModItems.BLAZE_SHOT_SHELL);
        registerItem(ModItems.SALT);
        registerItem(ModItems.SALT_SHOT_SHELL);
        registerItem(ModItems.ASH);
        registerItem(ModItems.ASH_SHOT_SHELL);
        registerItem(ModItems.OLIVE);
        registerItem(ModItems.OLIVE_WOOD_STICK);
        registerItem(ModItems.OLIVE_BREAD);
        registerItem(ModItems.FLASK);
        registerItem(ModItems.HOLY_OIL_FLASK);
        registerItem(ModItems.HOLY_WATER_FLASK);
        registerItem(ModItems.SALTY_CRACKER);
        registerItem(ModItems.OLIVE_CRACKER);
        registerItem(ModItems.ROSARY);
        registerItem(ModItems.ROSARY_FILLED);
    }

    private static void registerItem(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
