package com.mylimo.miraculous.item;

import com.mylimo.miraculous.entity.EntityShot;
import com.mylimo.miraculous.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemShotgun extends Item
{
    public ItemShotgun()
    {
        ItemMiraculous.registerItem(Reference.SHOTGUN, this);

        this.setMaxStackSize(1);
        this.setMaxDamage(384);
    }

    public void onUpdate(ItemStack itemStack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
        if (!itemStack.hasTagCompound())
        {
            itemStack.setTagCompound(new NBTTagCompound());
            itemStack.getTagCompound().setString("shotType", "Empty");
            itemStack.getTagCompound().setInteger("shellAmount", 0);
        }
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced)
    {
        if (itemStack.hasTagCompound())
        {
            String Color1;
            String Color2;

            switch (itemStack.getTagCompound().getString("shotType"))
            {
                case "Blaze":
                    Color1 = "\u00A74";
                    break;
                case "Iron":
                    Color1 = "\u00A71";
                    break;
                case "Salt":
                    Color1 = "\u00A72";
                    break;
                case "Ash":
                    Color1 = "\u00A78";
                    break;
                default:
                    Color1 = "\u00A7f";
            }
            tooltip.add(Color1 + "Shot Type: " + itemStack.getTagCompound().getString("shotType"));

            switch (itemStack.getTagCompound().getInteger("shellAmount"))
            {
                case 0:
                    Color2 = "\u00A7c";
                    break;
                case 1:
                    Color2 = "\u00A7e";
                    break;
                case 2:
                    Color2 = "\u00A7a";
                    break;
                default:
                    Color2 = "\u00A7f";
            }
            tooltip.add(Color2 + "Shell Amount: " + itemStack.getTagCompound().getInteger("shellAmount"));
        }
    }


    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack shotgun = player.getHeldItem(hand);

        if (shotgun.getItem() instanceof ItemShotgun)
        {
            switch (shotgun.getTagCompound().getInteger("shellAmount"))
            {
                case 0: return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));

                case 1: shoot(world, player, shotgun);
                        shotgun.getTagCompound().setInteger("shellAmount", 0);
                        shotgun.getTagCompound().setString("shotType", "Empty");
                        world.playSound(player, player.getPosition(), SoundEvents.ENTITY_FIREWORK_LARGE_BLAST, SoundCategory.PLAYERS, 3.0F, 1.0F);
                        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));

                case 2: shoot(world, player, shotgun);
                        shotgun.getTagCompound().setInteger("shellAmount", 1);
                        world.playSound(player, player.getPosition(), SoundEvents.ENTITY_FIREWORK_LARGE_BLAST, SoundCategory.PLAYERS, 3.0F, 1.0F);
                        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
            }
        }

        return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
    }

    private void shoot(World world, EntityPlayer player, ItemStack itemStack)
    {
        if(!world.isRemote)
        {
            for (int i =0; i < 16; i++)
            {
                itemStack.damageItem(1, player);
                EntityShot entityShot = new EntityShot(world, player);
                entityShot.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.5F, 8.0F);
                world.spawnEntity(entityShot);
                entityShot.readFromNBT(itemStack.getTagCompound());
            }
        }
    }

}
