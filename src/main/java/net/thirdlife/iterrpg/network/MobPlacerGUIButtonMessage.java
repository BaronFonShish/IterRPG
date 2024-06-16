
package net.thirdlife.iterrpg.network;

import net.thirdlife.iterrpg.world.inventory.MobPlacerGUIMenu;
import net.thirdlife.iterrpg.procedures.MobPlacerSpawnProcedure;
import net.thirdlife.iterrpg.procedures.MobPlacerGrieverCycleProcedure;
import net.thirdlife.iterrpg.procedures.MobPlacerGoblinCycleProcedure;
import net.thirdlife.iterrpg.procedures.MobPlacerDungeonCycleProcedure;
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
public class MobPlacerGUIButtonMessage {
	private final int buttonID, x, y, z;

	public MobPlacerGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MobPlacerGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MobPlacerGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MobPlacerGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = MobPlacerGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			MobPlacerSpawnProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			MobPlacerGoblinCycleProcedure.execute(entity);
		}
		if (buttonID == 2) {

			MobPlacerDungeonCycleProcedure.execute(entity);
		}
		if (buttonID == 3) {

			MobPlacerGrieverCycleProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		IterRpgMod.addNetworkMessage(MobPlacerGUIButtonMessage.class, MobPlacerGUIButtonMessage::buffer, MobPlacerGUIButtonMessage::new, MobPlacerGUIButtonMessage::handler);
	}
}
