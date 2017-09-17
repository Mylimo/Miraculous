package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemBlazeShotShell extends Item
{
    public ItemBlazeShotShell()
    {
        ItemMiraculous.registerItem(Reference.BLAZE_SHOT_SHELL, this);

        this.setMaxStackSize(16);
    }

    private int findShotgun(EntityPlayer player)
    {
        for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
        {
            if (player.inventory.getStackInSlot(i).getItem() instanceof ItemShotgun)
            {
                return i;
            }
        }
        return 0;
    }


    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack shell = player.getHeldItem(hand);
        ItemStack shotgun = player.inventory.getStackInSlot(findShotgun(player));

        if (shell.getItem() instanceof ItemBlazeShotShell && (shotgun.getTagCompound().getString("shotType").contentEquals("Blaze") || shotgun.getTagCompound().getString("shotType").contentEquals("Empty")))
        {
            switch (shotgun.getTagCompound().getInteger("shellAmount"))
            {
                case 0: shotgun.getTagCompound().setString("shotType", "Blaze");
                    shotgun.getTagCompound().setInteger("shellAmount", 1);
                    shell.shrink(1);
                    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));

                case 1: shotgun.getTagCompound().setInteger("shellAmount", 2);
                    shell.shrink(1);
                    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));

                case 2: return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
    }

}
