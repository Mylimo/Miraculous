package com.mylimo.miraculous.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityMagicBowl extends TileEntity implements ICapabilityProvider
{
    private ItemStackHandler itemStackHandler;

    public TileEntityMagicBowl()
    {
        this.itemStackHandler = new ItemStackHandler(3);
    }

    public TileEntityMagicBowl(ItemStack executor, ItemStack power, ItemStack definer)
    {
        this.itemStackHandler = new ItemStackHandler(NonNullList.from(ItemStack.EMPTY, executor, power, definer));
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
        this.readFromNBT(compound);
    }

}
