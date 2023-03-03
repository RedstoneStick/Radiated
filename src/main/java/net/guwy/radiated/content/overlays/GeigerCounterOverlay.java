package net.guwy.radiated.content.overlays;

import com.mojang.blaze3d.systems.RenderSystem;
import net.guwy.radiated.Radiated;
import net.guwy.radiated.index.ModTags;
import net.guwy.radiated.index.RDTTools;
import net.guwy.radiated.mechanics.radiation.EntityRadiation;
import net.guwy.radiated.mechanics.radiation.EntityRadiationProvider;
import net.guwy.radiated.mechanics.radiation.GetRadiationResistance;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.util.function.Predicate;

public class GeigerCounterOverlay {
    public static final ResourceLocation OVERLAY_TEXTURE = new ResourceLocation(Radiated.MOD_ID,
            "textures/overlay/overlay_misc.png");

    public static final IGuiOverlay OVERLAY = (((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
        if(Minecraft.getInstance().player.getInventory().hasAnyMatching(new Predicate<ItemStack>() {
            @Override
            public boolean test(ItemStack itemStack) {
                return itemStack.getItem().equals(RDTTools.GEIGER_COUNTER.get());
            }
        })){
            Player player = Minecraft.getInstance().player;
            int X = screenWidth / 20;
            int Y = screenHeight - 2;
            Inventory inventory = player.getInventory();
            double geigerVal = 0;
            double playerRad = 0;
            for(int i = 0; i < inventory.getContainerSize(); i++){
                ItemStack itemStack = inventory.getItem(i);
                if(itemStack.getItem().equals(RDTTools.GEIGER_COUNTER.get()) && itemStack.getTag() != null){
                    geigerVal = itemStack.getTag().getDouble("geiger_val");
                    geigerVal = geigerVal * (1 - GetRadiationResistance.getVal(player));
                    playerRad = itemStack.getTag().getDouble("player_rad");
                    break;
                }
            }

            RenderSystem.enableBlend();
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1, 1, 1, 1);
            RenderSystem.setShaderTexture(0, OVERLAY_TEXTURE);

            GuiComponent.blit(poseStack, X, Y - 18, 0, 0
                    , 94, 18
                    , 256, 256);

            GuiComponent.blit(poseStack, X, Y - 18, 0, 18
                    , (int) (76 *  (playerRad / EntityRadiation.getMaxPlayerRadiation())), 18
                    , 256, 256);

            if(geigerVal >= 5){
                GuiComponent.blit(poseStack, X + 76, Y - 36, getRadAmountOverlayOffset(geigerVal), 36
                        , 18, 18
                        , 256, 256);
            }

            if(geigerVal > 0){
                Minecraft.getInstance().font.draw(poseStack, getRadSText(geigerVal), X, Y - 26, 0xFFFF531B);
            }

            RenderSystem.disableBlend();
        }
    }));

    private static int getRadAmountOverlayOffset(double geigerVal){
        if(geigerVal >= 25){
            return 36;
        } else if (geigerVal >= 10){
            return 18;
        } else {
            return 0;
        }
    }

    private static String getRadSText(double geigerVal){
        String text;

        if(geigerVal < 1){
            text = "<1";
        } else {
            text = Integer.toString((int) geigerVal);
        }

        text = text + " " + Component.translatable("tooltip.radiated.radiation.rad_s").getString();

        return text;
    }
}
