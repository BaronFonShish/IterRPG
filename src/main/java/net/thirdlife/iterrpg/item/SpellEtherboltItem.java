
package net.thirdlife.iterrpg.item;

import net.thirdlife.iterrpg.procedures.SpellReturnLevelProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class SpellEtherboltItem extends Item {
	public SpellEtherboltItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("iterpg.spell.etherbolt"));
		list.add(Component.literal(" "));
		list.add(Component.translatable("iterpg.spell.domain.arcane"));
		list.add(Component.translatable("iterpg.spell.level.basic"));
		list.add(Component.literal(SpellReturnLevelProcedure.execute(itemstack)));
		list.add(Component.translatable("iterpg.spell.mana.2"));
		list.add(Component.translatable("iterpg.spell.desc.etherbolt"));
	}
}
