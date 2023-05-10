package net.guwy.radiated.content.overlays;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.guwy.radiated.Radiated;
import net.guwy.radiated.mechanics.gasmask.IVisorItem;
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

    public static final ResourceLocation MUD_0_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/mud/0.png");
    public static final ResourceLocation MUD_1_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/mud/1.png");
    public static final ResourceLocation MUD_2_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/mud/2.png");
    public static final ResourceLocation MUD_3_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/mud/3.png");
    public static final ResourceLocation MUD_4_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/mud/4.png");

    public static final ResourceLocation DIRT_0_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/dirt/0.png");
    public static final ResourceLocation DIRT_1_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/dirt/1.png");
    public static final ResourceLocation DIRT_2_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/dirt/2.png");
    public static final ResourceLocation DIRT_3_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/dirt/3.png");
    public static final ResourceLocation DIRT_4_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/dirt/4.png");

    public static final ResourceLocation WATER_BASE_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/water/base.png");
    public static final ResourceLocation WATER_DROPLETS_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/visor/water/droplets_animated.png");



    public static final IGuiOverlay OUTER_GUNK_OVERLAY = (((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
        if(Minecraft.getInstance().options.getCameraType().equals(CameraType.FIRST_PERSON)){
            Player player = Minecraft.getInstance().player;
            ItemStack itemStack = player.getItemBySlot(EquipmentSlot.HEAD);
            if(itemStack.getItem() instanceof IVisorItem){
                RenderSystem.enableBlend();
                RenderSystem.setShader(GameRenderer::getPositionTexShader);


                //Soot Overlay
                GeneralRender(poseStack, screenWidth, screenHeight, IVisorItem.getOuterSoot(itemStack),
                        SOOT_0_TEXTURE, SOOT_1_TEXTURE, SOOT_2_TEXTURE, SOOT_3_TEXTURE, SOOT_4_TEXTURE);

                //Sand Overlay
                GeneralRender(poseStack, screenWidth, screenHeight, IVisorItem.getOuterSand(itemStack),
                        SAND_0_TEXTURE, SAND_1_TEXTURE, SAND_2_TEXTURE, SAND_3_TEXTURE, SAND_4_TEXTURE);

                //Mud Overlay
                GeneralRender(poseStack, screenWidth, screenHeight, IVisorItem.getOuterMud(itemStack),
                        MUD_0_TEXTURE, MUD_1_TEXTURE, MUD_2_TEXTURE, MUD_3_TEXTURE, MUD_4_TEXTURE);

                //Dirt Overlay
                GeneralRender(poseStack, screenWidth, screenHeight, IVisorItem.getOuterDirt(itemStack),
                        DIRT_0_TEXTURE, DIRT_1_TEXTURE, DIRT_2_TEXTURE, DIRT_3_TEXTURE, DIRT_4_TEXTURE);

                //Water Overlay
                if(!player.isUnderWater()) {
                    WaterRender(poseStack, screenWidth, screenHeight, IVisorItem.getOuterWater(itemStack),
                            WATER_BASE_TEXTURE, WATER_DROPLETS_TEXTURE);
                }


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



    private static void WaterRender(PoseStack poseStack, int screenWidth, int screenHeight, double valForCompare,
                                    ResourceLocation baseImage, ResourceLocation dropletImage){
        double alpha, startPercentage, endPercentage;

        //Render Base Static Image
        startPercentage = 0;    // The % which the image starts rendering
        endPercentage = 0.5;    // The % which the image reaches max alpha
        alpha = map(valForCompare, startPercentage, endPercentage, 0, 1);   // Maps %start-1 to 0-1
        alpha = Math.min(1, alpha);                                                          // caps the alpha to fix overshoots
        RenderSystem.setShaderColor(1F, 1F, 1F, (float) alpha);            // Set's color and transparency
        RenderSystem.setShaderTexture(0, baseImage);                                    // Select texture
        GuiComponent.blit(poseStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight); // Render by stretching to the screen

        //Render Animated Image
        startPercentage = 0.2;
        endPercentage = 1;
        int animationStep = Minecraft.getInstance().player.tickCount % 50 / 5;              // Used For offsetting the texture (use "this * -1")
        alpha = map(valForCompare, startPercentage, endPercentage, 0, 1);
        alpha = Math.min(1, alpha);
        RenderSystem.setShaderColor(1F, 1F, 1F, (float) alpha);
        RenderSystem.setShaderTexture(0, dropletImage);
        // A crappy way of rendering, the image is stretched beyond the screen and offset is used to bring the desired image on screen
        GuiComponent.blit(poseStack, 0, 0, 0, 36 * -animationStep, screenWidth, screenHeight, screenWidth, screenHeight*9);
    }


}
