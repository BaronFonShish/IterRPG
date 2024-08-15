
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.entity.WindswirlEntity;
import net.thirdlife.iterrpg.entity.WeeperEntity;
import net.thirdlife.iterrpg.entity.WaterElementalEntity;
import net.thirdlife.iterrpg.entity.VoidPortalEntity;
import net.thirdlife.iterrpg.entity.VoidElementalEntity;
import net.thirdlife.iterrpg.entity.UnboundSoulEntity;
import net.thirdlife.iterrpg.entity.SpiderlingEntity;
import net.thirdlife.iterrpg.entity.SorrowsealedEntity;
import net.thirdlife.iterrpg.entity.SolsphereEntity;
import net.thirdlife.iterrpg.entity.SmallScallopEntity;
import net.thirdlife.iterrpg.entity.SeaArrowEntity;
import net.thirdlife.iterrpg.entity.ScallopEntity;
import net.thirdlife.iterrpg.entity.ScabEntity;
import net.thirdlife.iterrpg.entity.RevenantEntity;
import net.thirdlife.iterrpg.entity.PeeperEntity;
import net.thirdlife.iterrpg.entity.MudkinEntity;
import net.thirdlife.iterrpg.entity.MournstoneEntity;
import net.thirdlife.iterrpg.entity.MarrowProjectileEntity;
import net.thirdlife.iterrpg.entity.JavelinProjectileEntity;
import net.thirdlife.iterrpg.entity.InsatiableEntity;
import net.thirdlife.iterrpg.entity.HomingTearEntity;
import net.thirdlife.iterrpg.entity.HomingBubbleEntity;
import net.thirdlife.iterrpg.entity.HobgoblinEntity;
import net.thirdlife.iterrpg.entity.HarvestSpiralEntity;
import net.thirdlife.iterrpg.entity.GrimhookEntity;
import net.thirdlife.iterrpg.entity.GrimaceEntity;
import net.thirdlife.iterrpg.entity.GrimBoulderEntity;
import net.thirdlife.iterrpg.entity.GrieverEntity;
import net.thirdlife.iterrpg.entity.GoblinWarriorEntity;
import net.thirdlife.iterrpg.entity.GoblinEntity;
import net.thirdlife.iterrpg.entity.GiantSpiderEntity;
import net.thirdlife.iterrpg.entity.ForestVinesEntity;
import net.thirdlife.iterrpg.entity.FlameboltEntity;
import net.thirdlife.iterrpg.entity.FireballProjectileProjectileEntity;
import net.thirdlife.iterrpg.entity.FireElementalEntity;
import net.thirdlife.iterrpg.entity.FiendEntity;
import net.thirdlife.iterrpg.entity.EmberProjEntity;
import net.thirdlife.iterrpg.entity.EarthElementalEntity;
import net.thirdlife.iterrpg.entity.EarthBoulderEntity;
import net.thirdlife.iterrpg.entity.DwarfEntity;
import net.thirdlife.iterrpg.entity.DropletProjectileProjectileEntity;
import net.thirdlife.iterrpg.entity.DemonspineEntity;
import net.thirdlife.iterrpg.entity.DemonbloodProjectileEntity;
import net.thirdlife.iterrpg.entity.DebugMobmorphEntity;
import net.thirdlife.iterrpg.entity.ChaosApparitionEntity;
import net.thirdlife.iterrpg.entity.ChainHandleEntity;
import net.thirdlife.iterrpg.entity.CarcassEntity;
import net.thirdlife.iterrpg.entity.CaltropThrownEntity;
import net.thirdlife.iterrpg.entity.BonbProjectileEntity;
import net.thirdlife.iterrpg.entity.BlobEntity;
import net.thirdlife.iterrpg.entity.BloatedEntity;
import net.thirdlife.iterrpg.entity.AuraTearburstEntity;
import net.thirdlife.iterrpg.entity.AuraSoulfireEntity;
import net.thirdlife.iterrpg.entity.AuraMobspawnEntity;
import net.thirdlife.iterrpg.entity.AuraBoulderEntity;
import net.thirdlife.iterrpg.entity.ArcaneBoltEntity;
import net.thirdlife.iterrpg.entity.ArcaneBlastEntity;
import net.thirdlife.iterrpg.entity.AirElementalEntity;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IterRpgModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, IterRpgMod.MODID);
	public static final RegistryObject<EntityType<GrieverEntity>> GRIEVER = register("griever",
			EntityType.Builder.<GrieverEntity>of(GrieverEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(GrieverEntity::new)

					.sized(0.5f, 2f));
	public static final RegistryObject<EntityType<MournstoneEntity>> MOURNSTONE = register("mournstone", EntityType.Builder.<MournstoneEntity>of(MournstoneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(MournstoneEntity::new).fireImmune().sized(0.9f, 2.8f));
	public static final RegistryObject<EntityType<GoblinWarriorEntity>> GOBLIN_WARRIOR = register("goblin_warrior",
			EntityType.Builder.<GoblinWarriorEntity>of(GoblinWarriorEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoblinWarriorEntity::new)

					.sized(0.6f, 1.1f));
	public static final RegistryObject<EntityType<FireElementalEntity>> FIRE_ELEMENTAL = register("fire_elemental", EntityType.Builder.<FireElementalEntity>of(FireElementalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FireElementalEntity::new).fireImmune().sized(0.6f, 1.6f));
	public static final RegistryObject<EntityType<BloatedEntity>> BLOATED = register("bloated",
			EntityType.Builder.<BloatedEntity>of(BloatedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BloatedEntity::new)

					.sized(0.7f, 1.8f));
	public static final RegistryObject<EntityType<EarthElementalEntity>> EARTH_ELEMENTAL = register("earth_elemental",
			EntityType.Builder.<EarthElementalEntity>of(EarthElementalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EarthElementalEntity::new)

					.sized(0.8f, 1.2f));
	public static final RegistryObject<EntityType<WeeperEntity>> WEEPER = register("weeper",
			EntityType.Builder.<WeeperEntity>of(WeeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WeeperEntity::new)

					.sized(0.85f, 1.7f));
	public static final RegistryObject<EntityType<SorrowsealedEntity>> SORROWSEALED = register("sorrowsealed", EntityType.Builder.<SorrowsealedEntity>of(SorrowsealedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SorrowsealedEntity::new).fireImmune().sized(4f, 4f));
	public static final RegistryObject<EntityType<AuraSoulfireEntity>> AURA_SOULFIRE = register("aura_soulfire", EntityType.Builder.<AuraSoulfireEntity>of(AuraSoulfireEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AuraSoulfireEntity::new).fireImmune().sized(0.5f, 0.1f));
	public static final RegistryObject<EntityType<AuraTearburstEntity>> AURA_TEARBURST = register("aura_tearburst", EntityType.Builder.<AuraTearburstEntity>of(AuraTearburstEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AuraTearburstEntity::new).fireImmune().sized(0.5f, 0.1f));
	public static final RegistryObject<EntityType<AuraMobspawnEntity>> AURA_MOBSPAWN = register("aura_mobspawn", EntityType.Builder.<AuraMobspawnEntity>of(AuraMobspawnEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AuraMobspawnEntity::new).fireImmune().sized(0.5f, 0.1f));
	public static final RegistryObject<EntityType<AuraBoulderEntity>> AURA_BOULDER = register("aura_boulder", EntityType.Builder.<AuraBoulderEntity>of(AuraBoulderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AuraBoulderEntity::new).fireImmune().sized(0.5f, 0.1f));
	public static final RegistryObject<EntityType<GrimBoulderEntity>> GRIM_BOULDER = register("grim_boulder", EntityType.Builder.<GrimBoulderEntity>of(GrimBoulderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GrimBoulderEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<ScallopEntity>> SCALLOP = register("scallop",
			EntityType.Builder.<ScallopEntity>of(ScallopEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ScallopEntity::new)

					.sized(0.9f, 0.6f));
	public static final RegistryObject<EntityType<GiantSpiderEntity>> GIANT_SPIDER = register("giant_spider",
			EntityType.Builder.<GiantSpiderEntity>of(GiantSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GiantSpiderEntity::new)

					.sized(1.5f, 1.3f));
	public static final RegistryObject<EntityType<SpiderlingEntity>> SPIDERLING = register("spiderling",
			EntityType.Builder.<SpiderlingEntity>of(SpiderlingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpiderlingEntity::new)

					.sized(0.6f, 0.5f));
	public static final RegistryObject<EntityType<RevenantEntity>> REVENANT = register("revenant",
			EntityType.Builder.<RevenantEntity>of(RevenantEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RevenantEntity::new)

					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<MudkinEntity>> MUDKIN = register("mudkin",
			EntityType.Builder.<MudkinEntity>of(MudkinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MudkinEntity::new)

					.sized(1f, 1.75f));
	public static final RegistryObject<EntityType<DemonspineEntity>> DEMONSPINE = register("demonspine", EntityType.Builder.<DemonspineEntity>of(DemonspineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(DemonspineEntity::new).fireImmune().sized(0.6f, 2.2f));
	public static final RegistryObject<EntityType<HobgoblinEntity>> HOBGOBLIN = register("hobgoblin",
			EntityType.Builder.<HobgoblinEntity>of(HobgoblinEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HobgoblinEntity::new)

					.sized(0.8f, 2.4f));
	public static final RegistryObject<EntityType<ForestVinesEntity>> FOREST_VINES = register("forest_vines",
			EntityType.Builder.<ForestVinesEntity>of(ForestVinesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ForestVinesEntity::new)

					.sized(0.6f, 1.6f));
	public static final RegistryObject<EntityType<BlobEntity>> BLOB = register("blob",
			EntityType.Builder.<BlobEntity>of(BlobEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlobEntity::new).fireImmune().sized(0.44f, 0.44f));
	public static final RegistryObject<EntityType<PeeperEntity>> PEEPER = register("peeper",
			EntityType.Builder.<PeeperEntity>of(PeeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PeeperEntity::new)

					.sized(0.9f, 1f));
	public static final RegistryObject<EntityType<ChainHandleEntity>> CHAIN_HANDLE = register("chain_handle", EntityType.Builder.<ChainHandleEntity>of(ChainHandleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ChainHandleEntity::new).fireImmune().sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<WindswirlEntity>> WINDSWIRL = register("windswirl", EntityType.Builder.<WindswirlEntity>of(WindswirlEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(WindswirlEntity::new).fireImmune().sized(0.8f, 1.6f));
	public static final RegistryObject<EntityType<VoidElementalEntity>> VOID_ELEMENTAL = register("void_elemental",
			EntityType.Builder.<VoidElementalEntity>of(VoidElementalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VoidElementalEntity::new)

					.sized(0.8f, 1.6f));
	public static final RegistryObject<EntityType<AirElementalEntity>> AIR_ELEMENTAL = register("air_elemental",
			EntityType.Builder.<AirElementalEntity>of(AirElementalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AirElementalEntity::new)

					.sized(0.8f, 1.2f));
	public static final RegistryObject<EntityType<WaterElementalEntity>> WATER_ELEMENTAL = register("water_elemental",
			EntityType.Builder.<WaterElementalEntity>of(WaterElementalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WaterElementalEntity::new)

					.sized(0.6f, 1.5f));
	public static final RegistryObject<EntityType<GoblinEntity>> GOBLIN = register("goblin",
			EntityType.Builder.<GoblinEntity>of(GoblinEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoblinEntity::new)

					.sized(0.6f, 0.95f));
	public static final RegistryObject<EntityType<CaltropThrownEntity>> CALTROP_THROWN = register("caltrop_thrown", EntityType.Builder.<CaltropThrownEntity>of(CaltropThrownEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(80).setUpdateInterval(3).setCustomClientFactory(CaltropThrownEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<InsatiableEntity>> INSATIABLE = register("insatiable",
			EntityType.Builder.<InsatiableEntity>of(InsatiableEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InsatiableEntity::new)

					.sized(0.8f, 2.5f));
	public static final RegistryObject<EntityType<DebugMobmorphEntity>> DEBUG_MOBMORPH = register("debug_mobmorph", EntityType.Builder.<DebugMobmorphEntity>of(DebugMobmorphEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DebugMobmorphEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<EarthBoulderEntity>> EARTH_BOULDER = register("earth_boulder", EntityType.Builder.<EarthBoulderEntity>of(EarthBoulderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EarthBoulderEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<VoidPortalEntity>> VOID_PORTAL = register("void_portal", EntityType.Builder.<VoidPortalEntity>of(VoidPortalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(VoidPortalEntity::new).fireImmune().sized(0.8f, 0.8f));
	public static final RegistryObject<EntityType<FireballProjectileProjectileEntity>> FIREBALL_PROJECTILE_PROJECTILE = register("fireball_projectile_projectile",
			EntityType.Builder.<FireballProjectileProjectileEntity>of(FireballProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(FireballProjectileProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DropletProjectileProjectileEntity>> DROPLET_PROJECTILE_PROJECTILE = register("droplet_projectile_projectile",
			EntityType.Builder.<DropletProjectileProjectileEntity>of(DropletProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(DropletProjectileProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MarrowProjectileEntity>> MARROW_PROJECTILE = register("marrow_projectile", EntityType.Builder.<MarrowProjectileEntity>of(MarrowProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MarrowProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DemonbloodProjectileEntity>> DEMONBLOOD_PROJECTILE = register("demonblood_projectile", EntityType.Builder.<DemonbloodProjectileEntity>of(DemonbloodProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(DemonbloodProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FiendEntity>> FIEND = register("fiend",
			EntityType.Builder.<FiendEntity>of(FiendEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FiendEntity::new)

					.sized(0.9f, 1.5f));
	public static final RegistryObject<EntityType<ArcaneBoltEntity>> ARCANE_BOLT = register("arcane_bolt",
			EntityType.Builder.<ArcaneBoltEntity>of(ArcaneBoltEntity::new, MobCategory.MISC).setCustomClientFactory(ArcaneBoltEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CarcassEntity>> CARCASS = register("carcass",
			EntityType.Builder.<CarcassEntity>of(CarcassEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CarcassEntity::new)

					.sized(0.8f, 2.9f));
	public static final RegistryObject<EntityType<HarvestSpiralEntity>> HARVEST_SPIRAL = register("harvest_spiral", EntityType.Builder.<HarvestSpiralEntity>of(HarvestSpiralEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(HarvestSpiralEntity::new).fireImmune().sized(1.25f, 0.25f));
	public static final RegistryObject<EntityType<HomingBubbleEntity>> HOMING_BUBBLE = register("homing_bubble",
			EntityType.Builder.<HomingBubbleEntity>of(HomingBubbleEntity::new, MobCategory.MISC).setCustomClientFactory(HomingBubbleEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DwarfEntity>> DWARF = register("dwarf",
			EntityType.Builder.<DwarfEntity>of(DwarfEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DwarfEntity::new).fireImmune().sized(0.8f, 1.5f));
	public static final RegistryObject<EntityType<SeaArrowEntity>> SEA_ARROW = register("sea_arrow",
			EntityType.Builder.<SeaArrowEntity>of(SeaArrowEntity::new, MobCategory.MISC).setCustomClientFactory(SeaArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ArcaneBlastEntity>> ARCANE_BLAST = register("arcane_blast",
			EntityType.Builder.<ArcaneBlastEntity>of(ArcaneBlastEntity::new, MobCategory.MISC).setCustomClientFactory(ArcaneBlastEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SolsphereEntity>> SOLSPHERE = register("solsphere", EntityType.Builder.<SolsphereEntity>of(SolsphereEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128)
			.setUpdateInterval(3).setCustomClientFactory(SolsphereEntity::new).fireImmune().sized(0.625f, 0.625f));
	public static final RegistryObject<EntityType<GrimhookEntity>> GRIMHOOK = register("grimhook",
			EntityType.Builder.<GrimhookEntity>of(GrimhookEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GrimhookEntity::new).fireImmune().sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<HomingTearEntity>> HOMING_TEAR = register("homing_tear",
			EntityType.Builder.<HomingTearEntity>of(HomingTearEntity::new, MobCategory.MISC).setCustomClientFactory(HomingTearEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ScabEntity>> SCAB = register("scab",
			EntityType.Builder.<ScabEntity>of(ScabEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ScabEntity::new)

					.sized(0.8f, 0.5f));
	public static final RegistryObject<EntityType<BonbProjectileEntity>> BONB_PROJECTILE = register("bonb_projectile",
			EntityType.Builder.<BonbProjectileEntity>of(BonbProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(BonbProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<JavelinProjectileEntity>> JAVELIN_PROJECTILE = register("javelin_projectile", EntityType.Builder.<JavelinProjectileEntity>of(JavelinProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(JavelinProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GrimaceEntity>> GRIMACE = register("grimace",
			EntityType.Builder.<GrimaceEntity>of(GrimaceEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GrimaceEntity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SmallScallopEntity>> SMALL_SCALLOP = register("small_scallop",
			EntityType.Builder.<SmallScallopEntity>of(SmallScallopEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SmallScallopEntity::new)

					.sized(0.5f, 0.3f));
	public static final RegistryObject<EntityType<UnboundSoulEntity>> UNBOUND_SOUL = register("unbound_soul", EntityType.Builder.<UnboundSoulEntity>of(UnboundSoulEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(UnboundSoulEntity::new).fireImmune().sized(0.7f, 1.3f));
	public static final RegistryObject<EntityType<EmberProjEntity>> EMBER_PROJ = register("ember_proj",
			EntityType.Builder.<EmberProjEntity>of(EmberProjEntity::new, MobCategory.MISC).setCustomClientFactory(EmberProjEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ChaosApparitionEntity>> CHAOS_APPARITION = register("chaos_apparition", EntityType.Builder.<ChaosApparitionEntity>of(ChaosApparitionEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ChaosApparitionEntity::new).fireImmune().sized(0.6f, 1f));
	public static final RegistryObject<EntityType<FlameboltEntity>> FLAMEBOLT = register("flamebolt",
			EntityType.Builder.<FlameboltEntity>of(FlameboltEntity::new, MobCategory.MISC).setCustomClientFactory(FlameboltEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			GrieverEntity.init();
			MournstoneEntity.init();
			GoblinWarriorEntity.init();
			FireElementalEntity.init();
			BloatedEntity.init();
			EarthElementalEntity.init();
			WeeperEntity.init();
			SorrowsealedEntity.init();
			AuraSoulfireEntity.init();
			AuraTearburstEntity.init();
			AuraMobspawnEntity.init();
			AuraBoulderEntity.init();
			GrimBoulderEntity.init();
			ScallopEntity.init();
			GiantSpiderEntity.init();
			SpiderlingEntity.init();
			RevenantEntity.init();
			MudkinEntity.init();
			DemonspineEntity.init();
			HobgoblinEntity.init();
			ForestVinesEntity.init();
			BlobEntity.init();
			PeeperEntity.init();
			ChainHandleEntity.init();
			WindswirlEntity.init();
			VoidElementalEntity.init();
			AirElementalEntity.init();
			WaterElementalEntity.init();
			GoblinEntity.init();
			CaltropThrownEntity.init();
			InsatiableEntity.init();
			DebugMobmorphEntity.init();
			EarthBoulderEntity.init();
			VoidPortalEntity.init();
			FiendEntity.init();
			CarcassEntity.init();
			HarvestSpiralEntity.init();
			DwarfEntity.init();
			SolsphereEntity.init();
			GrimhookEntity.init();
			ScabEntity.init();
			GrimaceEntity.init();
			SmallScallopEntity.init();
			UnboundSoulEntity.init();
			ChaosApparitionEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GRIEVER.get(), GrieverEntity.createAttributes().build());
		event.put(MOURNSTONE.get(), MournstoneEntity.createAttributes().build());
		event.put(GOBLIN_WARRIOR.get(), GoblinWarriorEntity.createAttributes().build());
		event.put(FIRE_ELEMENTAL.get(), FireElementalEntity.createAttributes().build());
		event.put(BLOATED.get(), BloatedEntity.createAttributes().build());
		event.put(EARTH_ELEMENTAL.get(), EarthElementalEntity.createAttributes().build());
		event.put(WEEPER.get(), WeeperEntity.createAttributes().build());
		event.put(SORROWSEALED.get(), SorrowsealedEntity.createAttributes().build());
		event.put(AURA_SOULFIRE.get(), AuraSoulfireEntity.createAttributes().build());
		event.put(AURA_TEARBURST.get(), AuraTearburstEntity.createAttributes().build());
		event.put(AURA_MOBSPAWN.get(), AuraMobspawnEntity.createAttributes().build());
		event.put(AURA_BOULDER.get(), AuraBoulderEntity.createAttributes().build());
		event.put(GRIM_BOULDER.get(), GrimBoulderEntity.createAttributes().build());
		event.put(SCALLOP.get(), ScallopEntity.createAttributes().build());
		event.put(GIANT_SPIDER.get(), GiantSpiderEntity.createAttributes().build());
		event.put(SPIDERLING.get(), SpiderlingEntity.createAttributes().build());
		event.put(REVENANT.get(), RevenantEntity.createAttributes().build());
		event.put(MUDKIN.get(), MudkinEntity.createAttributes().build());
		event.put(DEMONSPINE.get(), DemonspineEntity.createAttributes().build());
		event.put(HOBGOBLIN.get(), HobgoblinEntity.createAttributes().build());
		event.put(FOREST_VINES.get(), ForestVinesEntity.createAttributes().build());
		event.put(BLOB.get(), BlobEntity.createAttributes().build());
		event.put(PEEPER.get(), PeeperEntity.createAttributes().build());
		event.put(CHAIN_HANDLE.get(), ChainHandleEntity.createAttributes().build());
		event.put(WINDSWIRL.get(), WindswirlEntity.createAttributes().build());
		event.put(VOID_ELEMENTAL.get(), VoidElementalEntity.createAttributes().build());
		event.put(AIR_ELEMENTAL.get(), AirElementalEntity.createAttributes().build());
		event.put(WATER_ELEMENTAL.get(), WaterElementalEntity.createAttributes().build());
		event.put(GOBLIN.get(), GoblinEntity.createAttributes().build());
		event.put(CALTROP_THROWN.get(), CaltropThrownEntity.createAttributes().build());
		event.put(INSATIABLE.get(), InsatiableEntity.createAttributes().build());
		event.put(DEBUG_MOBMORPH.get(), DebugMobmorphEntity.createAttributes().build());
		event.put(EARTH_BOULDER.get(), EarthBoulderEntity.createAttributes().build());
		event.put(VOID_PORTAL.get(), VoidPortalEntity.createAttributes().build());
		event.put(FIEND.get(), FiendEntity.createAttributes().build());
		event.put(CARCASS.get(), CarcassEntity.createAttributes().build());
		event.put(HARVEST_SPIRAL.get(), HarvestSpiralEntity.createAttributes().build());
		event.put(DWARF.get(), DwarfEntity.createAttributes().build());
		event.put(SOLSPHERE.get(), SolsphereEntity.createAttributes().build());
		event.put(GRIMHOOK.get(), GrimhookEntity.createAttributes().build());
		event.put(SCAB.get(), ScabEntity.createAttributes().build());
		event.put(GRIMACE.get(), GrimaceEntity.createAttributes().build());
		event.put(SMALL_SCALLOP.get(), SmallScallopEntity.createAttributes().build());
		event.put(UNBOUND_SOUL.get(), UnboundSoulEntity.createAttributes().build());
		event.put(CHAOS_APPARITION.get(), ChaosApparitionEntity.createAttributes().build());
	}
}
