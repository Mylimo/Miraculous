package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemFlask extends Item
{
    public ItemFlask()
    {
        ItemMiraculous.registerItem(Reference.FLASK, this);

        this.setMaxStackSize(1);
    }
}
