package com.mylimo.miraculous.init;

import com.mylimo.miraculous.item.*;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModItems
{
    public static ItemShotgun SHOTGUN;
    public static ItemShotDummy SHOTDUMMY;
    public static ItemIronShotShell IRON_SHOT_SHELL;
    public static ItemBlazeShotShell BLAZE_SHOT_SHELL;
    public static ItemSalt SALT;
    public static ItemSaltShotShell SALT_SHOT_SHELL;
    public static ItemAsh ASH;
    public static ItemAshShotShell ASH_SHOT_SHELL;
    public static ItemOlive OLIVE;
    public static ItemOliveWoodStick OLIVE_WOOD_STICK;
    public static ItemOliveBread OLIVE_BREAD;
    public static ItemSaltyCracker SALTY_CRACKER;
    public static ItemOliveCracker OLIVE_CRACKER;
    public static ItemFlask FLASK;
    public static ItemHolyOilFlask HOLY_OIL_FLASK;
    public static ItemHolyWaterFlask HOLY_WATER_FLASK;
    public static ItemRosary ROSARY;
    public static ItemColt COLT;
    public static ItemIronBullet IRON_BULLET;
    public static ItemGlassShards GLASS_SHARDS;
    public static ItemGroundCoal GROUND_COAL;
    public static ItemEndGem END_GEM;
    public static ItemNetherIngot NETHER_INGOT;

    public static void init(FMLPreInitializationEvent event)
    {
        SHOTGUN = new ItemShotgun();
        SHOTDUMMY = new ItemShotDummy();
        IRON_SHOT_SHELL = new ItemIronShotShell();
        BLAZE_SHOT_SHELL = new ItemBlazeShotShell();
        SALT = new ItemSalt();
        SALT_SHOT_SHELL = new ItemSaltShotShell();
        ASH = new ItemAsh();
        ASH_SHOT_SHELL = new ItemAshShotShell();
        OLIVE = new ItemOlive();
        OLIVE_WOOD_STICK = new ItemOliveWoodStick();
        OLIVE_BREAD = new ItemOliveBread();
        SALTY_CRACKER = new ItemSaltyCracker();
        OLIVE_CRACKER = new ItemOliveCracker();
        FLASK = new ItemFlask();
        HOLY_OIL_FLASK = new ItemHolyOilFlask();
        HOLY_WATER_FLASK = new ItemHolyWaterFlask();
        ROSARY = new ItemRosary();
        COLT = new ItemColt();
        IRON_BULLET = new ItemIronBullet();
        GLASS_SHARDS = new ItemGlassShards();
        GROUND_COAL = new ItemGroundCoal();
        END_GEM = new ItemEndGem();
        NETHER_INGOT = new ItemNetherIngot();
    }

}
