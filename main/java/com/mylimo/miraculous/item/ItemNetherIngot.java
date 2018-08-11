package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemNetherIngot extends Item
{
    public ItemNetherIngot()
    {
        ItemMiraculous.registerItem(Reference.NETHER_INGOT, this);

        this.setMaxStackSize(64);
    }
}
