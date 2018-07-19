package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemGlassShards extends Item
{
    public ItemGlassShards()
    {
        ItemMiraculous.registerItem(Reference.GLASS_SHARDS, this);

        this.setMaxStackSize(64);
    }
}
