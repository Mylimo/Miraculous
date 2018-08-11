package com.mylimo.miraculous.recipe;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class RecipeBowlMagic
{
    private boolean endericRecipe;
    private ItemStack executor;
    private ItemStack power;
    private ItemStack definer;
    private ItemStack input;
    private ItemStack output;

    public RecipeBowlMagic(@Nonnull boolean endericRecipe, @Nonnull ItemStack executor, @Nonnull ItemStack power, @Nonnull ItemStack definer, @Nonnull ItemStack input, @Nonnull ItemStack output)
    {
        this.endericRecipe = endericRecipe;
        this.executor = executor;
        this.power = power;
        this.definer = definer;
        this.input = input;
        this.output = output;
    }

    public boolean isEndericRecipe(@Nonnull boolean endericRecipe)
    {
        return this.endericRecipe == endericRecipe;
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

    public boolean isEndericRecipe()
    {
        return this.endericRecipe;
    }

    public ItemStack getExecutor()
    {
        return this.executor;
    }

    public ItemStack getPower()
    {
        return this.power;
    }

    public ItemStack getDefiner()
    {
        return this.definer;
    }

    public ItemStack getInput()
    {
        return this.input;
    }

    public ItemStack getOutput()
    {
        return output.copy();
    }
}

