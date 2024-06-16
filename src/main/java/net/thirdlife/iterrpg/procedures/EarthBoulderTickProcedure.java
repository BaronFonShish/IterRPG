package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.EarthBoulderEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class EarthBoulderTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ypos = 0;
		double zpos = 0;
		double xpos = 0;
		double k = 0;
		boolean flag = false;
		if (entity.getPersistentData().getDouble("ascend") > 0) {
			entity.getPersistentData().putDouble("ascend", (entity.getPersistentData().getDouble("ascend") - 0.05));
			entity.setDeltaMovement(new Vec3(0, (entity.getPersistentData().getDouble("ascend") * 0.025), 0));
		}
		if (entity.getPersistentData().getDouble("lifetime") == 32) {
			if (!entity.getPersistentData().getBoolean("friendly")) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
					xpos = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX() - entity.getX();
					ypos = (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY() + 1) - entity.getY();
					zpos = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ() - entity.getZ();
					k = Math.abs(ypos) + Math.abs(zpos) + Math.abs(xpos);
					xpos = xpos / k;
					ypos = ypos / k;
					zpos = zpos / k;
					entity.getPersistentData().putDouble("xVector", xpos);
					entity.getPersistentData().putDouble("yVector", ypos);
					entity.getPersistentData().putDouble("zVector", zpos);
				} else {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (!entity.level().isClientSide())
						entity.discard();
				}
			} else {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entity.getPersistentData().getString("owner")).equals(entityiterator.getStringUUID())) {
							entity.getPersistentData().putDouble("xVector", (entityiterator.getLookAngle().x));
							entity.getPersistentData().putDouble("yVector", (entityiterator.getLookAngle().y));
							entity.getPersistentData().putDouble("zVector", (entityiterator.getLookAngle().z));
						}
					}
				}
			}
		}
		for (int index0 = 0; index0 < 2; index0++) {
			world.addParticle(ParticleTypes.CRIT, (x + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + Mth.nextDouble(RandomSource.create(), -0.16, 0.64)), (z + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
					(entity.getPersistentData().getDouble("xVector") / (-8)), (entity.getPersistentData().getDouble("yVector") / (-8)), (entity.getPersistentData().getDouble("zVector") / (-8)));
		}
		if (entity.getPersistentData().getDouble("lifetime") > 150) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		entity.getPersistentData().putDouble("lifetime", (entity.getPersistentData().getDouble("lifetime") + 1));
		if (world.getBlockState(BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -0.5, 0.5), y + Mth.nextDouble(RandomSource.create(), -0.25, 1.25), z + Mth.nextDouble(RandomSource.create(), -0.5, 0.5))).canOcclude()
				&& entity.getPersistentData().getDouble("lifetime") > 20) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("lifetime") >= 33) {
			entity.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("xVector") / 1.5), (entity.getPersistentData().getDouble("yVector") / 1.5), (entity.getPersistentData().getDouble("zVector") / 1.5)));
			if (entity instanceof EarthBoulderEntity _datEntSetL)
				_datEntSetL.getEntityData().set(EarthBoulderEntity.DATA_death, false);
			if (entity.getPersistentData().getBoolean("friendly")) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.9 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage"))) && !(entityiterator instanceof EarthBoulderEntity) && !(entity == entityiterator)
								&& !(entity.getPersistentData().getString("owner")).equals(entityiterator.getStringUUID())) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 4);
							if (!entity.level().isClientSide())
								entity.discard();
							entityiterator.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("xVector") / 2), (entity.getPersistentData().getDouble("yVector") / 2), (entity.getPersistentData().getDouble("zVector") / 2)));
						}
					}
				}
			} else {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.9 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage"))) && !(entityiterator instanceof EarthBoulderEntity) && !(entity == entityiterator)
								&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:elementals")))) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 6);
							if (!entity.level().isClientSide())
								entity.discard();
							entityiterator.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("xVector") / 2), (entity.getPersistentData().getDouble("yVector") / 2), (entity.getPersistentData().getDouble("zVector") / 2)));
						}
					}
				}
			}
		}
	}
}
