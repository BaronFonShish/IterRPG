package net.thirdlife.iterrpg.client.gui;

import net.thirdlife.iterrpg.world.inventory.CoinPouchGuiMenu;
import net.thirdlife.iterrpg.procedures.CoinAmountReturnProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CoinPouchGuiScreen extends AbstractContainerScreen<CoinPouchGuiMenu> {
	private final static HashMap<String, Object> guistate = CoinPouchGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CoinPouchGuiScreen(CoinPouchGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 170;
		this.imageHeight = 157;
	}

	private static final ResourceLocation texture = new ResourceLocation("iter_rpg:textures/screens/coin_pouch_gui.png");

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

		guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/coin_pouch_gui_2.png"), this.leftPos + 44, this.topPos + 6, 0, 0, 82, 63, 82, 63);

		guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/small_coin.png"), this.leftPos + 69, this.topPos + 32, 0, 0, 8, 8, 8, 8);

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

				CoinAmountReturnProcedure.execute(entity), 78, 33, -205, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
