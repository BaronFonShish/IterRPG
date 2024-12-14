package net.thirdlife.iterrpg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class MendCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack repairitem = ItemStack.EMPTY;
		double power = 0;
		double cooldown = 0;
		double mana = 0;
		double iteration = 0;
		double repairpoints = 0;
		double amount = 0;
		power = WandReturnPowerProcedure.execute(entity);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, (y + 1), z, 6, 1, 1, 1, 0.025);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.PLAYERS, (float) 0.15, (float) 1.25);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.PLAYERS, (float) 0.15, (float) 1.25, false);
			}
		}
		repairpoints = Math.round(Mth.nextDouble(RandomSource.create(), 4, 5) * power);
		for (int index0 = 0; index0 < Math.round(5 * power); index0++) {
			iteration = 0;
			for (int index1 = 0; index1 < 4; index1++) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int) iteration)) : ItemStack.EMPTY).isDamaged() && repairpoints >= 1) {
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int) iteration)) : ItemStack.EMPTY)
							.setDamageValue((int) ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int) iteration)) : ItemStack.EMPTY).getDamageValue() - 1));
					repairpoints = repairpoints - 1;
				}
				iteration = iteration + 1;
			}
		}
		repairpoints = Math.round(Mth.nextDouble(RandomSource.create(), 3, 4) * power);
		for (int index2 = 0; index2 < Math.round(4 * power); index2++) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).isDamaged() && repairpoints >= 1) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).setDamageValue((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getDamageValue() - 1));
				repairpoints = repairpoints - 1;
			}
		}
	}
}
