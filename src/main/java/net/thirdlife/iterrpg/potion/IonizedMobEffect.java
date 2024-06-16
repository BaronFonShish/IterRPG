
package net.thirdlife.iterrpg.potion;

import net.thirdlife.iterrpg.procedures.IonizedEffectProcedure;
import net.thirdlife.iterrpg.procedures.IonizedDischargeProcedure;

import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class IonizedMobEffect extends MobEffect {
	public IonizedMobEffect() {
		super(MobEffectCategory.HARMFUL, -16724737);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		IonizedEffectProcedure.execute(entity.level(), entity.getY(), entity, amplifier);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		IonizedDischargeProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void initializeClient(java.util.function.Consumer<IClientMobEffectExtensions> consumer) {
		consumer.accept(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		});
	}
}
