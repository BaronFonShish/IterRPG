package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

public class HarvestSendBouldersProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		boolean flag = false;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 32);
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
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		}
		for (int index0 = 0; index0 < 3; index0++) {
			flag = true;
			xpos = x + Mth.nextDouble(RandomSource.create(), -1, 1);
			zpos = z + Mth.nextDouble(RandomSource.create(), -1, 1);
			ypos = y - 5;
			for (int index1 = 0; index1 < 12; index1++) {
				if (flag && world.isEmptyBlock(BlockPos.containing(xpos, ypos, zpos)) && world.getBlockState(BlockPos.containing(xpos, ypos - 1, zpos)).isFaceSturdy(world, BlockPos.containing(xpos, ypos - 1, zpos), Direction.UP)) {
					flag = false;
					if (world instanceof ServerLevel _serverLevel) {
						Entity entitytospawn = IterRpgModEntities.EARTH_BOULDER.get().spawn(_serverLevel, BlockPos.containing(xpos, ypos, zpos), MobSpawnType.MOB_SUMMONED);
						if (entitytospawn != null) {
							entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						}
						(entitytospawn).getPersistentData().putBoolean("friendly", true);
						(entitytospawn).getPersistentData().putDouble("ascend", (Mth.nextDouble(RandomSource.create(), 2.5, 4)));
						(entitytospawn).getPersistentData().putString("owner", (entity.getStringUUID()));
					}
				} else {
					ypos = ypos + 1;
				}
			}
		}
	}
}
