package com.mylimo.miraculous.tileentity;

import com.mylimo.miraculous.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMagicStandOld extends TileEntity implements IInventory
{
    private ItemStack displayItem;

    public TileEntityMagicStandOld()
    {
        this.displayItem = ItemStack.EMPTY;
    }

    public TileEntityMagicStandOld(ItemStack displayItem)
    {
        this.displayItem = displayItem;
    }


    @Override
    public int getSizeInventory()
    {
        return 1;
    }

    @Override
    public boolean isEmpty()
    {
        return displayItem.isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int index)
    {
        return displayItem;
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        ItemStack decreasedStack = displayItem;
        displayItem = ItemStack.EMPTY;
        return decreasedStack;
    }

    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        ItemStack removedStack = displayItem;
        displayItem = ItemStack.EMPTY;
        return removedStack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        displayItem = stack;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 1;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return false;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {

    }

    @Override
    public void closeInventory(EntityPlayer player)
    {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 0)
        {
            return true;
        }
        else return false;
    }

    @Override
    public int getField(int id)
    {
        return 0;
    }

    @Override
    public void setField(int id, int value)
    {

    }

    @Override
    public int getFieldCount()
    {
        return 0;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public String getName()
    {
        return Reference.MAGIC_STAND_TE;
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }

    @Override
    public boolean hasFastRenderer()
    {
        return true;
    }
}
