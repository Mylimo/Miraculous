package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMagicStand extends Block
{
    public static final AxisAlignedBB AABB = new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.4375D, 0.6875D);

    public BlockMagicStand()
    {
        super(Material.WOOD);

        BlockMiraculous.registerBlock(Reference.MAGIC_STAND, this);

        this.setHardness(2.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.WOOD);
        this.setHarvestLevel("axe", 1);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return AABB;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return this.canBePlacedOn(worldIn, pos.down());
    }

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!this.canBePlacedOn(worldIn, pos.down()))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }

    private boolean canBePlacedOn(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos).isTopSolid() || worldIn.getBlockState(pos).getBlock() instanceof BlockFence;
    }


}
