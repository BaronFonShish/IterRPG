package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.ArcaneBlastEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class ArcaneBlastCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double power = 0;
		double cooldown = 0;
		double mana = 0;
		power = WandReturnPowerProcedure.execute(entity);
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
					AbstractArrow entityToSpawn = new ArcaneBlastEntity(IterRpgModEntities.ARCANE_BLAST.get(), level);
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.setSilent(true);
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, entity, (float) (5 * power), (int) (0.5 * power));
			_entityToSpawn.setPos(x, (y + entity.getBbHeight() * 0.85), z);
			_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y + 0.05), (entity.getLookAngle().z), (float) (1.25 + power), (float) (0.25 * (1 / power)));
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
	}
}
