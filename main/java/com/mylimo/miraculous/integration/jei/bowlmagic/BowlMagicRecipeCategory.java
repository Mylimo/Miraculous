package com.mylimo.miraculous.integration.jei.bowlmagic;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.init.ModBlocks;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class BowlMagicRecipeCategory implements IRecipeCategory<BowlMagicRecipeWrapper>
{
    private final String localizedName;

    private final IDrawable background;
    private final IDrawable icon;

    public BowlMagicRecipeCategory(IGuiHelper guiHelper)
    {
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, Reference.TP_JEI_BOWLMAGIC_);
        background = guiHelper.drawableBuilder(location, 0, 0, 95, 66).build();
        icon = guiHelper.createDrawableIngredient(new ItemStack(ModBlocks.MAGIC_BOWL));
        localizedName = I18n.format(Reference.TK_JEI_BOWLMAGIC_);
    }

    @Override
    public String getUid()
    {
        return Reference.BOWL_MAGIC_UID;
    }

    @Override
    public String getTitle()
    {
        return localizedName;
    }

    @Override
    public String getModName()
    {
        return Reference.MOD_NAME;
    }

    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    @Nullable
    @Override
    public IDrawable getIcon()
    {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, BowlMagicRecipeWrapper recipeWrapper, IIngredients ingredients)
    {
        IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();

        itemStacks.init(0, true, 7, 42);
        itemStacks.init(1, true, 25, 42);
        itemStacks.init(2, true, 43, 42);
        itemStacks.init(3, true, 25, 6);
        itemStacks.init(4, false,71, 6);

        itemStacks.set(0, ingredients.getInputs(ItemStack.class).get(0));
        itemStacks.set(1, ingredients.getInputs(ItemStack.class).get(1));
        itemStacks.set(2, ingredients.getInputs(ItemStack.class).get(2));
        itemStacks.set(3, ingredients.getInputs(ItemStack.class).get(3));
        itemStacks.set(4, ingredients.getOutputs(ItemStack.class).get(0));
    }
}
