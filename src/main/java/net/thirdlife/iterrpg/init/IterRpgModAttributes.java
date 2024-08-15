/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IterRpgModAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, IterRpgMod.MODID);
	public static final RegistryObject<Attribute> BASEMANAREGENERATION = ATTRIBUTES.register("base_mana_regeneration", () -> (new RangedAttribute("attribute." + IterRpgMod.MODID + ".base_mana_regeneration", 0.025, 0, 10000)).setSyncable(true));
	public static final RegistryObject<Attribute> BASEMANACAPACITY = ATTRIBUTES.register("base_mana_capacity", () -> (new RangedAttribute("attribute." + IterRpgMod.MODID + ".base_mana_capacity", 50, 0, 10000)).setSyncable(true));
	public static final RegistryObject<Attribute> SPELLCASTINGPOWER = ATTRIBUTES.register("spellcasting_power", () -> (new RangedAttribute("attribute." + IterRpgMod.MODID + ".spellcasting_power", 0, 0, 10000000)).setSyncable(true));
	public static final RegistryObject<Attribute> SPELLCOOLDOWN = ATTRIBUTES.register("spell_cooldown", () -> (new RangedAttribute("attribute." + IterRpgMod.MODID + ".spell_cooldown", 0, 0, 10000000)).setSyncable(true));
	public static final RegistryObject<Attribute> MANACONSUMPTION = ATTRIBUTES.register("mana_consumption", () -> (new RangedAttribute("attribute." + IterRpgMod.MODID + ".mana_consumption", 0, 0, 10000000)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, BASEMANAREGENERATION.get());
		event.add(EntityType.PLAYER, BASEMANACAPACITY.get());
		event.add(EntityType.PLAYER, SPELLCASTINGPOWER.get());
		event.add(EntityType.PLAYER, SPELLCOOLDOWN.get());
		event.add(EntityType.PLAYER, MANACONSUMPTION.get());
	}

	@Mod.EventBusSubscriber
	private class Utils {
		@SubscribeEvent
		public static void persistAttributes(PlayerEvent.Clone event) {
			Player oldP = event.getOriginal();
			Player newP = (Player) event.getEntity();
			newP.getAttribute(BASEMANAREGENERATION.get()).setBaseValue(oldP.getAttribute(BASEMANAREGENERATION.get()).getBaseValue());
			newP.getAttribute(BASEMANACAPACITY.get()).setBaseValue(oldP.getAttribute(BASEMANACAPACITY.get()).getBaseValue());
			newP.getAttribute(SPELLCASTINGPOWER.get()).setBaseValue(oldP.getAttribute(SPELLCASTINGPOWER.get()).getBaseValue());
			newP.getAttribute(SPELLCOOLDOWN.get()).setBaseValue(oldP.getAttribute(SPELLCOOLDOWN.get()).getBaseValue());
			newP.getAttribute(MANACONSUMPTION.get()).setBaseValue(oldP.getAttribute(MANACONSUMPTION.get()).getBaseValue());
		}
	}
}
