
package net.thirdlife.iterrpg.item;

import net.thirdlife.iterrpg.procedures.SpellCastBaseProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

public class BoneWandItem extends Item {
	public BoneWandItem() {
		super(new Item.Properties().durability(180).rarity(Rarity.COMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 16;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		SpellCastBaseProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}
}
