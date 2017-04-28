package com.mylimo.miraculous.block;

import com.mylimo.miraculous.init.ModItems;
import com.mylimo.miraculous.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSaltOre extends BlockMiraculous
{
    public BlockSaltOre()
    {
        super(Material.ROCK ,Reference.SALT_ORE);
        setHardness(1.5F);
        setResistance(8.0F);
        setHarvestLevel("pickaxe", 1);
    }

    public Item getItemDropped(IBlockState state, Random random, int fortune)
    {
        return ModItems.SALT;
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }

    public int quantityDropped(Random random)
    {
        return 4 + random.nextInt(2);
    }

    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        if (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this))
        {
            return 1 + RANDOM.nextInt(5);
        }
        return 0;
    }

}
