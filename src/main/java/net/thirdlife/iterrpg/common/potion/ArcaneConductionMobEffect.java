
package net.thirdlife.iterrpg.common.potion;

import net.thirdlife.iterrpg.common.procedures.ArcaneConductionResetProcedure;
import net.thirdlife.iterrpg.common.procedures.ArcaneConductionFunctionProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ArcaneConductionMobEffect extends MobEffect {
	public ArcaneConductionMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3407668);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ArcaneConductionFunctionProcedure.execute();
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		ArcaneConductionResetProcedure.execute();
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
