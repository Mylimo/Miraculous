package com.mylimo.miraculous.integration.jei.bowlmagic;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.recipe.RecipeBowlMagic;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BowlMagicRecipeWrapper implements IRecipeWrapper
{
    private List<ItemStack> inputs = new ArrayList<>();
    private ItemStack output;
    private List<String> tooltips = new ArrayList<>();

    public BowlMagicRecipeWrapper(RecipeBowlMagic recipeBowlMagic)
    {
        this.inputs.add(recipeBowlMagic.getExecutor());
        this.inputs.add(recipeBowlMagic.getPower());
        this.inputs.add(recipeBowlMagic.getDefiner());
        this.inputs.add(recipeBowlMagic.getInput());
        this.output = recipeBowlMagic.getOutput();

        this.tooltips.add(recipeBowlMagic.isEndericRecipe()? I18n.format(Reference.TK_JEI_ENDERIC_ALTAR) : I18n.format(Reference.TK_JEI_NETHEROUS_ALTAR)) ;
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ingredients.setInputs(ItemStack.class, this.inputs);
        ingredients.setOutput(ItemStack.class, this.output);
    }

    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY)
    {
        return tooltips;
    }
}
