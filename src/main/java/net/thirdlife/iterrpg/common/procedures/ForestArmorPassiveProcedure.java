package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.common.network.IterRpgModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ForestArmorPassiveProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double chance = 0;
		if (entity.isShiftKeyDown() && (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).ElementalArmorCooldown == 0) {
			if ((world.getBlockState(BlockPos.containing(entity.getX() + entity.getLookAngle().x * 0.8, entity.getY(), entity.getZ() + entity.getLookAngle().z * 0.8))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
					&& (world.getBlockState(BlockPos.containing(entity.getX() + entity.getLookAngle().x * 0.8, entity.getY() + 1, entity.getZ() + entity.getLookAngle().z * 0.8))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.getX() + entity.getLookAngle().x * 0.001), (entity.getY()), (entity.getZ() + entity.getLookAngle().z * 0.001));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getX() + entity.getLookAngle().x * 0.001), (entity.getY()), (entity.getZ() + entity.getLookAngle().z * 0.001), _ent.getYRot(), _ent.getXRot());
				}
				{
					double _setval = 16;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ElementalArmorCooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.001, entity.getZ()))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))) && entity.getLookAngle().y < -0.92) {
				{
					double _setval = 20;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ElementalArmorCooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.getX()), (entity.getY() - 0.001), (entity.getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getX()), (entity.getY() - 0.001), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}
