
package net.thirdlife.iterrpg.item;

import net.thirdlife.iterrpg.procedures.ElementalSetRepairProcedure;
import net.thirdlife.iterrpg.procedures.ElementalAttackProcedure;
import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ElementalSwordItem extends SwordItem {
	public ElementalSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 2048;
			}

			public float getSpeed() {
				return 10f;
			}

			public float getAttackDamageBonus() {
				return 6f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 16;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(IterRpgModItems.ELEMENTAL_INGOT.get()), new ItemStack(IterRpgModItems.ELEMENTAL_FRAGMENT.get()));
			}
		}, 3, -2.4f, new Item.Properties().fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		ElementalAttackProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity, itemstack);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		ElementalSetRepairProcedure.execute(itemstack);
	}
}
