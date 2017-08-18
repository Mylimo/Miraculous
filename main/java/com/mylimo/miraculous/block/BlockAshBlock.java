package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

public class BlockAshBlock extends Block

{
    public BlockAshBlock() {
        super(Material.SAND);

        BlockMiraculous.registerBlock(Reference.ASH_BLOCK, this);

        this.setHardness(0.5F);
        this.setResistance(2.5F);
        this.setSoundType(SoundType.SAND);
        this.setHarvestLevel("shovel", 2);
    }
}