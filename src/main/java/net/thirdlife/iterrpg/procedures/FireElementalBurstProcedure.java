package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.FireballProjectileProjectileEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

public class FireElementalBurstProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 8, 12); index0++) {
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, float damage, int knockback) {
						AbstractArrow entityToSpawn = new FireballProjectileProjectileEntity(IterRpgModEntities.FIREBALL_PROJECTILE_PROJECTILE.get(), level);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, 7, 1);
				_entityToSpawn.setPos(x, (y + 0.5), z);
				_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), 1, (Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), (float) Mth.nextDouble(RandomSource.create(), 0.4, 0.6), 15);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
	}
}
