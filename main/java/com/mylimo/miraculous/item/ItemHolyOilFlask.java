package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemHolyOilFlask extends Item
{
    public ItemHolyOilFlask()
    {
        ItemMiraculous.registerItem(Reference.HOLY_OIL_FLASK, this);

        this.setMaxStackSize(1);
    }
}
