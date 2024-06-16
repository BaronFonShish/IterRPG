package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class BloodthirstKillProcedure {
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
		double splashdmg = 0;
		if (sourceentity instanceof Player && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == IterRpgModItems.BLOODTHIRST.get()) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, (y + entity.getBbHeight() / 2), z, 20, (entity.getBbWidth() / 2), (entity.getBbHeight() / 2), (entity.getBbWidth() / 2), 0);
			{
				final Vec3 _center = new Vec3(x, (y + entity.getBbHeight() / 2), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((2 * (entity.getBbWidth() + entity.getBbHeight())) / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
							&& !(entityiterator == sourceentity) && entityiterator instanceof LivingEntity) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 4);
					}
				}
			}
			if (sourceentity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(MobEffects.DAMAGE_BOOST) && sourceentity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(MobEffects.DIG_SPEED)) {
				if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DIG_SPEED) ? _livEnt.getEffect(MobEffects.DIG_SPEED).getDuration() : 0) <= 1080) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, (int) ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DIG_SPEED) ? _livEnt.getEffect(MobEffects.DIG_SPEED).getDuration() : 0) + 120),
								0, false, true));
				}
				if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getDuration() : 0) <= 1080) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,
								(int) ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getDuration() : 0) + 120), 0, false, true));
				}
			} else {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 100, 0, true, false));
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 0, true, false));
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), (sourceentity.getX()), (sourceentity.getY() + 0.9), (sourceentity.getZ()), 8, 0.16, 0.3, 0.16, 0);
		}
	}
}
