package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class TormentorChainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("cooldown") < 1) {
			if (sourceentity instanceof Player _player)
				_player.getCooldowns().addCooldown((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 256);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.break")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.break")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("iter_rpg:flail_strike")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("iter_rpg:flail_strike")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.use")), SoundSource.PLAYERS, (float) 0.6, 3);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.use")), SoundSource.PLAYERS, (float) 0.6, 3, false);
				}
			}
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("cooldown", 256);
			entity.getPersistentData().putDouble("chainedTime", 128);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.CHAIN_HANDLE.get().spawn(_level, BlockPos.containing(x + 1.6, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setXRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setDeltaMovement(0, (-1), 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.CHAIN_HANDLE.get().spawn(_level, BlockPos.containing(x - 1.6, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setXRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setDeltaMovement(0, (-1), 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.CHAIN_HANDLE.get().spawn(_level, BlockPos.containing(x, y, z + 1.6), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setXRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setDeltaMovement(0, (-1), 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.CHAIN_HANDLE.get().spawn(_level, BlockPos.containing(x, y, z - 1.6), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setXRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					entityToSpawn.setDeltaMovement(0, (-1), 0);
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140, 0, true, false));
			entity.getPersistentData().putDouble("brainX", (entity.getX()));
			entity.getPersistentData().putDouble("brainY", (entity.getY()));
			entity.getPersistentData().putDouble("brainZ", (entity.getZ()));
		}
	}
}
