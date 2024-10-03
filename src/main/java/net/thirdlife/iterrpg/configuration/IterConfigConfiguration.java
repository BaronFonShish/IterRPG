package net.thirdlife.iterrpg.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class IterConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ELEMENTALS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DEMONS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SPIDERS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GOBLIN_PATROLS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SORROW_SPIRE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ARTHROPOD_CATACOMBS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GOBLIN_CAMPS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> VASES;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ABYSSQUARTZ;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SPIDER_EGGS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GENERIC_DUNGEONS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GEODITES;
	public static final ForgeConfigSpec.ConfigValue<Double> GEODRILL_TIME;
	public static final ForgeConfigSpec.ConfigValue<Double> GOBLIN_SPAWNER_CYCLE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> COIN_DROP;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GEODE_DROP;
	public static final ForgeConfigSpec.ConfigValue<Boolean> EVENTS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GOBLIN_RAID;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SKIES_OF_RUIN;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SKIES_OF_RUIN_REPEATABLE;
	public static final ForgeConfigSpec.ConfigValue<Double> EVENT_DURATION;
	public static final ForgeConfigSpec.ConfigValue<Double> EVENT_MINTIME;
	public static final ForgeConfigSpec.ConfigValue<Double> EVENT_MAXTIME;
	static {
		BUILDER.push("mobs");
		ELEMENTALS = BUILDER.comment("Do elementals spawn?").define("Elementals", true);
		DEMONS = BUILDER.comment("Do demons spawn?").define("Demons", true);
		SPIDERS = BUILDER.comment("Do giant spider and spiderlings spawn?").define("Spiders", true);
		GOBLIN_PATROLS = BUILDER.define("Goblin patrols", true);
		BUILDER.pop();
		BUILDER.push("generation");
		SORROW_SPIRE = BUILDER.comment("Does Sorrow Spire generate in the Nether?").define("Sorrow Spire", true);
		ARTHROPOD_CATACOMBS = BUILDER.comment("Do Arthropod Catacombs generate underground?").define("Arthropod Catacombs", true);
		GOBLIN_CAMPS = BUILDER.comment("Do goblin camps generate around the world?").define("Goblin camps", true);
		VASES = BUILDER.comment("Do vases generate underground?").define("Vases", true);
		ABYSSQUARTZ = BUILDER.comment("Do abyssquartz crystals generate underground?").define("Abyssquartz", true);
		SPIDER_EGGS = BUILDER.comment("Do spider eggs generate underground?").define("Spider eggs", true);
		GENERIC_DUNGEONS = BUILDER.comment("Do generic dungeons generate?").define("Generic dungeons", true);
		GEODITES = BUILDER.comment("Do geodites generate?").define("Geodites", true);
		BUILDER.pop();
		BUILDER.push("functions");
		GEODRILL_TIME = BUILDER.comment("Amount of ticks it takes for a geodrill to produce a geode").define("Geodrill time", (double) 12000);
		GOBLIN_SPAWNER_CYCLE = BUILDER.comment("Amout of ticks it takes for a goblin spawner to repopulate a goblin camp").define("Goblin spawner cycle", (double) 12000);
		COIN_DROP = BUILDER.comment("Do mobs sometime drop coins?").define("Coin drop", true);
		GEODE_DROP = BUILDER.comment("Do mobs sometimes drop geodes?").define("Geode drop", true);
		BUILDER.pop();
		BUILDER.push("events");
		EVENTS = BUILDER.comment("Do world events happen?").define("Events", true);
		GOBLIN_RAID = BUILDER.comment("Do goblins sometimes raid the player?").define("Goblin raids", true);
		SKIES_OF_RUIN = BUILDER.comment("Do Celestials invade the world after the dragon is slain?").define("Skies of Ruin", true);
		SKIES_OF_RUIN_REPEATABLE = BUILDER.comment("Does Skies of ruin event sometimes repeat?").define("Repeatable Skies of ruin", true);
		EVENT_DURATION = BUILDER.define("Event duration", (double) 1);
		EVENT_MINTIME = BUILDER.define("Event min time", (double) 7);
		EVENT_MAXTIME = BUILDER.define("Event max time", (double) 28);
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
