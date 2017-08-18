package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.ItemFood;

public class ItemSaltyCracker extends ItemFood

{
    public ItemSaltyCracker()
    {
        super(2, false);

        ItemMiraculous.registerItem(Reference.SALTY_CRACKER, this);

        setMaxStackSize(64);

    }

}
