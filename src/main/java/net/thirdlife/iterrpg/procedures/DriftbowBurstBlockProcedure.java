package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.DropletProjectileProjectileEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class DriftbowBurstBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.splash")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.splash")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SPLASH, (x + 0.5), (y + 0.5), (z + 0.5), 8, 0.25, 0.25, 0.25, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.BUBBLE_POP, (x + 0.5), (y + 0.5), (z + 0.5), 8, 0.25, 0.25, 0.25, 0.025);
		for (int index0 = 0; index0 < 6; index0++) {
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
						AbstractArrow entityToSpawn = new DropletProjectileProjectileEntity(IterRpgModEntities.DROPLET_PROJECTILE_PROJECTILE.get(), level);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						entityToSpawn.setPierceLevel(piercing);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, 3, 0, (byte) 1);
				_entityToSpawn.setPos((x + 0.5), (y + 1.1), (z + 0.5));
				_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -0.25, 2)), (Mth.nextDouble(RandomSource.create(), -1, 1)), (float) Mth.nextDouble(RandomSource.create(), 0.25, 0.4), 5);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
	}
}
