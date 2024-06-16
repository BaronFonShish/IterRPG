package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.GrimaceEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class GrieverAiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean doattack = false;
		double attacktype = 0;
		double distance = 0;
		double rotation = 0;
		double mobcount = 0;
		MournersAiProcedure.execute(world, x, y, z, entity);
		if (entity.getPersistentData().getDouble("screamTime") >= 1250) {
			entity.getPersistentData().putDouble("screamTime", 1200);
		} else {
			entity.getPersistentData().putDouble("screamTime", (entity.getPersistentData().getDouble("screamTime") + 1));
		}
		if (entity.getPersistentData().getDouble("buffTime") >= Mth.nextInt(RandomSource.create(), 500, 750)) {
			entity.getPersistentData().putDouble("buffTime", 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.WITCH, x, (y + entity.getBbHeight() / 2), z, 6, (entity.getBbWidth() / 2.5), (entity.getBbHeight() / 2.5), (entity.getBbWidth() / 2.5), 0.01);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:mourners")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 120, 0, false, false));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0, false, false));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 6, (entityiterator.getBbWidth() / 2.5),
									(entityiterator.getBbHeight() / 2.5), (entityiterator.getBbWidth() / 2.5), 0.01);
					}
				}
			}
			doattack = false;
			mobcount = 0;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof GrimaceEntity && (entityiterator.getPersistentData().getString("host")).equals(entity.getStringUUID())) {
						mobcount = mobcount + 1;
					}
				}
			}
			if (mobcount < 3) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = IterRpgModEntities.GRIMACE.get().spawn(_serverLevel, BlockPos.containing(x, (y + 1), z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					(entitytospawn).getPersistentData().putString("latchtype", "mob");
					(entitytospawn).getPersistentData().putString("host", (entity.getStringUUID()));
				}
			}
		} else {
			entity.getPersistentData().putDouble("buffTime", (entity.getPersistentData().getDouble("buffTime") + 1));
		}
	}
}
