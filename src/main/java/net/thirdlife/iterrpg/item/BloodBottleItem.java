
package net.thirdlife.iterrpg.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BloodBottleItem extends Item {
	public BloodBottleItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
