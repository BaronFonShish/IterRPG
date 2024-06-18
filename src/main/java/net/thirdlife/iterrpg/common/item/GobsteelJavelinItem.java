
package net.thirdlife.iterrpg.common.item;

import net.thirdlife.iterrpg.common.procedures.GobsteelJavThrownProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

public class GobsteelJavelinItem extends Item {
	public GobsteelJavelinItem() {
		super(new Item.Properties().durability(32).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		GobsteelJavThrownProcedure.execute(entity, ar.getObject());
		return ar;
	}
}
