package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

public class GeodeCrackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 2);
			if (itemstack.getItem() == IterRpgModItems.STONE_GEODE.get()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"loot spawn ~ ~0.5 ~ loot iter_rpg:gameplay/geode_stone");
			} else if (itemstack.getItem() == IterRpgModItems.DEEPSLATE_GEODE.get()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"loot spawn ~ ~0.5 ~ loot iter_rpg:geode_deepslate");
			} else if (itemstack.getItem() == IterRpgModItems.NETHERRACK_GEODE.get()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"loot spawn ~ ~0.5 ~ loot iter_rpg:geode_netherrack");
			} else if (itemstack.getItem() == IterRpgModItems.BLACKSTONE_GEODE.get()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"loot spawn ~ ~0.5 ~ loot iter_rpg:geode_blackstone");
			} else if (itemstack.getItem() == IterRpgModItems.ENDSTONE_GEODE.get()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"loot spawn ~ ~0.5 ~ loot iter_rpg:geode_endstone");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
				} else {
					_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.PLAYERS, (float) 0.5,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
				} else {
					_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.PLAYERS, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
				}
			}
			for (int index0 = 0; index0 < 2; index0++) {
				if (world instanceof ServerLevel _level)
					_level.addFreshEntity(new ExperienceOrb(_level, x, (y + 1), z, 1));
			}
			if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				itemstack.shrink(1);
				if (1 > Mth.nextInt(RandomSource.create(), 0, (int) (1 + (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(Enchantments.UNBREAKING)))) {
					{
						ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
		}
	}
}
