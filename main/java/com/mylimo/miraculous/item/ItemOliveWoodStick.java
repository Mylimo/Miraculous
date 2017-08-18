package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemOliveWoodStick extends Item
{
    public ItemOliveWoodStick()
    {
        ItemMiraculous.registerItem(Reference.OLIVE_WOOD_STICK, this);

        setMaxStackSize(64);
    }

}
