package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemRosary extends Item
{
    public ItemRosary()
    {
        ItemMiraculous.registerItem(Reference.ROSARY, this);

        this.setMaxStackSize(16);
    }
}
