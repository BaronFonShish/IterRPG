package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class TorrentStrikeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double attackpower = 0;
		double rotation = 0;
		double distance = 0;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double type = 0;
		double damage = 0;
		double repeat = 0;
		double mobamount = 0;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(IterRpgModMobEffects.WRATH_OF_THE_DEPTHS.get(), 2400, 0, false, true));
	}
}
