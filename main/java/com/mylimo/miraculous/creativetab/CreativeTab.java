package com.mylimo.miraculous.creativetab;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab
{
    public static final CreativeTabs MIRACULOUS_TAB = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModItems.SHOTGUN);
        }
    };
}
