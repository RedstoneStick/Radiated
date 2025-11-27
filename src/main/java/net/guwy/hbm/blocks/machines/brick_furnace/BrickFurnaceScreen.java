package net.guwy.hbm.blocks.machines.brick_furnace;

import net.guwy.hbm.NTMMain;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class BrickFurnaceScreen extends AbstractContainerScreen<BrickFurnaceMenu> {
    private final ResourceLocation BACKGROUND_TEXTURE = ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "textures/gui/container/brick_furnace.png");
    private final ResourceLocation LIT_PROGRESS_SPRITE = ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "container/brick_furnace/lit_progress");
    private final ResourceLocation BURN_PROGRESS_SPRITE = ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "container/brick_furnace/burn_progress");
    private final ResourceLocation FUEL_OUTLINE_SPRITE = ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "container/brick_furnace/fuel_outline");

    public BrickFurnaceScreen(BrickFurnaceMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();

        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderLabels(guiGraphics, mouseX, mouseY);

        int color = FastColor.ARGB32.color(255, 255, 255);
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, color, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, color, false);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        guiGraphics.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        int i = this.leftPos;
        int j = this.topPos;
        if (this.menu.isLit()) {
            int k = 14;
            int l = Mth.ceil(this.menu.getLitProgress() * 13.0F) + 1;
            guiGraphics.blitSprite(LIT_PROGRESS_SPRITE, 14, 14, 0, 14 - l, i + 62, j + 54 + k - l, k, l);
        }
        int i1 = 24;
        int j1 = Mth.ceil(this.menu.getBurnProgress() * 24.0F);
        guiGraphics.blitSprite(BURN_PROGRESS_SPRITE, 24, 16, 0, 0, i + 85, j + 35, j1, 16);

        if (this.menu.getItems().get(BrickFurnaceMenu.FUEL_SLOT).isEmpty()) {
            guiGraphics.blitSprite(FUEL_OUTLINE_SPRITE, 16, 16, 0,0, i + 35, j + 17, 16, 16);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        // Smelting bonus tooltip
        if (isMouseWithinArea(mouseX, mouseY, 62, 35, 78, 51) && this.menu.getCarried().isEmpty() && this.menu.getItems().get(BrickFurnaceMenu.INGREDIENT_SLOT).isEmpty()) {
            guiGraphics.renderTooltip(this.font, List.of(
                    Component.translatable("screen.hbm.brick_furnace.speed_tooltip.1").withStyle(ChatFormatting.GOLD),
                    Component.translatable("screen.hbm.brick_furnace.speed_tooltip.2").withStyle(ChatFormatting.GRAY),
                    Component.translatable("screen.hbm.brick_furnace.speed_tooltip.3").withStyle(ChatFormatting.GRAY),
                    Component.translatable("screen.hbm.brick_furnace.speed_tooltip.4").withStyle(ChatFormatting.GRAY),
                    Component.translatable("screen.hbm.brick_furnace.speed_tooltip.5").withStyle(ChatFormatting.GRAY),
                    Component.translatable("screen.hbm.brick_furnace.speed_tooltip.6").withStyle(ChatFormatting.GRAY)
            ), Optional.empty(), mouseX, mouseY);
        }

        // Ash slot tooltip
        if (isMouseWithinArea(mouseX, mouseY, 35, 53, 51, 69) && this.menu.getCarried().isEmpty() && this.menu.getItems().get(BrickFurnaceMenu.ASH_SLOT).isEmpty()) {
            guiGraphics.renderTooltip(this.font, List.of(
                    Component.translatable("screen.hbm.brick_furnace.ash_slot_tooltip.1").withStyle(ChatFormatting.GOLD),
                    Component.translatable("screen.hbm.brick_furnace.ash_slot_tooltip.2").withStyle(ChatFormatting.GRAY)
            ), Optional.empty(), mouseX, mouseY);
        }

        // Item Tooltips
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    private boolean isMouseWithinArea(int mouseX, int mouseY, int xMin, int yMin, int xMax, int yMax) {
        return this.leftPos + xMin < mouseX && mouseX < this.leftPos + xMax &&
                this.topPos + yMin < mouseY && mouseY < this.topPos + yMax;
    }
}
