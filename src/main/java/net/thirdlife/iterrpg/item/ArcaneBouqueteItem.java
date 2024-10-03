
package net.thirdlife.iterrpg.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ArcaneBouqueteItem extends Item implements ICurioItem {
	public ArcaneBouqueteItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
