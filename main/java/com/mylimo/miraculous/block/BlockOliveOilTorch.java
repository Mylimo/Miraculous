package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import net.minecraft.block.BlockTorch;

public class BlockOliveOilTorch extends BlockTorch
{
    public BlockOliveOilTorch()
    {
        BlockMiraculous.registerBlock(Reference.OLIVE_OIL_TORCH, this);

        this.setLightLevel(0.75F);
    }


}
