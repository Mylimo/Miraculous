package com.mylimo.miraculous.item;

import com.mylimo.miraculous.creativetab.CreativeTab;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemMiraculous extends Item
{
    public ItemMiraculous(String name)
    {
        registerItem(name, this);
    }

    public ItemMiraculous(String name, boolean setCreativeTab)
    {
        registerItem(name, this, setCreativeTab);
    }


    public static void registerItem(String name, Item item)
    {
        item.setRegistryName(name);
        item.setUnlocalizedName(name);
        item.setCreativeTab(CreativeTab.MIRACULOUS_TAB);

        ForgeRegistries.ITEMS.register(item);
    }

    public static void registerItem(String name, Item item, boolean setCreativeTab)
    {

        item.setRegistryName(name);
        item.setUnlocalizedName(name);

        ForgeRegistries.ITEMS.register(item);
    }


}
