
package net.thirdlife.iterrpg.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SeashellItem extends Item {
	public SeashellItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
