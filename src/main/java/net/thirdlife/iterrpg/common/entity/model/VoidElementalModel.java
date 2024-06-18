package net.thirdlife.iterrpg.common.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.thirdlife.iterrpg.common.entity.VoidElementalEntity;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

public class VoidElementalModel extends GeoModel<VoidElementalEntity> {
	@Override
	public ResourceLocation getAnimationResource(VoidElementalEntity entity) {
		return new ResourceLocation("iter_rpg", "animations/void_elemental.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VoidElementalEntity entity) {
		return new ResourceLocation("iter_rpg", "geo/void_elemental.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VoidElementalEntity entity) {
		return new ResourceLocation("iter_rpg", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(VoidElementalEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
