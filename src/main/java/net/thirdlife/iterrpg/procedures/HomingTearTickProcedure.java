package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.client.Minecraft;

import java.util.List;
import java.util.Comparator;

public class HomingTearTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		boolean flag = false;
		double yort = 0;
		double xort = 0;
		double lifetime = 0;
		double sum = 0;
		double turn = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		double speed = 0;
		double zort = 0;
		double zvel = 0;
		double yvel = 0;
		double radius = 0;
		double xvel = 0;
		immediatesourceentity.setNoGravity(true);
		xvel = immediatesourceentity.getDeltaMovement().x();
		yvel = immediatesourceentity.getDeltaMovement().y();
		zvel = immediatesourceentity.getDeltaMovement().z();
		flag = true;
		lifetime = 80;
		turn = 0.1 * ((lifetime - immediatesourceentity.getPersistentData().getDouble("lifetime")) / lifetime);
		speed = 0.6;
		radius = 30;
		if (immediatesourceentity.getPersistentData().getDouble("lifetime") > lifetime) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), x, (y - 0.15), z, 8, 0, 0, 0, 0.05);
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		} else {
			immediatesourceentity.getPersistentData().putDouble("lifetime", (immediatesourceentity.getPersistentData().getDouble("lifetime") + 1));
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (flag && (entityiterator instanceof Player && (new Object() {
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
				}.checkGamemode(entityiterator)) || entityiterator instanceof Villager || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies"))))) {
					flag = false;
					xdir = entityiterator.getX() - immediatesourceentity.getX();
					ydir = (entityiterator.getY() + entityiterator.getBbHeight() / 2) - immediatesourceentity.getY();
					zdir = entityiterator.getZ() - immediatesourceentity.getZ();
				}
			}
		}
		sum = Math.abs(xdir) + Math.abs(ydir) + Math.abs(zdir);
		if (!(sum == 0)) {
			xort = xdir / sum;
			yort = ydir / sum;
			zort = zdir / sum;
			xvel = xvel + xort * turn;
			yvel = yvel + yort * turn;
			zvel = zvel + zort * turn;
		}
		sum = Math.abs(xvel) + Math.abs(yvel) + Math.abs(zvel);
		xvel = (xvel / sum) * speed;
		yvel = (yvel / sum) * speed;
		zvel = (zvel / sum) * speed;
		immediatesourceentity.setDeltaMovement(new Vec3(xvel, yvel, zvel));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, y, z, 1, 0, 0, 0, 0);
	}
}
