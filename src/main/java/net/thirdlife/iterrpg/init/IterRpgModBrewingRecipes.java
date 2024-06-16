
package net.thirdlife.iterrpg.init;

import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;
import java.util.ArrayList;

@JeiPlugin
public class IterRpgModBrewingRecipes implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("iter_rpg:brewing_recipes");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
		List<IJeiBrewingRecipe> brewingRecipes = new ArrayList<>();
		ItemStack potion = new ItemStack(Items.POTION);
		ItemStack potion2 = new ItemStack(Items.POTION);
		List<ItemStack> ingredientStack = new ArrayList<>();
		List<ItemStack> inputStack = new ArrayList<>();
		ingredientStack.add(new ItemStack(IterRpgModBlocks.ETHERBLOOM.get()));
		PotionUtils.setPotion(potion, Potions.WATER);
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), new ItemStack(IterRpgModItems.ETHERBLOOM_DECOCTION.get())));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.CHORUS_FRUIT));
		inputStack.add(new ItemStack(IterRpgModItems.BOTTLE_OF_OBSIDIAN_TEARS.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(IterRpgModItems.WARPED_GOO.get())));
		inputStack.clear();
		ingredientStack.clear();
		registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
	}
}
