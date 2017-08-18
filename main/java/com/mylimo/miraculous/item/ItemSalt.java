package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;


public class ItemSalt extends Item
{
    public ItemSalt()
    {
        ItemMiraculous.registerItem(Reference.SALT, this);

        this.setMaxStackSize(64);
    }
}
