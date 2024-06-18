package net.thirdlife.iterrpg.common.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
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

public class GustCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean attack = false;
		boolean hit = false;
		double power = 0;
		double cooldown = 0;
		double mana = 0;
		double amount = 0;
		double offset = 0;
		double dist = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		double yheight = 0;
		double splashdmg = 0;
		double push = 0;
		power = WandReturnPowerProcedure.execute(entity);
		dist = 0;
		yheight = y + entity.getBbHeight() * 0.85;
		xdir = entity.getLookAngle().x;
		ydir = entity.getLookAngle().y;
		zdir = entity.getLookAngle().z;
		push = power * 1.05;
		hit = true;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_elytra")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_elytra")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5, false);
			}
		}
		for (int index0 = 0; index0 < (int) (4 * power * 5); index0++) {
			if (hit) {
				if (world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist)).canOcclude()) {
					hit = false;
				}
				world.addParticle(ParticleTypes.POOF, (x + xdir * dist + dist * Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), (yheight + ydir * dist + dist * Mth.nextDouble(RandomSource.create(), -0.25, 0.25)),
						(z + zdir * dist + dist * Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), (xdir * 0.25), (ydir * 0.25), (zdir * 0.25));
				{
					final Vec3 _center = new Vec3((x + xdir * dist), (yheight + ydir * dist), (z + zdir * dist));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((1.5 * (1 + dist / 10)) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.toList();
					for (Entity entityiterator : _entfound) {
						if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage"))) && !(entity == entityiterator) && entityiterator instanceof LivingEntity
								|| entityiterator instanceof ItemEntity || entityiterator instanceof ExperienceOrb || entityiterator instanceof Projectile) {
							entityiterator.setDeltaMovement(new Vec3((xdir * (1 - dist / 10) * push), (ydir * (1 - dist / 10) * push), (zdir * (1 - dist / 10) * push)));
							entityiterator.fallDistance = 0;
						}
					}
				}
				dist = dist + 0.2;
			}
		}
	}
}
