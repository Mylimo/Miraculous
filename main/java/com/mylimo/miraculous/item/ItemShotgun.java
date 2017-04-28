package com.mylimo.miraculous.item;

import com.mylimo.miraculous.reference.Reference;


public class ItemShotgun extends ItemMiraculous
{
    public ItemShotgun()
    {
        super(Reference.SHOTGUN);

        this.setMaxStackSize(1);
        this.setMaxDamage(2);
    }
}
