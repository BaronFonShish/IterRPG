package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModGameRules;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class SorrowsealedSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getLevelData().getGameRules().getBoolean(IterRpgModGameRules.BUILDINGDEBUG) == false) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y - 8), z), 48, 48, 48), e -> true).isEmpty()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = IterRpgModEntities.SORROWSEALED.get().spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
