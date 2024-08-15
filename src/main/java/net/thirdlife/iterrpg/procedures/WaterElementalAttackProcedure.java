package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.DropletProjectileProjectileEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class WaterElementalAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean shouldtick = false;
		boolean shouldspawn = false;
		boolean shouldattack = false;
		double attack = 0;
		double timer = 0;
		double particle = 0;
		double fireforce = 0;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double yspawn = 0;
		double decide = 0;
		double attacktype = 0;
		WaterElementalDripProcedure.execute(world, x, y, z, entity);
		ElementalFlightBehaviourProcedure.execute(world, x, y, z, entity);
		if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.LAVA) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 10);
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 6) {
				for (int index0 = 0; index0 < 16; index0++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.POOF, x, (y + 0.8), z, 6, 1, 1, 1, 0.025);
					xpos = Mth.nextDouble(RandomSource.create(), -2, 2);
					ypos = Mth.nextDouble(RandomSource.create(), -0.75, 0.75);
					zpos = Mth.nextDouble(RandomSource.create(), -2, 2);
					if ((world.getBlockState(BlockPos.containing(entity.getX() + xpos, entity.getY() + ypos, entity.getZ() + zpos))).getBlock() == Blocks.LAVA) {
						decide = Mth.nextInt(RandomSource.create(), 1, 3);
						if (decide == 1) {
							world.setBlock(BlockPos.containing(entity.getX() + xpos, entity.getY() + ypos, entity.getZ() + zpos), Blocks.OBSIDIAN.defaultBlockState(), 3);
						} else if (decide == 2) {
							world.setBlock(BlockPos.containing(entity.getX() + xpos, entity.getY() + ypos, entity.getZ() + zpos), Blocks.MAGMA_BLOCK.defaultBlockState(), 3);
						} else if (decide == 3) {
							world.setBlock(BlockPos.containing(entity.getX() + xpos, entity.getY() + ypos, entity.getZ() + zpos), Blocks.STONE.defaultBlockState(), 3);
						}
					}
				}
			}
		}
		if (entity.getRemainingFireTicks() >= 1) {
			entity.clearFire();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.HOSTILE, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.HOSTILE, (float) 0.5, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, (y + 0.8), z, 16, 0.5, 0.5, 0.5, 0.025);
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 4);
			xpos = Mth.nextDouble(RandomSource.create(), -1, 1);
			ypos = Mth.nextDouble(RandomSource.create(), -1, 1);
			zpos = Mth.nextDouble(RandomSource.create(), -1, 1);
			for (int index1 = 0; index1 < 6; index1++) {
				if ((world.getBlockState(BlockPos.containing(entity.getX() + xpos, entity.getY() + ypos, entity.getZ() + zpos))).getBlock() == Blocks.FIRE) {
					world.setBlock(BlockPos.containing(entity.getX() + xpos, entity.getY() + ypos, entity.getZ() + zpos), Blocks.AIR.defaultBlockState(), 3);
				}
			}
		}
		if (entity.getPersistentData().getDouble("attack") >= 100) {
			entity.getPersistentData().putDouble("attack", 0);
			if (entity.getPersistentData().getDouble("attacktype") >= 2) {
				entity.getPersistentData().putDouble("attacktype", 0);
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = IterRpgModEntities.SMALL_SCALLOP.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY() + 0.25), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					(entitytospawn).getPersistentData().putBoolean("summoned", true);
				}
			} else if (entity.getPersistentData().getDouble("attacktype") >= 1) {
				entity.getPersistentData().putDouble("attacktype", (entity.getPersistentData().getDouble("attacktype") + 1));
				entity.getPersistentData().putDouble("barrage", 20);
			} else {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = IterRpgModEntities.BLOB.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 0.8, entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setXRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setDeltaMovement((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
					}
				}
				entity.getPersistentData().putDouble("attacktype", (entity.getPersistentData().getDouble("attacktype") + 1));
			}
		} else {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
						shouldattack = true;
					}
				}
			}
			if (shouldattack) {
				entity.getPersistentData().putDouble("attack", (entity.getPersistentData().getDouble("attack") + 1));
			}
		}
		if (entity.getPersistentData().getDouble("barrage") >= 1) {
			entity.getPersistentData().putDouble("barrage", (entity.getPersistentData().getDouble("barrage") - 1));
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback) {
							AbstractArrow entityToSpawn = new DropletProjectileProjectileEntity(IterRpgModEntities.DROPLET_PROJECTILE_PROJECTILE.get(), level);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 1, 0);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) Mth.nextDouble(RandomSource.create(), 0.5, 1), 15);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		}
	}
}
