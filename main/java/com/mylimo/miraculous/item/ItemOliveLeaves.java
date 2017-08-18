package com.mylimo.miraculous.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemOliveLeaves extends ItemBlock
{
    public ItemOliveLeaves(Block block)
    {
        super(block);
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage | 4;
    }
}
