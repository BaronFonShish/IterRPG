package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class ChainParticleDisplayProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double difx = 0;
		double dify = 0;
		double difz = 0;
		double distance = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getPersistentData().getDouble("chainedTime") > 1) {
					difx = entityiterator.getX() - x;
					dify = (entityiterator.getY() + entityiterator.getBbHeight() / 1.25) - y;
					difz = entityiterator.getZ() - z;
					distance = 0;
					for (int index0 = 0; index0 < 10; index0++) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.CHAIN_PARTICLE.get()), (x + difx * distance), (y + 0.16 + dify * distance), (z + difz * distance), 1, 0, 0, 0, 0);
						distance = distance + 0.1;
					}
					if (entity.getPersistentData().getDouble("timer") >= 100 || entity.getPersistentData().getDouble("timer") <= 8) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (x + difx * distance), (y + 0.16 + dify * distance), (z + difz * distance), 1, 0, 0, 0, 0);
					}
				}
			}
		}
		{
			Entity _ent = entity;
			_ent.teleportTo((entity.getPersistentData().getDouble("brainX")), (entity.getPersistentData().getDouble("brainY")), (entity.getPersistentData().getDouble("brainZ")));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("brainX")), (entity.getPersistentData().getDouble("brainY")), (entity.getPersistentData().getDouble("brainZ")), _ent.getYRot(), _ent.getXRot());
		}
		entity.setDeltaMovement(new Vec3(0, 0, 0));
		entity.fallDistance = 0;
		if (entity.getPersistentData().getDouble("timer") > 128) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.CHAIN_PARTICLE.get()), x, (y + 0.08), z, 8, 0.16, 0.16, 0.16, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, (y + 0.08), z, 8, 0.32, 0.32, 0.32, 0.008);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.break")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.break")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.destroy")), SoundSource.PLAYERS, (float) 0.6, 3);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.destroy")), SoundSource.PLAYERS, (float) 0.6, 3, false);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		}
	}
}
