package com.mylimo.miraculous.block;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.helper.TileEntityHelper;
import com.mylimo.miraculous.init.ModBlocks;
import com.mylimo.miraculous.init.ModItems;
import com.mylimo.miraculous.recipe.RecipeBowlMagicRegistry;
import com.mylimo.miraculous.tileentity.TileEntityMagicBowl;
import com.mylimo.miraculous.tileentity.TileEntityMagicStand;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
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

            if (!heldItem.isEmpty() && !heldItem.getItem().equals(ModItems.ROSARY))
            {
                for (int slot = 0; slot < 3; slot++)
                {
                    if (itemHandler.getStackInSlot(slot).isEmpty())
                    {
                        itemHandler.insertItem(slot, heldItem,false);
                        world.markChunkDirty(pos, tileMagicBowl);
                        player.getHeldItem(hand).shrink(1);
                        world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, pos.getX() + 0.5D, pos.getY() + 0.2D, pos.getZ() + 0.5D,0.0D, 0.01D, 0.0D);

                        return true;
                    }
                }
            }
            else if (heldItem.getItem().equals(ModItems.ROSARY) && isValidAltar(world, pos))
            {
                BlockPos magicStandPos = pos;
                switch (getAltarOrientation(world, pos))
                {
                    case 0: magicStandPos = pos.north(); break;
                    case 1: magicStandPos = pos.east(); break;
                    case 2: magicStandPos = pos.south(); break;
                    case 3: magicStandPos = pos.west(); break;
                }

                boolean isAngelicAltar = true;
                switch (getAltarType(world, pos))
                {
                    case 0: isAngelicAltar = true; break;
                    case 1: isAngelicAltar = false; break;
                }

                TileEntityMagicStand tileMagicStand = TileEntityHelper.getSafeCastTile(world, magicStandPos, TileEntityMagicStand.class);
                IItemHandler itemHandlerStand = tileMagicStand.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, enumFacing);

                ItemStack output = RecipeBowlMagicRegistry.getOutput(isAngelicAltar, itemHandler.getStackInSlot(0), itemHandler.getStackInSlot(1), itemHandler.getStackInSlot(2),itemHandlerStand.getStackInSlot(0));

                if (!output.isEmpty())
                {
                    itemHandler.extractItem(0,1,false);
                    itemHandler.extractItem(1,1,false);
                    itemHandler.extractItem(2,1,false);
                    itemHandlerStand.extractItem(0,1,false);
                    itemHandlerStand.insertItem(0,output,false);
                    heldItem.damageItem(1, player);
                    world.markChunkDirty(magicStandPos, tileMagicStand);

                    world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, pos.getX() + 0.5D, pos.getY() + 0.2D, pos.getZ() + 0.5D,0.0D, 0.01D, 0.0D);
                    world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, magicStandPos.getX() + 0.5D,magicStandPos.getY() + 0.5D, magicStandPos.getZ() + 0.5D, 0.0D, 0.01D, 0.0D);
                    world.playSound(player, pos, SoundEvents.ENTITY_FIREWORK_BLAST, SoundCategory.BLOCKS, 3.0f, -1.0f);
                }

                return true;
            }
            else
            {
                for (int slot = 2; slot >= 0; slot--)
                {
                    if (!itemHandler.getStackInSlot(slot).isEmpty() && player.isSneaking())
                    {
                        player.inventory.addItemStackToInventory(itemHandler.extractItem(slot,1,true));
                        itemHandler.extractItem(slot,1,false);
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

    private boolean isValidAltar(World world, BlockPos pos)
    {
        boolean isValid = true;
        Block altarBlock = null;
        if (getAltarType(world, pos) == 0) altarBlock = Blocks.END_BRICKS;
        if (getAltarType(world, pos) == 1) altarBlock = Blocks.RED_NETHER_BRICK;
        if (getAltarType(world, pos) == 2) isValid = false;

        switch (getAltarOrientation(world, pos))
        {
            case 0:
            {
                if (!world.getBlockState(pos.down().west()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().north().west()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().east()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().north().east()).getBlock().equals(altarBlock)) isValid = false;

                if (!world.getBlockState(pos.north().west()).getBlock().equals(ModBlocks.OLIVE_OIL_TORCH)) isValid = false;
                if (!world.getBlockState(pos.north().east()).getBlock().equals(ModBlocks.OLIVE_OIL_TORCH)) isValid = false;

                break;
            }
            case 1:
            {
                if (!world.getBlockState(pos.down().north()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().east().north()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().south()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().east().south()).getBlock().equals(altarBlock)) isValid = false;

                if (!world.getBlockState(pos.east().north()).getBlock().equals(ModBlocks.OLIVE_OIL_TORCH)) isValid = false;
                if (!world.getBlockState(pos.east().south()).getBlock().equals(ModBlocks.OLIVE_OIL_TORCH)) isValid = false;

                break;
            }
            case 2:
            {
                if (!world.getBlockState(pos.down().east()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().south().east()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().west()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().south().west()).getBlock().equals(altarBlock)) isValid = false;

                if (!world.getBlockState(pos.south().east()).getBlock().equals(ModBlocks.OLIVE_OIL_TORCH)) isValid = false;
                if (!world.getBlockState(pos.south().west()).getBlock().equals(ModBlocks.OLIVE_OIL_TORCH)) isValid = false;

                break;
            }
            case 3:
            {
                if (!world.getBlockState(pos.down().south()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().west().south()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().north()).getBlock().equals(altarBlock)) isValid = false;
                if (!world.getBlockState(pos.down().west().north()).getBlock().equals(altarBlock)) isValid = false;

                if (!world.getBlockState(pos.west().south()).getBlock().equals(ModBlocks.OLIVE_OIL_TORCH)) isValid = false;
                if (!world.getBlockState(pos.west().north()).getBlock().equals(ModBlocks.OLIVE_OIL_TORCH)) isValid = false;

                break;
            }

            case 4:
            {
                isValid = false;
                break;
            }
            default:
            {
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    private byte getAltarOrientation(World world, BlockPos pos)
    {
        if (world.getBlockState(pos.north()).getBlock().equals(ModBlocks.MAGIC_STAND)) return 0;
        if (world.getBlockState(pos.east()).getBlock().equals(ModBlocks.MAGIC_STAND)) return 1;
        if (world.getBlockState(pos.south()).getBlock().equals(ModBlocks.MAGIC_STAND)) return 2;
        if (world.getBlockState(pos.west()).getBlock().equals(ModBlocks.MAGIC_STAND)) return 3;
        else return 4;
    }

    private byte getAltarType(World world, BlockPos pos)
    {
        if (world.getBlockState(pos.down()).getBlock().equals(Blocks.END_BRICKS))return 0;
        if (world.getBlockState(pos.down()).getBlock().equals(Blocks.RED_NETHER_BRICK))return 1;
        else return 2;
    }


}
