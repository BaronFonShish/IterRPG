
package net.thirdlife.iterrpg.item;

import net.thirdlife.iterrpg.procedures.FlailPlaysoundProcedure;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

public class GoldenFlailItem extends SwordItem {
	public GoldenFlailItem() {
		super(new Tier() {
			public int getUses() {
				return 38;
			}

			public float getSpeed() {
				return 2f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 22;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 3, -3.5f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		FlailPlaysoundProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return retval;
	}
}
