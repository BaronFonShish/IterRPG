
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.client.renderer.WindswirlRenderer;
import net.thirdlife.iterrpg.client.renderer.WeeperRenderer;
import net.thirdlife.iterrpg.client.renderer.WaterElementalRenderer;
import net.thirdlife.iterrpg.client.renderer.VoidPortalRenderer;
import net.thirdlife.iterrpg.client.renderer.VoidElementalRenderer;
import net.thirdlife.iterrpg.client.renderer.UnboundSoulRenderer;
import net.thirdlife.iterrpg.client.renderer.SpiderlingRenderer;
import net.thirdlife.iterrpg.client.renderer.SorrowsealedRenderer;
import net.thirdlife.iterrpg.client.renderer.SolsphereRenderer;
import net.thirdlife.iterrpg.client.renderer.SmallScallopRenderer;
import net.thirdlife.iterrpg.client.renderer.SeaArrowRenderer;
import net.thirdlife.iterrpg.client.renderer.ScallopRenderer;
import net.thirdlife.iterrpg.client.renderer.ScabRenderer;
import net.thirdlife.iterrpg.client.renderer.RevenantRenderer;
import net.thirdlife.iterrpg.client.renderer.PeeperRenderer;
import net.thirdlife.iterrpg.client.renderer.PebbleheadRenderer;
import net.thirdlife.iterrpg.client.renderer.MudkinRenderer;
import net.thirdlife.iterrpg.client.renderer.MournstoneRenderer;
import net.thirdlife.iterrpg.client.renderer.MarrowProjectileRenderer;
import net.thirdlife.iterrpg.client.renderer.JavelinProjectileRenderer;
import net.thirdlife.iterrpg.client.renderer.InsatiableRenderer;
import net.thirdlife.iterrpg.client.renderer.HydraBubbleRenderer;
import net.thirdlife.iterrpg.client.renderer.HomingBubbleRenderer;
import net.thirdlife.iterrpg.client.renderer.HobgoblinRenderer;
import net.thirdlife.iterrpg.client.renderer.HarvestSpiralRenderer;
import net.thirdlife.iterrpg.client.renderer.GrimhookRenderer;
import net.thirdlife.iterrpg.client.renderer.GrimaceRenderer;
import net.thirdlife.iterrpg.client.renderer.GrimBoulderRenderer;
import net.thirdlife.iterrpg.client.renderer.GrieverRenderer;
import net.thirdlife.iterrpg.client.renderer.GoblinWarriorRenderer;
import net.thirdlife.iterrpg.client.renderer.GoblinRenderer;
import net.thirdlife.iterrpg.client.renderer.GiantSpiderRenderer;
import net.thirdlife.iterrpg.client.renderer.FrostSpikeRenderer;
import net.thirdlife.iterrpg.client.renderer.ForestVinesRenderer;
import net.thirdlife.iterrpg.client.renderer.FleshmiteRenderer;
import net.thirdlife.iterrpg.client.renderer.FlameboltRenderer;
import net.thirdlife.iterrpg.client.renderer.FireElementalRenderer;
import net.thirdlife.iterrpg.client.renderer.FiendRenderer;
import net.thirdlife.iterrpg.client.renderer.EventSpawnRenderer;
import net.thirdlife.iterrpg.client.renderer.EarthElementalRenderer;
import net.thirdlife.iterrpg.client.renderer.EarthBoulderRenderer;
import net.thirdlife.iterrpg.client.renderer.DwarfRenderer;
import net.thirdlife.iterrpg.client.renderer.DropletProjectileProjectileRenderer;
import net.thirdlife.iterrpg.client.renderer.DropletMagicRenderer;
import net.thirdlife.iterrpg.client.renderer.DemonspineRenderer;
import net.thirdlife.iterrpg.client.renderer.DemonbloodProjectileRenderer;
import net.thirdlife.iterrpg.client.renderer.DebugMobmorphRenderer;
import net.thirdlife.iterrpg.client.renderer.ChaosApparitionRenderer;
import net.thirdlife.iterrpg.client.renderer.ChainHandleRenderer;
import net.thirdlife.iterrpg.client.renderer.CaltropThrownRenderer;
import net.thirdlife.iterrpg.client.renderer.BlobRenderer;
import net.thirdlife.iterrpg.client.renderer.BloatedRenderer;
import net.thirdlife.iterrpg.client.renderer.AxebeakRenderer;
import net.thirdlife.iterrpg.client.renderer.AuraTearburstRenderer;
import net.thirdlife.iterrpg.client.renderer.AuraSoulfireRenderer;
import net.thirdlife.iterrpg.client.renderer.AuraMobspawnRenderer;
import net.thirdlife.iterrpg.client.renderer.AuraBoulderRenderer;
import net.thirdlife.iterrpg.client.renderer.ArcaneBoltRenderer;
import net.thirdlife.iterrpg.client.renderer.ArcaneBlastRenderer;
import net.thirdlife.iterrpg.client.renderer.AirElementalRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class IterRpgModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(IterRpgModEntities.GRIEVER.get(), GrieverRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.MOURNSTONE.get(), MournstoneRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.GOBLIN_WARRIOR.get(), GoblinWarriorRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.FIRE_ELEMENTAL.get(), FireElementalRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.BLOATED.get(), BloatedRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.EARTH_ELEMENTAL.get(), EarthElementalRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.WEEPER.get(), WeeperRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.SORROWSEALED.get(), SorrowsealedRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.AURA_SOULFIRE.get(), AuraSoulfireRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.AURA_TEARBURST.get(), AuraTearburstRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.AURA_MOBSPAWN.get(), AuraMobspawnRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.AURA_BOULDER.get(), AuraBoulderRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.GRIM_BOULDER.get(), GrimBoulderRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.SCALLOP.get(), ScallopRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.GIANT_SPIDER.get(), GiantSpiderRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.SPIDERLING.get(), SpiderlingRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.MUDKIN.get(), MudkinRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.DEMONSPINE.get(), DemonspineRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.HOBGOBLIN.get(), HobgoblinRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.FOREST_VINES.get(), ForestVinesRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.BLOB.get(), BlobRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.PEEPER.get(), PeeperRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.CHAIN_HANDLE.get(), ChainHandleRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.WINDSWIRL.get(), WindswirlRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.VOID_ELEMENTAL.get(), VoidElementalRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.AIR_ELEMENTAL.get(), AirElementalRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.WATER_ELEMENTAL.get(), WaterElementalRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.GOBLIN.get(), GoblinRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.CALTROP_THROWN.get(), CaltropThrownRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.INSATIABLE.get(), InsatiableRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.DEBUG_MOBMORPH.get(), DebugMobmorphRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.EARTH_BOULDER.get(), EarthBoulderRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.VOID_PORTAL.get(), VoidPortalRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.FIREBALL_PROJECTILE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.DROPLET_PROJECTILE_PROJECTILE.get(), DropletProjectileProjectileRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.MARROW_PROJECTILE.get(), MarrowProjectileRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.DEMONBLOOD_PROJECTILE.get(), DemonbloodProjectileRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.ARCANE_BOLT.get(), ArcaneBoltRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.HARVEST_SPIRAL.get(), HarvestSpiralRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.HOMING_BUBBLE.get(), HomingBubbleRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.DWARF.get(), DwarfRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.SEA_ARROW.get(), SeaArrowRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.ARCANE_BLAST.get(), ArcaneBlastRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.SOLSPHERE.get(), SolsphereRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.GRIMHOOK.get(), GrimhookRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.HOMING_TEAR.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.BONB_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.JAVELIN_PROJECTILE.get(), JavelinProjectileRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.GRIMACE.get(), GrimaceRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.SMALL_SCALLOP.get(), SmallScallopRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.UNBOUND_SOUL.get(), UnboundSoulRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.EMBER_PROJ.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.CHAOS_APPARITION.get(), ChaosApparitionRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.FLAMEBOLT.get(), FlameboltRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.EVENT_SPAWN.get(), EventSpawnRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.DROPLET_MAGIC.get(), DropletMagicRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.HYDRA_BUBBLE.get(), HydraBubbleRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.VOLATILE_FIREBALL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.FROST_SPIKE.get(), FrostSpikeRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.HOMING_ZAP.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.SCAB.get(), ScabRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.FLESHMITE.get(), FleshmiteRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.REVENANT.get(), RevenantRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.FIEND.get(), FiendRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.PEBBLEHEAD.get(), PebbleheadRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.ROCK_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(IterRpgModEntities.AXEBEAK.get(), AxebeakRenderer::new);
	}
}
