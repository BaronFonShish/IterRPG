package net.thirdlife.iterrpg.client.gui;

import net.thirdlife.iterrpg.common.world.inventory.GrimLockerGuiMenu;
import net.thirdlife.iterrpg.common.procedures.GrimLockerArrow4Procedure;
import net.thirdlife.iterrpg.common.procedures.GrimLockerArrow3Procedure;
import net.thirdlife.iterrpg.common.procedures.GrimLockerArrow2Procedure;
import net.thirdlife.iterrpg.common.procedures.GrimLockerArrow1Procedure;
import net.thirdlife.iterrpg.common.procedures.GrimLockerArrow0Procedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GrimLockerGuiScreen extends AbstractContainerScreen<GrimLockerGuiMenu> {
	private final static HashMap<String, Object> guistate = GrimLockerGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GrimLockerGuiScreen(GrimLockerGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 171;
	}

	private static final ResourceLocation texture = new ResourceLocation("iter_rpg:textures/screens/grim_locker_gui.png");

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
		if (GrimLockerArrow0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/grim_locker_arrow0.png"), this.leftPos + 101, this.topPos + 31, 0, 0, 7, 27, 7, 27);
		}
		if (GrimLockerArrow4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/grim_locker_arrow1.png"), this.leftPos + 101, this.topPos + 31, 0, 0, 7, 27, 7, 27);
		}
		if (GrimLockerArrow3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/grim_locker_arrow2.png"), this.leftPos + 101, this.topPos + 31, 0, 0, 7, 27, 7, 27);
		}
		if (GrimLockerArrow2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/grim_locker_arrow3.png"), this.leftPos + 101, this.topPos + 31, 0, 0, 7, 27, 7, 27);
		}
		if (GrimLockerArrow1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/grim_locker_arrow4.png"), this.leftPos + 101, this.topPos + 31, 0, 0, 7, 27, 7, 27);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.iter_rpg.grim_locker_gui.label_grim_locker"), 61, 3, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
