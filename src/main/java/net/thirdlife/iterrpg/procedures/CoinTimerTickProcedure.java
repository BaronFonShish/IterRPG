package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.List;
import java.util.Comparator;

public class CoinTimerTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean agr = false;
		boolean share = false;
		double fromZ = 0;
		double fromX = 0;
		double fromY = 0;
		share = false;
		if (entity.getPersistentData().getDouble("otcup") >= 1) {
			entity.getPersistentData().putDouble("otcup", (entity.getPersistentData().getDouble("otcup") - 1));
		}
		if (entity.getPersistentData().getDouble("war") >= 1) {
			entity.getPersistentData().putDouble("war", (entity.getPersistentData().getDouble("war") - 1));
		}
		if (entity.getPersistentData().getDouble("otcup") <= 9600 && entity.getPersistentData().getDouble("war") <= 1) {
			{
				final Vec3 _center = new Vec3(x, (y + entity.getBbHeight() / 2), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getBbHeight()) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof ItemEntity) {
						if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == IterRpgModItems.COIN.get()) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.COIN_PARTICLE.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 8, 0, 0, 0, 0.25);
							(entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).shrink(1);
							entity.getPersistentData().putDouble("otcup", (entity.getPersistentData().getDouble("otcup") + Mth.nextInt(RandomSource.create(), 1200, 3000)));
							share = true;
						}
					}
				}
			}
		}
		if (share == true) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("iter_rpg:life_tax"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:goblins")))) {
						entityiterator.getPersistentData().putDouble("otcup", (entityiterator.getPersistentData().getDouble("otcup") + Mth.nextInt(RandomSource.create(), 1200, 3000)));
					}
				}
			}
		}
	}
}
