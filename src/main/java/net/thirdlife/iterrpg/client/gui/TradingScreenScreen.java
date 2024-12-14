package net.thirdlife.iterrpg.client.gui;

import net.thirdlife.iterrpg.world.inventory.TradingScreenMenu;
import net.thirdlife.iterrpg.procedures.TradePrice5LabelProcedure;
import net.thirdlife.iterrpg.procedures.TradePrice4LabelProcedure;
import net.thirdlife.iterrpg.procedures.TradePrice3LabelProcedure;
import net.thirdlife.iterrpg.procedures.TradePrice2LabelProcedure;
import net.thirdlife.iterrpg.procedures.TradePrice1LabelProcedure;
import net.thirdlife.iterrpg.procedures.CoinDisplayProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TradingScreenScreen extends AbstractContainerScreen<TradingScreenMenu> {
	private final static HashMap<String, Object> guistate = TradingScreenMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public TradingScreenScreen(TradingScreenMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 181;
	}

	private static final ResourceLocation texture = new ResourceLocation("iter_rpg:textures/screens/trading_screen.png");

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

		guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/small_coin.png"), this.leftPos + 11, this.topPos + 86, 0, 0, 8, 8, 8, 8);

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

				TradePrice1LabelProcedure.execute(entity), 11, 35, -3355444, false);
		guiGraphics.drawString(this.font,

				TradePrice2LabelProcedure.execute(entity), 47, 35, -3355444, false);
		guiGraphics.drawString(this.font,

				TradePrice3LabelProcedure.execute(entity), 83, 35, -3355444, false);
		guiGraphics.drawString(this.font,

				TradePrice4LabelProcedure.execute(entity), 119, 35, -3355444, false);
		guiGraphics.drawString(this.font,

				TradePrice5LabelProcedure.execute(entity), 155, 35, -3355444, false);
		guiGraphics.drawString(this.font,

				CoinDisplayProcedure.execute(entity), 21, 86, -26368, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
