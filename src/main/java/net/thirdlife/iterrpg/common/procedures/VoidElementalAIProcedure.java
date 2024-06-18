package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.util.List;
import java.util.Comparator;

public class VoidElementalAIProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean flag = false;
		boolean shouldtick = false;
		boolean shouldspawn = false;
		double yspawn = 0;
		double ypos = 0;
		double zpos = 0;
		double xpos = 0;
		double attacktype = 0;
		double iteration = 0;
		double spawnamount = 0;
		ElementalFlightBehaviourProcedure.execute(world, x, y, z, entity);
		if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, x, (y + entity.getBbHeight() / 2), z, 1, 0.5, 0.5, 0.5, 0);
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_VOID.get()), x, (y + entity.getBbHeight() / 2), z, 1, 0.5, 0.5, 0.5, 0);
		}
		if (entity.getPersistentData().getDouble("attack") >= 80) {
			entity.getPersistentData().putDouble("attack", 0);
			spawnamount = 1;
			for (int index0 = 0; index0 < 8; index0++) {
				xpos = Mth.nextDouble(RandomSource.create(), -2, 2);
				ypos = Mth.nextDouble(RandomSource.create(), 1.25, 2.5);
				zpos = Mth.nextDouble(RandomSource.create(), -2, 2);
				shouldspawn = false;
				if (world.isEmptyBlock(BlockPos.containing(entity.getX() + xpos, entity.getY() + ypos, entity.getZ() + zpos)) && spawnamount == 1) {
					spawnamount = 0;
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = IterRpgModEntities.VOID_PORTAL.get().spawn(_level, BlockPos.containing(entity.getX() + xpos, entity.getY() + ypos, entity.getZ() + zpos), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.PORTAL_SPARK_PARTICLE.get()), (entity.getX() + xpos), (entity.getY() + ypos + 0.2), (entity.getZ() + zpos), 8, 0.25, 0.5, 0.25, 0.0025);
				}
			}
		} else {
			shouldtick = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player && (new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
							}
							return false;
						}
					}.checkGamemode(entityiterator) || new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
							}
							return false;
						}
					}.checkGamemode(entityiterator))) {
						shouldtick = true;
					}
				}
			}
			if (shouldtick == true) {
				entity.getPersistentData().putDouble("attack", (entity.getPersistentData().getDouble("attack") + 1));
			}
		}
	}
}
