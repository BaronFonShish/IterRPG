
package net.thirdlife.iterrpg.common.world.features;

import net.thirdlife.iterrpg.common.procedures.SpiderEggsConfigConditionProcedure;

import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.Level;

public class SpiderEggFeatureFeature extends SimpleBlockFeature {
	public SpiderEggFeatureFeature() {
		super(SimpleBlockConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
		Level world = context.level().getLevel();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!SpiderEggsConfigConditionProcedure.execute(world))
			return false;
		return super.place(context);
	}
}
