package net.thirdlife.iterrpg.client.gui;

import net.thirdlife.iterrpg.common.world.inventory.ElementalArmorModeSwitchGuiMenu;
import net.thirdlife.iterrpg.common.network.ElementalArmorModeSwitchGuiButtonMessage;
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

public class ElementalArmorModeSwitchGuiScreen extends AbstractContainerScreen<ElementalArmorModeSwitchGuiMenu> {
	private final static HashMap<String, Object> guistate = ElementalArmorModeSwitchGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_earth_mode;
	ImageButton imagebutton_water_mode;
	ImageButton imagebutton_air_mode;
	ImageButton imagebutton_fire_mode;
	ImageButton imagebutton_void_mode;

	public ElementalArmorModeSwitchGuiScreen(ElementalArmorModeSwitchGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_earth_mode = new ImageButton(this.leftPos + -48, this.topPos + 1, 16, 16, 0, 0, 16, new ResourceLocation("iter_rpg:textures/screens/atlas/imagebutton_earth_mode.png"), 16, 32, e -> {
			if (true) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new ElementalArmorModeSwitchGuiButtonMessage(0, x, y, z));
				ElementalArmorModeSwitchGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_earth_mode", imagebutton_earth_mode);
		this.addRenderableWidget(imagebutton_earth_mode);
		imagebutton_water_mode = new ImageButton(this.leftPos + 32, this.topPos + 1, 16, 16, 0, 0, 16, new ResourceLocation("iter_rpg:textures/screens/atlas/imagebutton_water_mode.png"), 16, 32, e -> {
			if (true) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new ElementalArmorModeSwitchGuiButtonMessage(1, x, y, z));
				ElementalArmorModeSwitchGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_water_mode", imagebutton_water_mode);
		this.addRenderableWidget(imagebutton_water_mode);
		imagebutton_air_mode = new ImageButton(this.leftPos + 16, this.topPos + -39, 16, 16, 0, 0, 16, new ResourceLocation("iter_rpg:textures/screens/atlas/imagebutton_air_mode.png"), 16, 32, e -> {
			if (true) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new ElementalArmorModeSwitchGuiButtonMessage(2, x, y, z));
				ElementalArmorModeSwitchGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_air_mode", imagebutton_air_mode);
		this.addRenderableWidget(imagebutton_air_mode);
		imagebutton_fire_mode = new ImageButton(this.leftPos + -32, this.topPos + -39, 16, 16, 0, 0, 16, new ResourceLocation("iter_rpg:textures/screens/atlas/imagebutton_fire_mode.png"), 16, 32, e -> {
			if (true) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new ElementalArmorModeSwitchGuiButtonMessage(3, x, y, z));
				ElementalArmorModeSwitchGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_fire_mode", imagebutton_fire_mode);
		this.addRenderableWidget(imagebutton_fire_mode);
		imagebutton_void_mode = new ImageButton(this.leftPos + -8, this.topPos + 33, 16, 16, 0, 0, 16, new ResourceLocation("iter_rpg:textures/screens/atlas/imagebutton_void_mode.png"), 16, 32, e -> {
			if (true) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new ElementalArmorModeSwitchGuiButtonMessage(4, x, y, z));
				ElementalArmorModeSwitchGuiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_void_mode", imagebutton_void_mode);
		this.addRenderableWidget(imagebutton_void_mode);
	}
}
