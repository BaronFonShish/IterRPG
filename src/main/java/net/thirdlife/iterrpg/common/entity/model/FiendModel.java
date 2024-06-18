package net.thirdlife.iterrpg.common.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.thirdlife.iterrpg.common.entity.FiendEntity;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

public class FiendModel extends GeoModel<FiendEntity> {
	@Override
	public ResourceLocation getAnimationResource(FiendEntity entity) {
		return new ResourceLocation("iter_rpg", "animations/fiend.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FiendEntity entity) {
		return new ResourceLocation("iter_rpg", "geo/fiend.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FiendEntity entity) {
		return new ResourceLocation("iter_rpg", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(FiendEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("mob");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
