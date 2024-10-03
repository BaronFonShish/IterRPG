package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class SpellCastSpecialProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double slot = 0;
		double spellslot = 0;
		double cooldown = 0;
		double mana = 0;
		boolean valid = false;
		boolean cast = false;
		ItemStack spellbook = ItemStack.EMPTY;
		ItemStack spell = ItemStack.EMPTY;
		ItemStack focus = ItemStack.EMPTY;
		focus = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem).getItem() == ItemStack.EMPTY.getItem()
				&& focus.is(ItemTags.create(new ResourceLocation("iter_rpg:spellcasting_focuses"))) && !(entity instanceof Player _plrCldCheck4 && _plrCldCheck4.getCooldowns().isOnCooldown(focus.getItem()))) {
			cast = false;
			if (focus.getItem() == IterRpgModItems.HYDRA_STAFF.get()) {
				cooldown = 115 * WandReturnCooldownProcedure.execute(entity);
				mana = 25 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					HydraSpecialSpellProcedure.execute(world, x, y, z, entity);
				}
			}
			if (focus.getItem() == IterRpgModItems.SMOLDERING_TOME.get()) {
				cooldown = 15 * WandReturnCooldownProcedure.execute(entity);
				mana = 4 * WandReturnManaProcedure.execute(entity);
				if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana >= mana) {
					cast = true;
					SmolderingTomeCastSpecialProcedure.execute(world, x, y, z, entity);
				}
			}
		} else {
			SpellCastBaseProcedure.execute(world, x, y, z, entity);
		}
		if (cast) {
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
					_player.getCooldowns().addCooldown(focus.getItem(), 75);
			} else {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(focus.getItem(), (int) (cooldown * 0.75));
			}
		}
	}
}
