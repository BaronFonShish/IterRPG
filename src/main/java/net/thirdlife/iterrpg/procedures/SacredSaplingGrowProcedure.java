package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class SacredSaplingGrowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 3, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 4, z))
				&& world.isEmptyBlock(BlockPos.containing(x, y + 5, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 6, z)) && Math.random() >= 0.475) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "sacred_tree_1"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y, z - 2), BlockPos.containing(x - 2, y, z - 2), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
	}
}
