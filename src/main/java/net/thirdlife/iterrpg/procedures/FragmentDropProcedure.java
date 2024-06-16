package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FragmentDropProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double luck = 0;
		double base = 0;
		double amount = 0;
		if (sourceentity instanceof Player) {
			if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT) && (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:earth_entities")))
					|| entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:water_entities"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:air_entities")))
					|| entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:fire_entities"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:void_entities"))))) {
				luck = Mth.nextInt(RandomSource.create(), 1, 7500);
				base = 5 + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 2.5;
				if (base >= luck) {
					if (IterRpgModVariables.MapVariables.get(world).unlocked_earth && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:earth_entities")))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(IterRpgModItems.EARTH_FRAGMENT.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (IterRpgModVariables.MapVariables.get(world).unlocked_water && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:water_entities")))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(IterRpgModItems.WATER_FRAGMENT.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (IterRpgModVariables.MapVariables.get(world).unlocked_air && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:air_entities")))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(IterRpgModItems.AIR_FRAGMENT.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (IterRpgModVariables.MapVariables.get(world).unlocked_fire && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:fire_entities")))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(IterRpgModItems.FIRE_FRAGMENT.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (IterRpgModVariables.MapVariables.get(world).unlocked_void && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:void_entities")))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(IterRpgModItems.VOID_FRAGMENT.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
