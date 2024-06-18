package net.thirdlife.iterrpg.client.gui;

import net.thirdlife.iterrpg.common.world.inventory.MobPlacerGUIMenu;
import net.thirdlife.iterrpg.common.procedures.MobPlacerModelProviderProcedure;
import net.thirdlife.iterrpg.common.procedures.MobPlacerCoordinatesReturnProcedure;
import net.thirdlife.iterrpg.common.network.MobPlacerGUIButtonMessage;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MobPlacerGUIScreen extends AbstractContainerScreen<MobPlacerGUIMenu> {
	private final static HashMap<String, Object> guistate = MobPlacerGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_spawn;
	Button button_g;
	Button button_d;
	Button button_s;

	public MobPlacerGUIScreen(MobPlacerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("iter_rpg:textures/screens/mob_placer_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (MobPlacerModelProviderProcedure.execute(world, entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 84, this.topPos + 132, 30, 0f + (float) Math.atan((this.leftPos + 84 - mouseX) / 40.0), (float) Math.atan((this.topPos + 83 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				MobPlacerCoordinatesReturnProcedure.execute(entity), 16, 10, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_spawn = Button.builder(Component.translatable("gui.iter_rpg.mob_placer_gui.button_spawn"), e -> {
			if (true) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new MobPlacerGUIButtonMessage(0, x, y, z));
				MobPlacerGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 61, this.topPos + 139, 51, 20).build();
		guistate.put("button:button_spawn", button_spawn);
		this.addRenderableWidget(button_spawn);
		button_g = Button.builder(Component.translatable("gui.iter_rpg.mob_placer_gui.button_g"), e -> {
			if (true) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new MobPlacerGUIButtonMessage(1, x, y, z));
				MobPlacerGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 29, 30, 20).build();
		guistate.put("button:button_g", button_g);
		this.addRenderableWidget(button_g);
		button_d = Button.builder(Component.translatable("gui.iter_rpg.mob_placer_gui.button_d"), e -> {
			if (true) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new MobPlacerGUIButtonMessage(2, x, y, z));
				MobPlacerGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 127, this.topPos + 29, 30, 20).build();
		guistate.put("button:button_d", button_d);
		this.addRenderableWidget(button_d);
		button_s = Button.builder(Component.translatable("gui.iter_rpg.mob_placer_gui.button_s"), e -> {
			if (true) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new MobPlacerGUIButtonMessage(3, x, y, z));
				MobPlacerGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 69, this.topPos + 29, 30, 20).build();
		guistate.put("button:button_s", button_s);
		this.addRenderableWidget(button_s);
	}
}
