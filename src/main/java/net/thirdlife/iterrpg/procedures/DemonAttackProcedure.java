package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.ScabEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class DemonAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean shouldtick = false;
		boolean shouldspawn = false;
		boolean dospawn = false;
		double attack = 0;
		double timer = 0;
		double particle = 0;
		double fireforce = 0;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double yspawn = 0;
		double distance = 0;
		double yfinal = 0;
		if (entity.getPersistentData().getDouble("manum") >= 100) {
			entity.getPersistentData().putDouble("manum", 0);
			attack = Mth.nextInt(RandomSource.create(), 1, 3);
			if (attack == 1) {
				entity.getPersistentData().putDouble("manum", 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_elytra")), SoundSource.HOSTILE, 1, (float) 0.7);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_elytra")), SoundSource.HOSTILE, 1, (float) 0.7, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CRIT, x, (y + 1.6), z, 64, 0.25, 0.5, 0.25, 0.25);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 0, true, true));
				entity.setDeltaMovement(new Vec3((2.6 * entity.getLookAngle().x), (2.6 * entity.getLookAngle().y + 0.26), (2.6 * entity.getLookAngle().z)));
			} else if (attack == 2) {
				entity.getPersistentData().putDouble("manum", 0);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 8, true, false));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, (y + 1.6), z, 64, 0.25, 0.5, 0.25, 0.25);
				for (int index0 = 0; index0 < 16; index0++) {
					xpos = Mth.nextDouble(RandomSource.create(), -6, 6);
					ypos = -4;
					zpos = Mth.nextDouble(RandomSource.create(), -6, 6);
					shouldspawn = false;
					for (int index1 = 0; index1 < 8; index1++) {
						if (world.isEmptyBlock(BlockPos.containing(x + xpos, y + ypos, z + zpos)) && world.getBlockState(BlockPos.containing(x + xpos, (y + ypos) - 1, z + zpos)).canOcclude()) {
							yspawn = ypos;
							shouldspawn = true;
						}
						ypos = ypos + 1;
					}
					if (shouldspawn == true) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = IterRpgModEntities.DEMONSPINE.get().spawn(_serverLevel, BlockPos.containing((x + xpos), (y + yspawn), (z + zpos)), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
							}
							(entitytospawn).getPersistentData().putBoolean("friendly", false);
							(entitytospawn).getPersistentData().putString("owner", (entity.getStringUUID()));
						}
					}
				}
			} else if (attack == 3) {
				if (!world.getEntitiesOfClass(ScabEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
					entity.getPersistentData().putDouble("manum", 80);
				} else {
					entity.getPersistentData().putDouble("manum", 0);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 8, true, false));
					xpos = Mth.nextDouble(RandomSource.create(), -1, 1);
					zpos = Mth.nextDouble(RandomSource.create(), -1, 1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.enchantment_table.use")), SoundSource.HOSTILE, (float) 0.6, (float) 0.7);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.enchantment_table.use")), SoundSource.HOSTILE, (float) 0.6, (float) 0.7, false);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = IterRpgModEntities.SCAB.get().spawn(_level, BlockPos.containing(x + xpos, y, z + zpos), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), (x + xpos), (y + 0.5), (z + zpos), 16, 0.25, 0.3, 0.25, 0.025);
				}
			}
		} else {
			shouldtick = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
						shouldtick = true;
					}
				}
			}
			if (shouldtick == true) {
				entity.getPersistentData().putDouble("manum", (entity.getPersistentData().getDouble("manum") + 1));
			}
		}
	}
}
