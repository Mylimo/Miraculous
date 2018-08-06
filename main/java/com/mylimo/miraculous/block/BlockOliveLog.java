package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockOliveLog extends net.minecraft.block.BlockRotatedPillar
{
    public static final PropertyEnum<BlockOliveLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockOliveLog.EnumAxis>create("axis", BlockOliveLog.EnumAxis.class);

    public BlockOliveLog()
    {
        super(Material.WOOD);

        BlockMiraculous.registerBlock(Reference.OLIVE_LOG, this);

        this.setHardness(2.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.WOOD);
        this.setHarvestLevel("axe", 1);

        Blocks.FIRE.setFireInfo(this, 5, 5);

        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));

    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] { LOG_AXIS});
    }


    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(LOG_AXIS).ordinal();
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.values()[meta]);
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = 4;
        int j = 5;

        if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5)))
        {
            for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4)))
            {
                IBlockState iblockstate = worldIn.getBlockState(blockpos);

                if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos))
                {
                    iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
                }
            }
        }
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getStateFromMeta(meta).withProperty(LOG_AXIS, BlockOliveLog.EnumAxis.fromFacingAxis(facing.getAxis()));
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        switch (rot)
        {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:

                switch ((BlockOliveLog.EnumAxis)state.getValue(LOG_AXIS))
                {
                    case X:
                        return state.withProperty(LOG_AXIS, BlockOliveLog.EnumAxis.Z);
                    case Z:
                        return state.withProperty(LOG_AXIS, BlockOliveLog.EnumAxis.X);
                    default:
                        return state;
                }

            default:
                return state;
        }
    }

    @Override public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos){ return true; }
    @Override public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos){ return true; }

    public enum EnumAxis implements IStringSerializable
    {
        X("x"),
        Y("y"),
        Z("z"),
        NONE("none");

        private final String name;

        EnumAxis(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }

        public static BlockOliveLog.EnumAxis fromFacingAxis(EnumFacing.Axis axis)
        {
            switch (axis)
            {
                case X:
                    return X;
                case Y:
                    return Y;
                case Z:
                    return Z;
                default:
                    return NONE;
            }
        }

        public String getName()
        {
            return this.name;
        }
    }
}

