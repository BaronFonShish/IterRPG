
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class IterRpgModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, IterRpgMod.MOD_ID);
	public static final RegistryObject<SimpleParticleType> ARCANE_PARTICLE = REGISTRY.register("arcane_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> WEEPER_TEAR_PARTICLE = REGISTRY.register("weeper_tear_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ELEMENTAL_DROPLET = REGISTRY.register("elemental_droplet", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DEMONBLOOD = REGISTRY.register("demonblood", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> COIN_PARTICLE = REGISTRY.register("coin_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ELEMENTAL_LEAF = REGISTRY.register("elemental_leaf", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> CHAIN_PARTICLE = REGISTRY.register("chain_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ELEMENTAL_VOID = REGISTRY.register("elemental_void", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> GOBSTEEL_SHARDS = REGISTRY.register("gobsteel_shards", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ELEMENTAL_PARTICLE = REGISTRY.register("elemental_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> VOID_EYE_PARTICLE = REGISTRY.register("void_eye_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> PORTAL_SPARK_PARTICLE = REGISTRY.register("portal_spark_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> EARTH_SIGIL = REGISTRY.register("earth_sigil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> WATER_SIGIL = REGISTRY.register("water_sigil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> AIR_SIGIL = REGISTRY.register("air_sigil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FIRE_SIGIL = REGISTRY.register("fire_sigil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> VOID_SIGIL = REGISTRY.register("void_sigil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> LIGHTNING_PARTICLE = REGISTRY.register("lightning_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SPIRIT_PARTICLE = REGISTRY.register("spirit_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> VENGEFUL_PARTICLE = REGISTRY.register("vengeful_particle", () -> new SimpleParticleType(false));
}
