
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.common.world.features.VaseRoomFeatureFeature;
import net.thirdlife.iterrpg.common.world.features.VaseFeatureFeature;
import net.thirdlife.iterrpg.common.world.features.SpiderEggFeatureFeature;
import net.thirdlife.iterrpg.common.world.features.GeoditeFeatureFeature;
import net.thirdlife.iterrpg.common.world.features.AbyssquartzFeatureFeature;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

@Mod.EventBusSubscriber
public class IterRpgModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, IterRpgMod.MOD_ID);
	public static final RegistryObject<Feature<?>> SPIDER_EGG_FEATURE = REGISTRY.register("spider_egg_feature", SpiderEggFeatureFeature::new);
	public static final RegistryObject<Feature<?>> ABYSSQUARTZ_FEATURE = REGISTRY.register("abyssquartz_feature", AbyssquartzFeatureFeature::new);
	public static final RegistryObject<Feature<?>> GEODITE_FEATURE = REGISTRY.register("geodite_feature", GeoditeFeatureFeature::new);
	public static final RegistryObject<Feature<?>> VASE_ROOM_FEATURE = REGISTRY.register("vase_room_feature", VaseRoomFeatureFeature::new);
	public static final RegistryObject<Feature<?>> VASE_FEATURE = REGISTRY.register("vase_feature", VaseFeatureFeature::new);
}
