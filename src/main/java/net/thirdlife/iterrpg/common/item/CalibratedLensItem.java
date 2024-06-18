
package net.thirdlife.iterrpg.common.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CalibratedLensItem extends Item implements ICurioItem {
	public CalibratedLensItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
