package com.mylimo.miraculous.init;

import com.mylimo.miraculous.recipe.RecipeBowlMagicRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
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
        final ItemStack glassShards = new ItemStack(ModItems.GLASS_SHARDS);
        final ItemStack groundCoal = new ItemStack(ModItems.GROUND_COAL);
        final ItemStack diamond = new ItemStack(Items.DIAMOND);
        final ItemStack end_gem = new ItemStack(ModItems.END_GEM);
        final ItemStack ironIngot = new ItemStack(Items.IRON_INGOT);
        final ItemStack nether_ingot = new ItemStack(ModItems.NETHER_INGOT);

        //Furnace Recipes
        GameRegistry.addSmelting(ModBlocks.OLIVE_LEAVES, ash, 0.1F);
        GameRegistry.addSmelting(ModBlocks.SALT_ORE, salt, 0.2F);
        GameRegistry.addSmelting(ModBlocks.OLIVE_LOG, coal, 0.15F );

        //Brewing
        BrewingRecipeRegistry.addRecipe(flask, olive, holyOil);
        BrewingRecipeRegistry.addRecipe(flask, oliveSapling, holyWater);

        //BowlMagic
        RecipeBowlMagicRegistry.addRecipe(true, glassShards, groundCoal, salt,diamond,end_gem);
        RecipeBowlMagicRegistry.addRecipe(false, glassShards, groundCoal,ash, ironIngot, nether_ingot);
    }
}
