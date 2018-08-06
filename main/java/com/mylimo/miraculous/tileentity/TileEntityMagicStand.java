package com.mylimo.miraculous.tileentity;


import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityMagicStand extends TileEntity implements ICapabilityProvider
{
    private ItemStackHandler itemStackHandler;

    public TileEntityMagicStand()
    {
        this.itemStackHandler = new ItemStackHandler(1);
    }

    public TileEntityMagicStand(ItemStack displayItem)
    {
        this.itemStackHandler = new ItemStackHandler(1);
        this.itemStackHandler.setStackInSlot(0, displayItem);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        if (capability.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY))
        {
            return (T) this.itemStackHandler;
        }

        return super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        if (capability.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY))
        {
            return true;
        }

        return super.hasCapability(capability, facing);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        this.itemStackHandler.deserializeNBT(compound.getCompoundTag("ItemStackHandler"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        compound.setTag("ItemStackHandler", this.itemStackHandler.serializeNBT());

        return compound;
    }


    @Override
    public NBTTagCompound getUpdateTag()
    {
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public void handleUpdateTag(NBTTagCompound compound)
    {
        readFromNBT(compound);
    }


}
