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

public class SorrowSpireSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double DungeonDecide = 0;
		double variation = 0;
		if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sorrow_spire_base1"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 16, y - 16, z - 16), BlockPos.containing(x - 16, y - 16, z - 16), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sorrow_spire_base2"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 16, y - 16, z - 16), BlockPos.containing(x - 16, y - 16, z - 16), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
		if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sorrow_spire_top1"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 11, y + 6, z - 11), BlockPos.containing(x - 11, y + 6, z - 11), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sorrow_spire_top2"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 11, y + 6, z - 11), BlockPos.containing(x - 11, y + 6, z - 11), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
		if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sorrow_spire_spire1"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y + 28, z - 6), BlockPos.containing(x - 6, y + 28, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		} else {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sorrow_spire_spire2"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y + 28, z - 6), BlockPos.containing(x - 6, y + 28, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
	}
}
