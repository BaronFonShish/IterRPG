package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.common.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModGameRules;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class MobmorphTurnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double y_decide = 0;
		if (world.getLevelData().getGameRules().getBoolean(IterRpgModGameRules.BUILDINGDEBUG) == false) {
			if ((entity.getPersistentData().getString("TurnInto")).equals("goblin")) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = IterRpgModEntities.GOBLIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("goblin_warrior")) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = IterRpgModEntities.GOBLIN_WARRIOR.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("hobgoblin")) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = IterRpgModEntities.HOBGOBLIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("griever")) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = IterRpgModEntities.GRIEVER.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					if ((entitytospawn) instanceof Mob _entity)
						_entity.setPersistenceRequired();
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("mournstone")) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = IterRpgModEntities.MOURNSTONE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					if ((entitytospawn) instanceof Mob _entity)
						_entity.setPersistenceRequired();
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("weeper")) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = IterRpgModEntities.WEEPER.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					if ((entitytospawn) instanceof Mob _entity)
						_entity.setPersistenceRequired();
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("dungeon_sorrow_spire")) {
				if (IterRpgModVariables.MapVariables.get(world).config_sorrow_spire) {
					y_decide = 35;
					SorrowSpirePrepareProcedure.execute(world, x, z);
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("dungeon_goblin")) {
				if (IterRpgModVariables.MapVariables.get(world).config_goblin_camps) {
					GoblinDungeonPrepareProcedure.execute(world, x, y, z);
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("dungeon_spider")) {
				if (IterRpgModVariables.MapVariables.get(world).config_spider_catacombs) {
					y_decide = Mth.nextInt(RandomSource.create(), -40, 40);
					ArthropodCatacombsPrepareProcedure.execute(world, x, y_decide, z);
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("dungeon_generic")) {
				if (IterRpgModVariables.MapVariables.get(world).config_generic_dungeons) {
					y_decide = Mth.nextInt(RandomSource.create(), -40, 40);
					GenericDungeonPrepareProcedure.execute(world, x, y_decide, z);
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("shrine_earth")) {
				if (IterRpgModVariables.MapVariables.get(world).config_elementals) {
					y_decide = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z);
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "shrine_earth"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 10, y_decide - 12, z - 10), BlockPos.containing(x - 10, y_decide - 12, z - 10),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("shrine_water")) {
				if (IterRpgModVariables.MapVariables.get(world).config_elementals) {
					y_decide = world.getHeight(Heightmap.Types.OCEAN_FLOOR, (int) x, (int) z);
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "shrine_water"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 10, y_decide - 1, z - 15), BlockPos.containing(x - 10, y_decide - 1, z - 15),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("shrine_air")) {
				if (IterRpgModVariables.MapVariables.get(world).config_elementals) {
					y_decide = Mth.nextInt(RandomSource.create(), 220, 250);
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "shrine_air"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 10, y_decide, z - 10), BlockPos.containing(x - 10, y_decide, z - 10),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("shrine_fire")) {
				if (IterRpgModVariables.MapVariables.get(world).config_elementals) {
					y_decide = 31;
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "shrine_fire"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 24, y_decide, z - 24), BlockPos.containing(x - 24, y_decide, z - 24),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("shrine_void")) {
				if (IterRpgModVariables.MapVariables.get(world).config_elementals) {
					y_decide = Mth.nextInt(RandomSource.create(), 50, 170);
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "shrine_void"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 12, y_decide, z - 12), BlockPos.containing(x - 12, y_decide, z - 12),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if ((entity.getPersistentData().getString("TurnInto")).equals("dungeon_monolith")) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
