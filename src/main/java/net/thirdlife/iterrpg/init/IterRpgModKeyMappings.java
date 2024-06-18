
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import org.lwjgl.glfw.GLFW;

import net.thirdlife.iterrpg.common.network.SpellScrollFMessage;
import net.thirdlife.iterrpg.common.network.SpellScrollBMessage;
import net.thirdlife.iterrpg.common.network.SetBonusToggleKeyMessage;
import net.thirdlife.iterrpg.common.network.JumpKeybindMessage;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class IterRpgModKeyMappings {
	public static final KeyMapping SET_BONUS_TOGGLE_KEY = new KeyMapping("key.iter_rpg.set_bonus_toggle_key", GLFW.GLFW_KEY_V, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new SetBonusToggleKeyMessage(0, 0));
				SetBonusToggleKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SPELL_SCROLL_F = new KeyMapping("key.iter_rpg.spell_scroll_f", GLFW.GLFW_KEY_KP_6, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new SpellScrollFMessage(0, 0));
				SpellScrollFMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SPELL_SCROLL_B = new KeyMapping("key.iter_rpg.spell_scroll_b", GLFW.GLFW_KEY_KP_4, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new SpellScrollBMessage(0, 0));
				SpellScrollBMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping JUMP_KEYBIND = new KeyMapping("key.iter_rpg.jump_keybind", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new JumpKeybindMessage(0, 0));
				JumpKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SET_BONUS_TOGGLE_KEY);
		event.register(SPELL_SCROLL_F);
		event.register(SPELL_SCROLL_B);
		event.register(JUMP_KEYBIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SET_BONUS_TOGGLE_KEY.consumeClick();
				SPELL_SCROLL_F.consumeClick();
				SPELL_SCROLL_B.consumeClick();
				JUMP_KEYBIND.consumeClick();
			}
		}
	}
}
