
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.common.enchantment.RigourEnchantment;
import net.thirdlife.iterrpg.common.enchantment.DexterityEnchantment;
import net.thirdlife.iterrpg.common.enchantment.BlightedBladeEnchantment;
import net.thirdlife.iterrpg.common.enchantment.AttunementEnchantment;
import net.thirdlife.iterrpg.common.enchantment.ArcaneConductivityEnchantment;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

public class IterRpgModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, IterRpgMod.MOD_ID);
	public static final RegistryObject<Enchantment> ARCANE_CONDUCTIVITY = REGISTRY.register("arcane_conductivity", () -> new ArcaneConductivityEnchantment());
	public static final RegistryObject<Enchantment> BLIGHTED_BLADE = REGISTRY.register("blighted_blade", () -> new BlightedBladeEnchantment());
	public static final RegistryObject<Enchantment> ATTUNEMENT = REGISTRY.register("attunement", () -> new AttunementEnchantment());
	public static final RegistryObject<Enchantment> DEXTERITY = REGISTRY.register("dexterity", () -> new DexterityEnchantment());
	public static final RegistryObject<Enchantment> RIGOUR = REGISTRY.register("rigour", () -> new RigourEnchantment());
}
