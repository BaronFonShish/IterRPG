
package net.thirdlife.iterrpg.common.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PearlItem extends Item {
	public PearlItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
