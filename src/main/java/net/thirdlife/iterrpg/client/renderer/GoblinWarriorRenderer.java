
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.GoblinWarriorEntity;
import net.thirdlife.iterrpg.client.model.Modelgoblin_warrior;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GoblinWarriorRenderer extends MobRenderer<GoblinWarriorEntity, Modelgoblin_warrior<GoblinWarriorEntity>> {
	public GoblinWarriorRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgoblin_warrior(context.bakeLayer(Modelgoblin_warrior.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(GoblinWarriorEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/goblin_warrior.png");
	}
}
