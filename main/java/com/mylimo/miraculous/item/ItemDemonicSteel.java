package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemDemonicSteel extends Item
{
    public ItemDemonicSteel()
    {
        ItemMiraculous.registerItem(Reference.DEMONIC_STEEL, this);

        this.setMaxStackSize(64);
    }
}
