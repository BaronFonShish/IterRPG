package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.List;
import java.util.Comparator;

public class GrimaceAiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double attacktype = 0;
		double distance = 0;
		double rotation = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double attachx = 0;
		double attachy = 0;
		double attachz = 0;
		double dist = 0;
		boolean doattack = false;
		boolean found = false;
		boolean entityhost = false;
		boolean chaindisplay = false;
		if (entity.isAlive()) {
			if ((entity.getPersistentData().getString("latchtype")).equals("block")) {
				chaindisplay = true;
				attachx = entity.getPersistentData().getDouble("xlatch");
				attachy = entity.getPersistentData().getDouble("ylatch");
				attachz = entity.getPersistentData().getDouble("zlatch");
				dist = new Vec3(x, y, z).distanceTo(new Vec3(attachx, attachy, attachz));
				if (world.isEmptyBlock(BlockPos.containing(attachx, attachy, attachz)) && world.isEmptyBlock(BlockPos.containing(attachx, attachy - 0.5, attachz))) {
					if (!entity.level().isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL, x, y, z, 5, 0.05, 0.05, 0.05, 0.025);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WITCH, x, y, z, 5, 0.05, 0.05, 0.05, 0.025);
				}
				if (dist >= 2.5) {
					entity.setDeltaMovement(new Vec3(((attachx - x) * (dist / 250)), ((attachy - y) * (dist / 250)), ((attachz - z) * (dist / 250))));
				}
			} else if ((entity.getPersistentData().getString("latchtype")).equals("mob")) {
				entityhost = false;
				chaindisplay = false;
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("host"))) {
							entity.getPersistentData().putDouble("xlatch", (entityiterator.getX()));
							entity.getPersistentData().putDouble("ylatch", (entityiterator.getY() + entityiterator.getBbHeight() / 2));
							entity.getPersistentData().putDouble("zlatch", (entityiterator.getZ()));
							chaindisplay = true;
							entityhost = true;
						}
					}
				}
				attachx = entity.getPersistentData().getDouble("xlatch");
				attachy = entity.getPersistentData().getDouble("ylatch");
				attachz = entity.getPersistentData().getDouble("zlatch");
				dist = new Vec3(x, y, z).distanceTo(new Vec3(attachx, attachy, attachz));
				if (!entityhost) {
					if (!entity.level().isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL, x, y, z, 5, 0.05, 0.05, 0.05, 0.025);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WITCH, x, y, z, 5, 0.05, 0.05, 0.05, 0.025);
				}
				if (dist >= 2.5) {
					entity.setDeltaMovement(new Vec3(((attachx - x) * (dist / 250)), ((attachy - y) * (dist / 250)), ((attachz - z) * (dist / 250))));
				}
			} else {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL, x, y, z, 5, 0.05, 0.05, 0.05, 0.025);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.WITCH, x, y, z, 5, 0.05, 0.05, 0.05, 0.025);
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) && (entity instanceof LivingEntity _entity ? _entity.hasLineOfSight(entityiterator) : false)) {
						entity.getPersistentData().putDouble("recharge", (entity.getPersistentData().getDouble("recharge") + 1));
						entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())));
					}
				}
			}
			if (entity.getPersistentData().getDouble("recharge") > 0) {
				entity.getPersistentData().putDouble("recharge", (entity.getPersistentData().getDouble("recharge") - 0.25));
			}
			if (entity.getPersistentData().getDouble("recharge") >= Mth.nextInt(RandomSource.create(), 60, 100)) {
				entity.getPersistentData().putDouble("recharge", 0);
				entity.getPersistentData().putDouble("attackprogress", 27);
			}
			if (entity.getPersistentData().getDouble("attackprogress") > 0) {
				entity.getPersistentData().putDouble("attackprogress", (entity.getPersistentData().getDouble("attackprogress") - 1));
				if (entity.getPersistentData().getDouble("attackprogress") > 25) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
								entity.getPersistentData().putDouble("xstart", x);
								entity.getPersistentData().putDouble("ystart", y);
								entity.getPersistentData().putDouble("zstart", z);
								entity.getPersistentData().putDouble("xfinish",
										(entityiterator.getX() + Mth.nextDouble(RandomSource.create(), -0.01, 0.01) * new Vec3(x, y, z).distanceTo(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())))));
								entity.getPersistentData().putDouble("yfinish", (entityiterator.getY()));
								entity.getPersistentData().putDouble("zfinish",
										(entityiterator.getZ() + Mth.nextDouble(RandomSource.create(), -0.01, 0.01) * new Vec3(x, y, z).distanceTo(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())))));
							}
						}
					}
				}
				if (entity.getPersistentData().getDouble("attackprogress") <= 25) {
					sx = entity.getPersistentData().getDouble("xstart") + (entity.getPersistentData().getDouble("xfinish") - entity.getPersistentData().getDouble("xstart")) * (1 - entity.getPersistentData().getDouble("attackprogress") / 25);
					sy = entity.getPersistentData().getDouble("ystart") + (entity.getPersistentData().getDouble("yfinish") - entity.getPersistentData().getDouble("ystart")) * (1 - entity.getPersistentData().getDouble("attackprogress") / 25)
							+ Math.pow(entity.getPersistentData().getDouble("attackprogress") - 12.5, 2) * (-0.01) + 1.6;
					sz = entity.getPersistentData().getDouble("zstart") + (entity.getPersistentData().getDouble("zfinish") - entity.getPersistentData().getDouble("zstart")) * (1 - entity.getPersistentData().getDouble("attackprogress") / 25);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, sx, sy, sz, 1, 0.05, 0.05, 0.05, 0.025);
					{
						final Vec3 _center = new Vec3(sx, sy, sz);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:mourners")))
									&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage"))) && !(entityiterator == entity) && entityiterator instanceof LivingEntity) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1);
								entityiterator.setSecondsOnFire(3);
							}
						}
					}
				}
				if (entity.getPersistentData().getDouble("attackprogress") <= 1) {
					{
						final Vec3 _center = new Vec3(sx, sy, sz);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:mourners")))
									&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage"))) && !(entityiterator == entity) && entityiterator instanceof LivingEntity) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1);
								entityiterator.setSecondsOnFire(3);
							}
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, sx, sy, sz, 16, 0.25, 0.25, 0.25, 0.05);
				}
			}
			if (chaindisplay) {
				dist = 0;
				for (int index0 = 0; index0 < 11; index0++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.CHAIN_PARTICLE.get()), (x + (attachx - x) * dist), (y + (attachy - y) * dist + (Math.pow(dist - 0.5, 2) - 0.25) * 1), (z + (attachz - z) * dist), 1, 0, 0, 0,
								0);
					dist = dist + 0.1;
				}
			}
		}
	}
}
