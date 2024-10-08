package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModMobEffects;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

public class IonizedEffectProcedure {
	public static void execute(LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		double mobamount = 0;
		double chosen = 0;
		double distance = 0;
		if (entity.onGround()) {
			if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.25, entity.getZ()))).is(BlockTags.create(new ResourceLocation("forge:conductive_blocks")))) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("iter_rpg:arcane_damage")))), 6);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(IterRpgModMobEffects.IONIZED.get());
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())));;
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.LIGHTNING_PARTICLE.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() * 0.48), (entity.getZ()), 16, (entity.getBbWidth() / 3),
							(entity.getBbHeight() / 4), (entity.getBbWidth() / 3), 0.05);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.LIGHTNING_PARTICLE.get()), (entity.getX()), (y + entity.getBbHeight() / 2), (entity.getZ()), 1, (entity.getBbWidth() / 2.5), (entity.getBbHeight() / 4),
					(entity.getBbWidth() / 2.5), 0);
	}
}
