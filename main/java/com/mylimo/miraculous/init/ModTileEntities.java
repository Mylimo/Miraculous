package com.mylimo.miraculous.init;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.tileentity.TileEntityMagicBowl;
import com.mylimo.miraculous.tileentity.TileEntityMagicStand;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities
{
    public static void  init()
    {
        registerTileEntity(TileEntityMagicBowl.class, Reference.TE_MAGIC_BOWL);
        registerTileEntity(TileEntityMagicStand.class, Reference.TE_MAGIC_STAND);
    }

    private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String tileEntityName)
    {
        GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation(Reference.MOD_ID, tileEntityName));
    }
}
