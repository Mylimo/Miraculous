package com.mylimo.miraculous.init;

import com.mylimo.miraculous.block.*;

public class ModBlocks
{
    public static BlockSaltOre SALT_ORE;
    public static BlockSaltBlock SALT_BLOCK;
    public static BlockAshBlock ASH_BLOCK;
    public static BlockOliveLog OLIVE_LOG;
    public static BlockOliveLeaves OLIVE_LEAVES;
    public static BlockOliveSapling OLIVE_SAPLING;
    public static BlockOlivePlanks OLIVE_PLANKS;

    public static void init()
    {
        SALT_ORE = new BlockSaltOre();
        SALT_BLOCK = new BlockSaltBlock();
        ASH_BLOCK = new BlockAshBlock();
        OLIVE_LOG = new BlockOliveLog();
        OLIVE_LEAVES = new BlockOliveLeaves();
        OLIVE_SAPLING = new BlockOliveSapling();
        OLIVE_PLANKS = new BlockOlivePlanks();
    }
}
