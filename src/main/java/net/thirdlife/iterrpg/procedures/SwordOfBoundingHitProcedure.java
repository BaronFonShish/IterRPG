package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.UnboundSoulEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

public class SwordOfBoundingHitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		boolean flag = false;
		if (entity instanceof UnboundSoulEntity) {
			entity.getPersistentData().putDouble("evade", (-40));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, (y + 1), z, 6, 0.5, 0.75, 0.5, 0);
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("iter_rpg:arcane_damage"))), sourceentity), 5);
		}
	}
}
