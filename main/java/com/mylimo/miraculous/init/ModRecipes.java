package com.mylimo.miraculous.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes
{


    public static void init()
    {
        final ItemStack salt = new ItemStack(ModItems.SALT);
        final ItemStack ash = new ItemStack(ModItems.ASH);
        final ItemStack coal = new ItemStack(Items.COAL, 1, 1);

        final ItemStack flask = new ItemStack(ModItems.FLASK);
        final ItemStack olive = new ItemStack(ModItems.OLIVE);
        final ItemStack holyOil = new ItemStack(ModItems.HOLY_OIL_FLASK);
        final ItemStack oliveSapling = new ItemStack(ModBlocks.OLIVE_SAPLING);
        final ItemStack holyWater = new ItemStack(ModItems.HOLY_WATER_FLASK);

        //Furnace Recipes
        GameRegistry.addSmelting(ModBlocks.OLIVE_LEAVES, ash, 0.1F);
        GameRegistry.addSmelting(ModBlocks.SALT_ORE, salt, 0.2F);
        GameRegistry.addSmelting(ModBlocks.OLIVE_LOG, coal, 0.15F );

        //Brewing
        BrewingRecipeRegistry.addRecipe(flask, olive, holyOil);
        BrewingRecipeRegistry.addRecipe(flask, oliveSapling, holyWater);
    }
}
