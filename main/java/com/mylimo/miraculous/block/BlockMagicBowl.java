package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.helper.TileEntityHelper;
import com.mylimo.miraculous.tileentity.TileEntityMagicBowl;
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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockMagicBowl extends Block
{
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
        return new TileEntityMagicBowl();
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing enumFacing, float hitX, float hitY, float hitZ)
    {
        TileEntityMagicBowl tileMagicBowl = TileEntityHelper.getSafeCastTile(world, pos, TileEntityMagicBowl.class);
        if (tileMagicBowl != null)
        {
            IItemHandler itemHandler = tileMagicBowl.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, enumFacing);
            ItemStack heldItem = new ItemStack(player.getHeldItem(hand).getItem(), 1, player.getHeldItem(hand).getMetadata());

            if (!heldItem.isEmpty())
            {
                for (int slot = 0; slot < 3; slot++)
                {
                    if (itemHandler.getStackInSlot(slot).isEmpty())
                    {

                        itemHandler.insertItem(slot, heldItem,false);
                        System.out.println(itemHandler.getStackInSlot(slot).getDisplayName() + ": " + slot);
                        world.markChunkDirty(pos, tileMagicBowl);
                        player.getHeldItem(hand).shrink(1);
                        world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, pos.getX() + 0.5D, pos.getY() + 0.2D, pos.getZ() + 0.5D,0.0D, 0.01D, 0.0D);
                        return true;
                    }
                }
            }
            else
            {
                for (int slot = 2; slot >= 0; slot--)
                {
                    if (!itemHandler.getStackInSlot(slot).isEmpty() && player.isSneaking())
                    {
                        player.setHeldItem(hand, itemHandler.extractItem(slot, 1,false));
                        world.markChunkDirty(pos, tileMagicBowl);
                        return true;
                    }
                }
            }
            return false;
        }
        else return false;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntityMagicBowl tileMagicBowl = TileEntityHelper.getSafeCastTile(worldIn, pos, TileEntityMagicBowl.class);
        if (tileMagicBowl != null)
        {
            IItemHandler itemHandler = tileMagicBowl.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

            InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemHandler.extractItem(0,1, false));
            InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemHandler.extractItem(1,1, false));
            InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemHandler.extractItem(2,1, false));
        }
        super.breakBlock(worldIn, pos, state);
    }
}
