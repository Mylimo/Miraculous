package com.mylimo.miraculous.init;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities
{
    public static void  init()
    {

    }

    private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String tileEntityName)
    {
        GameRegistry.registerTileEntity(tileEntityClass, tileEntityName);
    }
}
