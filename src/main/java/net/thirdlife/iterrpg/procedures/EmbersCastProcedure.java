package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.EmberProjEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class EmbersCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double power = 0;
		double cooldown = 0;
		double mana = 0;
		power = WandReturnPowerProcedure.execute(entity);
		for (int index0 = 0; index0 < (int) Math.round(power * 4); index0++) {
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
						AbstractArrow entityToSpawn = new EmberProjEntity(IterRpgModEntities.EMBER_PROJ.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						entityToSpawn.setPierceLevel(piercing);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity, (float) (0.25 * power), 0, (byte) 1);
				_entityToSpawn.setPos(x, (y + entity.getBbHeight() * 0.85), z);
				_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), (float) (0.75 * power), (float) (25 * (1 / power)));
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
	}
}
