package com.mylimo.miraculous.world;

import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class StructureOliveTree
{

    public static void generateStructure(BlockPos pos, World world)
    {
        final ResourceLocation TREE_CENTER_ID = new ResourceLocation("miraculous","olivetree/treecenter");
        final ResourceLocation TREETRUNK_SHORT_ID = new ResourceLocation("miraculous","olivetree/treetrunkshort");
        final ResourceLocation TREETRUNK_LONG_ID = new ResourceLocation("miraculous","olivetree/treetrunklong");
        final ResourceLocation TREETRUNK_NEXT_ID = new ResourceLocation("miraculous","olivetree/treetrunknext");
        final ResourceLocation TREETOP_LOW_ID = new ResourceLocation("miraculous","olivetree/treetoplow");
        final ResourceLocation TREETOP_HIGH_ID = new ResourceLocation("miraculous","olivetree/treetophigh");
        final ResourceLocation TREETOP_NEXT_ID = new ResourceLocation("miraculous","olivetree/treetopnext");

        WorldServer worldServer = (WorldServer) world;
        MinecraftServer minecraftServer = world.getMinecraftServer();
        TemplateManager templateManager = worldServer.getStructureTemplateManager();

        Template treeCenter = templateManager.getTemplate(minecraftServer, TREE_CENTER_ID);
        Template treetrunkShort = templateManager.getTemplate(minecraftServer, TREETRUNK_SHORT_ID);
        Template treetrunkLong = templateManager.getTemplate(minecraftServer, TREETRUNK_LONG_ID);
        Template treetrunkNext = templateManager.getTemplate(minecraftServer, TREETRUNK_NEXT_ID);
        Template treetopLow = templateManager.getTemplate(minecraftServer, TREETOP_LOW_ID);
        Template treetopHigh = templateManager.getTemplate(minecraftServer, TREETOP_HIGH_ID);
        Template treetopNext = templateManager.getTemplate(minecraftServer, TREETOP_NEXT_ID);

        PlacementSettings base = new PlacementSettings().setReplacedBlock(Blocks.AIR);
        PlacementSettings rightUp = new PlacementSettings().setReplacedBlock(Blocks.AIR);
        PlacementSettings rightDown = new PlacementSettings().setRotation(Rotation.CLOCKWISE_90).setReplacedBlock(Blocks.AIR);
        PlacementSettings leftDown = new PlacementSettings().setRotation(Rotation.CLOCKWISE_180).setReplacedBlock(Blocks.AIR);
        PlacementSettings leftUp = new PlacementSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setReplacedBlock(Blocks.AIR);

        IBlockState iBlockState = world.getBlockState(pos);
        world.notifyBlockUpdate(pos, iBlockState, iBlockState, 3);

        int[] randomTrunk = getRandomTreetrunk();
        int[] randomTop = getRandomTreetop();

        treeCenter.addBlocksToWorld(world, pos, base);

        switch (randomTrunk[0])
        {
            case 0: treetrunkShort.addBlocksToWorld(world, pos.add(1, 0, 0), rightUp); break;
            case 1: treetrunkLong.addBlocksToWorld(world, pos.add(1, 0, 0), rightUp); break;
            case 2: treetrunkNext.addBlocksToWorld(world, pos.add(1, 0, 0), rightUp); break;
        }
        switch (randomTrunk[1])
        {
            case 0: treetrunkShort.addBlocksToWorld(world, pos.add(0, 0, 1), rightDown); break;
            case 1: treetrunkLong.addBlocksToWorld(world, pos.add(0, 0, 1), rightDown); break;
            case 2: treetrunkNext.addBlocksToWorld(world, pos.add(0, 0, 1), rightDown); break;
        }
        switch (randomTrunk[2])
        {
            case 0: treetrunkShort.addBlocksToWorld(world, pos.add(-1, 0, 0), leftDown); break;
            case 1: treetrunkLong.addBlocksToWorld(world, pos.add(-1, 0, 0), leftDown); break;
            case 2: treetrunkNext.addBlocksToWorld(world, pos.add(-1, 0, 0), leftDown); break;
        }
        switch (randomTrunk[3])
        {
            case 0: treetrunkShort.addBlocksToWorld(world, pos.add(0, 0, -1), leftUp); break;
            case 1: treetrunkLong.addBlocksToWorld(world, pos.add(0, 0, -1), leftUp); break;
            case 2: treetrunkNext.addBlocksToWorld(world, pos.add(0, 0, -1), leftUp); break;
        }

        switch (randomTop[0])
        {
            case 0: treetopLow.addBlocksToWorld(world, pos.add(1, 3, 0), rightUp); break;
            case 1: treetopHigh.addBlocksToWorld(world, pos.add(1, 3, 0), rightUp); break;
            case 2: treetopNext.addBlocksToWorld(world, pos.add(1, 3, 0), rightUp); break;
        }
        switch (randomTop[1])
        {
            case 0: treetopLow.addBlocksToWorld(world, pos.add(0, 3, 1), rightDown); break;
            case 1: treetopHigh.addBlocksToWorld(world, pos.add(0, 3, 1), rightDown); break;
            case 2: treetopNext.addBlocksToWorld(world, pos.add(0, 3, 1), rightDown); break;
        }
        switch (randomTop[2])
        {
            case 0: treetopLow.addBlocksToWorld(world, pos.add(-1, 3, 0), leftDown); break;
            case 1: treetopHigh.addBlocksToWorld(world, pos.add(-1, 3, 0), leftDown); break;
            case 2: treetopNext.addBlocksToWorld(world, pos.add(-1, 3, 0), leftDown); break;
        }
        switch (randomTop[3])
        {
            case 0: treetopLow.addBlocksToWorld(world, pos.add(0, 3, -1), leftUp); break;
            case 1: treetopHigh.addBlocksToWorld(world, pos.add(0, 3, -1), leftUp); break;
            case 2: treetopNext.addBlocksToWorld(world, pos.add(0, 3, -1), leftUp); break;
        }
    }


    private static int[] getRandomTreetrunk()
    {
        Random rand = new Random();

        int rightUp = (rand.nextDouble() <= 0.25D) ? 1 : 0;
        int rightDown = (rand.nextDouble() <= 0.25D) ? 1 : 0;
        int leftDown = (rand.nextDouble() <= 0.25D) ? 1 : 0;
        int leftUp = (rand.nextDouble() <= 0.25D) ? 1 : 0;

        if (rightUp == 1 && rand.nextDouble() <= 0.75D)
        {
            leftUp = 2;
        }
        else if (rightDown == 1 && rand.nextDouble() <= 0.75D)
        {
            rightUp = 2;
        }
        else if (leftDown == 1 && rand.nextDouble() <= 0.75D)
        {
            rightDown = 2;
        }
        else if (leftUp == 1 && rand.nextDouble() <= 0.75D)
        {
            leftDown = 2;
        }

        //System.out.println("trunk: " + rightUp + rightDown + leftDown + leftUp);
        return new int[]{rightUp, rightDown, leftDown, leftUp};
    }

    private static int[] getRandomTreetop()
    {
        Random rand = new Random();

        int rightUp = (rand.nextDouble() <= 0.50D) ? 1 : 0;
        int rightDown = (rand.nextDouble() <= 0.50D) ? 1 : 0;
        int leftDown = (rand.nextDouble() <= 0.50D) ? 1 : 0;
        int leftUp = (rand.nextDouble() <= 0.50D) ? 1 : 0;

        if (rightUp == 1)
        {
            leftUp = 2;
        }
        else if (rightDown == 1)
        {
            rightUp = 2;
        }
        else if (leftDown == 1)
        {
            rightDown = 2;
        }
        else if (leftUp == 1)
        {
            leftDown = 2;
        }

        //System.out.println("tree: " + rightUp + rightDown + leftDown + leftUp);
        return new int[]{rightUp, rightDown, leftDown, leftUp};
    }

    public static boolean hasSpace(World world, BlockPos pos)
    {
        checker:
        for (int Y = pos.getY() + 1; Y <= pos.getY() + 7; Y++)
        {
            if (Y != pos.getY() + 7)
            {
                for (int X = pos.getX() - 4; X <= pos.getX() + 4; X++)
                {
                    for (int Z = pos.getZ() - 4; Z <= pos.getZ() + 4; Z++)
                    {
                        if (!isAir(world, new BlockPos(X, Y, Z))) {
                            break checker;
                        }
                    }
                }
            }
            else
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isAir(World world, BlockPos pos)
    {
        IBlockState blockState = world.getBlockState(pos);
        return blockState.getBlock()instanceof BlockAir || blockState.getBlock()instanceof BlockTallGrass;
    }
}
