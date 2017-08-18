package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.world.StructureOliveTree;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockOliveSapling extends BlockBush implements IGrowable
{
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);

    public static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

    public BlockOliveSapling()
    {
        BlockMiraculous.registerBlock(Reference.OLIVE_SAPLING, this);

        this.setSoundType(SoundType.PLANT);
        this.setDefaultState(blockState.getBaseState().withProperty(STAGE, 0));
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, STAGE);
    }

    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(STAGE, (meta & 8) >> 3);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int meta = 0;

        meta |= state.getValue(STAGE) << 3;

        return meta;
    }

    @Nonnull
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess access, BlockPos pos)
    {
        return SAPLING_AABB;
    }

    @Override
    public void updateTick(@Nonnull World world,@Nonnull BlockPos pos,@Nonnull IBlockState state, Random rand)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, pos, state, rand);

            if (world.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                grow(world, rand, pos, state);
            }
        }
    }

    @Override
    public void grow(@Nonnull World world,@Nonnull Random rand,@Nonnull BlockPos pos,@Nonnull IBlockState state)
    {
        if (state.getValue(STAGE) == 0)
        {
            world.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            generateTree(world, pos);
        }
    }

    private void generateTree(World world, BlockPos pos)
    {
        if (StructureOliveTree.hasSpace(world, pos))
        {
            StructureOliveTree.generateStructure(pos, world);
        }

    }

    @Override
    public boolean canGrow(@Nonnull World world,@Nonnull BlockPos pos,@Nonnull IBlockState state, boolean isClient)
    {
        return true;
    }

    @Override
    public boolean canUseBonemeal(@Nonnull World world,@Nonnull Random rand,@Nonnull BlockPos pos,@Nonnull IBlockState state)
    {
        return world.rand.nextFloat() < 0.45D;
    }

}
