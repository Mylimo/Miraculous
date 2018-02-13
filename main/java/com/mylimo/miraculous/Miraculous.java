package com.mylimo.miraculous;

import com.mylimo.miraculous.init.*;
import com.mylimo.miraculous.proxy.CommonProxy;
import com.mylimo.miraculous.world.WorldGenMiraculous;
import com.mylimo.miraculous.world.WorldGenOliveTree;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;



@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME,version = Reference.MOD_VERSION)

public class Miraculous
{

    @Mod.Instance(Reference.MOD_ID)
    public static Miraculous instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.init(event);
        ModBlocks.init();
        ModEntities.init();
        ModTileEntities.init();

        ModPotions.init();

        proxy.registerModels();


    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent event)
    {
        ModRecipes.init();

        GameRegistry.registerWorldGenerator(new WorldGenMiraculous(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenOliveTree(), 0);

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.registerRenders();
    }
}
