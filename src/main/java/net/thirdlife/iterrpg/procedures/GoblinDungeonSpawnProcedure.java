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

public class GoblinDungeonSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double DungeonDecide = 0;
		double variation = 0;
		DungeonDecide = Mth.nextInt(RandomSource.create(), 1, 4);
		if (DungeonDecide == 1) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "goblin_camp_small"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 4, y - 1, z - 4), BlockPos.containing(x - 4, y - 1, z - 4), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else if (DungeonDecide == 2) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "goblin_camp_medium"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y - 2, z - 6), BlockPos.containing(x - 6, y - 2, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else if (DungeonDecide == 3) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "goblin_camp_big"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y - 3, z - 8), BlockPos.containing(x - 8, y - 3, z - 8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else if (DungeonDecide == 4) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "goblin_fortress"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 10, y - 4, z - 10), BlockPos.containing(x - 10, y - 4, z - 10), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
	}
}
