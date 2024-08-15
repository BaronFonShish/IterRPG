package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class SorrowSpireSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double DungeonDecide = 0;
		double variation = 0;
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sorrow_spire_basement1"));
			if (template != null) {
				template.placeInWorld(_serverworld, BlockPos.containing(x - 24, y - 25, z - 24), BlockPos.containing(x - 24, y - 25, z - 24), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
						_serverworld.random, 3);
			}
		}
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sorrow_spire_middle1"));
			if (template != null) {
				template.placeInWorld(_serverworld, BlockPos.containing(x - 17, y + 12, z - 17), BlockPos.containing(x - 17, y + 12, z - 17), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
						_serverworld.random, 3);
			}
		}
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sorrow_spire_tip1"));
			if (template != null) {
				template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y + 48, z - 6), BlockPos.containing(x - 6, y + 48, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
						_serverworld.random, 3);
			}
		}
	}
}
