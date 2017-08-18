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

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack itemStack = player.getHeldItem(hand);

        if (player.capabilities.isCreativeMode)
        {
            return new ActionResult(EnumActionResult.SUCCESS, this.fillRosary(itemStack, player, ModItems.ROSARY_FILLED));
        }
        else
        {
            if (player.experienceLevel >= 4)
            {
                player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                player.addExperienceLevel(-4);
                return new ActionResult(EnumActionResult.SUCCESS, this.fillRosary(itemStack, player, ModItems.ROSARY_FILLED));
            }
            else
            {
                return new ActionResult(EnumActionResult.FAIL, itemStack);
            }
        }
    }

    private ItemStack fillRosary(ItemStack emptyRosary, EntityPlayer player, Item fullRosary)
    {
        emptyRosary.shrink(1);

        if (emptyRosary.isEmpty())
        {
            return new ItemStack(fullRosary);
        }
        else
        {
            if (!player.inventory.addItemStackToInventory(new ItemStack(fullRosary)))
            {
                player.dropItem(new ItemStack(fullRosary), false);
            }

            return emptyRosary;
        }
    }
}
