
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.world.inventory.VoidMawGuiMenu;
import net.thirdlife.iterrpg.world.inventory.TradingScreenMenu;
import net.thirdlife.iterrpg.world.inventory.SpellbookGuiMenu;
import net.thirdlife.iterrpg.world.inventory.MobPlacerGUIMenu;
import net.thirdlife.iterrpg.world.inventory.GrimLockerGuiMenu;
import net.thirdlife.iterrpg.world.inventory.GnawerGuiMenu;
import net.thirdlife.iterrpg.world.inventory.ElementalArmorModeSwitchGuiMenu;
import net.thirdlife.iterrpg.world.inventory.CoinPouchGuiMenu;
import net.thirdlife.iterrpg.world.inventory.ArcanistTableGuiMenu;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class IterRpgModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, IterRpgMod.MODID);
	public static final RegistryObject<MenuType<MobPlacerGUIMenu>> MOB_PLACER_GUI = REGISTRY.register("mob_placer_gui", () -> IForgeMenuType.create(MobPlacerGUIMenu::new));
	public static final RegistryObject<MenuType<SpellbookGuiMenu>> SPELLBOOK_GUI = REGISTRY.register("spellbook_gui", () -> IForgeMenuType.create(SpellbookGuiMenu::new));
	public static final RegistryObject<MenuType<GrimLockerGuiMenu>> GRIM_LOCKER_GUI = REGISTRY.register("grim_locker_gui", () -> IForgeMenuType.create(GrimLockerGuiMenu::new));
	public static final RegistryObject<MenuType<VoidMawGuiMenu>> VOID_MAW_GUI = REGISTRY.register("void_maw_gui", () -> IForgeMenuType.create(VoidMawGuiMenu::new));
	public static final RegistryObject<MenuType<ArcanistTableGuiMenu>> ARCANIST_TABLE_GUI = REGISTRY.register("arcanist_table_gui", () -> IForgeMenuType.create(ArcanistTableGuiMenu::new));
	public static final RegistryObject<MenuType<ElementalArmorModeSwitchGuiMenu>> ELEMENTAL_ARMOR_MODE_SWITCH_GUI = REGISTRY.register("elemental_armor_mode_switch_gui", () -> IForgeMenuType.create(ElementalArmorModeSwitchGuiMenu::new));
	public static final RegistryObject<MenuType<CoinPouchGuiMenu>> COIN_POUCH_GUI = REGISTRY.register("coin_pouch_gui", () -> IForgeMenuType.create(CoinPouchGuiMenu::new));
	public static final RegistryObject<MenuType<TradingScreenMenu>> TRADING_SCREEN = REGISTRY.register("trading_screen", () -> IForgeMenuType.create(TradingScreenMenu::new));
	public static final RegistryObject<MenuType<GnawerGuiMenu>> GNAWER_GUI = REGISTRY.register("gnawer_gui", () -> IForgeMenuType.create(GnawerGuiMenu::new));
}
