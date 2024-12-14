package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModItems;
import net.thirdlife.iterrpg.init.IterRpgModEnchantments;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BowReleaseProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(IterRpgModEnchantments.AUTOMATIC.get(), (entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY)) != 0 && !entity.isShiftKeyDown()) {
			if ((entity instanceof LivingEntity _entUseItem3 ? _entUseItem3.getUseItem() : ItemStack.EMPTY).getItem() == Items.BOW
					|| (entity instanceof LivingEntity _entUseItem5 ? _entUseItem5.getUseItem() : ItemStack.EMPTY).getItem() == IterRpgModItems.RECURVE_BOW.get()) {
				if ((entity instanceof LivingEntity _entUseTicks7 ? _entUseTicks7.getTicksUsingItem() : 0) >= 22) {
					if (entity instanceof LivingEntity _entity)
						_entity.releaseUsingItem();
				}
			} else if ((entity instanceof LivingEntity _entUseItem9 ? _entUseItem9.getUseItem() : ItemStack.EMPTY).getItem() == IterRpgModItems.DRIFTBOW.get()) {
				if ((entity instanceof LivingEntity _entUseTicks11 ? _entUseTicks11.getTicksUsingItem() : 0) >= 22) {
					if (entity instanceof LivingEntity _entity)
						_entity.releaseUsingItem();
				}
			} else if ((entity instanceof LivingEntity _entUseItem13 ? _entUseItem13.getUseItem() : ItemStack.EMPTY).getItem() == IterRpgModItems.FIRESTARTER.get()) {
				if ((entity instanceof LivingEntity _entUseTicks15 ? _entUseTicks15.getTicksUsingItem() : 0) >= 22) {
					if (entity instanceof LivingEntity _entity)
						_entity.releaseUsingItem();
				}
			} else if ((entity instanceof LivingEntity _entUseItem17 ? _entUseItem17.getUseItem() : ItemStack.EMPTY).getItem() == IterRpgModItems.BLOODBRANCH.get()) {
				if ((entity instanceof LivingEntity _entUseTicks19 ? _entUseTicks19.getTicksUsingItem() : 0) >= 37) {
					if (entity instanceof LivingEntity _entity)
						_entity.releaseUsingItem();
				}
			}
		}
	}
}
