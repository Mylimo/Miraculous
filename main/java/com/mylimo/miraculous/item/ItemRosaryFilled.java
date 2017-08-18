package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRosaryFilled extends Item
{
    public ItemRosaryFilled()
    {
        ItemMiraculous.registerItem(Reference.ROSARY_FILLED, this);

        this.setMaxStackSize(16);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}
