
package net.thirdlife.iterrpg.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ProfaneFleshItem extends Item {
	public ProfaneFleshItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
