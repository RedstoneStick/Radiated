package net.guwy.ntm.content.blocks.machines.rtg;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.guwy.ntm.NTM;
import net.guwy.ntm.utils.EnergyInfoArea;
import net.guwy.ntm.utils.MouseUtil;
import net.guwy.ntm.utils.NumberToTextConverter;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.Optional;

public class RTGScreen extends AbstractContainerScreen<RTGMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(NTM.MOD_ID,"textures/machines/rtg/gui_rtg.png");
    private static final ResourceLocation UTILITY_TEXTURE =
            new ResourceLocation(NTM.MOD_ID,"textures/gui/gui_utility.png");
    private EnergyInfoArea energyInfoArea;

    public RTGScreen(RTGMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        assignEnergyInfoArea();
    }

    private void assignEnergyInfoArea() {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        energyInfoArea = new EnergyInfoArea(x + 156, y + 13, menu.blockEntity.getEnergyStorage(), 8, 64);
    }

    @Override
    protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderEnergyAreaTooltips(pPoseStack, pMouseX, pMouseY, x, y);
        renderHeatAreaTooltips(pPoseStack, pMouseX, pMouseY, x, y);
        renderInfoBoxTooltips(pPoseStack, pMouseX, pMouseY, x, y);
    }

    private void renderEnergyAreaTooltips(PoseStack pPoseStack, int pMouseX, int pMouseY, int x, int y) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 156, 13, 8, 64)) {
            renderTooltip(pPoseStack, energyInfoArea.getTooltips(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }

    private void renderHeatAreaTooltips(PoseStack pPoseStack, int pMouseX, int pMouseY, int x, int y) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 20, 17, 8, 52)) {
            renderTooltip(pPoseStack, HeatTooltip(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }
    private List<Component> HeatTooltip(){
        return List.of(Component.literal(
                menu.getHeatLevel()
                        + " "
                        + Component.translatable("tooltip.ntm.rtg.menu.heat").getString()));
    }

    private void renderInfoBoxTooltips(PoseStack pPoseStack, int pMouseX, int pMouseY, int x, int y) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, -16, 16, 16, 16)) {
            renderTooltip(pPoseStack, InfoBoxTooltip(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }
    private List<Component> InfoBoxTooltip(){
        return List.of(Component.literal(
                Component.translatable("tooltip.ntm.rtg.menu.info_box").getString()
                + NumberToTextConverter.EnergyToText((int) (menu.getHeatLevel() * RTGBlockEntity.ENERGY_MULTIPLIER))
                + " "
                + Component.literal("FE/t").getString()));
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        renderHeatBar(pPoseStack, x, y);
        energyInfoArea.draw(pPoseStack);

        //Draw info box
        RenderSystem.setShaderTexture(0, UTILITY_TEXTURE);
        this.blit(pPoseStack, x-16, y+16, 8, 0, 16, 16);
    }

    private void renderHeatBar(PoseStack pPoseStack, int x, int y) {
        int progress = menu.getScaledProgress();
        blit(pPoseStack, x + 20, y + 17 + (52 - progress), 176, 52 - progress, 8, progress);
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }
}
