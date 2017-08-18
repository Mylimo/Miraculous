package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.ItemFood;

public class ItemOliveCracker extends ItemFood

{
    public ItemOliveCracker()
    {
        super(3, false);

        ItemMiraculous.registerItem(Reference.OLIVE_CRACKER, this);

        setMaxStackSize(64);

    }

}
