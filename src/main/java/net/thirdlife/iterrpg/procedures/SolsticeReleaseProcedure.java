package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

public class SolsticeReleaseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		itemstack.getOrCreateTag().putDouble("CustomModelData", 1);
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
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = IterRpgModEntities.SOLSPHERE.get().spawn(_serverLevel, BlockPos.containing(x, (y + 1.5), z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
			}
			(entitytospawn).getPersistentData().putDouble("lifetime", 120);
			(entitytospawn).setDeltaMovement(new Vec3((entity.getLookAngle().x / 4), (entity.getLookAngle().y / 4), (entity.getLookAngle().z / 4)));
			(entitytospawn).setNoGravity(true);
			(entitytospawn).getPersistentData().putDouble("speed", 0.15);
			(entitytospawn).getPersistentData().putDouble("xvec", (entity.getLookAngle().x));
			(entitytospawn).getPersistentData().putDouble("yvec", (entity.getLookAngle().y));
			(entitytospawn).getPersistentData().putDouble("zvec", (entity.getLookAngle().z));
		}
	}
}
