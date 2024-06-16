package net.thirdlife.iterrpg;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.thirdlife.iterrpg.world.features.StructureFeature;
import net.thirdlife.iterrpg.init.IterRpgModTabs;
import net.thirdlife.iterrpg.init.IterRpgModSounds;
import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModMobEffects;
import net.thirdlife.iterrpg.init.IterRpgModMenus;
import net.thirdlife.iterrpg.init.IterRpgModItems;
import net.thirdlife.iterrpg.init.IterRpgModFeatures;
import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.init.IterRpgModEnchantments;
import net.thirdlife.iterrpg.init.IterRpgModBlocks;
import net.thirdlife.iterrpg.init.IterRpgModBlockEntities;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

@Mod("iter_rpg")
public class IterRpgMod {
	public static final Logger LOGGER = LogManager.getLogger(IterRpgMod.class);
	public static final String MODID = "iter_rpg";

	public IterRpgMod() {
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		IterRpgModSounds.REGISTRY.register(bus);
		IterRpgModBlocks.REGISTRY.register(bus);
		IterRpgModBlockEntities.REGISTRY.register(bus);
		IterRpgModItems.REGISTRY.register(bus);
		IterRpgModEntities.REGISTRY.register(bus);
		IterRpgModEnchantments.REGISTRY.register(bus);
		IterRpgModTabs.REGISTRY.register(bus);
		IterRpgModFeatures.REGISTRY.register(bus);
		StructureFeature.REGISTRY.register(bus);
		IterRpgModMobEffects.REGISTRY.register(bus);

		IterRpgModParticleTypes.REGISTRY.register(bus);

		IterRpgModMenus.REGISTRY.register(bus);
		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}
