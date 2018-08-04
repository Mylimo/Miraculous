package com.mylimo.miraculous.init;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.tileentity.TileEntityMagicBowl;
import com.mylimo.miraculous.tileentity.TileEntityMagicStand;
import com.mylimo.miraculous.tileentity.TileEntityMagicStandOld;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities
{
    public static void  init()
    {
        registerTileEntity(TileEntityMagicBowl.class, Reference.MAGIC_BOWL_TE);
        registerTileEntity(TileEntityMagicStand.class, Reference.MAGIC_STAND_TE);
    }

    private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String tileEntityName)
    {
        GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation("miraculous", tileEntityName));
    }
}
