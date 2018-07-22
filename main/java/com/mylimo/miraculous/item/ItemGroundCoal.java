package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGroundCoal extends Item
{
    public ItemGroundCoal()
    {
        ItemMiraculous.registerItem(Reference.GROUND_COAL, this);

        this.setMaxStackSize(64);
    }

    @Override
    public int getItemBurnTime(ItemStack itemStack)
    {
        return 200;
    }
}
