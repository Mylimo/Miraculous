package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemIronBullet extends Item
{
    public ItemIronBullet()
    {
        ItemMiraculous.registerItem(Reference.IRON_BULLET, this);

        this.setMaxStackSize(64);
    }

    private int findColt(EntityPlayer player)
    {
        for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
        {
            if (player.inventory.getStackInSlot(i).getItem() instanceof ItemColt)
            {
                return i;
            }
        }
        return 0;
    }

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack bullet = player.getHeldItem(hand);
        ItemStack colt = player.inventory.getStackInSlot(findColt(player));

        if (bullet.getItem() instanceof ItemIronBullet && (colt.getTagCompound().getString("bulletType").contentEquals("Iron") || colt.getTagCompound().getString("bulletType").contentEquals("Empty")))
        {
            int bulletAmount = colt.getTagCompound().getInteger("bulletAmount");
            if (bulletAmount == 0)
            {
                colt.getTagCompound().setString("bulletType", "Iron");
                colt.getTagCompound().setInteger("bulletAmount", 1);
                bullet.shrink(1);
                //world.playSound(player, player.getPosition(), SoundEvents.);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
            }
            else if (bulletAmount == 6)
            {
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
            }
            else
            {
                colt.getTagCompound().setInteger("bulletAmount", bulletAmount + 1);
                bullet.shrink(1);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
    }

}
