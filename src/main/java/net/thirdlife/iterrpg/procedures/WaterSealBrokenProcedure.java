package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

public class WaterSealBrokenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double distance = 0;
		double xof = 0;
		double yof = 0;
		double zof = 0;
		if (!IterRpgModVariables.MapVariables.get(world).unlocked_water) {
			IterRpgModVariables.MapVariables.get(world).unlocked_water = true;
			IterRpgModVariables.MapVariables.get(world).syncData(world);
			for (int index0 = 0; index0 < 150; index0++) {
				world.addParticle((SimpleParticleType) (IterRpgModParticleTypes.WATER_SIGIL.get()), (x + 0.5), (y + 0.5), (z + 0.5), (Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
						(Mth.nextDouble(RandomSource.create(), -0.5, 0.5)));
			}
			for (int index1 = 0; index1 < 200; index1++) {
				world.addParticle((SimpleParticleType) (IterRpgModParticleTypes.WATER_SIGIL.get()), (x + Mth.nextDouble(RandomSource.create(), -20, 20)), (y + Mth.nextDouble(RandomSource.create(), -2, 6)),
						(z + Mth.nextDouble(RandomSource.create(), -20, 20)), 0, 0.05, 0);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.WATER_ELEMENTAL.get().spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement((Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), 0.05, (Mth.nextDouble(RandomSource.create(), -0.05, 0.05)));
				}
			}
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable("iterpg.global.waterseal").getString())), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable("iterpg.global.waterseal1").getString())), false);
		}
	}
}
