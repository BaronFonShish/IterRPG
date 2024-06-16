package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import java.util.List;
import java.util.Comparator;

public class ElementalsSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double elementsnear = 0;
		double elementstotal = 0;
		elementsnear = 0;
		elementstotal = 0;
		if (ElementalsConfigConditionProcedure.execute(world)) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:elementals")))) {
						elementsnear = elementsnear + 1;
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(250 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:elementals")))) {
						elementstotal = elementstotal + 1;
					}
				}
			}
			if (elementsnear < 1 && elementstotal < 2) {
				return true;
			}
		}
		return false;
	}
}
