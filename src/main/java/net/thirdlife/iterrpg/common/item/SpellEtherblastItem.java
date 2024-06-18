
package net.thirdlife.iterrpg.common.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class SpellEtherblastItem extends Item {
	public SpellEtherblastItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("iterpg.spell.etherblast"));
		list.add(Component.literal(" "));
		list.add(Component.translatable("iterpg.spell.domain.arcane"));
		list.add(Component.translatable("iterpg.spell.damage.6"));
		list.add(Component.translatable("iterpg.spell.mana.5"));
		list.add(Component.translatable("iterpg.spell.desc.etherblast"));
	}
}
