package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class WarpedGooEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xpos = 0;
		double zpos = 0;
		double ycheck = 0;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 140, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 0, false, false));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, y, z, 16, 0.25, 0.25, 0.25, 0.25);
		if ((entity.level().dimension()) == Level.NETHER) {
			if (y >= 127) {
				xpos = Mth.nextInt(RandomSource.create(), -1200, 1200);
				zpos = Mth.nextInt(RandomSource.create(), -1200, 1200);
				{
					Entity _ent = entity;
					_ent.teleportTo(xpos, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xpos, (int) zpos) + 1), zpos);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(xpos, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xpos, (int) zpos) + 1), zpos, _ent.getYRot(), _ent.getXRot());
				}
			} else {
				for (int index0 = 0; index0 < 6; index0++) {
					xpos = Mth.nextInt(RandomSource.create(), -1200, 1200);
					zpos = Mth.nextInt(RandomSource.create(), -1200, 1200);
					ycheck = 32;
					for (int index1 = 0; index1 < 70; index1++) {
						if (world.isEmptyBlock(BlockPos.containing(xpos, ycheck + 1, zpos)) && world.isEmptyBlock(BlockPos.containing(xpos, ycheck + 2, zpos)) && world.getBlockState(BlockPos.containing(xpos, ycheck, zpos)).canOcclude()) {
							{
								Entity _ent = entity;
								_ent.teleportTo(xpos, (ycheck + 1), zpos);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(xpos, (ycheck + 1), zpos, _ent.getYRot(), _ent.getXRot());
							}
							break;
						} else {
							ycheck = ycheck + 1;
						}
					}
				}
			}
		}
		if ((entity.level().dimension()) == Level.END) {
			for (int index2 = 0; index2 < 12; index2++) {
				xpos = Mth.nextInt(RandomSource.create(), -1200, 1200);
				zpos = Mth.nextInt(RandomSource.create(), -1200, 1200);
				if (world.getBlockState(BlockPos.containing(xpos, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xpos, (int) zpos), zpos)).canOcclude()) {
					{
						Entity _ent = entity;
						_ent.teleportTo(xpos, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xpos, (int) zpos) + 1), zpos);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(xpos, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xpos, (int) zpos) + 1), zpos, _ent.getYRot(), _ent.getXRot());
					}
					break;
				}
			}
		}
		if ((entity.level().dimension()) == Level.OVERWORLD) {
			for (int index3 = 0; index3 < 12; index3++) {
				xpos = Mth.nextInt(RandomSource.create(), -1200, 1200);
				zpos = Mth.nextInt(RandomSource.create(), -1200, 1200);
				if (world.getBlockState(BlockPos.containing(xpos, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xpos, (int) zpos), zpos)).canOcclude()) {
					{
						Entity _ent = entity;
						_ent.teleportTo(xpos, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xpos, (int) zpos) + 1), zpos);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(xpos, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xpos, (int) zpos) + 1), zpos, _ent.getYRot(), _ent.getXRot());
					}
					break;
				}
			}
		}
	}
}
