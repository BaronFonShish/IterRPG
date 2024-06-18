package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Map;

public class ArthropodCatacombsGenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double DungeonDecide = 0;
		double variation = 0;
		double xoffset = 0;
		double zoffset = 0;
		double iteration = 0;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		for (int index0 = 0; index0 < 64; index0++) {
			xpos = Mth.nextInt(RandomSource.create(), -16, 16);
			ypos = Mth.nextInt(RandomSource.create(), -6, 6);
			zpos = Mth.nextInt(RandomSource.create(), -16, 16);
			if ((world.getBlockState(BlockPos.containing(x + xpos, y + ypos, z + zpos))).getBlock() == Blocks.STONE) {
				{
					BlockPos _bp = BlockPos.containing(x + xpos, y + ypos, z + zpos);
					BlockState _bs = Blocks.INFESTED_STONE.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + xpos, y + ypos, z + zpos))).getBlock() == Blocks.DEEPSLATE) {
				{
					BlockPos _bp = BlockPos.containing(x + xpos, y + ypos, z + zpos);
					BlockState _bs = Blocks.INFESTED_DEEPSLATE.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			}
		}
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_main_room_tall"));
			if (template != null) {
				template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y, z - 8), BlockPos.containing(x - 8, y, z - 8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
						_serverworld.random, 3);
			}
		}
		iteration = 0;
		for (int index1 = 0; index1 < 8; index1++) {
			variation = Mth.nextInt(RandomSource.create(), 1, 15);
			if (iteration == 0) {
				xoffset = 11;
				zoffset = -6;
			} else if (iteration == 1) {
				xoffset = 11;
				zoffset = 11;
			} else if (iteration == 2) {
				xoffset = -6;
				zoffset = 11;
			} else if (iteration == 3) {
				xoffset = -23;
				zoffset = 11;
			} else if (iteration == 4) {
				xoffset = -23;
				zoffset = -6;
			} else if (iteration == 5) {
				xoffset = -23;
				zoffset = -23;
			} else if (iteration == 6) {
				xoffset = -6;
				zoffset = -23;
			} else if (iteration == 7) {
				xoffset = 11;
				zoffset = -23;
			}
			if (variation == 1) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_1"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 2) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_2"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 3) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_3"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 4) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_4"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 5) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_5"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 6) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_6"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 7) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_7"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 8) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_8"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 9) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_9"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 10) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_10"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 11) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_12"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 12) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_12"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 13) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_13"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 14) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_14"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 15) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_15"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 2, z + zoffset), BlockPos.containing(x + xoffset, y + 2, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			iteration = iteration + 1;
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-1 ~1 ~-8 ~2 ~6 ~-10 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~ ~3 ~-8 ~1 ~5 ~-10 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~9 ~1 ~-1 ~11 ~6 ~2 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~9 ~3 ~ ~11 ~5 ~1 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~2 ~1 ~9 ~-1 ~6 ~11 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~1 ~3 ~9 ~ ~5 ~11 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-8 ~1 ~2 ~-10 ~6 ~-1 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-8 ~3 ~1 ~-10 ~5 ~ minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~7 ~1 ~16 ~11 ~6 ~19 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~7 ~3 ~17 ~11 ~5 ~18 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-10 ~1 ~16 ~-6 ~6 ~19 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-10 ~3 ~17 ~-6 ~5 ~18 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-18 ~1 ~11 ~-15 ~6 ~7 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-17 ~3 ~11 ~-16 ~5 ~7 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-18 ~1 ~-6 ~-15 ~6 ~-10 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-17 ~3 ~-6 ~-16 ~5 ~-10 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~16 ~1 ~11 ~19 ~6 ~7 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~17 ~3 ~11 ~18 ~5 ~6 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~19 ~1 ~-6 ~16 ~6 ~-10 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~18 ~3 ~-6 ~17 ~5 ~-10 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~11 ~1 ~-15 ~7 ~6 ~-18 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~11 ~3 ~-16 ~7 ~5 ~-17 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-6 ~1 ~-15 ~-10 ~6 ~-18 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-6 ~3 ~-16 ~-10 ~5 ~-17 minecraft:air");
		iteration = 0;
		for (int index2 = 0; index2 < 8; index2++) {
			variation = Mth.nextInt(RandomSource.create(), 1, 15);
			if (iteration == 0) {
				xoffset = 11;
				zoffset = -6;
			} else if (iteration == 1) {
				xoffset = 11;
				zoffset = 11;
			} else if (iteration == 2) {
				xoffset = -6;
				zoffset = 11;
			} else if (iteration == 3) {
				xoffset = -23;
				zoffset = 11;
			} else if (iteration == 4) {
				xoffset = -23;
				zoffset = -6;
			} else if (iteration == 5) {
				xoffset = -23;
				zoffset = -23;
			} else if (iteration == 6) {
				xoffset = -6;
				zoffset = -23;
			} else if (iteration == 7) {
				xoffset = 11;
				zoffset = -23;
			}
			if (variation == 1) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_1"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 2) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_2"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 3) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_3"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 4) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_4"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 5) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_5"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 6) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_6"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 7) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_7"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 8) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_8"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 9) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_9"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 10) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_10"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 11) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_12"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 12) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_12"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 13) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_13"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 14) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_14"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else if (variation == 15) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("iter_rpg", "arthropod_catacombs_small_room_15"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x + xoffset, y + 10, z + zoffset), BlockPos.containing(x + xoffset, y + 10, z + zoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			iteration = iteration + 1;
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-1 ~1 ~-8 ~2 ~6 ~-10 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~ ~3 ~-8 ~1 ~5 ~-10 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~9 ~1 ~-1 ~11 ~6 ~2 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~9 ~3 ~ ~11 ~5 ~1 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((y + 8), y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~2 ~1 ~9 ~-1 ~6 ~11 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~1 ~3 ~9 ~ ~5 ~11 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-8 ~1 ~2 ~-10 ~6 ~-1 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-8 ~3 ~1 ~-10 ~5 ~ minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~7 ~1 ~16 ~11 ~6 ~19 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~7 ~3 ~17 ~11 ~5 ~18 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-10 ~1 ~16 ~-6 ~6 ~19 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-10 ~3 ~17 ~-6 ~5 ~18 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-18 ~1 ~11 ~-15 ~6 ~7 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-17 ~3 ~11 ~-16 ~5 ~7 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-18 ~1 ~-6 ~-15 ~6 ~-10 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-17 ~3 ~-6 ~-16 ~5 ~-10 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~16 ~1 ~11 ~19 ~6 ~7 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~17 ~3 ~11 ~18 ~5 ~6 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~19 ~1 ~-6 ~16 ~6 ~-10 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~18 ~3 ~-6 ~17 ~5 ~-10 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~11 ~1 ~-15 ~7 ~6 ~-18 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~11 ~3 ~-16 ~7 ~5 ~-17 minecraft:air");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-6 ~1 ~-15 ~-10 ~6 ~-18 iter_rpg:hivestone");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 8), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~-6 ~3 ~-16 ~-10 ~5 ~-17 minecraft:air");
	}
}
