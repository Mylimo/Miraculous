package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup extends ItemGroup
{
    public ModItemGroup(String label)
    {
        super(Reference.MOD_ID);
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(Blocks.CARVED_PUMPKIN);
    }
}
