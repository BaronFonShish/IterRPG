package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

public class SpellCastBaseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean valid = false;
		boolean cast = false;
		ItemStack spellbook = ItemStack.EMPTY;
		ItemStack spell = ItemStack.EMPTY;
		ItemStack focus = ItemStack.EMPTY;
		double slot = 0;
		double spellslot = 0;
		double cooldown = 0;
		double mana = 0;
		double spelltier = 0;
		double casttier = 0;
		String textspell = "";
		String textcast = "";
		focus = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (!(((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == ItemStack.EMPTY.getItem())
				&& !(entity instanceof Player _plrCldCheck3
						&& _plrCldCheck3.getCooldowns().isOnCooldown(((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem()))
				&& focus.is(ItemTags.create(new ResourceLocation("iter_rpg:spellcasting_focuses"))) && !(entity instanceof Player _plrCldCheck5 && _plrCldCheck5.getCooldowns().isOnCooldown(focus.getItem()))) {
			textspell = "iterpg.spell.level.";
			if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).is(ItemTags.create(new ResourceLocation("iter_rpg:spell_tier_basic")))) {
				spelltier = 1;
				textspell = textspell + "basic";
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).is(ItemTags.create(new ResourceLocation("iter_rpg:spell_tier_advanced")))) {
				spelltier = 2;
				textspell = textspell + "advanced";
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).is(ItemTags.create(new ResourceLocation("iter_rpg:spell_tier_expert")))) {
				spelltier = 3;
				textspell = textspell + "expert";
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).is(ItemTags.create(new ResourceLocation("iter_rpg:spell_tier_fabled")))) {
				spelltier = 4;
				textspell = textspell + "fabled";
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).is(ItemTags.create(new ResourceLocation("iter_rpg:spell_tier_primeval")))) {
				spelltier = 5;
				textspell = textspell + "primeval";
			} else {
				spelltier = 0;
				textspell = textspell + "basic";
			}
			textcast = "iterpg.spell.level.";
			if (focus.is(ItemTags.create(new ResourceLocation("iter_rpg:spellcast_tier_basic")))) {
				casttier = 1;
				textcast = textcast + "basic";
			} else if (focus.is(ItemTags.create(new ResourceLocation("iter_rpg:spellcast_tier_advanced")))) {
				casttier = 2;
				textcast = textcast + "advanced";
			} else if (focus.is(ItemTags.create(new ResourceLocation("iter_rpg:spellcast_tier_expert")))) {
				casttier = 3;
				textcast = textcast + "expert";
			} else if (focus.is(ItemTags.create(new ResourceLocation("iter_rpg:spellcast_tier_fabled")))) {
				casttier = 4;
				textcast = textcast + "fabled";
			} else if (focus.is(ItemTags.create(new ResourceLocation("iter_rpg:spellcast_tier_primeval")))) {
				casttier = 5;
				textcast = textcast + "primeval";
			} else {
				casttier = 0;
				textcast = textcast + "basic";
			}
			if (casttier >= spelltier) {
				valid = true;
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("iterpg.spell.levelfail").getString() + "" + Component.translatable("iterpg.spell.castlevel").getString() + Component.translatable(textcast).getString()
							+ Component.translatable("iterpg.spell.spelllevel").getString() + Component.translatable(textspell).getString())), true);
			}
		}
		if (valid) {
			cast = false;
			if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_ETHERBOLT.get()) {
				cooldown = 20 * WandReturnCooldownProcedure.execute(entity);
				mana = 2 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					ArcaneBoltCastProcedure.execute(world, x, y, z, entity);
				}
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_HEAL.get()) {
				cooldown = 250 * WandReturnCooldownProcedure.execute(entity);
				mana = 12 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					HealCastProcedure.execute(world, x, y, z, entity);
				}
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_ETHERBLAST.get()) {
				cooldown = 45 * WandReturnCooldownProcedure.execute(entity);
				mana = 5 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					ArcaneBlastCastProcedure.execute(world, x, y, z, entity);
				}
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_IGNITE.get()) {
				cooldown = 35 * WandReturnCooldownProcedure.execute(entity);
				mana = 2 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					IgniteCastProcedure.execute(world, x, y, z, entity);
				}
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_GUST.get()) {
				cooldown = 35 * WandReturnCooldownProcedure.execute(entity);
				mana = 2 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					GustCastProcedure.execute(world, x, y, z, entity);
				}
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_SPLASHES.get()) {
				cooldown = 35 * WandReturnCooldownProcedure.execute(entity);
				mana = 2 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					SplashesCastProcedure.execute(world, x, y, z, entity);
				}
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_ATTRACT.get()) {
				cooldown = 35 * WandReturnCooldownProcedure.execute(entity);
				mana = 2 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					AttractCastProcedure.execute(world, x, y, z, entity);
				}
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_CULTIVATE.get()) {
				cooldown = 115 * WandReturnCooldownProcedure.execute(entity);
				mana = 8 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					CultivateCastProcedure.execute(world, x, y, z, entity);
				}
			} else if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_EMBERS.get()) {
				cooldown = 25 * WandReturnCooldownProcedure.execute(entity);
				mana = 2 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					EmbersCastProcedure.execute(world, x, y, z, entity);
				}
			}
			if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_DROPLETS.get()) {
				cooldown = 10 * WandReturnCooldownProcedure.execute(entity);
				mana = 1 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					DropletsCastProcedure.execute(world, x, y, z, entity);
				}
			}
			if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_ZAP.get()) {
				cooldown = 20 * WandReturnCooldownProcedure.execute(entity);
				mana = 2 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					ZapCastProcedure.execute(world, entity);
				}
			}
			if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_POISON_GAS.get()) {
				cooldown = 40 * WandReturnCooldownProcedure.execute(entity);
				mana = 2 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					PoisonGasCastProcedure.execute(world, x, y, z, entity);
				}
			}
			if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_SHADELASH.get()) {
				cooldown = 16 * WandReturnCooldownProcedure.execute(entity);
				mana = 2 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					ShadeLashCastProcedure.execute(world, x, y, z, entity);
				}
			}
			if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_FLAMEBOLT.get()) {
				cooldown = 30 * WandReturnCooldownProcedure.execute(entity);
				mana = 4 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					FlameboltCastProcedure.execute(world, x, y, z, entity);
				}
			}
			if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == IterRpgModItems.SPELL_VOIDBEAM.get()) {
				cooldown = 25 * WandReturnCooldownProcedure.execute(entity);
				mana = 4 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					VoidbeamCastProcedure.execute(world, entity);
				}
			}
			if (cast) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem(), (int) cooldown);
				{
					double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana - mana;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.PLAYERS, (float) 0.5,
								(float) Mth.nextDouble(RandomSource.create(), 1.5, 1.75));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.PLAYERS, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 1.5, 1.75), false);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (cooldown >= 100) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(focus.getItem(), 50);
				} else {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(focus.getItem(), (int) (cooldown * 0.5));
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
					{
						ItemStack _ist = focus;
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
				AftercastEffectProcedure.execute(entity);
			}
		}
	}
}
