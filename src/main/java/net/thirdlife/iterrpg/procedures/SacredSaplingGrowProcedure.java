package net.thirdlife.iterrpg.procedures;

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

public class SacredSaplingGrowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double type = 0;
		double rotation = 0;
		double mirror = 0;
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 3, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 4, z))
				&& world.isEmptyBlock(BlockPos.containing(x, y + 5, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 6, z)) && Math.random() >= 0.475) {
			type = Mth.nextInt(RandomSource.create(), 1, 3);
			if (type == 1) {
				rotation = Mth.nextInt(RandomSource.create(), 1, 4);
				if (rotation == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 3, y, z - 3), BlockPos.containing(x - 3, y, z - 3), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (rotation == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x + 3, y, z - 3), BlockPos.containing(x + 3, y, z - 3),
									new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (rotation == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x + 3, y, z + 3), BlockPos.containing(x + 3, y, z + 3),
									new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (rotation == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 3, y, z + 3), BlockPos.containing(x - 3, y, z + 3),
									new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
			} else if (type == 2) {
				rotation = Mth.nextInt(RandomSource.create(), 1, 4);
				if (rotation == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 4, y, z - 3), BlockPos.containing(x - 4, y, z - 3), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (rotation == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x + 4, y, z - 3), BlockPos.containing(x + 4, y, z - 3),
									new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (rotation == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x + 4, y, z + 3), BlockPos.containing(x + 4, y, z + 3),
									new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (rotation == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 4, y, z + 3), BlockPos.containing(x - 4, y, z + 3),
									new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
			} else if (type == 3) {
				rotation = Mth.nextInt(RandomSource.create(), 1, 4);
				if (rotation == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z - 2), BlockPos.containing(x - 2, y, z - 2), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (rotation == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y, z - 2), BlockPos.containing(x + 2, y, z - 2),
									new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (rotation == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y, z + 2), BlockPos.containing(x + 2, y, z + 2),
									new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				} else if (rotation == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z + 2), BlockPos.containing(x - 2, y, z + 2),
									new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
				}
			}
		}
	}
}
