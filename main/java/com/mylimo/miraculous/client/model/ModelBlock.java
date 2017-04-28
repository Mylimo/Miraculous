package com.mylimo.miraculous.client.model;

import com.mylimo.miraculous.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ModelBlock
{
    public static void register()
    {
        registerBlock(ModBlocks.SALT_ORE);
    }

    private static void registerBlock(Block block)
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}
