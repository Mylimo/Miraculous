package com.mylimo.miraculous.helper;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityHelper
{
    public static <T> T getSafeCastTile(World world, BlockPos pos, Class<T> target)
    {
        TileEntity tileEntity = world.getTileEntity(pos);
        try
        {
            return target.cast(tileEntity);
        }
        catch (ClassCastException e)
        {
            return null;
        }
    }
}
