package com.mylimo.miraculous.item;

import com.mylimo.miraculous.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSaltShotShell extends ItemMiraculous
{
    public ItemSaltShotShell()
    {
        super(Reference.SALT_SHOT_SHELL);

        this.setMaxStackSize(16);
    }

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        //Shell Refill Code goes here

        return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
    }

}
