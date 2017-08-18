package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemShotDummy extends Item

{
    public ItemShotDummy()
    {
        ItemMiraculous.registerItem(Reference.SHOTDUMMY, this, false);
    }
}

