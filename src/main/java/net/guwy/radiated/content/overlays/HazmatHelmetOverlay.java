package net.guwy.radiated.content.overlays;

import com.mojang.blaze3d.systems.RenderSystem;
import net.guwy.radiated.Radiated;
import net.guwy.radiated.index.NTMTags;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class HazmatHelmetOverlay {
    public static final ResourceLocation HELMET_OVERLAY_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/armor/hazmat.png");
    public static final ResourceLocation DAMAGE_0_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/armor/overlay_damage_0.png");
    public static final ResourceLocation DAMAGE_1_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/armor/overlay_damage_1.png");
    public static final ResourceLocation DAMAGE_2_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/armor/overlay_damage_2.png");
    public static final ResourceLocation DAMAGE_3_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/armor/overlay_damage_3.png");
    public static final ResourceLocation DAMAGE_4_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/armor/overlay_damage_4.png");
    public static final ResourceLocation DAMAGE_5_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/armor/overlay_damage_5.png");

    public static final IGuiOverlay HELMET_OVERLAY = (((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
        if(Minecraft.getInstance().options.getCameraType().equals(CameraType.FIRST_PERSON)){
            if(Minecraft.getInstance().player.getItemBySlot(EquipmentSlot.HEAD).is(NTMTags.Items.HAZMAT_HELMETS)){
                Player player = Minecraft.getInstance().player;
                ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

                RenderSystem.enableBlend();
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1, 1, 1, 1);
                //RenderSystem.setShaderTexture(0, HELMET_OVERLAY_TEXTURE);
                //GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);


                double damagePercentage = (double) helmet.getDamageValue() / helmet.getMaxDamage();
                damagePercentage = 1 - damagePercentage;

                if(damagePercentage < 0.1){
                    RenderSystem.setShaderTexture(0, DAMAGE_5_TEXTURE);
                    GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);
                } else if (damagePercentage < 0.3) {
                    RenderSystem.setShaderTexture(0, DAMAGE_4_TEXTURE);
                    GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);
                } else if (damagePercentage < 0.5) {
                    RenderSystem.setShaderTexture(0, DAMAGE_3_TEXTURE);
                    GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);
                } else if (damagePercentage < 0.7) {
                    RenderSystem.setShaderTexture(0, DAMAGE_2_TEXTURE);
                    GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);
                } else if (damagePercentage < 0.9) {
                    RenderSystem.setShaderTexture(0, DAMAGE_1_TEXTURE);
                    GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);
                } else {
                    RenderSystem.setShaderTexture(0, DAMAGE_0_TEXTURE);
                    GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);

                    //Minecraft.getInstance().font.draw(poseStack, "Hello", 100, 100, -12829636);
                }


                RenderSystem.disableBlend();
            }
        }
    }));
}
