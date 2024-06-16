package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

public class CaltropUsedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean dospawn = false;
		double distance = 0;
		double ypos = 0;
		double yfinal = 0;
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			itemstack.shrink(1);
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 12);
		if (entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.MAIN_HAND, true);
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = IterRpgModEntities.CALTROP_THROWN.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
				entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
				entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
				entityToSpawn.setXRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
				entityToSpawn.setDeltaMovement((entity.getLookAngle().x * 0.75), (entity.getLookAngle().y * 0.75), (entity.getLookAngle().z * 0.75));
			}
		}
	}
}
