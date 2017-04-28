package com.mylimo.miraculous;

import com.mylimo.miraculous.event.EventHandler;
import com.mylimo.miraculous.init.ModBlocks;
import com.mylimo.miraculous.init.ModEntities;
import com.mylimo.miraculous.init.ModItems;
import com.mylimo.miraculous.init.ModRecipes;
import com.mylimo.miraculous.proxy.CommonProxy;
import com.mylimo.miraculous.reference.Reference;
import com.mylimo.miraculous.world.WorldGenMiraculous;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME,version = Reference.MOD_VERSION)

public class Miraculous
{
    EventHandler handler = new EventHandler();

    @Mod.Instance(Reference.MOD_ID)
    public static Miraculous instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.init();
        ModBlocks.init();
        ModRecipes.init();
        ModEntities.init();

        proxy.registerModels();

        MinecraftForge.EVENT_BUS.register(handler);
        FMLCommonHandler.instance().bus().register(handler);
    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent event)
    {
        GameRegistry.registerWorldGenerator(new WorldGenMiraculous(), 0);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.registerRenders();
    }
}
