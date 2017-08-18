package com.mylimo.miraculous.client.model;

import com.mylimo.miraculous.block.BlockOliveSapling;
import com.mylimo.miraculous.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ModelBlock
{
    public static void register()
    {
        registerBlock(ModBlocks.SALT_ORE);
        registerBlock(ModBlocks.SALT_BLOCK);
        registerBlock(ModBlocks.ASH_BLOCK);
        registerBlock(ModBlocks.OLIVE_LOG);
        registerBlock(ModBlocks.OLIVE_LEAVES);
        registerBlock(ModBlocks.OLIVE_SAPLING);
        registerBlock(ModBlocks.OLIVE_PLANKS);

        registerBlockWithStateMapper(ModBlocks.OLIVE_LEAVES, (new StateMap.Builder()).ignore(BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE).build());
        registerBlockWithStateMapper(ModBlocks.OLIVE_SAPLING, (new StateMap.Builder()).ignore(BlockOliveSapling.STAGE).build());
    }

    private static void registerBlock(Block block)
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    private static void registerBlockWithStateMapper(Block block, IStateMapper stateMapper)
    {
        ModelLoader.setCustomStateMapper(block, stateMapper);
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));

    }
}
