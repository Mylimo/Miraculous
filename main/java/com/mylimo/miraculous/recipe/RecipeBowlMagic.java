package com.mylimo.miraculous.recipe;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class RecipeBowlMagic
{
    private boolean angelicRecipe;
    private ItemStack executor;
    private ItemStack power;
    private ItemStack definer;
    private ItemStack input;
    private ItemStack output;

    public RecipeBowlMagic(@Nonnull boolean angelicRecipe, @Nonnull ItemStack executor, @Nonnull ItemStack power, @Nonnull ItemStack definer, @Nonnull ItemStack input, @Nonnull ItemStack output)
    {
        this.angelicRecipe = angelicRecipe;
        this.executor = executor;
        this.power = power;
        this.definer = definer;
        this.input = input;
        this.output = output;
    }

    public boolean isAngelicRecipe(@Nonnull boolean angelicRecipe)
    {
        return this.angelicRecipe == angelicRecipe;
    }

    public boolean isExecutor(@Nonnull ItemStack executor)
    {
        return this.executor.getItem().equals(executor.getItem());
    }

    public boolean isPower(@Nonnull ItemStack power)
    {
        return this.power.getItem().equals(power.getItem());
    }

    public boolean isDefiner(@Nonnull ItemStack definer)
    {
        return this.definer.getItem().equals(definer.getItem());
    }

    public boolean isInput(@Nonnull ItemStack input)
    {
        return this.input.getItem().equals(input.getItem());
    }

    public ItemStack getOutput()
    {
        return output.copy();
    }
}

