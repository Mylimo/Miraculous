package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemRosary extends Item
{
    public ItemRosary()
    {
        ItemMiraculous.registerItem(Reference.ROSARY, this);

        this.setMaxStackSize(16);
    }
}
