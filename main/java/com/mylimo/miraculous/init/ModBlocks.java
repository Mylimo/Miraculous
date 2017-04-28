package com.mylimo.miraculous.init;

import com.mylimo.miraculous.block.BlockSaltOre;

public class ModBlocks
{
    public static BlockSaltOre SALT_ORE;

    public static void init()
    {
        SALT_ORE = new BlockSaltOre();
    }
}
