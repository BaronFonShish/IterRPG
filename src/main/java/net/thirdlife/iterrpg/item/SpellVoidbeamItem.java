
package net.thirdlife.iterrpg.item;

import net.thirdlife.iterrpg.procedures.SpellReturnLevelProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class SpellVoidbeamItem extends Item {
	public SpellVoidbeamItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("iterpg.spell.voidbeam"));
		list.add(Component.literal(" "));
		list.add(Component.translatable("iterpg.spell.domain.elemental"));
		list.add(Component.translatable("iterpg.spell.level.advanced"));
		list.add(Component.literal(SpellReturnLevelProcedure.execute(itemstack)));
		list.add(Component.translatable("iterpg.spell.mana.4"));
		list.add(Component.translatable("iterpg.spell.desc.voidbeam"));
	}
}
