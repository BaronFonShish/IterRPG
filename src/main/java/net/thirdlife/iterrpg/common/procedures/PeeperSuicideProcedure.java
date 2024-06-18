package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.common.entity.PeeperEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PeeperSuicideProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		execute(null, world, x, y, z, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof PeeperEntity) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ()), 8, 0.2, 0.2, 0.2, 0.025);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ASH, (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ()), 8, 0.2, 0.2, 0.2, 0.025);
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 2); index0++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.SILVERFISH.spawn(_level, BlockPos.containing(sourceentity.getX() + Mth.nextDouble(RandomSource.create(), -0.2, 0.2), sourceentity.getY() + Mth.nextDouble(RandomSource.create(), 0.3, 0.6),
							sourceentity.getZ() + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 2); index1++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = IterRpgModEntities.SPIDERLING.get().spawn(_level, BlockPos.containing(sourceentity.getX() + Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
							sourceentity.getY() + Mth.nextDouble(RandomSource.create(), 0.3, 0.6), sourceentity.getZ() + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 1, 1.5));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 1, 1.5), false);
				}
			}
			if (!sourceentity.level().isClientSide())
				sourceentity.discard();
		}
	}
}
