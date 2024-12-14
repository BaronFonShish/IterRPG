package net.thirdlife.iterrpg.network;

import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IterRpgModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		IterRpgMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		IterRpgMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.MageStatus = original.MageStatus;
			clone.ItemManaCapacity = original.ItemManaCapacity;
			clone.MagicCooldown = original.MagicCooldown;
			clone.ManabarStyle = original.ManabarStyle;
			clone.ElementalArmorCooldown = original.ElementalArmorCooldown;
			clone.MeleeAttackCooldown = original.MeleeAttackCooldown;
			clone.SetBonusToggle = original.SetBonusToggle;
			clone.ElementalArmorPassiveCooldown = original.ElementalArmorPassiveCooldown;
			clone.SelectedSpell = original.SelectedSpell;
			clone.AetherExhaustion = original.AetherExhaustion;
			clone.AetherExhaustionThreshold = original.AetherExhaustionThreshold;
			clone.AetherExhaustionDissipation = original.AetherExhaustionDissipation;
			clone.MaxMana = original.MaxMana;
			clone.ManaOverlay = original.ManaOverlay;
			clone.PlayerCoinAmount = original.PlayerCoinAmount;
			clone.demon_friendly = original.demon_friendly;
			if (!event.isWasDeath()) {
				clone.SpellItem = original.SpellItem;
				clone.SpellbookSlot = original.SpellbookSlot;
				clone.LastDamageDealt = original.LastDamageDealt;
				clone.LastDamageRecieved = original.LastDamageRecieved;
				clone.Mana = original.Mana;
				clone.tradepage = original.tradepage;
				clone.earth_lure = original.earth_lure;
				clone.water_lure = original.water_lure;
				clone.air_lure = original.air_lure;
				clone.fire_lure = original.fire_lure;
				clone.void_lure = original.void_lure;
				clone.DropLuck = original.DropLuck;
				clone.spellbook = original.spellbook;
				clone.spellbookslot = original.spellbookslot;
				clone.CurrentlyTrading = original.CurrentlyTrading;
				clone.price1 = original.price1;
				clone.price2 = original.price2;
				clone.price3 = original.price3;
				clone.price4 = original.price4;
				clone.price5 = original.price5;
				clone.flaps_left = original.flaps_left;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					IterRpgMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					IterRpgMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					IterRpgMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "iter_rpg_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				IterRpgMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "iter_rpg_mapvars";
		public boolean unlocked_earth = false;
		public boolean unlocked_water = false;
		public boolean unlocked_air = false;
		public boolean unlocked_fire = false;
		public boolean unlocked_void = false;
		public boolean config_abyss_quartz = false;
		public boolean config_vases = false;
		public boolean config_spider_eggs = false;
		public boolean config_giant_spiders = false;
		public boolean config_spiderlings = false;
		public boolean config_generic_dungeons = false;
		public boolean config_geodes = false;
		public boolean config_goblin_camps = false;
		public boolean config_sorrow_spire = false;
		public boolean config_spider_catacombs = false;
		public boolean config_elementals = false;
		public boolean config_demons = false;
		public boolean config_scallops = false;
		public double config_geodrill_time = 0;
		public double config_goblinspawner_time = 0;
		public boolean config_geodes_drop = false;
		public boolean config_coins_drop = false;
		public boolean config_goblin_patrols = false;
		public boolean config_demon_hive = false;
		public boolean config_skies_of_ruin = false;
		public boolean config_skies_of_ruin_repeatable = false;
		public boolean config_events = false;
		public double config_event_rate = 0;
		public String OverworldEvent = "\"\"";
		public String NetherEvent = "\"\"";
		public double OverworldEventTimer = 0;
		public double OverworldEventChance = 0;
		public double NetherEventTimer = 0;
		public double NetherEventChance = 0;
		public double event_duration = 0;
		public double event_mintime = 0;
		public double event_maxtime = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			unlocked_earth = nbt.getBoolean("unlocked_earth");
			unlocked_water = nbt.getBoolean("unlocked_water");
			unlocked_air = nbt.getBoolean("unlocked_air");
			unlocked_fire = nbt.getBoolean("unlocked_fire");
			unlocked_void = nbt.getBoolean("unlocked_void");
			config_abyss_quartz = nbt.getBoolean("config_abyss_quartz");
			config_vases = nbt.getBoolean("config_vases");
			config_spider_eggs = nbt.getBoolean("config_spider_eggs");
			config_giant_spiders = nbt.getBoolean("config_giant_spiders");
			config_spiderlings = nbt.getBoolean("config_spiderlings");
			config_generic_dungeons = nbt.getBoolean("config_generic_dungeons");
			config_geodes = nbt.getBoolean("config_geodes");
			config_goblin_camps = nbt.getBoolean("config_goblin_camps");
			config_sorrow_spire = nbt.getBoolean("config_sorrow_spire");
			config_spider_catacombs = nbt.getBoolean("config_spider_catacombs");
			config_elementals = nbt.getBoolean("config_elementals");
			config_demons = nbt.getBoolean("config_demons");
			config_scallops = nbt.getBoolean("config_scallops");
			config_geodrill_time = nbt.getDouble("config_geodrill_time");
			config_goblinspawner_time = nbt.getDouble("config_goblinspawner_time");
			config_geodes_drop = nbt.getBoolean("config_geodes_drop");
			config_coins_drop = nbt.getBoolean("config_coins_drop");
			config_goblin_patrols = nbt.getBoolean("config_goblin_patrols");
			config_demon_hive = nbt.getBoolean("config_demon_hive");
			config_skies_of_ruin = nbt.getBoolean("config_skies_of_ruin");
			config_skies_of_ruin_repeatable = nbt.getBoolean("config_skies_of_ruin_repeatable");
			config_events = nbt.getBoolean("config_events");
			config_event_rate = nbt.getDouble("config_event_rate");
			OverworldEvent = nbt.getString("OverworldEvent");
			NetherEvent = nbt.getString("NetherEvent");
			OverworldEventTimer = nbt.getDouble("OverworldEventTimer");
			OverworldEventChance = nbt.getDouble("OverworldEventChance");
			NetherEventTimer = nbt.getDouble("NetherEventTimer");
			NetherEventChance = nbt.getDouble("NetherEventChance");
			event_duration = nbt.getDouble("event_duration");
			event_mintime = nbt.getDouble("event_mintime");
			event_maxtime = nbt.getDouble("event_maxtime");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("unlocked_earth", unlocked_earth);
			nbt.putBoolean("unlocked_water", unlocked_water);
			nbt.putBoolean("unlocked_air", unlocked_air);
			nbt.putBoolean("unlocked_fire", unlocked_fire);
			nbt.putBoolean("unlocked_void", unlocked_void);
			nbt.putBoolean("config_abyss_quartz", config_abyss_quartz);
			nbt.putBoolean("config_vases", config_vases);
			nbt.putBoolean("config_spider_eggs", config_spider_eggs);
			nbt.putBoolean("config_giant_spiders", config_giant_spiders);
			nbt.putBoolean("config_spiderlings", config_spiderlings);
			nbt.putBoolean("config_generic_dungeons", config_generic_dungeons);
			nbt.putBoolean("config_geodes", config_geodes);
			nbt.putBoolean("config_goblin_camps", config_goblin_camps);
			nbt.putBoolean("config_sorrow_spire", config_sorrow_spire);
			nbt.putBoolean("config_spider_catacombs", config_spider_catacombs);
			nbt.putBoolean("config_elementals", config_elementals);
			nbt.putBoolean("config_demons", config_demons);
			nbt.putBoolean("config_scallops", config_scallops);
			nbt.putDouble("config_geodrill_time", config_geodrill_time);
			nbt.putDouble("config_goblinspawner_time", config_goblinspawner_time);
			nbt.putBoolean("config_geodes_drop", config_geodes_drop);
			nbt.putBoolean("config_coins_drop", config_coins_drop);
			nbt.putBoolean("config_goblin_patrols", config_goblin_patrols);
			nbt.putBoolean("config_demon_hive", config_demon_hive);
			nbt.putBoolean("config_skies_of_ruin", config_skies_of_ruin);
			nbt.putBoolean("config_skies_of_ruin_repeatable", config_skies_of_ruin_repeatable);
			nbt.putBoolean("config_events", config_events);
			nbt.putDouble("config_event_rate", config_event_rate);
			nbt.putString("OverworldEvent", OverworldEvent);
			nbt.putString("NetherEvent", NetherEvent);
			nbt.putDouble("OverworldEventTimer", OverworldEventTimer);
			nbt.putDouble("OverworldEventChance", OverworldEventChance);
			nbt.putDouble("NetherEventTimer", NetherEventTimer);
			nbt.putDouble("NetherEventChance", NetherEventChance);
			nbt.putDouble("event_duration", event_duration);
			nbt.putDouble("event_mintime", event_mintime);
			nbt.putDouble("event_maxtime", event_maxtime);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				IterRpgMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("iter_rpg", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean MageStatus = false;
		public double ItemManaCapacity = 0;
		public double MagicCooldown = 0;
		public double ManabarStyle = 0;
		public double ElementalArmorCooldown = 0;
		public double MeleeAttackCooldown = 0;
		public boolean SetBonusToggle = true;
		public double ElementalArmorPassiveCooldown = 0;
		public double SelectedSpell = 1.0;
		public ItemStack SpellItem = ItemStack.EMPTY;
		public double SpellbookSlot = 0;
		public double AetherExhaustion = 0;
		public double AetherExhaustionThreshold = 0;
		public double AetherExhaustionDissipation = 0;
		public double LastDamageDealt = 0;
		public double LastDamageRecieved = 0;
		public double Mana = 0;
		public double MaxMana = 0;
		public boolean tradepage = false;
		public double earth_lure = 0;
		public double water_lure = 0.0;
		public double air_lure = 0;
		public double fire_lure = 0;
		public double void_lure = 0;
		public double DropLuck = 0;
		public boolean ManaOverlay = false;
		public double PlayerCoinAmount = 0;
		public boolean demon_friendly = false;
		public boolean spellbook = false;
		public double spellbookslot = 0;
		public String CurrentlyTrading = "\"\"";
		public double price1 = 0;
		public double price2 = 0;
		public double price3 = 0;
		public double price4 = 0;
		public double price5 = 0;
		public double flaps_left = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				IterRpgMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("MageStatus", MageStatus);
			nbt.putDouble("ItemManaCapacity", ItemManaCapacity);
			nbt.putDouble("MagicCooldown", MagicCooldown);
			nbt.putDouble("ManabarStyle", ManabarStyle);
			nbt.putDouble("ElementalArmorCooldown", ElementalArmorCooldown);
			nbt.putDouble("MeleeAttackCooldown", MeleeAttackCooldown);
			nbt.putBoolean("SetBonusToggle", SetBonusToggle);
			nbt.putDouble("ElementalArmorPassiveCooldown", ElementalArmorPassiveCooldown);
			nbt.putDouble("SelectedSpell", SelectedSpell);
			nbt.put("SpellItem", SpellItem.save(new CompoundTag()));
			nbt.putDouble("SpellbookSlot", SpellbookSlot);
			nbt.putDouble("AetherExhaustion", AetherExhaustion);
			nbt.putDouble("AetherExhaustionThreshold", AetherExhaustionThreshold);
			nbt.putDouble("AetherExhaustionDissipation", AetherExhaustionDissipation);
			nbt.putDouble("LastDamageDealt", LastDamageDealt);
			nbt.putDouble("LastDamageRecieved", LastDamageRecieved);
			nbt.putDouble("Mana", Mana);
			nbt.putDouble("MaxMana", MaxMana);
			nbt.putBoolean("tradepage", tradepage);
			nbt.putDouble("earth_lure", earth_lure);
			nbt.putDouble("water_lure", water_lure);
			nbt.putDouble("air_lure", air_lure);
			nbt.putDouble("fire_lure", fire_lure);
			nbt.putDouble("void_lure", void_lure);
			nbt.putDouble("DropLuck", DropLuck);
			nbt.putBoolean("ManaOverlay", ManaOverlay);
			nbt.putDouble("PlayerCoinAmount", PlayerCoinAmount);
			nbt.putBoolean("demon_friendly", demon_friendly);
			nbt.putBoolean("spellbook", spellbook);
			nbt.putDouble("spellbookslot", spellbookslot);
			nbt.putString("CurrentlyTrading", CurrentlyTrading);
			nbt.putDouble("price1", price1);
			nbt.putDouble("price2", price2);
			nbt.putDouble("price3", price3);
			nbt.putDouble("price4", price4);
			nbt.putDouble("price5", price5);
			nbt.putDouble("flaps_left", flaps_left);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			MageStatus = nbt.getBoolean("MageStatus");
			ItemManaCapacity = nbt.getDouble("ItemManaCapacity");
			MagicCooldown = nbt.getDouble("MagicCooldown");
			ManabarStyle = nbt.getDouble("ManabarStyle");
			ElementalArmorCooldown = nbt.getDouble("ElementalArmorCooldown");
			MeleeAttackCooldown = nbt.getDouble("MeleeAttackCooldown");
			SetBonusToggle = nbt.getBoolean("SetBonusToggle");
			ElementalArmorPassiveCooldown = nbt.getDouble("ElementalArmorPassiveCooldown");
			SelectedSpell = nbt.getDouble("SelectedSpell");
			SpellItem = ItemStack.of(nbt.getCompound("SpellItem"));
			SpellbookSlot = nbt.getDouble("SpellbookSlot");
			AetherExhaustion = nbt.getDouble("AetherExhaustion");
			AetherExhaustionThreshold = nbt.getDouble("AetherExhaustionThreshold");
			AetherExhaustionDissipation = nbt.getDouble("AetherExhaustionDissipation");
			LastDamageDealt = nbt.getDouble("LastDamageDealt");
			LastDamageRecieved = nbt.getDouble("LastDamageRecieved");
			Mana = nbt.getDouble("Mana");
			MaxMana = nbt.getDouble("MaxMana");
			tradepage = nbt.getBoolean("tradepage");
			earth_lure = nbt.getDouble("earth_lure");
			water_lure = nbt.getDouble("water_lure");
			air_lure = nbt.getDouble("air_lure");
			fire_lure = nbt.getDouble("fire_lure");
			void_lure = nbt.getDouble("void_lure");
			DropLuck = nbt.getDouble("DropLuck");
			ManaOverlay = nbt.getBoolean("ManaOverlay");
			PlayerCoinAmount = nbt.getDouble("PlayerCoinAmount");
			demon_friendly = nbt.getBoolean("demon_friendly");
			spellbook = nbt.getBoolean("spellbook");
			spellbookslot = nbt.getDouble("spellbookslot");
			CurrentlyTrading = nbt.getString("CurrentlyTrading");
			price1 = nbt.getDouble("price1");
			price2 = nbt.getDouble("price2");
			price3 = nbt.getDouble("price3");
			price4 = nbt.getDouble("price4");
			price5 = nbt.getDouble("price5");
			flaps_left = nbt.getDouble("flaps_left");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.MageStatus = message.data.MageStatus;
					variables.ItemManaCapacity = message.data.ItemManaCapacity;
					variables.MagicCooldown = message.data.MagicCooldown;
					variables.ManabarStyle = message.data.ManabarStyle;
					variables.ElementalArmorCooldown = message.data.ElementalArmorCooldown;
					variables.MeleeAttackCooldown = message.data.MeleeAttackCooldown;
					variables.SetBonusToggle = message.data.SetBonusToggle;
					variables.ElementalArmorPassiveCooldown = message.data.ElementalArmorPassiveCooldown;
					variables.SelectedSpell = message.data.SelectedSpell;
					variables.SpellItem = message.data.SpellItem;
					variables.SpellbookSlot = message.data.SpellbookSlot;
					variables.AetherExhaustion = message.data.AetherExhaustion;
					variables.AetherExhaustionThreshold = message.data.AetherExhaustionThreshold;
					variables.AetherExhaustionDissipation = message.data.AetherExhaustionDissipation;
					variables.LastDamageDealt = message.data.LastDamageDealt;
					variables.LastDamageRecieved = message.data.LastDamageRecieved;
					variables.Mana = message.data.Mana;
					variables.MaxMana = message.data.MaxMana;
					variables.tradepage = message.data.tradepage;
					variables.earth_lure = message.data.earth_lure;
					variables.water_lure = message.data.water_lure;
					variables.air_lure = message.data.air_lure;
					variables.fire_lure = message.data.fire_lure;
					variables.void_lure = message.data.void_lure;
					variables.DropLuck = message.data.DropLuck;
					variables.ManaOverlay = message.data.ManaOverlay;
					variables.PlayerCoinAmount = message.data.PlayerCoinAmount;
					variables.demon_friendly = message.data.demon_friendly;
					variables.spellbook = message.data.spellbook;
					variables.spellbookslot = message.data.spellbookslot;
					variables.CurrentlyTrading = message.data.CurrentlyTrading;
					variables.price1 = message.data.price1;
					variables.price2 = message.data.price2;
					variables.price3 = message.data.price3;
					variables.price4 = message.data.price4;
					variables.price5 = message.data.price5;
					variables.flaps_left = message.data.flaps_left;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
