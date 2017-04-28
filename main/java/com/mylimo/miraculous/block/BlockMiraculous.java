package com.mylimo.miraculous.block;

import com.mylimo.miraculous.creativetab.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockMiraculous extends Block
{
    public BlockMiraculous(Material material, String name)
    {
        super(material);
        registerBlock(name, this);
    }

    public static void registerBlock(String name, Block block)
    {
        block.setUnlocalizedName(name);
        block.setRegistryName(name);
        block.setCreativeTab(CreativeTab.MIRACULOUS_TAB);
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
}
