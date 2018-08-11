package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemEndGem extends Item
{
    public ItemEndGem()
    {
        ItemMiraculous.registerItem(Reference.END_GEM, this);

        this.setMaxStackSize(64);
    }
}
