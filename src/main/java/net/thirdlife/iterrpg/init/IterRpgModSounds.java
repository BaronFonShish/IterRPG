
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public class IterRpgModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, IterRpgMod.MOD_ID);
	public static final RegistryObject<SoundEvent> GRIEVER_AMBIENT = REGISTRY.register("griever_ambient", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "griever_ambient")));
	public static final RegistryObject<SoundEvent> GRIEVER_DEATH = REGISTRY.register("griever_death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "griever_death")));
	public static final RegistryObject<SoundEvent> GRIEVER_SCREAM = REGISTRY.register("griever_scream", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "griever_scream")));
	public static final RegistryObject<SoundEvent> FLAIL_STRIKE = REGISTRY.register("flail_strike", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "flail_strike")));
	public static final RegistryObject<SoundEvent> GRIEVER_HURT = REGISTRY.register("griever_hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "griever_hurt")));
	public static final RegistryObject<SoundEvent> WEEPER_AMBIENT = REGISTRY.register("weeper_ambient", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "weeper_ambient")));
	public static final RegistryObject<SoundEvent> WEEPER_DEATH = REGISTRY.register("weeper_death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "weeper_death")));
	public static final RegistryObject<SoundEvent> WEEPER_HURT = REGISTRY.register("weeper_hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "weeper_hurt")));
	public static final RegistryObject<SoundEvent> MUDKIN_HURT = REGISTRY.register("mudkin_hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "mudkin_hurt")));
	public static final RegistryObject<SoundEvent> MUDKIN_DEATH = REGISTRY.register("mudkin_death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "mudkin_death")));
	public static final RegistryObject<SoundEvent> MUDKIN_RUN = REGISTRY.register("mudkin_run", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "mudkin_run")));
	public static final RegistryObject<SoundEvent> MUDKIN_AMBIENT = REGISTRY.register("mudkin_ambient", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "mudkin_ambient")));
	public static final RegistryObject<SoundEvent> GIANT_SPIDER_IDLE = REGISTRY.register("giant_spider_idle", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "giant_spider_idle")));
	public static final RegistryObject<SoundEvent> GIANT_SPIDER_HURT = REGISTRY.register("giant_spider_hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "giant_spider_hurt")));
	public static final RegistryObject<SoundEvent> GIANT_SPIDER_DEATH = REGISTRY.register("giant_spider_death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "giant_spider_death")));
	public static final RegistryObject<SoundEvent> FIEND_HURT = REGISTRY.register("fiend_hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("iter_rpg", "fiend_hurt")));
}
