package net.guwy.ntm.mechanics.hazard_items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class HazardItemTooltips {

    public static void AsbestosTooltip(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();

        if(itemStack.getItem() instanceof IAsbestosItem asbestosItem){
            double val = asbestosItem.asbestosVal(itemStack);

            if(val != 0){
                Component tooltip;

                tooltip = Component.translatable("tooltip.ntm.hazard.asbestos")
                        .withStyle(ChatFormatting.WHITE);
                event.getToolTip().add(tooltip);
            }
        }
    }

    public static void CoalDustTooltip(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();

        if(itemStack.getItem() instanceof ICoalDustItem coalDustItem){
            double val = coalDustItem.coalDustVal(itemStack);

            if(val != 0){
                Component tooltip;

                tooltip = Component.translatable("tooltip.ntm.hazard.coal_dust")
                        .withStyle(ChatFormatting.DARK_GRAY);
                event.getToolTip().add(tooltip);
            }
        }
    }

    public static void PyrophoricHotTooltip(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();

        if(itemStack.getItem() instanceof IPyrophoricHotItem pyrophoricHotItem){
            boolean val = pyrophoricHotItem.isPyrophoricHot(itemStack);

            if(val){
                Component tooltip;

                tooltip = Component.translatable("tooltip.ntm.hazard.pyrophoric_hot")
                        .withStyle(ChatFormatting.GOLD);
                event.getToolTip().add(tooltip);
            }
        }
    }

    public static void HydroreactiveTooltip(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();

        if(itemStack.getItem() instanceof IHydroreactiveItem hydroreactiveItem){
            boolean val = hydroreactiveItem.isHydroreactive(itemStack);

            if(val){
                Component tooltip;

                tooltip = Component.translatable("tooltip.ntm.hazard.hydroreactive")
                        .withStyle(ChatFormatting.RED);
                event.getToolTip().add(tooltip);
            }
        }
    }

    public static void FlammableExplosiveTooltip(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();

        if(itemStack.getItem() instanceof IFlammableExplosiveItem flammableExplosiveItem){
            boolean val = flammableExplosiveItem.isFlammableExplosive(itemStack);

            if(val){
                Component tooltip;

                tooltip = Component.translatable("tooltip.ntm.hazard.flammable_explosive")
                        .withStyle(ChatFormatting.RED);
                event.getToolTip().add(tooltip);
            }
        }
    }

    public static void BlindingTooltip(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();

        if(itemStack.getItem() instanceof IBlindingItem blindingItem){
            boolean val = blindingItem.isBlinding(itemStack);

            if(val){
                Component tooltip;

                tooltip = Component.translatable("tooltip.ntm.hazard.blinding")
                        .withStyle(ChatFormatting.DARK_AQUA);
                event.getToolTip().add(tooltip);
            }
        }
    }
}
