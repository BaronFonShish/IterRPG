package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.common.entity.DemonspineEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.TamableAnimal;
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
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class DemonspinetickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double damage = 0;
		if (entity.getPersistentData().getDouble("ascend") > 0) {
			entity.getPersistentData().putDouble("ascend", (entity.getPersistentData().getDouble("ascend") - 0.1));
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y + entity.getPersistentData().getDouble("ascend") * 0.02), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + entity.getPersistentData().getDouble("ascend") * 0.02), z, _ent.getYRot(), _ent.getXRot());
			}
		}
		if (entity.getPersistentData().getDouble("ascend") <= 3) {
			{
				final Vec3 _center = new Vec3(x, (y + Mth.nextDouble(RandomSource.create(), -1, 1)), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.75 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entity.getPersistentData().getBoolean("friendly") == true) {
						if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage"))) && !(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)
								&& !(entity == entityiterator || entityiterator instanceof DemonspineEntity) && entityiterator instanceof LivingEntity && !(entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("owner"))) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) entity.getPersistentData().getDouble("damage"));
						}
					} else {
						if (!(entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage"))) || entityiterator instanceof WitherSkeleton || entityiterator instanceof Skeleton
								|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:demons"))) || entity == entityiterator)) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 3);
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("lifetime") > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 24) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, (y + 0.6), z, 32, 0.16, 0.5, 0.16, 0.025);
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.getPersistentData().putDouble("lifetime", (entity.getPersistentData().getDouble("lifetime") + 1));
		}
		if (!(world.getBlockState(BlockPos.containing(x, y - 0.01, z)).isFaceSturdy(world, BlockPos.containing(x, y - 0.01, z), Direction.UP)
				|| world.getBlockState(BlockPos.containing(x, y + 0.6, z)).isFaceSturdy(world, BlockPos.containing(x, y + 0.6, z), Direction.UP))) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y - 0.02), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y - 0.02), z, _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}
