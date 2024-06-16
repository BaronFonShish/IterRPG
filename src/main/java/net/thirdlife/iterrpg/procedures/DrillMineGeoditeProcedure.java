package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class DrillMineGeoditeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("forge:geodites")))) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "drillTime") >= GeodrillTimeConfigProcedure.execute(world) + new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "TimeOffset")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.BLOCKS, (float) 0.25, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.BLOCKS, (float) 0.25, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, (x + 0.5), (y + 0.32), (z + 0.5), 8, 0.16, 0.24, 0.16, 0.16);
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("drillTime", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == IterRpgModBlocks.GEODITE.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("forge:has_inventory_drill")))) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 1), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("loot insert ~ ~ ~ loot iter_rpg:gameplay/" + "geode_stone"));
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 0.25), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("loot spawn ~ ~ ~ loot iter_rpg:gameplay/" + "geode_stone"));
					}
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == IterRpgModBlocks.DEEPSLATE_GEODITE.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("forge:has_inventory_drill")))) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 1), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("loot insert ~ ~ ~ loot iter_rpg:" + "geode_deepslate"));
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 0.25), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("loot spawn ~ ~ ~ loot iter_rpg:" + "geode_deepslate"));
					}
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == IterRpgModBlocks.NETHERRACK_GEODITE.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("forge:has_inventory_drill")))) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 1), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("loot insert ~ ~ ~ loot iter_rpg:" + "geode_netherrack"));
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 0.25), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("loot spawn ~ ~ ~ loot iter_rpg:" + "geode_netherrack"));
					}
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == IterRpgModBlocks.BLACKSTONE_GEODITE.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("forge:has_inventory_drill")))) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 1), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("loot insert ~ ~ ~ loot iter_rpg:" + "geode_blackstone"));
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 0.25), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("loot spawn ~ ~ ~ loot iter_rpg:" + "geode_blackstone"));
					}
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == IterRpgModBlocks.ENDSTONE_GEODITE.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("forge:has_inventory_drill")))) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 1), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("loot insert ~ ~ ~ loot iter_rpg:" + "geode_endstone"));
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 0.25), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("loot spawn ~ ~ ~ loot iter_rpg:" + "geode_endstone"));
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("TimeOffset", (GeodrillTimeConfigProcedure.execute(world) * Mth.nextDouble(RandomSource.create(), -0.025, 0.025)));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("drillTime", (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "drillTime") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CRIT, (x + 0.5), (y + 0.32), (z + 0.5), 1, 0.16, 0.24, 0.16, 0.025);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ASH, (x + 0.5), (y + 0.32), (z + 0.5), 1, 0.16, 0.16, 0.16, 0.025);
			}
		}
	}
}
