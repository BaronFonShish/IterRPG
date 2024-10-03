package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModMobEffects;
import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.HomingBubbleEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;

public class TorrentStrikeProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double attackpower = 0;
		double rotation = 0;
		double distance = 0;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double type = 0;
		double damage = 0;
		double repeat = 0;
		double mobamount = 0;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(IterRpgModMobEffects.WRATH_OF_THE_DEPTHS.get(), 2400, 0, false, true));
		for (int index0 = 0; index0 < 3; index0++) {
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, float damage, int knockback) {
						AbstractArrow entityToSpawn = new HomingBubbleEntity(IterRpgModEntities.HOMING_BUBBLE.get(), level);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, 2, 0);
				_entityToSpawn.setPos((entity.getX()), (entity.getY() + entity.getBbHeight() / 1.5), (entity.getZ()));
				_entityToSpawn.shoot((sourceentity.getLookAngle().x), (sourceentity.getLookAngle().y + 0.25), (sourceentity.getLookAngle().z), (float) 0.5, 25);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
	}
}
