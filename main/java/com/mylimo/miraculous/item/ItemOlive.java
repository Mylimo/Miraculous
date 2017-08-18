package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.ItemFood;

public class ItemOlive extends ItemFood

{
    public ItemOlive()
    {
        super(1, false);

        ItemMiraculous.registerItem(Reference.OLIVE, this);

        this.setMaxStackSize(64);
    }
}
