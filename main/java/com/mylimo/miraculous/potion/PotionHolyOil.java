package com.mylimo.miraculous.potion;

import com.mylimo.miraculous.Reference;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class PotionHolyOil extends PotionMiraculous
{
    public PotionHolyOil()
    {
        super(Reference.HOLY_OIL, true, Color.BLACK.getRGB());

        this.setIcon(new ResourceLocation("miraculous:textures/effects/holy_oil.png"));
        this.setPotionName("Holy Oil");
    }
}
