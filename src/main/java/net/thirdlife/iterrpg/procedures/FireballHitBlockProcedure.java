package net.thirdlife.iterrpg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class FireballHitBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LAVA, (x + 0.5), (y + 0.5), (z + 0.5), 8, 0.25, 0.25, 0.25, 0.15);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 2, 4));
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 2, 4), false);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.FIRE.defaultBlockState(), 3);
		}
	}
}
