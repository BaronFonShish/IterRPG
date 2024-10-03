
package net.thirdlife.iterrpg.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EnchantedPageItem extends Item {
	public EnchantedPageItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
