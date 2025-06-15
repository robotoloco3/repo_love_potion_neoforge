package com.roland.repolovepotion.effects;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.tslat.effectslib.api.EffectOverlayRenderer;

public class LoveOverlayRenderer implements EffectOverlayRenderer {
    private static final ResourceLocation OVERLAY = new ResourceLocation("yourmodid", "textures/gui/love_overlay.png");

    @Override
    public void renderOverlay(MobEffectInstance effectInstance, PoseStack poseStack, float partialTick) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen != null) return; // skip GUI screens

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);

        // Dynamic alpha by amplifier
        float amp = effectInstance.getAmplifier();
        float alpha = 0.2f + 0.1f * amp;
        RenderSystem.setShaderColor(1.0f, 0.6f, 0.8f, alpha);

        mc.getTextureManager().bindForSetup(OVERLAY);

        int w = mc.getWindow().getGuiScaledWidth();
        int h = mc.getWindow().getGuiScaledHeight();
        GuiComponent.blit(poseStack, 0, 0, 0f, 0f, w, h, 256, 256);

        RenderSystem.disableBlend();
    }
}