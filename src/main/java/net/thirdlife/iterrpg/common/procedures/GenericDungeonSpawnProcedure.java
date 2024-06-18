package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GenericDungeonSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double DungeonDecide = 0;
		double variation = 0;
		double type = 0;
		type = Mth.nextInt(RandomSource.create(), 1, 3);
		if (type != 2) {
			DungeonDecide = Mth.nextInt(RandomSource.create(), 1, 8);
			if (DungeonDecide == 1) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "cave_lake"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y + 1, z - 7), BlockPos.containing(x - 6, y + 1, z - 7), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (DungeonDecide == 2) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "small_library_ruins"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 4, y + 1, z - 5), BlockPos.containing(x - 4, y + 1, z - 5), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (DungeonDecide == 3) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "deepslate_cavity"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 5, y + 1, z - 5), BlockPos.containing(x - 5, y + 1, z - 5), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (DungeonDecide == 4) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "simple_dungeon1"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 5, y + 1, z - 1), BlockPos.containing(x - 5, y + 1, z - 1), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (DungeonDecide == 5) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "simple_dungeon2"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 5, y + 1, z - 1), BlockPos.containing(x - 5, y + 1, z - 1), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (DungeonDecide == 6) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "simple_dungeon3"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 5, y + 1, z - 1), BlockPos.containing(x - 5, y + 1, z - 1), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (DungeonDecide == 7) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "simple_dungeon4"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 5, y + 1, z - 1), BlockPos.containing(x - 5, y + 1, z - 1), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (DungeonDecide == 8) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "simple_dungeon5"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 5, y + 1, z - 1), BlockPos.containing(x - 5, y + 1, z - 1), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			}
		} else {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("ice_spikes")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_plains"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_taiga")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("cold_ocean"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_cold_ocean")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_slopes"))) {
				DungeonDecide = Mth.nextInt(RandomSource.create(), 1, 4);
				if (DungeonDecide == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "ice_dungeon1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y + 1, z - 8), BlockPos.containing(x - 8, y + 1, z - 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (DungeonDecide == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "ice_dungeon2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y + 1, z - 8), BlockPos.containing(x - 8, y + 1, z - 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (DungeonDecide == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "ice_dungeon3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y + 1, z - 8), BlockPos.containing(x - 8, y + 1, z - 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (DungeonDecide == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "ice_dungeon4"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y + 1, z - 8), BlockPos.containing(x - 8, y + 1, z - 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("desert")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("wooded_badlands"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("badlands")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("eroded_badlands"))) {
				DungeonDecide = Mth.nextInt(RandomSource.create(), 1, 3);
				if (DungeonDecide == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "desert_dungeon1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y + 1, z - 8), BlockPos.containing(x - 8, y + 1, z - 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (DungeonDecide == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "desert_dungeon2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y + 1, z - 8), BlockPos.containing(x - 8, y + 1, z - 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (DungeonDecide == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "desert_dungeon3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y + 1, z - 8), BlockPos.containing(x - 8, y + 1, z - 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("bamboo_jungle")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("jungle")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("sparse_jungle"))) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "jungle_dungeon"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y + 1, z - 8), BlockPos.containing(x - 8, y + 1, z - 8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else {
				DungeonDecide = Mth.nextInt(RandomSource.create(), 1, 5);
				if (DungeonDecide == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "generic_dungeon1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 23, y + 1, z - 20), BlockPos.containing(x - 23, y + 1, z - 20),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (DungeonDecide == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "generic_dungeon2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 12, y + 1, z - 13), BlockPos.containing(x - 12, y + 1, z - 13),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (DungeonDecide == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "generic_dungeon3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 15, y + 1, z - 17), BlockPos.containing(x - 15, y + 1, z - 17),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (DungeonDecide == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "generic_dungeon4"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 12, y + 1, z - 12), BlockPos.containing(x - 12, y + 1, z - 12),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
			}
		}
		world.setBlock(BlockPos.containing(x, y, z), (world.getBlockState(BlockPos.containing(x, y - 1, z))), 3);
	}
}
