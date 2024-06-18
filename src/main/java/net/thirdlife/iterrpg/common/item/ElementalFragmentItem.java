
package net.thirdlife.iterrpg.common.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ElementalFragmentItem extends Item {
	public ElementalFragmentItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.UNCOMMON));
	}
}
