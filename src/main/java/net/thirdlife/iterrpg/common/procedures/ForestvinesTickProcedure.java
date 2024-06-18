package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.common.entity.ForestVinesEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.List;
import java.util.Comparator;

public class ForestvinesTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("ascend") > 0) {
			entity.getPersistentData().putDouble("ascend", (entity.getPersistentData().getDouble("ascend") - 0.05));
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y + entity.getPersistentData().getDouble("ascend") * 0.01), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + entity.getPersistentData().getDouble("ascend") * 0.01), z, _ent.getYRot(), _ent.getXRot());
			}
		}
		if (entity.getPersistentData().getDouble("lifetime") > -6) {
			entity.getPersistentData().putDouble("lifetime", (entity.getPersistentData().getDouble("lifetime") - 1));
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_LEAF.get()), x, (y + 0.3), z, 24, 0.25, 0.5, 0.25, 0.025);
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 10) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_LEAF.get()), x, (y + 0.3), z, 32, 0.25, 0.5, 0.25, 0.025);
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity.getPersistentData().getDouble("ascend") <= 3) {
			{
				final Vec3 _center = new Vec3(x, (y + Mth.nextDouble(RandomSource.create(), -1, 1)), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.9 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage"))) || entityiterator instanceof ForestVinesEntity || entity == entityiterator
							|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:elementals"))))) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.SWEET_BERRY_BUSH)), (float) 0.5);
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 16, 4, true, false));
					}
				}
			}
		}
	}
}
