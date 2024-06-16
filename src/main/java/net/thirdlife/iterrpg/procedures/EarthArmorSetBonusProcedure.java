package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class EarthArmorSetBonusProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double chance = 0;
		if (entity.isShiftKeyDown() && (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).ElementalArmorCooldown == 0) {
			if ((world.getBlockState(BlockPos.containing(entity.getX() + entity.getLookAngle().x * 0.8, entity.getY(), entity.getZ() + entity.getLookAngle().z * 0.8))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
					&& (world.getBlockState(BlockPos.containing(entity.getX() + entity.getLookAngle().x * 0.8, entity.getY() + 1, entity.getZ() + entity.getLookAngle().z * 0.8))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.getX() + entity.getLookAngle().x * 0.001), (entity.getY()), (entity.getZ() + entity.getLookAngle().z * 0.001));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getX() + entity.getLookAngle().x * 0.001), (entity.getY()), (entity.getZ() + entity.getLookAngle().z * 0.001), _ent.getYRot(), _ent.getXRot());
				}
				{
					double _setval = 16;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ElementalArmorCooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.001, entity.getZ()))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))) && entity.getLookAngle().y < -0.92) {
				{
					double _setval = 20;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ElementalArmorCooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.getX()), (entity.getY() - 0.001), (entity.getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getX()), (entity.getY() - 0.001), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
				}
			}
		}
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).ElementalArmorPassiveCooldown <= 0) {
			{
				double _setval = 320;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ElementalArmorPassiveCooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0, true, false));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entity) && !(entityiterator instanceof Monster)) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0, true, false));
					}
				}
			}
		}
	}
}
