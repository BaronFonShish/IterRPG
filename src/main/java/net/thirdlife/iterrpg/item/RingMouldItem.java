
package net.thirdlife.iterrpg.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RingMouldItem extends Item {
	public RingMouldItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
