package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemHolyWaterFlask extends Item
{
    public ItemHolyWaterFlask()
    {
        ItemMiraculous.registerItem(Reference.HOLY_WATER_FLASK, this);

        this.setMaxStackSize(1);
    }
}
