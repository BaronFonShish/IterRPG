
package net.thirdlife.iterrpg.world.features;

import net.thirdlife.iterrpg.procedures.AbyssQuartzConfigConditionProcedure;

import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.Level;

public class AbyssquartzFeatureFeature extends SimpleBlockFeature {
	public AbyssquartzFeatureFeature() {
		super(SimpleBlockConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
		Level world = context.level().getLevel();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!AbyssQuartzConfigConditionProcedure.execute(world))
			return false;
		return super.place(context);
	}
}
