package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.creativetab.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockMiraculous extends Block
{
    public BlockMiraculous(Material material, String name)
    {
        super(material);
        registerBlock(name, this);
    }

    public static void registerBlock(String name, Block block)
    {
        block.setRegistryName(name);
        block.setUnlocalizedName(name);
        block.setCreativeTab(CreativeTab.MIRACULOUS_TAB);

        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    public static void registerBlock(String name, Block block, Class<? extends ItemBlock> itemBlock)
    {
        block.setRegistryName(name);
        block.setUnlocalizedName(name);
        block.setCreativeTab(CreativeTab.MIRACULOUS_TAB);

        ForgeRegistries.BLOCKS.register(block);

        try
        {
            ForgeRegistries.ITEMS.register(itemBlock.getConstructor(Block.class).newInstance(block).setRegistryName(block.getRegistryName()));
        }
        catch (Exception e)
        {
            System.out.println("Error registering ItemBlock for: " + name + " by " + Reference.MOD_ID);
            e.printStackTrace();
        }
    }
}
