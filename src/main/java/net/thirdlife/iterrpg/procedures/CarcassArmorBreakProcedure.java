package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.CarcassEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CarcassArmorBreakProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, double amount) {
		execute(null, world, x, y, z, damagesource, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, double amount) {
		if (damagesource == null || entity == null)
			return;
		if (entity instanceof CarcassEntity && entity instanceof CarcassEntity _datEntL1 && _datEntL1.getEntityData().get(CarcassEntity.DATA_armored)
				&& (amount >= 10 + (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 8 || (damagesource.is(DamageTypes.FALLING_ANVIL) || damagesource.is(DamageTypes.FALLING_STALACTITE) || damagesource.is(DamageTypes.STALAGMITE)
						|| damagesource.is(DamageTypes.TRIDENT) || damagesource.is(DamageTypes.PLAYER_EXPLOSION) || damagesource.is(DamageTypes.EXPLOSION)) && amount >= 6)) {
			if (entity instanceof CarcassEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CarcassEntity.DATA_armored, false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.HOSTILE, 1, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.HOSTILE, 1, (float) 0.8, false);
				}
			}
		}
	}
}
