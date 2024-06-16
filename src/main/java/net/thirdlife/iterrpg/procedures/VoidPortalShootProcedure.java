package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.List;
import java.util.Comparator;

public class VoidPortalShootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity targetentity = null;
		double distance = 0;
		double xiter = 0;
		double yiter = 0;
		double ziter = 0;
		boolean stoptarget = false;
		boolean doattack = false;
		entity.setNoGravity(true);
		entity.getPersistentData().putDouble("charge", (entity.getPersistentData().getDouble("charge") + 1));
		if (entity.getPersistentData().getDouble("charge") == 25) {
			stoptarget = true;
			doattack = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (stoptarget && (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies"))) || entityiterator instanceof Player)) {
						targetentity = entityiterator;
						stoptarget = false;
						doattack = true;
					}
				}
			}
			if (doattack) {
				entity.getPersistentData().putDouble("xtarget", (targetentity.getX()));
				entity.getPersistentData().putDouble("ytarget", (targetentity.getY() + targetentity.getBbHeight() / 2));
				entity.getPersistentData().putDouble("ztarget", (targetentity.getZ()));
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((targetentity.getX()), (targetentity.getY() + targetentity.getBbHeight() / 2), (targetentity.getZ())));
			}
		}
		if (entity.getPersistentData().getDouble("charge") >= 16 && entity.getPersistentData().getDouble("charge") <= 35) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.DRAGON_BREATH, x, (y + entity.getBbHeight() / 2), z, 2, (entity.getBbWidth() / 3), (entity.getBbHeight() / 3), (entity.getBbWidth() / 3), 0);
		}
		if (entity.getPersistentData().getDouble("charge") >= 35 && entity.getPersistentData().getDouble("charge") <= 75) {
			distance = 0;
			stoptarget = true;
			doattack = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (stoptarget && (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies"))) || entityiterator instanceof Player)) {
						targetentity = entityiterator;
						stoptarget = false;
						doattack = true;
					}
				}
			}
			if (doattack) {
				entity.getPersistentData().putDouble("xtarget", (entity.getPersistentData().getDouble("xtarget") + (targetentity.getX() - entity.getPersistentData().getDouble("xtarget")) / 30));
				entity.getPersistentData().putDouble("ytarget", (entity.getPersistentData().getDouble("ytarget") + ((targetentity.getY() + targetentity.getBbHeight() / 2) - entity.getPersistentData().getDouble("ytarget")) / 30));
				entity.getPersistentData().putDouble("ztarget", (entity.getPersistentData().getDouble("ztarget") + (targetentity.getZ() - entity.getPersistentData().getDouble("ztarget")) / 30));
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getPersistentData().getDouble("xtarget")), (entity.getPersistentData().getDouble("ytarget")), (entity.getPersistentData().getDouble("ztarget"))));
				for (int index0 = 0; index0 < 32; index0++) {
					xiter = x + distance * (entity.getPersistentData().getDouble("xtarget") - x);
					yiter = y + entity.getBbHeight() / 2 + distance * (entity.getPersistentData().getDouble("ytarget") - y);
					ziter = z + distance * (entity.getPersistentData().getDouble("ztarget") - z);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.PORTAL_SPARK_PARTICLE.get()), xiter, yiter, ziter, 1, 0.02, 0.02, 0.02, 0);
					{
						final Vec3 _center = new Vec3(xiter, yiter, ziter);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies"))) || entityiterator instanceof Player) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 5);
							}
						}
					}
					distance = distance + Mth.nextDouble(RandomSource.create(), 0.085, 0.115);
				}
			}
		}
		if (entity.getPersistentData().getDouble("charge") >= 90) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
