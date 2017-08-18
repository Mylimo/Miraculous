package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.ItemFood;

public class ItemOliveBread extends ItemFood

{
    public ItemOliveBread()
    {
        super(5, false);

        ItemMiraculous.registerItem(Reference.OLIVE_BREAD, this);

        setMaxStackSize(64);

    }

}
