
package net.thirdlife.iterrpg.item;

import net.thirdlife.iterrpg.procedures.AmetrineMendProcedure;
import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

public class AmetrineSpearItem extends SwordItem {
	public AmetrineSpearItem() {
		super(new Tier() {
			public int getUses() {
				return 152;
			}

			public float getSpeed() {
				return 7f;
			}

			public float getAttackDamageBonus() {
				return 2.5f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 32;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(IterRpgModItems.AMETRINE_INGOT.get()));
			}
		}, 3, -2.6f, new Item.Properties());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		AmetrineMendProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
