package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModItems;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class ArmorSwitchVoidProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == IterRpgModItems.ELEMENTAL_ARMOR_BOOTS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == IterRpgModItems.ELEMENTAL_ARMOR_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == IterRpgModItems.ELEMENTAL_ARMOR_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == IterRpgModItems.ELEMENTAL_ARMOR_HELMET.get()) {
			if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrCreateTag().getDouble("element") == 4
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().getDouble("element") == 4
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().getDouble("element") == 4
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble("element") == 4)) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().putDouble("switchcooldown", 100);
				ArmorCooldownResetProcedure.execute(entity);
				if (entity instanceof Player _player)
					_player.closeContainer();
				IterRpgMod.queueServerWork(4, () -> {
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrCreateTag().putDouble("element", 4);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.VOID_SIGIL.get()), (entity.getX()), (entity.getY() + 0), (entity.getZ()), 8, 0.25, 0.1, 0.25, 0.025);
				});
				IterRpgMod.queueServerWork(8, () -> {
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().putDouble("element", 4);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.VOID_SIGIL.get()), (entity.getX()), (entity.getY() + 0.6), (entity.getZ()), 8, 0.25, 0.1, 0.25, 0.025);
				});
				IterRpgMod.queueServerWork(12, () -> {
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().putDouble("element", 4);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.VOID_SIGIL.get()), (entity.getX()), (entity.getY() + 1.2), (entity.getZ()), 8, 0.25, 0.1, 0.25, 0.025);
				});
				IterRpgMod.queueServerWork(16, () -> {
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble("element", 4);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.VOID_SIGIL.get()), (entity.getX()), (entity.getY() + 1.8), (entity.getZ()), 8, 0.25, 0.1, 0.25, 0.025);
				});
			}
		}
	}
}
