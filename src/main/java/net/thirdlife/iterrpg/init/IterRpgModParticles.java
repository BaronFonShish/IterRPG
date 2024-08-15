
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.client.particle.WeeperTearParticleParticle;
import net.thirdlife.iterrpg.client.particle.WaterSigilParticle;
import net.thirdlife.iterrpg.client.particle.VoidSigilParticle;
import net.thirdlife.iterrpg.client.particle.VoidEyeParticleParticle;
import net.thirdlife.iterrpg.client.particle.VengefulParticleParticle;
import net.thirdlife.iterrpg.client.particle.SpiritParticleParticle;
import net.thirdlife.iterrpg.client.particle.PortalSparkParticleParticle;
import net.thirdlife.iterrpg.client.particle.PoisonCloudParticle;
import net.thirdlife.iterrpg.client.particle.LightningParticleParticle;
import net.thirdlife.iterrpg.client.particle.GobsteelShardsParticle;
import net.thirdlife.iterrpg.client.particle.FireSigilParticle;
import net.thirdlife.iterrpg.client.particle.ElementalVoidParticle;
import net.thirdlife.iterrpg.client.particle.ElementalParticleParticle;
import net.thirdlife.iterrpg.client.particle.ElementalLeafParticle;
import net.thirdlife.iterrpg.client.particle.ElementalDropletParticle;
import net.thirdlife.iterrpg.client.particle.ElemFlameParticle;
import net.thirdlife.iterrpg.client.particle.EarthSigilParticle;
import net.thirdlife.iterrpg.client.particle.DemonbloodParticle;
import net.thirdlife.iterrpg.client.particle.CoinParticleParticle;
import net.thirdlife.iterrpg.client.particle.ChainParticleParticle;
import net.thirdlife.iterrpg.client.particle.ArcaneParticleParticle;
import net.thirdlife.iterrpg.client.particle.AirSigilParticle;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class IterRpgModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(IterRpgModParticleTypes.ARCANE_PARTICLE.get(), ArcaneParticleParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get(), WeeperTearParticleParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.ELEMENTAL_DROPLET.get(), ElementalDropletParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.DEMONBLOOD.get(), DemonbloodParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.COIN_PARTICLE.get(), CoinParticleParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.ELEMENTAL_LEAF.get(), ElementalLeafParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.CHAIN_PARTICLE.get(), ChainParticleParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.ELEMENTAL_VOID.get(), ElementalVoidParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.GOBSTEEL_SHARDS.get(), GobsteelShardsParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.ELEMENTAL_PARTICLE.get(), ElementalParticleParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.VOID_EYE_PARTICLE.get(), VoidEyeParticleParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.PORTAL_SPARK_PARTICLE.get(), PortalSparkParticleParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.EARTH_SIGIL.get(), EarthSigilParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.WATER_SIGIL.get(), WaterSigilParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.AIR_SIGIL.get(), AirSigilParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.FIRE_SIGIL.get(), FireSigilParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.VOID_SIGIL.get(), VoidSigilParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.LIGHTNING_PARTICLE.get(), LightningParticleParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.SPIRIT_PARTICLE.get(), SpiritParticleParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.VENGEFUL_PARTICLE.get(), VengefulParticleParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.ELEM_FLAME.get(), ElemFlameParticle::provider);
		event.registerSpriteSet(IterRpgModParticleTypes.POISON_CLOUD.get(), PoisonCloudParticle::provider);
	}
}
