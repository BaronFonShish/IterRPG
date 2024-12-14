
package net.thirdlife.iterrpg.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class VileTissueItem extends Item {
	public VileTissueItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
