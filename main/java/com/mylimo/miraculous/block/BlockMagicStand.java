package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.helper.TileEntityHelper;
import com.mylimo.miraculous.tileentity.TileEntityMagicStand;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

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

    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return false;
    }


    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityMagicStand(ItemStack.EMPTY);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        TileEntityMagicStand tileMagicStand = TileEntityHelper.getSafeCastTile(worldIn, pos, TileEntityMagicStand.class);
        if (tileMagicStand != null)
        {
            IItemHandler itemHandler = tileMagicStand.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing);

            if (itemHandler.getStackInSlot(0).isEmpty())
            {
                ItemStack heldItem = new ItemStack(playerIn.getHeldItem(hand).getItem(), 1, playerIn.getHeldItem(hand).getMetadata());
                playerIn.getHeldItem(hand).shrink(1);
                itemHandler.insertItem(0, heldItem, false);
                worldIn.markChunkDirty(pos, tileMagicStand);
            }
            else
            {
                playerIn.inventory.addItemStackToInventory(itemHandler.extractItem(0,1,true));
                itemHandler.extractItem(0,1,false);
                worldIn.markChunkDirty(pos, tileMagicStand);
            }
            return true;
        }
        else return false;

    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntityMagicStand tileMagicStand = TileEntityHelper.getSafeCastTile(worldIn, pos, TileEntityMagicStand.class);
        if (tileMagicStand != null)
        {
            IItemHandler itemHandler = tileMagicStand.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

            InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemHandler.extractItem(0,1, false));
        }
        super.breakBlock(worldIn, pos, state);
    }
}
