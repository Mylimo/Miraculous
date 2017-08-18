package com.mylimo.miraculous.potion;


import com.mylimo.miraculous.Reference;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class PotionHolyWater extends PotionMiraculous
{
    public PotionHolyWater()
    {
        super(Reference.HOLY_WATER, false, Color.WHITE.getRGB());

        this.setIcon(new ResourceLocation("miraculous:textures/effects/holy_water.png"));
        this.setPotionName("Holy Water");
    }
}
