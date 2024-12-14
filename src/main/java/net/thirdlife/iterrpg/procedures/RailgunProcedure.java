package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class RailgunProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
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
		boolean hitcontinue = false;
		dist = 0;
		xdir = entity.getLookAngle().x;
		ydir = entity.getLookAngle().y;
		zdir = entity.getLookAngle().z;
		xnew = entity.getX() + xdir * dist;
		ynew = entity.getY() + entity.getBbHeight() * 0.85 + ydir * dist;
		znew = entity.getZ() + zdir * dist;
		hitcontinue = true;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		for (int index0 = 0; index0 < 100; index0++) {
			if (hitcontinue) {
				xnew = xnew + xdir * dist;
				ynew = ynew + ydir * dist;
				znew = znew + zdir * dist;
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.END_ROD, xnew, ynew, znew, 1, 0, 0, 0, 0);
				{
					final Vec3 _center = new Vec3(xnew, ynew, znew);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator) && entityiterator instanceof LivingEntity) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity), 5);
							hitcontinue = false;
						}
					}
				}
				if (world.getBlockState(BlockPos.containing(xnew, ynew, znew)).canOcclude()) {
					hitcontinue = false;
				}
				if (!hitcontinue) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.LARGE_SMOKE, xnew, ynew, znew, 16, 0.05, 0.05, 0.05, 0.05);
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, xnew, ynew, znew, (float) 1.5, Level.ExplosionInteraction.TNT);
				}
				dist = dist + 0.025;
			}
		}
	}
}
