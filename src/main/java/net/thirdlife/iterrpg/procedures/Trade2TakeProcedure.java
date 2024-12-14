package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import com.mojang.util.UUIDTypeAdapter;

public class Trade2TakeProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).PlayerCoinAmount
					- (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).price2;
			entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerCoinAmount = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (((new Object() {
			public Entity get(LevelAccessor _world, String _uuid) {
				try {
					if (_world instanceof ServerLevel _serverLevel) {
						return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
					}
				} catch (Exception _e) {
				}
				return null;
			}
		}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))) instanceof LivingEntity) {
			((new Object() {
				public Entity get(LevelAccessor _world, String _uuid) {
					try {
						if (_world instanceof ServerLevel _serverLevel) {
							return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
						}
					} catch (Exception _e) {
					}
					return null;
				}
			}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().putDouble("limit2", (((new Object() {
				public Entity get(LevelAccessor _world, String _uuid) {
					try {
						if (_world instanceof ServerLevel _serverLevel) {
							return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
						}
					} catch (Exception _e) {
					}
					return null;
				}
			}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getDouble("limit2") - 1));
		}
	}
}
