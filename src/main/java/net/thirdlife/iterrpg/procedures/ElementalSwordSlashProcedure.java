package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class ElementalSwordSlashProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double pitch = 0;
		double yaw = 0;
		double pitch_off = 0;
		double yaw_off = 0;
		double xdec = 0;
		double ydec = 0;
		double zdec = 0;
		double repeat = 0;
		double dist = 0;
		double splashdmg = 0;
		double distabs = 0;
		double decide = 0;
		double true_pitch = 0;
		double iteration = 0;
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).MeleeAttackCooldown <= 0) {
			{
				double _setval = 13;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MeleeAttackCooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 13);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, (float) 0.25, 2);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, (float) 0.25, 2, false);
				}
			}
			yaw = entity.getYRot();
			true_pitch = entity.getXRot();
			pitch_off = Mth.nextDouble(RandomSource.create(), -30, 30);
			yaw_off = Mth.nextDouble(RandomSource.create(), 75, 105);
			pitch = true_pitch - pitch_off;
			yaw = yaw - yaw_off;
			repeat = 36;
			distabs = (Math.abs(entity.getLookAngle().x) + Math.abs(entity.getLookAngle().z) + 0.25) / 1.5;
			iteration = 0;
			for (int index0 = 0; index0 < (int) repeat; index0++) {
				dist = distabs * Mth.nextDouble(RandomSource.create(), 1.5, 2);
				{
					final Vec3 _center = new Vec3((entity.getX() - Math.sin(Math.toRadians(yaw)) * dist),
							((entity.getY() + 1.5) - (Math.sin(Math.toRadians(true_pitch)) * dist * (0.25 - (iteration / repeat - 0.5) * (iteration / repeat - 0.5)) * 5 + Math.sin(Math.toRadians(pitch)) / 2)),
							(entity.getZ() + Math.cos(Math.toRadians(yaw)) * dist));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
								&& entityiterator instanceof LivingEntity && !(entity == entityiterator)) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 3);
						}
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_PARTICLE.get()), (entity.getX() - Math.sin(Math.toRadians(yaw)) * dist),
							((entity.getY() + 1.5) - (Math.sin(Math.toRadians(true_pitch)) * dist * (0.25 - (iteration / repeat - 0.5) * (iteration / repeat - 0.5)) * 5 + Math.sin(Math.toRadians(pitch)) / 2)),
							(entity.getZ() + Math.cos(Math.toRadians(yaw)) * dist), 1, 0.01, 0.01, 0.01, 0.0032);
				pitch = pitch + 2 * (pitch_off / repeat);
				yaw = yaw + 2 * (yaw_off / repeat);
				iteration = iteration + 1;
			}
		}
	}
}
