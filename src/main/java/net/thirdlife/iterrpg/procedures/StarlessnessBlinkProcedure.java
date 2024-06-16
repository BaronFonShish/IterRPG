package net.thirdlife.iterrpg.procedures;

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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class StarlessnessBlinkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean blink = false;
		boolean found = false;
		Entity enemy = null;
		Entity target = null;
		double distance = 0;
		double xdir = 0;
		double ydir = 0;
		double zdir = 0;
		double ycalib = 0;
		double i = 0;
		double xswap = 0;
		double yswap = 0;
		double zswap = 0;
		double mobamount = 0;
		double chosen = 0;
		distance = 0;
		xdir = entity.getLookAngle().x;
		ydir = entity.getLookAngle().y;
		zdir = entity.getLookAngle().z;
		blink = true;
		found = false;
		if (world instanceof Level _level) {
			if (_level.isClientSide()) {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 1.15, 1.25), false);
			}
		}
		for (int index0 = 0; index0 < 75; index0++) {
			if (blink) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.REVERSE_PORTAL, (x + xdir * distance), (y + entity.getBbHeight() / 2 + ydir * distance), (z + zdir * distance), 1, 0.25, 0.5, 0.25, 0.025);
				{
					final Vec3 _center = new Vec3((x + xdir * distance), (y + entity.getBbHeight() / 2 + ydir * distance), (z + zdir * distance));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
								&& entityiterator instanceof LivingEntity && !(entity == entityiterator)) {
							if (entityiterator.invulnerableTime == 0) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity), 5);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.DRAGON_BREATH, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 8, 0.25, 0.5, 0.25, 0.025);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.SWEEP_ATTACK, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 1, 0, 0, 0, 0);
							}
						}
					}
				}
				if (world.getBlockState(BlockPos.containing(x + xdir * distance, y + entity.getBbHeight() / 2 + ydir * distance, z + zdir * distance)).canOcclude()) {
					distance = distance - 0.1;
					blink = false;
				}
				if (blink) {
					distance = distance + 0.1;
				}
			}
		}
		{
			Entity _ent = entity;
			_ent.teleportTo((x + xdir * distance), Math.round(y + ydir * distance + 1), (z + zdir * distance));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((x + xdir * distance), Math.round(y + ydir * distance + 1), (z + zdir * distance), _ent.getYRot(), _ent.getXRot());
		}
		entity.fallDistance = 0;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 40);
	}
}
