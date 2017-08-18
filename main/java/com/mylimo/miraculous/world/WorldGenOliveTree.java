package com.mylimo.miraculous.world;

import com.mylimo.miraculous.block.BlockOliveSapling;
import com.mylimo.miraculous.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenOliveTree implements IWorldGenerator
{

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        final int xChunk = chunkX * 16 + 8, zChunk = chunkZ * 16 +8;
        final int xPos = chunkX * 16 + rand.nextInt(16) + 8;
        final int zPos = chunkZ * 16 + rand.nextInt(16) + 8;
        final int yPos = findSurfaceGround(world, xPos, zPos);

        final Biome biome = world.getBiomeForCoordsBody(new BlockPos(xChunk + 16, 0, zChunk +16));
        final BlockPos blockPos = new BlockPos(xPos, yPos, zPos);

        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS) && StructureOliveTree.hasSpace(world, blockPos) && yPos > 60 && rand.nextDouble() <= 0.05D)
        {
            StructureOliveTree.generateStructure(blockPos, world);
        }
    }

    private int findSurfaceGround(World world, int X, int Z)
    {
        int possibleZ = world.getHeight(X, Z);
        IBlockState state = world.getBlockState(new BlockPos(X, possibleZ - 1, Z));
        Block block = state.getBlock();
        if (block == Blocks.GRASS)
        {
            return possibleZ;
        }
        else
        {
            return 0;
        }
    }
}
