
package net.thirdlife.iterrpg.item;

import net.thirdlife.iterrpg.procedures.InsatiableSummonProcedure;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;

public class SevenSeasConcoctionItem extends Item {
	public SevenSeasConcoctionItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		InsatiableSummonProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), itemstack);
		return true;
	}
}
