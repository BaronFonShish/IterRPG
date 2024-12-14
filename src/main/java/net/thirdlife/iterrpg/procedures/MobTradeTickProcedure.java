package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;
import java.util.Map;

import com.mojang.util.UUIDTypeAdapter;

public class MobTradeTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
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
			}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getDouble("limit1") >= 1) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((((new Object() {
						public Entity get(LevelAccessor _world, String _uuid) {
							try {
								if (_world instanceof ServerLevel _serverLevel) {
									return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
								}
							} catch (Exception _e) {
							}
							return null;
						}
					}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getString("trade1")))
							.toLowerCase(java.util.Locale.ENGLISH)))).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(0)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				{
					double _setval = ((new Object() {
						public Entity get(LevelAccessor _world, String _uuid) {
							try {
								if (_world instanceof ServerLevel _serverLevel) {
									return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
								}
							} catch (Exception _e) {
							}
							return null;
						}
					}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getDouble("price1");
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.price1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(0)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				{
					double _setval = 0;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.price1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
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
			}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getDouble("limit2") >= 1) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((((new Object() {
						public Entity get(LevelAccessor _world, String _uuid) {
							try {
								if (_world instanceof ServerLevel _serverLevel) {
									return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
								}
							} catch (Exception _e) {
							}
							return null;
						}
					}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getString("trade2")))
							.toLowerCase(java.util.Locale.ENGLISH)))).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(1)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				{
					double _setval = ((new Object() {
						public Entity get(LevelAccessor _world, String _uuid) {
							try {
								if (_world instanceof ServerLevel _serverLevel) {
									return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
								}
							} catch (Exception _e) {
							}
							return null;
						}
					}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getDouble("price2");
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.price2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(1)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				{
					double _setval = 0;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.price2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
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
			}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getDouble("limit3") >= 1) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((((new Object() {
						public Entity get(LevelAccessor _world, String _uuid) {
							try {
								if (_world instanceof ServerLevel _serverLevel) {
									return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
								}
							} catch (Exception _e) {
							}
							return null;
						}
					}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getString("trade3")))
							.toLowerCase(java.util.Locale.ENGLISH)))).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(2)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				{
					double _setval = ((new Object() {
						public Entity get(LevelAccessor _world, String _uuid) {
							try {
								if (_world instanceof ServerLevel _serverLevel) {
									return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
								}
							} catch (Exception _e) {
							}
							return null;
						}
					}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getDouble("price3");
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.price3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(2)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				{
					double _setval = 0;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.price3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
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
			}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getDouble("limit4") >= 1) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((((new Object() {
						public Entity get(LevelAccessor _world, String _uuid) {
							try {
								if (_world instanceof ServerLevel _serverLevel) {
									return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
								}
							} catch (Exception _e) {
							}
							return null;
						}
					}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getString("trade4")))
							.toLowerCase(java.util.Locale.ENGLISH)))).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(3)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				{
					double _setval = ((new Object() {
						public Entity get(LevelAccessor _world, String _uuid) {
							try {
								if (_world instanceof ServerLevel _serverLevel) {
									return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
								}
							} catch (Exception _e) {
							}
							return null;
						}
					}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getDouble("price4");
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.price4 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(3)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				{
					double _setval = 0;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.price4 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
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
			}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getDouble("limit5") >= 1) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((((new Object() {
						public Entity get(LevelAccessor _world, String _uuid) {
							try {
								if (_world instanceof ServerLevel _serverLevel) {
									return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
								}
							} catch (Exception _e) {
							}
							return null;
						}
					}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getString("trade5")))
							.toLowerCase(java.util.Locale.ENGLISH)))).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(4)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				{
					double _setval = ((new Object() {
						public Entity get(LevelAccessor _world, String _uuid) {
							try {
								if (_world instanceof ServerLevel _serverLevel) {
									return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
								}
							} catch (Exception _e) {
							}
							return null;
						}
					}).get(world, ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).CurrentlyTrading))).getPersistentData().getDouble("price5");
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.price5 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(4)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				{
					double _setval = 0;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.price5 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
