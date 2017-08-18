package com.mylimo.miraculous.init;

import com.mylimo.miraculous.potion.PotionHolyOil;
import com.mylimo.miraculous.potion.PotionHolyWater;

public class ModPotions
{
    public static PotionHolyOil HOLY_OIL;
    public static PotionHolyWater HOLY_WATER;

    public static void init()
    {
        HOLY_OIL = new PotionHolyOil();
        HOLY_WATER = new PotionHolyWater();
    }

}
