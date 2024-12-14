
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.block.entity.VoidMawBlockEntity;
import net.thirdlife.iterrpg.block.entity.VaseDecoBlockEntity;
import net.thirdlife.iterrpg.block.entity.TwiffleBlockBlockEntity;
import net.thirdlife.iterrpg.block.entity.TearCatcherBlockEntity;
import net.thirdlife.iterrpg.block.entity.SpireSpawnerBlockEntity;
import net.thirdlife.iterrpg.block.entity.SmallVaseDecoBlockEntity;
import net.thirdlife.iterrpg.block.entity.SacredSaplingBlockEntity;
import net.thirdlife.iterrpg.block.entity.RunicGrimstoneBlockEntity;
import net.thirdlife.iterrpg.block.entity.RunicGrimstoneActiveBlockEntity;
import net.thirdlife.iterrpg.block.entity.PebbleLauncherBlockEntity;
import net.thirdlife.iterrpg.block.entity.MonolithDoorBlockEntity;
import net.thirdlife.iterrpg.block.entity.GunpowderBarrelBlockEntity;
import net.thirdlife.iterrpg.block.entity.GrimaceTrapBlockEntity;
import net.thirdlife.iterrpg.block.entity.GrimSoultrapBlockEntity;
import net.thirdlife.iterrpg.block.entity.GrimLockerBlockEntity;
import net.thirdlife.iterrpg.block.entity.GrandSpireSpawnerBlockEntity;
import net.thirdlife.iterrpg.block.entity.GoblinSpawnerBlockEntity;
import net.thirdlife.iterrpg.block.entity.GnawerBlockEntity;
import net.thirdlife.iterrpg.block.entity.GiantPhantomChainBlockEntity;
import net.thirdlife.iterrpg.block.entity.FleshWeaverTileEntity;
import net.thirdlife.iterrpg.block.entity.DrillBlockEntity;
import net.thirdlife.iterrpg.block.entity.CruncherBlockEntity;
import net.thirdlife.iterrpg.block.entity.BigVaseDecoBlockEntity;
import net.thirdlife.iterrpg.block.entity.ArcaneFlowerSeedsBlockEntity;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class IterRpgModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, IterRpgMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ARCANE_FLOWER_SEEDS = register("arcane_flower_seeds", IterRpgModBlocks.ARCANE_FLOWER_SEEDS, ArcaneFlowerSeedsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TWIFFLE_BLOCK = register("twiffle_block", IterRpgModBlocks.TWIFFLE_BLOCK, TwiffleBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SMALL_VASE_DECO = register("small_vase_deco", IterRpgModBlocks.SMALL_VASE_DECO, SmallVaseDecoBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> VASE_DECO = register("vase_deco", IterRpgModBlocks.VASE_DECO, VaseDecoBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIG_VASE_DECO = register("big_vase_deco", IterRpgModBlocks.BIG_VASE_DECO, BigVaseDecoBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GUNPOWDER_BARREL = register("gunpowder_barrel", IterRpgModBlocks.GUNPOWDER_BARREL, GunpowderBarrelBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DRILL = register("drill", IterRpgModBlocks.DRILL, DrillBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SACRED_SAPLING = register("sacred_sapling", IterRpgModBlocks.SACRED_SAPLING, SacredSaplingBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GOBLIN_SPAWNER = register("goblin_spawner", IterRpgModBlocks.GOBLIN_SPAWNER, GoblinSpawnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GRIM_SOULTRAP = register("grim_soultrap", IterRpgModBlocks.GRIM_SOULTRAP, GrimSoultrapBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RUNIC_GRIMSTONE = register("runic_grimstone", IterRpgModBlocks.RUNIC_GRIMSTONE, RunicGrimstoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RUNIC_GRIMSTONE_ACTIVE = register("runic_grimstone_active", IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE, RunicGrimstoneActiveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GIANT_PHANTOM_CHAIN = register("giant_phantom_chain", IterRpgModBlocks.GIANT_PHANTOM_CHAIN, GiantPhantomChainBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPIRE_SPAWNER = register("spire_spawner", IterRpgModBlocks.SPIRE_SPAWNER, SpireSpawnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GRAND_SPIRE_SPAWNER = register("grand_spire_spawner", IterRpgModBlocks.GRAND_SPIRE_SPAWNER, GrandSpireSpawnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GRIMACE_TRAP = register("grimace_trap", IterRpgModBlocks.GRIMACE_TRAP, GrimaceTrapBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TEAR_CATCHER = register("tear_catcher", IterRpgModBlocks.TEAR_CATCHER, TearCatcherBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GRIM_LOCKER = register("grim_locker", IterRpgModBlocks.GRIM_LOCKER, GrimLockerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> VOID_MAW = register("void_maw", IterRpgModBlocks.VOID_MAW, VoidMawBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MONOLITH_DOOR = register("monolith_door", IterRpgModBlocks.MONOLITH_DOOR, MonolithDoorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<FleshWeaverTileEntity>> FLESH_WEAVER = REGISTRY.register("flesh_weaver", () -> BlockEntityType.Builder.of(FleshWeaverTileEntity::new, IterRpgModBlocks.FLESH_WEAVER.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> CRUNCHER = register("cruncher", IterRpgModBlocks.CRUNCHER, CruncherBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PEBBLE_LAUNCHER = register("pebble_launcher", IterRpgModBlocks.PEBBLE_LAUNCHER, PebbleLauncherBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GNAWER = register("gnawer", IterRpgModBlocks.GNAWER, GnawerBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
