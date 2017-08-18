package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

public class BlockSaltBlock extends Block
{
    public BlockSaltBlock() {
        super(Material.SAND);

        BlockMiraculous.registerBlock(Reference.SALT_BLOCK, this);

        setHardness(0.5F);
        setResistance(2.5F);
        setSoundType(SoundType.SAND);
        setHarvestLevel("shovel", 2);
    }
}