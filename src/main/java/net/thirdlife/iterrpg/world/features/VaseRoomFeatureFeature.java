
package net.thirdlife.iterrpg.world.features;

import net.thirdlife.iterrpg.procedures.VasesConfigConditionProcedure;

import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.SimpleRandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

public class VaseRoomFeatureFeature extends SimpleRandomSelectorFeature {
	public VaseRoomFeatureFeature() {
		super(SimpleRandomFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<SimpleRandomFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!VasesConfigConditionProcedure.execute(world))
			return false;
		return super.place(context);
	}
}
