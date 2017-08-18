package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;

public class BlockOlivePlanks extends Block

{
    public BlockOlivePlanks() {
        super(Material.WOOD);

        BlockMiraculous.registerBlock(Reference.OLIVE_PLANKS, this);

        setHardness(2.0F);
        setResistance(15.0F);
        setSoundType(SoundType.WOOD);
        setHarvestLevel("axe", 1);

        Blocks.FIRE.setFireInfo(this, 5, 20);
    }
}