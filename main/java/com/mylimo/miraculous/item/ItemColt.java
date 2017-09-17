package com.mylimo.miraculous.item;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.entity.EntityBullet;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemColt extends Item
{
    public ItemColt()
    {
        ItemMiraculous.registerItem(Reference.COLT, this);

        this.setMaxStackSize(1);
        this.setMaxDamage(384);
    }

    public void onUpdate(ItemStack itemStack, World world, Entity entity, int itemSlot, boolean isSelected)
    {
        if (!itemStack.hasTagCompound())
        {
            itemStack.setTagCompound(new NBTTagCompound());
            itemStack.getTagCompound().setString("bulletType", "Empty");
            itemStack.getTagCompound().setInteger("bulletAmount", 0);
        }
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced)
    {
        if (itemStack.hasTagCompound())
        {
            String Color1;
            String Color2;

            switch (itemStack.getTagCompound().getString("bulletType"))
            {
                case "Iron":
                    Color1 = "\u00A71";
                    break;
                default:
                    Color1 = "\u00A7f";
            }
            tooltip.add(Color1 + "Bullet Type: " + itemStack.getTagCompound().getString("bulletType"));

            switch (itemStack.getTagCompound().getInteger("bulletAmount"))
            {
                case 0:
                    Color2 = "\u00A7c";
                    break;
                case 1:
                    Color2 = "\u00A7e";
                    break;
                case 2:
                    Color2 = "\u00A7e";
                    break;
                case 3:
                    Color2 = "\u00A7a";
                    break;
                case 4:
                    Color2 = "\u00A7a";
                    break;
                case 5:
                    Color2 = "\u00A7a";
                    break;
                case 6:
                    Color2 = "\u00A7a";
                    break;
                default:
                    Color2 = "\u00A7f";
            }
            tooltip.add(Color2 + "Bullet Amount: " + itemStack.getTagCompound().getInteger("bulletAmount"));
        }
    }

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack colt = player.getHeldItem(hand);

        if (colt.getItem() instanceof ItemColt)
        {
            int bulletAmount = colt.getTagCompound().getInteger("bulletAmount");
            if (bulletAmount == 0)
            {
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
            }
            else if (bulletAmount == 1)
            {
                shoot(world, player, colt);
                colt.getTagCompound().setInteger("bulletAmount", 0);
                colt.getTagCompound().setString("bulletType", "Empty");
                world.playSound(player, player.getPosition(), SoundEvents.ENTITY_FIREWORK_LARGE_BLAST, SoundCategory.PLAYERS, 3.0F, 1.0F);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
            }
            else
            {
                shoot(world, player, colt);
                colt.getTagCompound().setInteger("bulletAmount", bulletAmount - 1);
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
                itemStack.damageItem(1, player );
                EntityBullet entityBullet = new EntityBullet(world, player);
                entityBullet.readFromNBT(itemStack.getTagCompound());
                entityBullet.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 5.0F, 0.1F);
                world.spawnEntity(entityBullet);

        }
    }
}
