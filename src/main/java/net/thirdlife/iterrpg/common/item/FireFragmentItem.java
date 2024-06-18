
package net.thirdlife.iterrpg.common.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FireFragmentItem extends Item {
	public FireFragmentItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}
}
