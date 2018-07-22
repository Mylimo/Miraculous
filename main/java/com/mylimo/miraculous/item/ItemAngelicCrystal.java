package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;

public class ItemAngelicCrystal extends Item
{
    public ItemAngelicCrystal()
    {
        ItemMiraculous.registerItem(Reference.ANGELIC_CRYSTAL, this);

        this.setMaxStackSize(64);
    }
}
