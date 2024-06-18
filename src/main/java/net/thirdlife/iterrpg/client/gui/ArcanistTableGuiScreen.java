package net.thirdlife.iterrpg.client.gui;

import net.thirdlife.iterrpg.common.world.inventory.ArcanistTableGuiMenu;
import net.thirdlife.iterrpg.common.procedures.SpellUpgradeConditionProcedure;
import net.thirdlife.iterrpg.common.procedures.SpellLapisConditionProcedure;
import net.thirdlife.iterrpg.common.procedures.SpellEyeConditionProcedure;
import net.thirdlife.iterrpg.common.procedures.SpellEssenceConditionProcedure;
import net.thirdlife.iterrpg.common.procedures.SpellDiamondConditionProcedure;
import net.thirdlife.iterrpg.common.procedures.SpellCopyConditionProcedure;
import net.thirdlife.iterrpg.common.procedures.Scroll1ConditionProcedure;
import net.thirdlife.iterrpg.common.procedures.PaperinkConditionProcedure;
import net.thirdlife.iterrpg.common.procedures.ArcanistTableButtonConditionReverseProcedure;
import net.thirdlife.iterrpg.common.procedures.ArcanistTableButtonConditionProcedure;
import net.thirdlife.iterrpg.common.network.ArcanistTableGuiButtonMessage;
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

public class ArcanistTableGuiScreen extends AbstractContainerScreen<ArcanistTableGuiMenu> {
	private final static HashMap<String, Object> guistate = ArcanistTableGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_arcanist_table_button;

	public ArcanistTableGuiScreen(ArcanistTableGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("iter_rpg:textures/screens/arcanist_table_gui.png");

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
		if (Scroll1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/scroll_icon.png"), this.leftPos + 25, this.topPos + 44, 0, 0, 16, 16, 16, 16);
		}
		if (PaperinkConditionProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/paper_ink.png"), this.leftPos + 61, this.topPos + 44, 0, 0, 33, 16, 33, 16);
		}
		if (SpellCopyConditionProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/spell_copy.png"), this.leftPos + 60, this.topPos + 43, 0, 0, 54, 18, 54, 18);
		}
		if (SpellUpgradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/spell_upgrade_base.png"), this.leftPos + 60, this.topPos + 43, 0, 0, 54, 18, 54, 18);
		}
		if (SpellLapisConditionProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/spell_upgrade_lapis.png"), this.leftPos + 60, this.topPos + 43, 0, 0, 54, 18, 54, 18);
		}
		if (SpellDiamondConditionProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/spell_upgrade_diamond.png"), this.leftPos + 60, this.topPos + 43, 0, 0, 54, 18, 54, 18);
		}
		if (SpellEyeConditionProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/spell_upgrade_eye.png"), this.leftPos + 60, this.topPos + 43, 0, 0, 54, 18, 54, 18);
		}
		if (SpellEssenceConditionProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/spell_upgrade_essence.png"), this.leftPos + 60, this.topPos + 43, 0, 0, 54, 18, 54, 18);
		}
		if (ArcanistTableButtonConditionReverseProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("iter_rpg:textures/screens/arcanist_table_button_deny.png"), this.leftPos + 77, this.topPos + 64, 0, 0, 20, 15, 20, 15);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.iter_rpg.arcanist_table_gui.label_arcanists_table"), 42, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arcanist_table_button = new ImageButton(this.leftPos + 77, this.topPos + 64, 20, 15, 0, 0, 15, new ResourceLocation("iter_rpg:textures/screens/atlas/imagebutton_arcanist_table_button.png"), 20, 30, e -> {
			if (ArcanistTableButtonConditionProcedure.execute(entity)) {
				IterRpgMod.PACKET_HANDLER.sendToServer(new ArcanistTableGuiButtonMessage(0, x, y, z));
				ArcanistTableGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ArcanistTableButtonConditionProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_arcanist_table_button", imagebutton_arcanist_table_button);
		this.addRenderableWidget(imagebutton_arcanist_table_button);
	}
}
