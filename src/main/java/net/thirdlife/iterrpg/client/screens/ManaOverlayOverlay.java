
package net.thirdlife.iterrpg.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.thirdlife.iterrpg.common.procedures.ReturnSpellNumberProcedure;
import net.thirdlife.iterrpg.common.procedures.ManaReturnProcedure;
import net.thirdlife.iterrpg.common.procedures.ManaCell9DisplayProcedure;
import net.thirdlife.iterrpg.common.procedures.ManaCell8DisplayProcedure;
import net.thirdlife.iterrpg.common.procedures.ManaCell7DisplayProcedure;
import net.thirdlife.iterrpg.common.procedures.ManaCell6DisplayProcedure;
import net.thirdlife.iterrpg.common.procedures.ManaCell5DisplayProcedure;
import net.thirdlife.iterrpg.common.procedures.ManaCell4DisplayProcedure;
import net.thirdlife.iterrpg.common.procedures.ManaCell3DisplayProcedure;
import net.thirdlife.iterrpg.common.procedures.ManaCell2DisplayProcedure;
import net.thirdlife.iterrpg.common.procedures.ManaCell1DisplayProcedure;
import net.thirdlife.iterrpg.common.procedures.ManaCell10DisplayProcedure;
import net.thirdlife.iterrpg.common.procedures.MageStatusReturnProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ManaOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (MageStatusReturnProcedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("iter_rpg:textures/screens/manabar_horizontal_10.png"), 6, h / 2 + -102, 0, 0, 83, 7, 83, 7);

			if (ManaCell1DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("iter_rpg:textures/screens/manacell_full.png"), 6, h / 2 + -102, 0, 0, 11, 7, 11, 7);
			}
			if (ManaCell2DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("iter_rpg:textures/screens/manacell_full.png"), 14, h / 2 + -102, 0, 0, 11, 7, 11, 7);
			}
			if (ManaCell3DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("iter_rpg:textures/screens/manacell_full.png"), 22, h / 2 + -102, 0, 0, 11, 7, 11, 7);
			}
			if (ManaCell4DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("iter_rpg:textures/screens/manacell_full.png"), 30, h / 2 + -102, 0, 0, 11, 7, 11, 7);
			}
			if (ManaCell5DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("iter_rpg:textures/screens/manacell_full.png"), 38, h / 2 + -102, 0, 0, 11, 7, 11, 7);
			}
			if (ManaCell6DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("iter_rpg:textures/screens/manacell_full.png"), 46, h / 2 + -102, 0, 0, 11, 7, 11, 7);
			}
			if (ManaCell7DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("iter_rpg:textures/screens/manacell_full.png"), 54, h / 2 + -102, 0, 0, 11, 7, 11, 7);
			}
			if (ManaCell8DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("iter_rpg:textures/screens/manacell_full.png"), 62, h / 2 + -102, 0, 0, 11, 7, 11, 7);
			}
			if (ManaCell9DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("iter_rpg:textures/screens/manacell_full.png"), 70, h / 2 + -102, 0, 0, 11, 7, 11, 7);
			}
			if (ManaCell10DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("iter_rpg:textures/screens/manacell_full.png"), 78, h / 2 + -102, 0, 0, 11, 7, 11, 7);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnSpellNumberProcedure.execute(entity), 6, h / 2 + -115, -3381505, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ManaReturnProcedure.execute(entity), 17, h / 2 + -92, -16750900, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
