package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.common.entity.DropletProjectileProjectileEntity;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
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

public class DropletHitBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.FIRE || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.SOUL_FIRE) {
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, (x + 0.5), (y + 1), (z + 0.5), 8, 0.25, 0.25, 0.25, 0.15);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SPLASH, (x + 0.5), (y + 1), (z + 0.5), 8, 0.25, 0.25, 0.25, 0.15);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.BUBBLE_POP, (x + 0.5), (y + 1), (z + 0.5), 4, 0.25, 0.25, 0.25, 0.15);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.splash")), SoundSource.NEUTRAL, (float) 0.25, (float) Mth.nextDouble(RandomSource.create(), 2, 5));
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.splash")), SoundSource.NEUTRAL, (float) 0.25, (float) Mth.nextDouble(RandomSource.create(), 2, 5), false);
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.BUBBLE_POP, (x + 0.5), y, (z + 0.5), 4, 0.25, 0.25, 0.25, 0.15);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.RAIN, (x + 0.5), y, (z + 0.5), 4, 0.25, 0.25, 0.25, 0.15);
				IterRpgMod.queueServerWork(Mth.nextInt(RandomSource.create(), 10, 100), () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.RAIN, (x + 0.5), y, (z + 0.5), 4, 0.25, 0.25, 0.25, 0.15);
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
						}.getArrow(projectileLevel, 5, 1, (byte) 1);
						_entityToSpawn.setPos((x + Mth.nextDouble(RandomSource.create(), -1, 2)), (y - 0.25), (z + Mth.nextDouble(RandomSource.create(), -1, 2)));
						_entityToSpawn.shoot(0, (-1), 0, 0, 5);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				});
			}
		}
	}
}
