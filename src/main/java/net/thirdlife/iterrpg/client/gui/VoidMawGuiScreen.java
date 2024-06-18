package net.thirdlife.iterrpg.client.gui;

import net.thirdlife.iterrpg.common.world.inventory.VoidMawGuiMenu;
import net.thirdlife.iterrpg.common.procedures.VoidMawNotEnoughProcedure;
import net.thirdlife.iterrpg.common.procedures.VoidMawEnoughConditionProcedure;
import net.thirdlife.iterrpg.common.network.VoidMawGuiButtonMessage;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class VoidMawGuiScreen extends AbstractContainerScreen<VoidMawGuiMenu> {
	private final static HashMap<String, Object> guistate = VoidMawGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_void_maw_button;

	public VoidMawGuiScreen(VoidMawGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("iter_rpg:textures/screens/void_maw_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (VoidMawNotEnoughProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/void_maw_button_deny_1.png"), this.leftPos + 73, this.topPos + 63, 0, 0, 29, 15, 29, 15);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.iter_rpg.void_maw_gui.label_void_maw"), 68, 8, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_void_maw_button = new ImageButton(this.leftPos + 73, this.topPos + 63, 29, 15, 0, 0, 15, new ResourceLocation("iter_rpg:textures/screens/atlas/imagebutton_void_maw_button.png"), 29, 30, e -> {
			if (VoidMawEnoughConditionProcedure.execute(entity)) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new VoidMawGuiButtonMessage(0, x, y, z));
				VoidMawGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (VoidMawEnoughConditionProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_void_maw_button", imagebutton_void_maw_button);
		this.addRenderableWidget(imagebutton_void_maw_button);
	}
}
