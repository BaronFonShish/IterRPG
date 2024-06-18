package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.common.entity.ScallopEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class EternalTorrentReleaseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean hit = false;
		boolean particle = false;
		double distance = 0;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double damage = 0;
		double rotation = 0;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 250);
		if (entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.MAIN_HAND, true);
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = IterRpgModEntities.SCALLOP.get().spawn(_serverLevel, BlockPos.containing((x + Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), (y + 1.25), (z + Mth.nextDouble(RandomSource.create(), -0.25, 0.25))),
					MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
			}
			(entitytospawn).setDeltaMovement(new Vec3((entity.getLookAngle().x / Mth.nextDouble(RandomSource.create(), 1.75, 2.15)), (entity.getLookAngle().y / Mth.nextDouble(RandomSource.create(), 1.75, 2.15)),
					(entity.getLookAngle().z / Mth.nextDouble(RandomSource.create(), 1.75, 2.15))));
			(entitytospawn).getPersistentData().putBoolean("friendly", true);
			if ((entitytospawn) instanceof ScallopEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ScallopEntity.DATA_has_pearl, false);
		}
		for (int index0 = 0; index0 < 3; index0++) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = IterRpgModEntities.SMALL_SCALLOP.get().spawn(_serverLevel, BlockPos.containing((x + Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), (y + 1.25), (z + Mth.nextDouble(RandomSource.create(), -0.25, 0.25))),
						MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				}
				(entitytospawn).setDeltaMovement(new Vec3((entity.getLookAngle().x / Mth.nextDouble(RandomSource.create(), 1.75, 2.15)), (entity.getLookAngle().y / Mth.nextDouble(RandomSource.create(), 1.75, 2.15)),
						(entity.getLookAngle().z / Mth.nextDouble(RandomSource.create(), 1.75, 2.15))));
				(entitytospawn).getPersistentData().putBoolean("friendly", true);
			}
		}
	}
}
