package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.common.entity.WeeperEntity;
import net.thirdlife.iterrpg.common.entity.WaterElementalEntity;
import net.thirdlife.iterrpg.common.entity.VoidElementalEntity;
import net.thirdlife.iterrpg.common.entity.SpiderlingEntity;
import net.thirdlife.iterrpg.common.entity.MournstoneEntity;
import net.thirdlife.iterrpg.common.entity.HobgoblinEntity;
import net.thirdlife.iterrpg.common.entity.GrieverEntity;
import net.thirdlife.iterrpg.common.entity.GoblinWarriorEntity;
import net.thirdlife.iterrpg.common.entity.GoblinEntity;
import net.thirdlife.iterrpg.common.entity.FireElementalEntity;
import net.thirdlife.iterrpg.common.entity.EarthElementalEntity;
import net.thirdlife.iterrpg.common.entity.AirElementalEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

public class MobPlacerModelProviderProcedure {
	public static Entity execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return null;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == 0) {
			return world instanceof Level _level ? new GoblinEntity(IterRpgModEntities.GOBLIN.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == 1) {
			return world instanceof Level _level ? new GoblinWarriorEntity(IterRpgModEntities.GOBLIN_WARRIOR.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == 2) {
			return world instanceof Level _level ? new HobgoblinEntity(IterRpgModEntities.HOBGOBLIN.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == 3) {
			return world instanceof Level _level ? new GrieverEntity(IterRpgModEntities.GRIEVER.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == 4) {
			return world instanceof Level _level ? new MournstoneEntity(IterRpgModEntities.MOURNSTONE.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == 5) {
			return world instanceof Level _level ? new WeeperEntity(IterRpgModEntities.WEEPER.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == -1) {
			return world instanceof Level _level ? new GrieverEntity(IterRpgModEntities.GRIEVER.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == -2) {
			return world instanceof Level _level ? new GoblinWarriorEntity(IterRpgModEntities.GOBLIN_WARRIOR.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == -3) {
			return world instanceof Level _level ? new SpiderlingEntity(IterRpgModEntities.SPIDERLING.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == -4) {
			return world instanceof Level _level ? new Zombie(EntityType.ZOMBIE, _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == -5) {
			return world instanceof Level _level ? new EarthElementalEntity(IterRpgModEntities.EARTH_ELEMENTAL.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == -6) {
			return world instanceof Level _level ? new WaterElementalEntity(IterRpgModEntities.WATER_ELEMENTAL.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == -7) {
			return world instanceof Level _level ? new AirElementalEntity(IterRpgModEntities.AIR_ELEMENTAL.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == -8) {
			return world instanceof Level _level ? new FireElementalEntity(IterRpgModEntities.FIRE_ELEMENTAL.get(), _level) : null;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("select") == -9) {
			return world instanceof Level _level ? new VoidElementalEntity(IterRpgModEntities.VOID_ELEMENTAL.get(), _level) : null;
		}
		return null;
	}
}
