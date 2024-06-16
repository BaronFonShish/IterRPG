package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class ShouldDamageProcedure {
	public static boolean execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return false;
		if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage"))) && !(sourceentity == entity)) {
			return true;
		}
		return false;
	}
}
