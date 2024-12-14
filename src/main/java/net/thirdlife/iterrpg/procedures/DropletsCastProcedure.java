package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.DropletMagicEntity;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

public class DropletsCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean hit = false;
		double power = 0;
		double cooldown = 0;
		double mana = 0;
		double velocity = 0;
		double dist = 0;
		double yheight = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		power = WandReturnPowerProcedure.execute(entity);
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.NETHER) {
			power = power * 0.6;
		}
		velocity = 0.75;
		for (int index0 = 0; index0 < (int) (2 + Math.round(power * 1.25)); index0++) {
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
						AbstractArrow entityToSpawn = new DropletMagicEntity(IterRpgModEntities.DROPLET_MAGIC.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity, (float) (0.5 * power), 0);
				_entityToSpawn.setPos(x, (y + entity.getBbHeight() * 0.85), z);
				_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), (float) (velocity * (0.75 + Math.log(power + 1) / 2.5)), (float) (10 / velocity));
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (velocity <= 3) {
				velocity = velocity + 0.25;
			} else {
				velocity = Mth.nextDouble(RandomSource.create(), 1, 3);
			}
		}
	}
}
