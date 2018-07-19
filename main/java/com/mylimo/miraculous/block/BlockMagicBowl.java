package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMagicBowl extends Block
{
    public static final PropertyEnum<BlockMagicBowl.EnumIngredient> INGREDIENT = PropertyEnum.create("ingredient", BlockMagicBowl.EnumIngredient.class);
    public static final AxisAlignedBB AABB = new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.25D, 0.8125D);

    public BlockMagicBowl()
    {
        super(Material.WOOD);

        BlockMiraculous.registerBlock(Reference.MAGIC_BOWL, this);

        this.setHardness(2.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.WOOD);
        this.setHarvestLevel("axe", 1);
    }

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

    public boolean onBlockActivated(World world, BlockPos blockPos, IBlockState iBlockState, EntityPlayer player, EnumHand enumHand, EnumFacing enumFacing, float hitX, float hitY, float hitZ)
    {
        world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, blockPos.getX() + 0.5D, blockPos.getY() + 0.2D, blockPos.getZ() + 0.5D,0.0D, 0.01D, 0.0D);
        return false;
    }

    public static enum EnumIngredient implements IStringSerializable
    {
        EMPTY("empty"),
        EXECUTOR("executer"),
        POWER("power"),
        DEFINER("definer");

        private final String name;

        private EnumIngredient(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }

        public String getName()
        {
            return this.name;
        }
    }
}
