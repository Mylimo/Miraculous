package com.mylimo.miraculous.recipe;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class BowlMagicRecipeRegistry
{
    private static List<BowlMagicRecipe> bowlMagicRecipes = new ArrayList<>();

    public static boolean addRecipe(@Nonnull boolean angelicRecipe, @Nonnull ItemStack executor, @Nonnull ItemStack power, @Nonnull ItemStack definer, @Nonnull ItemStack input, @Nonnull ItemStack output)
    {
        return bowlMagicRecipes.add(new BowlMagicRecipe(angelicRecipe, executor, power,definer, input,output));
    }

    public ItemStack getOutput(@Nonnull boolean angelicRecipe, @Nonnull ItemStack executor, @Nonnull ItemStack power, @Nonnull ItemStack definer, @Nonnull ItemStack input)
    {
        if (executor.equals(ItemStack.EMPTY) || power.equals(ItemStack.EMPTY) || definer.equals(ItemStack.EMPTY) || input.equals(ItemStack.EMPTY)) return ItemStack.EMPTY;

        for (BowlMagicRecipe bowlMagicRecipe: bowlMagicRecipes)
        {
            if (bowlMagicRecipe.isAngelicRecipe(angelicRecipe) && bowlMagicRecipe.isExecutor(executor) && bowlMagicRecipe.isPower(power) && bowlMagicRecipe.isDefiner(definer) && bowlMagicRecipe.isInput(input)) return bowlMagicRecipe.getOutput();
        }
        return ItemStack.EMPTY;
    }
}
