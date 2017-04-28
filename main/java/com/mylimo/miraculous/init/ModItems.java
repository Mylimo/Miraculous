package com.mylimo.miraculous.init;

import com.mylimo.miraculous.item.ItemSalt;
import com.mylimo.miraculous.item.ItemSaltShotShell;
import com.mylimo.miraculous.item.ItemShotgun;

public class ModItems
{
    public static ItemSalt SALT;
    public static ItemSaltShotShell SALT_SHOT_SHELL;
    public static ItemShotgun SHOTGUN;

    public static void init()
    {
        SALT = new ItemSalt();
        SALT_SHOT_SHELL = new ItemSaltShotShell();
        SHOTGUN = new ItemShotgun();
    }
}
