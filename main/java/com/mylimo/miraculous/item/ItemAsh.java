package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemAsh extends Item
{
    public ItemAsh()
    {
        ItemMiraculous.registerItem(Reference.ASH, this);

        this.setMaxStackSize(64);
    }
}
