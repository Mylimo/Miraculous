package com.mylimo.miraculous.item;

import com.mylimo.miraculous.creativetab.CreativeTab;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemMiraculous extends Item
{
    public ItemMiraculous(String name)
    {
        registerItem(name, this);
    }

    public static void registerItem(String name, Item item)
    {
        item.setRegistryName(name);
        item.setCreativeTab(CreativeTab.MIRACULOUS_TAB);
        item.setUnlocalizedName(name);
        GameRegistry.register(item);
    }
}
