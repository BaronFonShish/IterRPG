package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.GiantSpiderEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class GiantSpiderSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD
				&& !(!world.getEntitiesOfClass(GiantSpiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 120, 120, 120), e -> true).isEmpty()) && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 2
				&& (y <= 16 || world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("forge:giant_spider_biomes"))))) {
			return true;
		}
		return false;
	}
}
