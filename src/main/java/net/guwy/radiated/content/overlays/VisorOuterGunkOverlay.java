package net.guwy.radiated.content.overlays;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.guwy.radiated.Radiated;
import net.guwy.radiated.index.ModTags;
import net.guwy.radiated.mechanics.gasmask.VisorItem;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import static net.minecraft.util.Mth.map;

public class VisorOuterGunkOverlay {
    public static final ResourceLocation SOOT_0_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/soot/0.png");
    public static final ResourceLocation SOOT_1_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/soot/1.png");
    public static final ResourceLocation SOOT_2_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/soot/2.png");
    public static final ResourceLocation SOOT_3_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/soot/3.png");
    public static final ResourceLocation SOOT_4_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/soot/4.png");

    public static final ResourceLocation SAND_0_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/sand/0.png");
    public static final ResourceLocation SAND_1_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/sand/1.png");
    public static final ResourceLocation SAND_2_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/sand/2.png");
    public static final ResourceLocation SAND_3_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/sand/3.png");
    public static final ResourceLocation SAND_4_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/sand/4.png");



    public static final IGuiOverlay OUTER_GUNK_OVERLAY = (((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
        if(Minecraft.getInstance().options.getCameraType().equals(CameraType.FIRST_PERSON)){
            Player player = Minecraft.getInstance().player;
            ItemStack itemStack = player.getItemBySlot(EquipmentSlot.HEAD);
            if(itemStack.getItem() instanceof VisorItem){
                RenderSystem.enableBlend();
                RenderSystem.setShader(GameRenderer::getPositionTexShader);


                //Soot Overlay
                GeneralRender(poseStack, screenWidth, screenHeight, VisorItem.getOuterSoot(itemStack),
                        SOOT_0_TEXTURE, SOOT_1_TEXTURE, SOOT_2_TEXTURE, SOOT_3_TEXTURE, SOOT_4_TEXTURE);

                //Sand Overlay
                GeneralRender(poseStack, screenWidth, screenHeight, VisorItem.getOuterSand(itemStack),
                        SAND_0_TEXTURE, SAND_1_TEXTURE, SAND_2_TEXTURE, SAND_3_TEXTURE, SAND_4_TEXTURE);


                RenderSystem.disableBlend();
            }
        }
    }));



    private static void GeneralRender(PoseStack poseStack, int screenWidth, int screenHeight, double valForCompare,
                                      ResourceLocation p0, ResourceLocation p1, ResourceLocation p2, ResourceLocation p3, ResourceLocation p4){
        double alpha, startPercentage, endPercentage;

        //Render image 1
        startPercentage = 0;    // The % which the image starts rendering
        endPercentage = 0.2;    // The % which the image reaches max alpha
        alpha = map(valForCompare, startPercentage, endPercentage, 0, 1);   // Maps %start-1 to 0-1
        alpha = Math.min(1, alpha);                                                          // caps the alpha to fix overshoots
        RenderSystem.setShaderColor(1F, 1F, 1F, (float) alpha);            // Set's color and transparency
        RenderSystem.setShaderTexture(0, p0);                                    // Select texture
        GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight); // Render by stretching to the screen

        //Render image 2
        startPercentage = 0.2;
        endPercentage = 0.4;
        alpha = map(valForCompare, startPercentage, endPercentage, 0, 1);
        alpha = Math.min(1, alpha);
        RenderSystem.setShaderColor(1F, 1F, 1F, (float) alpha);
        RenderSystem.setShaderTexture(0, p1);
        GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);

        //Render image 3
        startPercentage = 0.4;
        endPercentage = 0.6;
        alpha = map(valForCompare, startPercentage, endPercentage, 0, 1);
        alpha = Math.min(1, alpha);
        RenderSystem.setShaderColor(1F, 1F, 1F, (float) alpha);
        RenderSystem.setShaderTexture(0, p2);
        GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);

        //Render image 4
        startPercentage = 0.6;
        endPercentage = 0.8;
        alpha = map(valForCompare, startPercentage, endPercentage, 0, 1);
        alpha = Math.min(1, alpha);
        RenderSystem.setShaderColor(1F, 1F, 1F, (float) alpha);
        RenderSystem.setShaderTexture(0, p3);
        GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);

        //Render image 5
        startPercentage = 0.8;
        endPercentage = 1;
        alpha = map(valForCompare, startPercentage, endPercentage, 0, 1);
        alpha = Math.min(1, alpha);
        RenderSystem.setShaderColor(1F, 1F, 1F, (float) alpha);
        RenderSystem.setShaderTexture(0, p4);
        GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);
    }


}
