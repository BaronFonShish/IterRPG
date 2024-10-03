package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class AftercastEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean valid = false;
		boolean cast = false;
		ItemStack spellbook = ItemStack.EMPTY;
		ItemStack spell = ItemStack.EMPTY;
		ItemStack focus = ItemStack.EMPTY;
		double slot = 0;
		double spellslot = 0;
		double cooldown = 0;
		double mana = 0;
		double spelltier = 0;
		double casttier = 0;
		focus = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (focus.getItem() == IterRpgModItems.MAGMANUM_STAFF.get()) {
			{
				double _setval = Mth.nextInt(RandomSource.create(), 1, 6);
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SelectedSpell = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
