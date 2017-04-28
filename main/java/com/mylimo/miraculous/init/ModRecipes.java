package com.mylimo.miraculous.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes
{
    public static void init()
    {
        final ItemStack goldNugget = new ItemStack(Items.GOLD_NUGGET);
        final ItemStack gunpowder = new ItemStack(Items.GUNPOWDER);
        final ItemStack ironIngot = new ItemStack(Items.IRON_INGOT);
        final ItemStack lever = new ItemStack(Blocks.LEVER);
        final ItemStack planks = new ItemStack(Blocks.PLANKS);
        final ItemStack fence = new ItemStack(Blocks.OAK_FENCE);


        final ItemStack salt = new ItemStack(ModItems.SALT);

        //Items
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SALT_SHOT_SHELL, 2), new Object[]{"g  ", " s ", "  p", 'g', goldNugget, 's', salt, 'p', gunpowder}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SHOTGUN, 1), new Object[]{"ig ", "li ", " fp", 'i', ironIngot, 'g', goldNugget, 'l', lever, 'f', fence, 'p', planks}));

    }
}
