
package net.thirdlife.iterrpg.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AwakenedSanguarnetItem extends Item {
	public AwakenedSanguarnetItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
