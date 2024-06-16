package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.entity.GrimhookEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.client.Minecraft;

import java.util.List;
import java.util.Comparator;

public class GrimhookAiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		double xdir = 0;
		double ydir = 0;
		double zdir = 0;
		double distance = 0;
		boolean aim = false;
		boolean sightline = false;
		entity.setNoGravity(true);
		if (entity.getPersistentData().getDouble("reel") <= 2) {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getPersistentData().getDouble("xinit") + entity.getPersistentData().getDouble("xdest") * 2),
					(entity.getPersistentData().getDouble("yinit") + entity.getPersistentData().getDouble("ydest") * 2), (entity.getPersistentData().getDouble("zinit") + entity.getPersistentData().getDouble("zdest") * 2)));
		}
		if (entity.getPersistentData().getDouble("reel") >= 30) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.getPersistentData().putDouble("reel", (entity.getPersistentData().getDouble("reel") + 1));
			if (entity.getPersistentData().getDouble("reel") <= 12) {
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.getPersistentData().getDouble("xinit") + entity.getPersistentData().getDouble("xdest") * (entity.getPersistentData().getDouble("reel") / 10)),
							(entity.getPersistentData().getDouble("yinit") + entity.getPersistentData().getDouble("ydest") * (entity.getPersistentData().getDouble("reel") / 10)),
							(entity.getPersistentData().getDouble("zinit") + entity.getPersistentData().getDouble("zdest") * (entity.getPersistentData().getDouble("reel") / 10)));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("xinit") + entity.getPersistentData().getDouble("xdest") * (entity.getPersistentData().getDouble("reel") / 10)),
								(entity.getPersistentData().getDouble("yinit") + entity.getPersistentData().getDouble("ydest") * (entity.getPersistentData().getDouble("reel") / 10)),
								(entity.getPersistentData().getDouble("zinit") + entity.getPersistentData().getDouble("zdest") * (entity.getPersistentData().getDouble("reel") / 10)), _ent.getYRot(), _ent.getXRot());
				}
			}
			distance = 0;
			for (int index0 = 0; index0 < 10; index0++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.CHAIN_PARTICLE.get()), (entity.getPersistentData().getDouble("xinit") + (entity.getX() - entity.getPersistentData().getDouble("xinit")) * distance),
							(entity.getPersistentData().getDouble("yinit") + (entity.getY() - entity.getPersistentData().getDouble("yinit")) * distance),
							(entity.getPersistentData().getDouble("zinit") + (entity.getZ() - entity.getPersistentData().getDouble("zinit")) * distance), 1, 0, 0, 0, 0);
				distance = distance + 0.1;
			}
			if (entity.getPersistentData().getDouble("reel") >= 18) {
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.getPersistentData().getDouble("xinit") + entity.getPersistentData().getDouble("xdest") * ((30 - entity.getPersistentData().getDouble("reel")) / 10)),
							(entity.getPersistentData().getDouble("yinit") + entity.getPersistentData().getDouble("ydest") * ((30 - entity.getPersistentData().getDouble("reel")) / 10)),
							(entity.getPersistentData().getDouble("zinit") + entity.getPersistentData().getDouble("zdest") * ((30 - entity.getPersistentData().getDouble("reel")) / 10)));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("xinit") + entity.getPersistentData().getDouble("xdest") * ((30 - entity.getPersistentData().getDouble("reel")) / 10)),
								(entity.getPersistentData().getDouble("yinit") + entity.getPersistentData().getDouble("ydest") * ((30 - entity.getPersistentData().getDouble("reel")) / 10)),
								(entity.getPersistentData().getDouble("zinit") + entity.getPersistentData().getDouble("zdest") * ((30 - entity.getPersistentData().getDouble("reel")) / 10)), _ent.getYRot(), _ent.getXRot());
				}
			}
		}
		if (entity.getPersistentData().getDouble("reel") >= 5) {
			if (!entity.getPersistentData().getBoolean("connected")) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage"))) && entityiterator instanceof LivingEntity && !(entityiterator instanceof GrimhookEntity)
								&& !(new Object() {
									public boolean checkGamemode(Entity _ent) {
										if (_ent instanceof ServerPlayer _serverPlayer) {
											return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
										} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
											return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
													&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
										}
										return false;
									}
								}.checkGamemode(entityiterator) || new Object() {
									public boolean checkGamemode(Entity _ent) {
										if (_ent instanceof ServerPlayer _serverPlayer) {
											return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
										} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
											return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
													&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
										}
										return false;
									}
								}.checkGamemode(entityiterator)) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:mourners")))
								&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:shadespawns")))) {
							entity.getPersistentData().putBoolean("connected", true);
							entity.getPersistentData().putString("hookedmob", (entityiterator.getStringUUID()));
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1);
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getBoolean("connected")) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("hookedmob"))) {
						{
							Entity _ent = entityiterator;
							_ent.teleportTo((entity.getX()), (entity.getY() - entityiterator.getBbHeight() / 2), (entity.getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((entity.getX()), (entity.getY() - entityiterator.getBbHeight() / 2), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			}
		}
	}
}
