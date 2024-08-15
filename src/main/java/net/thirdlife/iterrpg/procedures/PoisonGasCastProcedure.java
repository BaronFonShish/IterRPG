package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class PoisonGasCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean hitcontinue = false;
		boolean hit = false;
		double power = 0;
		double cooldown = 0;
		double mana = 0;
		double dist = 0;
		double xdir = 0;
		double ydir = 0;
		double zdir = 0;
		double xnew = 0;
		double ynew = 0;
		double znew = 0;
		double distance = 0;
		double yheight = 0;
		double push = 0;
		power = WandReturnPowerProcedure.execute(entity);
		dist = 0;
		yheight = y + entity.getBbHeight() * 0.85;
		xdir = entity.getLookAngle().x;
		ydir = entity.getLookAngle().y;
		zdir = entity.getLookAngle().z;
		hit = true;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_elytra")), SoundSource.PLAYERS, (float) 0.5, (float) 0.7);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_elytra")), SoundSource.PLAYERS, (float) 0.5, (float) 0.7, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")), SoundSource.PLAYERS, (float) 0.2, (float) 0.5);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")), SoundSource.PLAYERS, (float) 0.2, (float) 0.5, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")), SoundSource.PLAYERS, (float) 0.2, (float) 1.25);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")), SoundSource.PLAYERS, (float) 0.2, (float) 1.25, false);
			}
		}
		for (int index0 = 0; index0 < (int) (25 * power); index0++) {
			if (hit) {
				if (world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist)).canOcclude()) {
					hit = false;
				}
				world.addParticle((SimpleParticleType) (IterRpgModParticleTypes.POISON_CLOUD.get()), (x + xdir + dist * Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), (yheight + ydir + dist * Mth.nextDouble(RandomSource.create(), -0.25, 0.25)),
						(z + zdir + dist * Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), (xdir * 0.05 * dist), (ydir * 0.05 * dist), (zdir * 0.05 * dist));
				{
					final Vec3 _center = new Vec3((x + xdir * dist), (yheight + ydir * dist), (z + zdir * dist));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((1.5 * (1 + dist / 10)) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
								&& !(entityiterator == entity) && entityiterator instanceof LivingEntity) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.POISON, (int) (150 * power), 0));
						}
					}
				}
				dist = dist + 0.25;
			}
		}
	}
}
