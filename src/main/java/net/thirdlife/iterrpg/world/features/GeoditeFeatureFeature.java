
package net.thirdlife.iterrpg.world.features;

import net.thirdlife.iterrpg.procedures.GeodesConfigConditionProcedure;

import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.Level;

public class GeoditeFeatureFeature extends OreFeature {
	public GeoditeFeatureFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		Level world = context.level().getLevel();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!GeodesConfigConditionProcedure.execute(world))
			return false;
		return super.place(context);
	}
}
