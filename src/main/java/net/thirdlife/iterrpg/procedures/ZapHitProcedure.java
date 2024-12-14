package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

public class ZapHitProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.AIR_SIGIL.get()), (immediatesourceentity.getX()), (immediatesourceentity.getY() + 0.1), (immediatesourceentity.getZ()), 8, 0.15, 0.15, 0.15, 0.025);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.LIGHTNING_PARTICLE.get()), (immediatesourceentity.getX()), (immediatesourceentity.getY() + 0.1), (immediatesourceentity.getZ()), 4, 0.15, 0.15, 0.15, 0.025);
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
		if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:elementals")))) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LIGHTNING_BOLT)), 3);
		}
	}
}
