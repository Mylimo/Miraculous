package com.mylimo.miraculous;


import com.mylimo.miraculous.item.ModItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Reference.MOD_ID)
public class Miraculous
{
    public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);

    public static final ItemGroup MIRACULOUS = new ModItemGroup(Reference.MOD_ID);

    public static Miraculous instance;

    public Miraculous()
    {
        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::preInit);
    }

    public void preInit(final FMLCommonSetupEvent event)
    {

    }
}
