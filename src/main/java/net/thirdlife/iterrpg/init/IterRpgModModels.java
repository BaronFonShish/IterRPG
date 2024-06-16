
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.client.model.Modelwitchmud_golem;
import net.thirdlife.iterrpg.client.model.Modelwindswirl;
import net.thirdlife.iterrpg.client.model.Modelweeper;
import net.thirdlife.iterrpg.client.model.Modelwater_elemental;
import net.thirdlife.iterrpg.client.model.Modelvoid_portal;
import net.thirdlife.iterrpg.client.model.Modelvengeful_spirit;
import net.thirdlife.iterrpg.client.model.Modelunbound_soul;
import net.thirdlife.iterrpg.client.model.Modeltiny_scallop;
import net.thirdlife.iterrpg.client.model.Modelspider_hatchling;
import net.thirdlife.iterrpg.client.model.Modelsorrowsealed;
import net.thirdlife.iterrpg.client.model.Modelsolsphere;
import net.thirdlife.iterrpg.client.model.Modelsea_arrow;
import net.thirdlife.iterrpg.client.model.Modelsam;
import net.thirdlife.iterrpg.client.model.Modelrevenant_gore;
import net.thirdlife.iterrpg.client.model.Modelrevenant;
import net.thirdlife.iterrpg.client.model.Modelpeeper_fallen;
import net.thirdlife.iterrpg.client.model.Modelpeeper;
import net.thirdlife.iterrpg.client.model.Modelmussel;
import net.thirdlife.iterrpg.client.model.Modelmudkin;
import net.thirdlife.iterrpg.client.model.Modelmournstone;
import net.thirdlife.iterrpg.client.model.Modelmarrow;
import net.thirdlife.iterrpg.client.model.Modelharvest_spiral;
import net.thirdlife.iterrpg.client.model.Modelhappy_spirit;
import net.thirdlife.iterrpg.client.model.Modelgrimhook;
import net.thirdlife.iterrpg.client.model.Modelgrimace;
import net.thirdlife.iterrpg.client.model.Modelgrim_boulder;
import net.thirdlife.iterrpg.client.model.Modelgriever;
import net.thirdlife.iterrpg.client.model.Modelgoblin_warrior;
import net.thirdlife.iterrpg.client.model.Modelgoblin;
import net.thirdlife.iterrpg.client.model.Modelgobjavelin_projectile;
import net.thirdlife.iterrpg.client.model.Modelgiant_spider;
import net.thirdlife.iterrpg.client.model.Modelforest_vines;
import net.thirdlife.iterrpg.client.model.Modelfire_elemental;
import net.thirdlife.iterrpg.client.model.Modelearth_elemental;
import net.thirdlife.iterrpg.client.model.Modeldwarf;
import net.thirdlife.iterrpg.client.model.Modeldroplet_projectile;
import net.thirdlife.iterrpg.client.model.Modeldemonspine;
import net.thirdlife.iterrpg.client.model.Modeldemon_soul;
import net.thirdlife.iterrpg.client.model.Modelchain_handle;
import net.thirdlife.iterrpg.client.model.Modelcarcass;
import net.thirdlife.iterrpg.client.model.Modelcaltrop;
import net.thirdlife.iterrpg.client.model.Modelblob;
import net.thirdlife.iterrpg.client.model.Modelbloated;
import net.thirdlife.iterrpg.client.model.Modelaura_tearburst;
import net.thirdlife.iterrpg.client.model.Modelaura_soulfire;
import net.thirdlife.iterrpg.client.model.Modelaura_mobspawn;
import net.thirdlife.iterrpg.client.model.Modelaura_boulder;
import net.thirdlife.iterrpg.client.model.Modelangry_spirit;
import net.thirdlife.iterrpg.client.model.Modelair_elemental;
import net.thirdlife.iterrpg.client.model.Modelaetherbolt;
import net.thirdlife.iterrpg.client.model.ModelThrowingSpear;
import net.thirdlife.iterrpg.client.model.ModelScab;
import net.thirdlife.iterrpg.client.model.ModelHobGoblin;
import net.thirdlife.iterrpg.client.model.ModelEarthBoulder;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class IterRpgModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelsea_arrow.LAYER_LOCATION, Modelsea_arrow::createBodyLayer);
		event.registerLayerDefinition(Modelsam.LAYER_LOCATION, Modelsam::createBodyLayer);
		event.registerLayerDefinition(Modelaura_mobspawn.LAYER_LOCATION, Modelaura_mobspawn::createBodyLayer);
		event.registerLayerDefinition(Modelcarcass.LAYER_LOCATION, Modelcarcass::createBodyLayer);
		event.registerLayerDefinition(ModelScab.LAYER_LOCATION, ModelScab::createBodyLayer);
		event.registerLayerDefinition(Modelpeeper_fallen.LAYER_LOCATION, Modelpeeper_fallen::createBodyLayer);
		event.registerLayerDefinition(Modelaura_boulder.LAYER_LOCATION, Modelaura_boulder::createBodyLayer);
		event.registerLayerDefinition(Modelaura_soulfire.LAYER_LOCATION, Modelaura_soulfire::createBodyLayer);
		event.registerLayerDefinition(Modeldroplet_projectile.LAYER_LOCATION, Modeldroplet_projectile::createBodyLayer);
		event.registerLayerDefinition(Modelgoblin.LAYER_LOCATION, Modelgoblin::createBodyLayer);
		event.registerLayerDefinition(Modelcaltrop.LAYER_LOCATION, Modelcaltrop::createBodyLayer);
		event.registerLayerDefinition(Modeldwarf.LAYER_LOCATION, Modeldwarf::createBodyLayer);
		event.registerLayerDefinition(Modelangry_spirit.LAYER_LOCATION, Modelangry_spirit::createBodyLayer);
		event.registerLayerDefinition(Modelvoid_portal.LAYER_LOCATION, Modelvoid_portal::createBodyLayer);
		event.registerLayerDefinition(Modelfire_elemental.LAYER_LOCATION, Modelfire_elemental::createBodyLayer);
		event.registerLayerDefinition(Modelgiant_spider.LAYER_LOCATION, Modelgiant_spider::createBodyLayer);
		event.registerLayerDefinition(Modelgrimace.LAYER_LOCATION, Modelgrimace::createBodyLayer);
		event.registerLayerDefinition(Modelaetherbolt.LAYER_LOCATION, Modelaetherbolt::createBodyLayer);
		event.registerLayerDefinition(Modelmarrow.LAYER_LOCATION, Modelmarrow::createBodyLayer);
		event.registerLayerDefinition(Modelair_elemental.LAYER_LOCATION, Modelair_elemental::createBodyLayer);
		event.registerLayerDefinition(Modelpeeper.LAYER_LOCATION, Modelpeeper::createBodyLayer);
		event.registerLayerDefinition(Modelrevenant_gore.LAYER_LOCATION, Modelrevenant_gore::createBodyLayer);
		event.registerLayerDefinition(Modelblob.LAYER_LOCATION, Modelblob::createBodyLayer);
		event.registerLayerDefinition(Modelspider_hatchling.LAYER_LOCATION, Modelspider_hatchling::createBodyLayer);
		event.registerLayerDefinition(Modelwitchmud_golem.LAYER_LOCATION, Modelwitchmud_golem::createBodyLayer);
		event.registerLayerDefinition(Modelweeper.LAYER_LOCATION, Modelweeper::createBodyLayer);
		event.registerLayerDefinition(Modelgoblin_warrior.LAYER_LOCATION, Modelgoblin_warrior::createBodyLayer);
		event.registerLayerDefinition(Modelgrimhook.LAYER_LOCATION, Modelgrimhook::createBodyLayer);
		event.registerLayerDefinition(Modelrevenant.LAYER_LOCATION, Modelrevenant::createBodyLayer);
		event.registerLayerDefinition(Modelgriever.LAYER_LOCATION, Modelgriever::createBodyLayer);
		event.registerLayerDefinition(Modelearth_elemental.LAYER_LOCATION, Modelearth_elemental::createBodyLayer);
		event.registerLayerDefinition(Modelgobjavelin_projectile.LAYER_LOCATION, Modelgobjavelin_projectile::createBodyLayer);
		event.registerLayerDefinition(ModelHobGoblin.LAYER_LOCATION, ModelHobGoblin::createBodyLayer);
		event.registerLayerDefinition(Modelunbound_soul.LAYER_LOCATION, Modelunbound_soul::createBodyLayer);
		event.registerLayerDefinition(Modeltiny_scallop.LAYER_LOCATION, Modeltiny_scallop::createBodyLayer);
		event.registerLayerDefinition(Modelgrim_boulder.LAYER_LOCATION, Modelgrim_boulder::createBodyLayer);
		event.registerLayerDefinition(Modelharvest_spiral.LAYER_LOCATION, Modelharvest_spiral::createBodyLayer);
		event.registerLayerDefinition(Modelwater_elemental.LAYER_LOCATION, Modelwater_elemental::createBodyLayer);
		event.registerLayerDefinition(Modelhappy_spirit.LAYER_LOCATION, Modelhappy_spirit::createBodyLayer);
		event.registerLayerDefinition(Modelvengeful_spirit.LAYER_LOCATION, Modelvengeful_spirit::createBodyLayer);
		event.registerLayerDefinition(ModelThrowingSpear.LAYER_LOCATION, ModelThrowingSpear::createBodyLayer);
		event.registerLayerDefinition(Modelwindswirl.LAYER_LOCATION, Modelwindswirl::createBodyLayer);
		event.registerLayerDefinition(Modelaura_tearburst.LAYER_LOCATION, Modelaura_tearburst::createBodyLayer);
		event.registerLayerDefinition(Modelforest_vines.LAYER_LOCATION, Modelforest_vines::createBodyLayer);
		event.registerLayerDefinition(Modelmussel.LAYER_LOCATION, Modelmussel::createBodyLayer);
		event.registerLayerDefinition(Modelsolsphere.LAYER_LOCATION, Modelsolsphere::createBodyLayer);
		event.registerLayerDefinition(Modelbloated.LAYER_LOCATION, Modelbloated::createBodyLayer);
		event.registerLayerDefinition(Modelmournstone.LAYER_LOCATION, Modelmournstone::createBodyLayer);
		event.registerLayerDefinition(Modeldemon_soul.LAYER_LOCATION, Modeldemon_soul::createBodyLayer);
		event.registerLayerDefinition(ModelEarthBoulder.LAYER_LOCATION, ModelEarthBoulder::createBodyLayer);
		event.registerLayerDefinition(Modelsorrowsealed.LAYER_LOCATION, Modelsorrowsealed::createBodyLayer);
		event.registerLayerDefinition(Modeldemonspine.LAYER_LOCATION, Modeldemonspine::createBodyLayer);
		event.registerLayerDefinition(Modelmudkin.LAYER_LOCATION, Modelmudkin::createBodyLayer);
		event.registerLayerDefinition(Modelchain_handle.LAYER_LOCATION, Modelchain_handle::createBodyLayer);
	}
}
