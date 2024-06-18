
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.common.potion.WrathOfTheDepthsMobEffect;
import net.thirdlife.iterrpg.common.potion.IonizedMobEffect;
import net.thirdlife.iterrpg.common.potion.CursedMobEffect;
import net.thirdlife.iterrpg.common.potion.ArcaneConductionMobEffect;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class IterRpgModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, IterRpgMod.MOD_ID);
	public static final RegistryObject<MobEffect> CURSED = REGISTRY.register("cursed", () -> new CursedMobEffect());
	public static final RegistryObject<MobEffect> ARCANE_CONDUCTION = REGISTRY.register("arcane_conduction", () -> new ArcaneConductionMobEffect());
	public static final RegistryObject<MobEffect> IONIZED = REGISTRY.register("ionized", () -> new IonizedMobEffect());
	public static final RegistryObject<MobEffect> WRATH_OF_THE_DEPTHS = REGISTRY.register("wrath_of_the_depths", () -> new WrathOfTheDepthsMobEffect());
}
