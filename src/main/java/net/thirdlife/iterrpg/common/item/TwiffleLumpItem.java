
package net.thirdlife.iterrpg.common.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class TwiffleLumpItem extends Item {
	public TwiffleLumpItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(12f).meat().build()));
	}
}
