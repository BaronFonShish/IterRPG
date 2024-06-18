
package net.thirdlife.iterrpg.common.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HauntedSplinterItem extends Item {
	public HauntedSplinterItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
