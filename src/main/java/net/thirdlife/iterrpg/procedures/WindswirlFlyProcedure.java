package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.client.Minecraft;

import java.util.List;
import java.util.Comparator;

public class WindswirlFlyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xvec = 0;
		double yvec = 0;
		double zvec = 0;
		double ypos = 0;
		double zpos = 0;
		double xpos = 0;
		double k = 0;
		if (entity.getPersistentData().getDouble("setTarget") < 2) {
			if ((entity.getPersistentData().getString("type")).equals("at_player")) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
					xpos = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX() - entity.getX();
					ypos = (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY() + 1) - entity.getY();
					zpos = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ() - entity.getZ();
					k = Math.abs(ypos) + Math.abs(zpos) + Math.abs(xpos);
					xpos = xpos / k;
					ypos = ypos / k;
					zpos = zpos / k;
					entity.getPersistentData().putDouble("speed", 2);
					entity.getPersistentData().putDouble("deathtime", 200);
					entity.getPersistentData().putDouble("timer", 0);
					entity.getPersistentData().putDouble("xVector", xpos);
					entity.getPersistentData().putDouble("yVector", ypos);
					entity.getPersistentData().putDouble("zVector", zpos);
				} else {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			} else if ((entity.getPersistentData().getString("type")).equals("scatter")) {
				xpos = Mth.nextInt(RandomSource.create(), -4, 4);
				ypos = Mth.nextInt(RandomSource.create(), -4, 4);
				zpos = Mth.nextInt(RandomSource.create(), -4, 4);
				k = Math.abs(ypos) + Math.abs(zpos) + Math.abs(xpos);
				xpos = xpos / k;
				ypos = ypos / k;
				zpos = zpos / k;
				entity.getPersistentData().putDouble("speed", 1);
				entity.getPersistentData().putDouble("deathtime", 40);
				entity.getPersistentData().putDouble("timer", 0);
				entity.getPersistentData().putDouble("xVector", xpos);
				entity.getPersistentData().putDouble("yVector", ypos);
				entity.getPersistentData().putDouble("zVector", zpos);
			}
			entity.getPersistentData().putDouble("setTarget", 4);
		} else {
			if (entity.getPersistentData().getDouble("timer") >= entity.getPersistentData().getDouble("deathtime") + Mth.nextInt(RandomSource.create(), 4, 10)
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.POOF, x, y, z, 32, 0.16, 0.16, 0.16, 0.16);
				if (!entity.level().isClientSide())
					entity.discard();
			} else {
				xvec = entity.getPersistentData().getDouble("xVector") * entity.getPersistentData().getDouble("speed");
				yvec = entity.getPersistentData().getDouble("yVector") * entity.getPersistentData().getDouble("speed");
				zvec = entity.getPersistentData().getDouble("zVector") * entity.getPersistentData().getDouble("speed");
				entity.setDeltaMovement(new Vec3((xvec / 4), (yvec / 4), (zvec / 4)));
				for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 3); index0++) {
					world.addParticle(ParticleTypes.POOF, (entity.getX() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (entity.getY() + Mth.nextDouble(RandomSource.create(), -0.16, 0.64)),
							(entity.getZ() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (xvec / (-8)), (yvec / (-8)), (zvec / (-8)));
				}
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
				if ((entity.getPersistentData().getString("type")).equals("at_player")) {
					entity.getPersistentData().putDouble("speed", (entity.getPersistentData().getDouble("speed") * 0.995));
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:player_allies"))) || entityiterator instanceof Player && (new Object() {
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
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 4);
							entityiterator.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -0.64, 0.64)), 0.64, (Mth.nextDouble(RandomSource.create(), -0.64, 0.64))));
						}
					}
				}
			}
		}
	}
}
