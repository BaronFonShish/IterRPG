package net.thirdlife.iterrpg.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModItems;
import net.thirdlife.iterrpg.init.IterRpgModEnchantments;
import net.thirdlife.iterrpg.init.IterRpgModAttributes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

import java.util.concurrent.atomic.AtomicReference;

@Mod.EventBusSubscriber
public class PlayerManaProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		boolean valid = false;
		ItemStack spell = ItemStack.EMPTY;
		ItemStack spellbook = ItemStack.EMPTY;
		double cooldown = 0;
		double slot = 0;
		double regen = 0;
		double capacity = 0;
		double exhaustion = 0;
		double dissipation = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("iter_rpg:spellcasting_focuses")))
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("iter_rpg:spellcasting_focuses")))
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("iter_rpg:magic_item")))
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("iter_rpg:magic_item")))
				|| (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).ManaOverlay) {
			{
				boolean _setval = true;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MageStatus = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			slot = 0;
			valid = false;
			for (int index0 = 0; index0 < 35; index0++) {
				if (!((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) slot, entity)).getItem() == IterRpgModItems.SPELL_BOOK.get())) {
					slot = slot + 1;
				} else {
					spellbook = (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
							return _retval.get();
						}
					}.getItemStack((int) slot, entity));
				}
			}
			if (!(spellbook.getItem() == ItemStack.EMPTY.getItem())) {
				{
					ItemStack _setval = (new Object() {
						public ItemStack getItemStack(int sltid, ItemStack _isc) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
							return _retval.get();
						}
					}.getItemStack((int) (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SelectedSpell, spellbook));
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SpellItem = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					ItemStack _setval = ItemStack.EMPTY;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SpellItem = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MageStatus = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		regen = ((LivingEntity) entity).getAttribute(IterRpgModAttributes.BASEMANAREGENERATION.get()).getValue();
		capacity = ((LivingEntity) entity).getAttribute(IterRpgModAttributes.BASEMANACAPACITY.get()).getValue();
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.AMETRINE_PENDANT.get(), lv).isPresent() : false) {
			regen = regen + 0.025;
		}
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.ABYSSQUARTZ_CAPACITATOR.get(), lv).isPresent() : false) {
			capacity = capacity + 15;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == IterRpgModItems.RAGGED_HELMET.get()) {
			capacity = capacity + 10;
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == IterRpgModItems.AMETRINE_HELMET.get()) {
			capacity = capacity + 2.5;
			regen = regen + 0.0025;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == IterRpgModItems.RAGGED_CHESTPLATE.get()) {
			regen = regen * 1.15;
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == IterRpgModItems.AMETRINE_CHESTPLATE.get()) {
			capacity = capacity + 2.5;
			regen = regen + 0.0025;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == IterRpgModItems.AMETRINE_LEGGINGS.get()) {
			capacity = capacity + 2.5;
			regen = regen + 0.0025;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == IterRpgModItems.AMETRINE_BOOTS.get()) {
			capacity = capacity + 2.5;
			regen = regen + 0.0025;
		}
		regen = regen + capacity / 7500;
		regen = regen + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getEnchantmentLevel(IterRpgModEnchantments.ARCANE_CONDUCTIVITY.get()) * 0.0025;
		regen = regen + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(IterRpgModEnchantments.ARCANE_CONDUCTIVITY.get()) * 0.0025;
		regen = regen + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getEnchantmentLevel(IterRpgModEnchantments.ARCANE_CONDUCTIVITY.get()) * 0.0025;
		regen = regen + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getEnchantmentLevel(IterRpgModEnchantments.ARCANE_CONDUCTIVITY.get()) * 0.0025;
		{
			double _setval = capacity;
			entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MaxMana = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		regen = regen / 25;
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana < (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new IterRpgModVariables.PlayerVariables())).MaxMana) {
			if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).MaxMana
					- (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana <= regen) {
				{
					double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).MaxMana;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana + regen;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana > (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new IterRpgModVariables.PlayerVariables())).MaxMana) {
			{
				double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).MaxMana;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana < 0) {
			{
				double _setval = 0;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
