package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.UnboundSoulEntity;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GhostHitProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		boolean flag = false;
		if (entity instanceof UnboundSoulEntity) {
			if (entity.getPersistentData().getDouble("evade") > Mth.nextInt(RandomSource.create(), 20, 150)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0, true, false));
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			} else {
				entity.getPersistentData().putDouble("evade", (entity.getPersistentData().getDouble("evade") + 35 + amount * 5));
			}
		}
	}
}
