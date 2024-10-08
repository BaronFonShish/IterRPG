
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IterRpgModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IterRpgMod.MODID);
	public static final RegistryObject<CreativeModeTab> ITER_MAGIC = REGISTRY.register("iter_magic",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.iter_rpg.iter_magic")).icon(() -> new ItemStack(IterRpgModItems.SPELL_ETHERBOLT.get())).displayItems((parameters, tabData) -> {
				tabData.accept(IterRpgModBlocks.ARCANIST_TABLE.get().asItem());
				tabData.accept(IterRpgModItems.SPELL_BOOK.get());
				tabData.accept(IterRpgModItems.GIST.get());
				tabData.accept(IterRpgModItems.INK_BOTTLE.get());
				tabData.accept(IterRpgModItems.ENCHANTED_PAGE.get());
				tabData.accept(IterRpgModItems.UNIDENTIFIED_SPELL.get());
				tabData.accept(IterRpgModItems.SPELL_ETHERBOLT.get());
				tabData.accept(IterRpgModItems.SPELL_ETHERBLAST.get());
				tabData.accept(IterRpgModItems.SPELL_HEAL.get());
				tabData.accept(IterRpgModItems.SPELL_CULTIVATE.get());
				tabData.accept(IterRpgModItems.SPELL_POISON_GAS.get());
				tabData.accept(IterRpgModItems.SPELL_SPLASHES.get());
				tabData.accept(IterRpgModItems.SPELL_DROPLETS.get());
				tabData.accept(IterRpgModItems.SPELL_GUST.get());
				tabData.accept(IterRpgModItems.SPELL_ZAP.get());
				tabData.accept(IterRpgModItems.SPELL_IGNITE.get());
				tabData.accept(IterRpgModItems.SPELL_EMBERS.get());
				tabData.accept(IterRpgModItems.SPELL_FLAMEBOLT.get());
				tabData.accept(IterRpgModItems.SPELL_ATTRACT.get());
				tabData.accept(IterRpgModItems.SPELL_SHADELASH.get());
				tabData.accept(IterRpgModItems.SPELL_VOIDBEAM.get());
				tabData.accept(IterRpgModItems.ABYSSQUARTZ_WAND.get());
				tabData.accept(IterRpgModItems.AMETHYST_WAND.get());
				tabData.accept(IterRpgModItems.BONE_WAND.get());
				tabData.accept(IterRpgModItems.PEARL_WAND.get());
				tabData.accept(IterRpgModItems.NIMBLE_COPPER_SHORTSTAFF.get());
				tabData.accept(IterRpgModItems.ENCHANTOME.get());
				tabData.accept(IterRpgModItems.AMETRINE_STAFF.get());
				tabData.accept(IterRpgModItems.MAGMANUM_STAFF.get());
				tabData.accept(IterRpgModItems.HYDRA_STAFF.get());
				tabData.accept(IterRpgModItems.THUNDERCLAP.get());
				tabData.accept(IterRpgModItems.SMOLDERING_TOME.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(IterRpgModBlocks.AMETRINE_BLOCK.get().asItem());
			tabData.accept(IterRpgModBlocks.AMETRINE_BRICKS.get().asItem());
			tabData.accept(IterRpgModBlocks.ABYSSQUARTZ_BLOCK.get().asItem());
			tabData.accept(IterRpgModBlocks.POLISHED_GRIMSTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.GRIMSTONE_BRICKS.get().asItem());
			tabData.accept(IterRpgModBlocks.CRACKED_GRIMSTONE_BRICKS.get().asItem());
			tabData.accept(IterRpgModBlocks.CHISELED_GRIMSTONE_BRICKS.get().asItem());
			tabData.accept(IterRpgModBlocks.POLISHED_GRIMSTONE_STAIRS.get().asItem());
			tabData.accept(IterRpgModBlocks.GRIMSTONE_BRICKS_STAIRS.get().asItem());
			tabData.accept(IterRpgModBlocks.GRIMSTONE_SLAB.get().asItem());
			tabData.accept(IterRpgModBlocks.POLISHED_GRIMSTONE_SLAB.get().asItem());
			tabData.accept(IterRpgModBlocks.GRIMSTONE_BRICKS_SLAB.get().asItem());
			tabData.accept(IterRpgModBlocks.POLISHED_GRIMSTONE_WALL.get().asItem());
			tabData.accept(IterRpgModBlocks.GRIMSTONE_BRICKS_WALL.get().asItem());
			tabData.accept(IterRpgModBlocks.CHARGED_GRIMSTONE_BRICKS.get().asItem());
			tabData.accept(IterRpgModBlocks.GRIM_KEYHOLE.get().asItem());
			tabData.accept(IterRpgModBlocks.RUNIC_GRIMSTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.GRIM_SOULTRAP.get().asItem());
			tabData.accept(IterRpgModBlocks.BARRIER_PROJECTOR.get().asItem());
			tabData.accept(IterRpgModBlocks.SPIRE_SPAWNER.get().asItem());
			tabData.accept(IterRpgModBlocks.GRAND_SPIRE_SPAWNER.get().asItem());
			tabData.accept(IterRpgModBlocks.GIANT_CHAIN.get().asItem());
			tabData.accept(IterRpgModBlocks.SMALL_VASE.get().asItem());
			tabData.accept(IterRpgModBlocks.VASE.get().asItem());
			tabData.accept(IterRpgModBlocks.BIG_VASE.get().asItem());
			tabData.accept(IterRpgModBlocks.SMALL_VASE_DECO.get().asItem());
			tabData.accept(IterRpgModBlocks.VASE_DECO.get().asItem());
			tabData.accept(IterRpgModBlocks.BIG_VASE_DECO.get().asItem());
			tabData.accept(IterRpgModBlocks.SPIDER_SILK_BLOCK.get().asItem());
			tabData.accept(IterRpgModBlocks.MAGMANUM_BLOCK.get().asItem());
			tabData.accept(IterRpgModBlocks.HIVESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.CUT_HIVESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.CRACKED_HIVESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.CRUMBLING_HIVESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.RUNIC_HIVESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.SILKY_HIVESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.WEAVED_HIVESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.INFESTED_HIVESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.HIVESTONE_SLAB.get().asItem());
			tabData.accept(IterRpgModBlocks.HIVESTONE_STAIRS.get().asItem());
			tabData.accept(IterRpgModBlocks.HIVESTONE_WALL.get().asItem());
			tabData.accept(IterRpgModBlocks.GUNPOWDER_BARREL.get().asItem());
			tabData.accept(IterRpgModBlocks.GOBSTEEL_BLOCK.get().asItem());
			tabData.accept(IterRpgModBlocks.PEARL_BLOCK.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_LOG.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_WOOD.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_LEAVES.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_PLANKS.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_STAIRS.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_SLAB.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_FENCE.get().asItem());
			tabData.accept(IterRpgModBlocks.COIN_PILE.get().asItem());
			tabData.accept(IterRpgModBlocks.COIN_BLOCK.get().asItem());
			tabData.accept(IterRpgModBlocks.EARTH_SEAL.get().asItem());
			tabData.accept(IterRpgModBlocks.WATER_SEAL.get().asItem());
			tabData.accept(IterRpgModBlocks.AIR_SEAL.get().asItem());
			tabData.accept(IterRpgModBlocks.FIRE_SEAL.get().asItem());
			tabData.accept(IterRpgModBlocks.VOID_SEAL.get().asItem());
			tabData.accept(IterRpgModBlocks.GRIMACE_TRAP.get().asItem());
			tabData.accept(IterRpgModBlocks.STRIPPED_SACRED_LOG.get().asItem());
			tabData.accept(IterRpgModBlocks.TOMBSTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.TOMBSTONE_FRAGMENTS_BLOCK.get().asItem());
			tabData.accept(IterRpgModBlocks.GRAVE_CROSS.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(IterRpgModBlocks.TEAR_CATCHER.get().asItem());
			tabData.accept(IterRpgModBlocks.GRIM_LOCKER.get().asItem());
			tabData.accept(IterRpgModBlocks.VOID_MAW.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(IterRpgModBlocks.DRILL.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_DOOR.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_FENCE_GATE.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_TRAPDOOR.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_PRESSURE_PLATE.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_BUTTON.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(IterRpgModItems.WODDEN_DAGGER.get());
			tabData.accept(IterRpgModItems.STONE_DAGGER.get());
			tabData.accept(IterRpgModItems.IRON_DAGGER.get());
			tabData.accept(IterRpgModItems.GOLDEN_DAGGER.get());
			tabData.accept(IterRpgModItems.DIAMOND_DAGGER.get());
			tabData.accept(IterRpgModItems.NETHERITE_DAGGER.get());
			tabData.accept(IterRpgModItems.WOODEN_SPEAR.get());
			tabData.accept(IterRpgModItems.STONE_SPEAR.get());
			tabData.accept(IterRpgModItems.IRON_SPEAR.get());
			tabData.accept(IterRpgModItems.GOLDEN_SPEAR.get());
			tabData.accept(IterRpgModItems.DIAMOND_SPEAR.get());
			tabData.accept(IterRpgModItems.NETHERITE_SPEAR.get());
			tabData.accept(IterRpgModItems.WOODEN_SCYTHE.get());
			tabData.accept(IterRpgModItems.STONE_SCYTHE.get());
			tabData.accept(IterRpgModItems.IRON_SCYTHE.get());
			tabData.accept(IterRpgModItems.GOLDEN_SCYTHE.get());
			tabData.accept(IterRpgModItems.DIAMOND_SCYTHE.get());
			tabData.accept(IterRpgModItems.NETHERITE_SCYTHE.get());
			tabData.accept(IterRpgModItems.WOODEN_FLAIL.get());
			tabData.accept(IterRpgModItems.STONE_FLAIL.get());
			tabData.accept(IterRpgModItems.IRON_FLAIL.get());
			tabData.accept(IterRpgModItems.GOLDEN_FLAIL.get());
			tabData.accept(IterRpgModItems.DIAMOND_FLAIL.get());
			tabData.accept(IterRpgModItems.NETHERITE_FLAIL.get());
			tabData.accept(IterRpgModItems.AMETRINE_SWORD.get());
			tabData.accept(IterRpgModItems.AMETRINE_DAGGER.get());
			tabData.accept(IterRpgModItems.AMETRINE_SPEAR.get());
			tabData.accept(IterRpgModItems.AMETRINE_SCYTHE.get());
			tabData.accept(IterRpgModItems.AMETRINE_FLAIL.get());
			tabData.accept(IterRpgModItems.SWORD_OF_BOUNDING.get());
			tabData.accept(IterRpgModItems.HUMIE_BUTCHER.get());
			tabData.accept(IterRpgModItems.STINGER.get());
			tabData.accept(IterRpgModItems.GOBSTEEL_JAVELIN.get());
			tabData.accept(IterRpgModItems.BONB.get());
			tabData.accept(IterRpgModItems.VERY_GOOD_AND_CHEERFUL_RAPIER.get());
			tabData.accept(IterRpgModItems.CALTROP.get());
			tabData.accept(IterRpgModItems.DEEPSTEEL_SWORD.get());
			tabData.accept(IterRpgModItems.MAGMANUM_SWORD.get());
			tabData.accept(IterRpgModItems.BLOODTHIRST.get());
			tabData.accept(IterRpgModItems.BLOODBRANCH.get());
			tabData.accept(IterRpgModItems.MARROW.get());
			tabData.accept(IterRpgModItems.ELEMENTAL_SWORD.get());
			tabData.accept(IterRpgModItems.TORMENTOR.get());
			tabData.accept(IterRpgModItems.CRESCENT.get());
			tabData.accept(IterRpgModItems.SACRIFICIAL_DAGGER.get());
			tabData.accept(IterRpgModItems.DRIFTBOW.get());
			tabData.accept(IterRpgModItems.HARVEST.get());
			tabData.accept(IterRpgModItems.ETERNAL_TORRENT.get());
			tabData.accept(IterRpgModItems.STORMCALLER.get());
			tabData.accept(IterRpgModItems.SOLSTICE.get());
			tabData.accept(IterRpgModItems.STARLESSNESS.get());
			tabData.accept(IterRpgModItems.RAGGED_HELMET.get());
			tabData.accept(IterRpgModItems.RAGGED_CHESTPLATE.get());
			tabData.accept(IterRpgModItems.RAGGED_LEGGINGS.get());
			tabData.accept(IterRpgModItems.RAGGED_BOOTS.get());
			tabData.accept(IterRpgModItems.AMETRINE_HELMET.get());
			tabData.accept(IterRpgModItems.AMETRINE_CHESTPLATE.get());
			tabData.accept(IterRpgModItems.AMETRINE_LEGGINGS.get());
			tabData.accept(IterRpgModItems.AMETRINE_BOOTS.get());
			tabData.accept(IterRpgModItems.MAGMANUM_ARMOR_HELMET.get());
			tabData.accept(IterRpgModItems.MAGMANUM_ARMOR_CHESTPLATE.get());
			tabData.accept(IterRpgModItems.MAGMANUM_ARMOR_LEGGINGS.get());
			tabData.accept(IterRpgModItems.MAGMANUM_ARMOR_BOOTS.get());
			tabData.accept(IterRpgModItems.ELEMENTAL_ARMOR_HELMET.get());
			tabData.accept(IterRpgModItems.ELEMENTAL_ARMOR_CHESTPLATE.get());
			tabData.accept(IterRpgModItems.ELEMENTAL_ARMOR_LEGGINGS.get());
			tabData.accept(IterRpgModItems.ELEMENTAL_ARMOR_BOOTS.get());
			tabData.accept(IterRpgModItems.AMETRINE_PENDANT.get());
			tabData.accept(IterRpgModItems.ABYSSQUARTZ_CAPACITATOR.get());
			tabData.accept(IterRpgModItems.ARCANE_BOUQUETE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(IterRpgModItems.GOBLIN_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.GOBLIN_WARRIOR_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.HOBGOBLIN_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.SCALLOP_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.GIANT_SPIDER_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.SPIDERLING_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.PEEPER_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.MUDKIN_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.GRIEVER_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.MOURNSTONE_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.WEEPER_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.SORROWSEALED_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.EARTH_ELEMENTAL_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.WATER_ELEMENTAL_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.AIR_ELEMENTAL_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.FIRE_ELEMENTAL_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.VOID_ELEMENTAL_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.BLOATED_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.INSATIABLE_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.SMALL_SCALLOP_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.CHAOS_APPARITION_SPAWN_EGG.get());
			tabData.accept(IterRpgModItems.UNBOUND_SOUL_SPAWN_EGG.get());
			tabData.accept(IterRpgModBlocks.GOBLIN_SPAWNER.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(IterRpgModBlocks.ARCANE_FLOWER_SEEDS.get().asItem());
			tabData.accept(IterRpgModItems.ABYSSQUARTZ_SHARD.get());
			tabData.accept(IterRpgModItems.AMETRINE_INGOT.get());
			tabData.accept(IterRpgModItems.AMETRINE_NUGGET.get());
			tabData.accept(IterRpgModItems.ETHER_DUST.get());
			tabData.accept(IterRpgModItems.COIN.get());
			tabData.accept(IterRpgModItems.SPAWNER_FRAGMENT.get());
			tabData.accept(IterRpgModItems.MUG.get());
			tabData.accept(IterRpgModItems.POTSHERD.get());
			tabData.accept(IterRpgModItems.GOBSTEEL_SCRAP.get());
			tabData.accept(IterRpgModItems.SEASHELL.get());
			tabData.accept(IterRpgModItems.STARFISH.get());
			tabData.accept(IterRpgModItems.PEARL.get());
			tabData.accept(IterRpgModItems.SPIDER_SILK.get());
			tabData.accept(IterRpgModItems.MAGMANUM_CHUNK.get());
			tabData.accept(IterRpgModItems.STONE_GEODE.get());
			tabData.accept(IterRpgModItems.DEEPSLATE_GEODE.get());
			tabData.accept(IterRpgModItems.NETHERRACK_GEODE.get());
			tabData.accept(IterRpgModItems.BLACKSTONE_GEODE.get());
			tabData.accept(IterRpgModItems.ENDSTONE_GEODE.get());
			tabData.accept(IterRpgModItems.BOTTLE_OF_OBSIDIAN_TEARS.get());
			tabData.accept(IterRpgModItems.EMPTY_RUNE.get());
			tabData.accept(IterRpgModItems.EARTH_RUNE.get());
			tabData.accept(IterRpgModItems.EARTH_INGOT.get());
			tabData.accept(IterRpgModItems.EARTH_FRAGMENT.get());
			tabData.accept(IterRpgModItems.WATER_RUNE.get());
			tabData.accept(IterRpgModItems.WATER_INGOT.get());
			tabData.accept(IterRpgModItems.WATER_FRAGMENT.get());
			tabData.accept(IterRpgModItems.AIR_RUNE.get());
			tabData.accept(IterRpgModItems.AIR_INGOT.get());
			tabData.accept(IterRpgModItems.AIR_FRAGMENT.get());
			tabData.accept(IterRpgModItems.FIRE_RUNE.get());
			tabData.accept(IterRpgModItems.FIRE_INGOT.get());
			tabData.accept(IterRpgModItems.FIRE_FRAGMENT.get());
			tabData.accept(IterRpgModItems.VOID_RUNE.get());
			tabData.accept(IterRpgModItems.VOID_INGOT.get());
			tabData.accept(IterRpgModItems.VOID_FRAGMENT.get());
			tabData.accept(IterRpgModItems.ELEMENTAL_UPGRADE.get());
			tabData.accept(IterRpgModItems.ELEMENTAL_INGOT.get());
			tabData.accept(IterRpgModItems.ELEMENTAL_FRAGMENT.get());
			tabData.accept(IterRpgModItems.HOLLOW_VISAGE.get());
			tabData.accept(IterRpgModItems.CRYSTAL_TEAR.get());
			tabData.accept(IterRpgModItems.SACRED_TWIG.get());
			tabData.accept(IterRpgModItems.ESSENCE_OF_CREATION.get());
			tabData.accept(IterRpgModItems.DEEPSTEEL_INGOT.get());
			tabData.accept(IterRpgModItems.ABSTRUSE_CLOTH.get());
			tabData.accept(IterRpgModItems.TOMBSTONE_FRAGMENT.get());
			tabData.accept(IterRpgModItems.HAUNTED_SPLINTER.get());
			tabData.accept(IterRpgModItems.ECTOPLASM.get());
			tabData.accept(IterRpgModItems.OTHERWORDLY_INGOT.get());
			tabData.accept(IterRpgModItems.GRIMSTONE_PEBBLE.get());
			tabData.accept(IterRpgModItems.BLOOD_BOTTLE.get());
			tabData.accept(IterRpgModItems.SEVEN_SEAS_CONCOCTION.get());
			tabData.accept(IterRpgModItems.STARDUST_ICE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(IterRpgModBlocks.ETHERBLOOM.get().asItem());
			tabData.accept(IterRpgModBlocks.ABYSS_QUARTZ.get().asItem());
			tabData.accept(IterRpgModBlocks.SPIDER_EGG.get().asItem());
			tabData.accept(IterRpgModBlocks.GRIMSTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.MAGMANUM_ORE.get().asItem());
			tabData.accept(IterRpgModBlocks.GEODITE.get().asItem());
			tabData.accept(IterRpgModBlocks.DEEPSLATE_GEODITE.get().asItem());
			tabData.accept(IterRpgModBlocks.NETHERRACK_GEODITE.get().asItem());
			tabData.accept(IterRpgModBlocks.BLACKSTONE_GEODITE.get().asItem());
			tabData.accept(IterRpgModBlocks.ENDSTONE_GEODITE.get().asItem());
			tabData.accept(IterRpgModBlocks.TWIFFLE_BLOCK.get().asItem());
			tabData.accept(IterRpgModBlocks.TWIFFLE.get().asItem());
			tabData.accept(IterRpgModBlocks.TWIFFLE_BULB.get().asItem());
			tabData.accept(IterRpgModBlocks.WITCHMUD.get().asItem());
			tabData.accept(IterRpgModBlocks.CATTAIL.get().asItem());
			tabData.accept(IterRpgModBlocks.CLOUD_BLOCK.get().asItem());
			tabData.accept(IterRpgModBlocks.SACRED_SAPLING.get().asItem());
			tabData.accept(IterRpgModBlocks.MONOLITH_STONE.get().asItem());
			tabData.accept(IterRpgModBlocks.MONOLITH_STAIRS.get().asItem());
			tabData.accept(IterRpgModBlocks.MONOLITH_SLAB.get().asItem());
			tabData.accept(IterRpgModBlocks.MONOLITH_WALL.get().asItem());
			tabData.accept(IterRpgModBlocks.HALFLOWER.get().asItem());
			tabData.accept(IterRpgModBlocks.SMOOTH_MONOLITH_STONE.get().asItem());
			tabData.accept(IterRpgModBlocks.EARTH_RUNESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.WATER_RUNESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.AIR_RUNESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.FIRE_RUNESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.VOID_RUNESTONE.get().asItem());
			tabData.accept(IterRpgModBlocks.MONOLITH_DOOR.get().asItem());
			tabData.accept(IterRpgModBlocks.OBSCURITE.get().asItem());
			tabData.accept(IterRpgModBlocks.COBBLED_OBSCURITE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(IterRpgModItems.ETHERBLOOM_DECOCTION.get());
			tabData.accept(IterRpgModItems.TWIFFLE_LUMP.get());
			tabData.accept(IterRpgModItems.BEER_MUG.get());
			tabData.accept(IterRpgModItems.SPIDER_MEAD_MUG.get());
			tabData.accept(IterRpgModItems.WARPED_GOO.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(IterRpgModItems.AMETRINE_PICKAXE.get());
			tabData.accept(IterRpgModItems.AMETRINE_AXE.get());
			tabData.accept(IterRpgModItems.AMETRINE_SHOVEL.get());
			tabData.accept(IterRpgModItems.AMETRINE_HOE.get());
			tabData.accept(IterRpgModItems.MAGMANUM_PICKAXE.get());
			tabData.accept(IterRpgModItems.DEEPSTEEL_PICKAXE.get());
			tabData.accept(IterRpgModItems.COIN_POUCH.get());
			tabData.accept(IterRpgModItems.DEEPSTEEL_AXE.get());
		}
	}
}
