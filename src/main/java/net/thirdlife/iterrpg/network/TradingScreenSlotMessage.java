
package net.thirdlife.iterrpg.network;

import net.thirdlife.iterrpg.world.inventory.TradingScreenMenu;
import net.thirdlife.iterrpg.procedures.Trade5TakeProcedure;
import net.thirdlife.iterrpg.procedures.Trade4TakeProcedure;
import net.thirdlife.iterrpg.procedures.Trade3TakeProcedure;
import net.thirdlife.iterrpg.procedures.Trade2TakeProcedure;
import net.thirdlife.iterrpg.procedures.Trade1TakeProcedure;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TradingScreenSlotMessage {
	private final int slotID, x, y, z, changeType, meta;

	public TradingScreenSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public TradingScreenSlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(TradingScreenSlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(TradingScreenSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int slotID = message.slotID;
			int changeType = message.changeType;
			int meta = message.meta;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleSlotAction(entity, slotID, changeType, meta, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = TradingScreenMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 1) {

			Trade1TakeProcedure.execute(world, entity);
		}
		if (slot == 1 && changeType == 1) {

			Trade2TakeProcedure.execute(world, entity);
		}
		if (slot == 2 && changeType == 1) {

			Trade3TakeProcedure.execute(world, entity);
		}
		if (slot == 3 && changeType == 1) {

			Trade4TakeProcedure.execute(world, entity);
		}
		if (slot == 4 && changeType == 1) {

			Trade5TakeProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		IterRpgMod.addNetworkMessage(TradingScreenSlotMessage.class, TradingScreenSlotMessage::buffer, TradingScreenSlotMessage::new, TradingScreenSlotMessage::handler);
	}
}
