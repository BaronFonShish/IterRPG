package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.DropletProjectileProjectileEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class BlobExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double attacktype = 0;
		entity.getPersistentData().putDouble("deathtime", 45);
		if (entity.getPersistentData().getDouble("timer") >= entity.getPersistentData().getDouble("deathtime") && entity.getPersistentData().getDouble("timer") >= 2) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 16, 0.5, 0.5, 0.5, 0.025);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 16, 1, 1, 1, 0.025);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SPLASH, x, y, z, 16, 1, 1, 1, 0.025);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_DROPLET.get()), x, y, z, 16, 1, 1, 1, 0.025);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FALLING_WATER, x, y, z, 16, 1, 1, 1, 0.25);
			for (int index0 = 0; index0 < 8; index0++) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback) {
							AbstractArrow entityToSpawn = new DropletProjectileProjectileEntity(IterRpgModEntities.DROPLET_PROJECTILE_PROJECTILE.get(), level);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 1, 0);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), 0, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), (float) Mth.nextDouble(RandomSource.create(), 0.4, 0.6), 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies")))) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 4);
					}
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_DROPLET.get()), x, y, z, 2, 0.25, 0.25, 0.25, 0.025);
			if (entity.getPersistentData().getDouble("timer") >= entity.getPersistentData().getDouble("deathtime") * 0.5) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SPLASH, x, y, z, 2, 0.25, 0.25, 0.25, 0.025);
			}
			if (entity.getPersistentData().getDouble("timer") >= entity.getPersistentData().getDouble("deathtime") * 0.75) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 2, 0.25, 0.25, 0.25, 0.025);
			}
		}
	}
}
