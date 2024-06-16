
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.client.gui.VoidMawGuiScreen;
import net.thirdlife.iterrpg.client.gui.SpellbookGuiScreen;
import net.thirdlife.iterrpg.client.gui.MobPlacerGUIScreen;
import net.thirdlife.iterrpg.client.gui.GrimLockerGuiScreen;
import net.thirdlife.iterrpg.client.gui.ElementalArmorModeSwitchGuiScreen;
import net.thirdlife.iterrpg.client.gui.ArcanistTableGuiScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class IterRpgModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(IterRpgModMenus.MOB_PLACER_GUI.get(), MobPlacerGUIScreen::new);
			MenuScreens.register(IterRpgModMenus.SPELLBOOK_GUI.get(), SpellbookGuiScreen::new);
			MenuScreens.register(IterRpgModMenus.GRIM_LOCKER_GUI.get(), GrimLockerGuiScreen::new);
			MenuScreens.register(IterRpgModMenus.VOID_MAW_GUI.get(), VoidMawGuiScreen::new);
			MenuScreens.register(IterRpgModMenus.ARCANIST_TABLE_GUI.get(), ArcanistTableGuiScreen::new);
			MenuScreens.register(IterRpgModMenus.ELEMENTAL_ARMOR_MODE_SWITCH_GUI.get(), ElementalArmorModeSwitchGuiScreen::new);
		});
	}
}
