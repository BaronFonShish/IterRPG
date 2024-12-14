package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.ScallopEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class ScallopSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double count = 0;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("iter_rpg:scallop_biomes"))) && y > 0 && y < 80 && world.getBrightness(LightLayer.BLOCK, BlockPos.containing(x, y, z)) <= 2
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SAND || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.DIRT
						|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.CLAY || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK
						|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRAVEL || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.STONE)) {
			count = 0;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof ScallopEntity) {
						count = count + 1;
					}
				}
			}
			if (count <= 3) {
				return true;
			}
		}
		return false;
	}
}
