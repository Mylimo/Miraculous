package com.mylimo.miraculous.integration.jei;

import com.mylimo.miraculous.Reference;
import com.mylimo.miraculous.init.ModBlocks;
import com.mylimo.miraculous.init.ModItems;
import com.mylimo.miraculous.integration.jei.bowlmagic.BowlMagicRecipeCategory;
import com.mylimo.miraculous.integration.jei.bowlmagic.BowlMagicRecipeWrapper;
import com.mylimo.miraculous.recipe.RecipeBowlMagic;
import com.mylimo.miraculous.recipe.RecipeBowlMagicRegistry;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEIMiraculousPlugin implements IModPlugin
{
    @Override
    public void register (IModRegistry registry)
    {
        registry.addRecipes(RecipeBowlMagicRegistry.getRecipesBowlMagic(), Reference.BOWL_MAGIC_UID);

        registry.handleRecipes(RecipeBowlMagic.class, BowlMagicRecipeWrapper::new, Reference.BOWL_MAGIC_UID);

        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.MAGIC_BOWL), Reference.BOWL_MAGIC_UID);

        IIngredientBlacklist blacklist = registry.getJeiHelpers().getIngredientBlacklist();
        blacklist.addIngredientToBlacklist(new ItemStack(ModItems.SHOTDUMMY));
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry)
    {
        registry.addRecipeCategories(new BowlMagicRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
    }
}
