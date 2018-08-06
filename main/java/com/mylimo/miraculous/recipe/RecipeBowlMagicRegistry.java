package com.mylimo.miraculous.recipe;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class RecipeBowlMagicRegistry
{
    private static List<RecipeBowlMagic> recipesBowlMagic = new ArrayList<>();

    public static boolean addRecipe(@Nonnull boolean angelicRecipe, @Nonnull ItemStack executor, @Nonnull ItemStack power, @Nonnull ItemStack definer, @Nonnull ItemStack input, @Nonnull ItemStack output)
    {
        return recipesBowlMagic.add(new RecipeBowlMagic(angelicRecipe, executor, power,definer, input,output));
    }

    public static ItemStack getOutput(@Nonnull boolean angelicRecipe, @Nonnull ItemStack executor, @Nonnull ItemStack power, @Nonnull ItemStack definer, @Nonnull ItemStack input)
    {
        ItemStack output = ItemStack.EMPTY;

        if (executor.equals(ItemStack.EMPTY) || power.equals(ItemStack.EMPTY) || definer.equals(ItemStack.EMPTY) || input.equals(ItemStack.EMPTY))
        {
            return output;
        }

        for (RecipeBowlMagic recipeBowlMagic : recipesBowlMagic)
        {
            if (recipeBowlMagic.isAngelicRecipe(angelicRecipe) && recipeBowlMagic.isExecutor(executor) && recipeBowlMagic.isPower(power) && recipeBowlMagic.isDefiner(definer) && recipeBowlMagic.isInput(input))
            {
                output = recipeBowlMagic.getOutput();
            }

            System.out.println(recipeBowlMagic.getOutput().getDisplayName());

        }

        return output;
    }
}
