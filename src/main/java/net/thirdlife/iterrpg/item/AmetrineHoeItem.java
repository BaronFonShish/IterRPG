
package net.thirdlife.iterrpg.item;

import net.thirdlife.iterrpg.procedures.AmetrineToolMendProcedure;
import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.entity.Entity;

public class AmetrineHoeItem extends HoeItem {
	public AmetrineHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 152;
			}

			public float getSpeed() {
				return 7f;
			}

			public float getAttackDamageBonus() {
				return 1f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 32;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(IterRpgModItems.AMETRINE_INGOT.get()));
			}
		}, 0, -0.5f, new Item.Properties());
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		AmetrineToolMendProcedure.execute(entity, itemstack);
	}
}
