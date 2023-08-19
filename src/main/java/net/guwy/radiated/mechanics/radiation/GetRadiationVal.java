package net.guwy.radiated.mechanics.radiation;

import com.simibubi.create.AllItems;
import net.guwy.radiated.mechanics.hazard_items.IRadiatedItem;
import net.guwy.sticky_foundations.index.SFTags;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import java.util.concurrent.atomic.AtomicReference;

public class GetRadiationVal {

    /** Gets Radiation of a given item * the amount of item from entered Item Stack **/
    public static double getStackVal(ItemStack itemStack){
        double val = getVal(itemStack) * itemStack.getCount();
        val = val * 1000;
        val = Math.round(val);
        val = val / 1000.0;
        return val;

    }

    /** Gets the radiation of a entered Item Stack, Use getStackVal() if you don't know what you are doing **/
    public static double getVal(ItemStack itemStack){
        Item item = itemStack.getItem();

        //Checks radiation capable item radioactivity
        if(item instanceof IRadiatedItem){
            IRadiatedItem radiatedItem = (IRadiatedItem) item;

            double val = radiatedItem.radiationVal(itemStack);
            val = val * 1000;
            val = Math.round(val);
            val = val / 1000.0;

            return val;
        }



        // Checks tags for radioactivity
        else if (itemStack.is(SFTags.Items.URANIUM_INGOT)) {return 0.35;}
        else if (itemStack.is(SFTags.Items.URANIUM_NUGGET)) {return 0.035;}
        else if (itemStack.is(SFTags.Items.URANIUM_RAW)) {return 0.02;}
        else if (itemStack.is(SFTags.Items.URANIUM_PLATE)) {return 0.35;}
        else if (itemStack.is(SFTags.Items.URANIUM_DUST)) {return 1.05;}
        else if (itemStack.is(SFTags.Items.URANIUM_ORE)) {return 0.015;}
        else if (itemStack.is(SFTags.Items.URANIUM_BLOCK)) {return 3.5;}
        else if (itemStack.is(SFTags.Items.URANIUM_BLOCK_RAW)) {return 0.2;}
        else if (itemStack.is(SFTags.Items.URANIUM_CRUSHED)) {return 1.05;}

        else if (itemStack.is(SFTags.Items.THORIUM_INGOT)) {return 0.1;}
        else if (itemStack.is(SFTags.Items.THORIUM_NUGGET)) {return 0.01;}
        else if (itemStack.is(SFTags.Items.THORIUM_RAW)) {return 0.006;}
        else if (itemStack.is(SFTags.Items.THORIUM_PLATE)) {return 0.1;}
        else if (itemStack.is(SFTags.Items.THORIUM_DUST)) {return 0.3;}
        else if (itemStack.is(SFTags.Items.THORIUM_ORE)) {return 0.004;}
        else if (itemStack.is(SFTags.Items.THORIUM_BLOCK)) {return 1.0;}
        else if (itemStack.is(SFTags.Items.THORIUM_BLOCK_RAW)) {return 0.06;}
        else if (itemStack.is(SFTags.Items.THORIUM_CRUSHED)) {return 0.3;}

        else if (itemStack.getItem().equals(AllItems.CRUSHED_URANIUM.get())) {return 1.05;}



        // Checks if there is any item storage in that item (most mods have their own item inventory, so it mostly only works with shulkerboxes)
        else if (itemStack.getCapability(ForgeCapabilities.ITEM_HANDLER).isPresent()){
            AtomicReference<Double> returnVal = new AtomicReference<>(0.0);

            itemStack.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(inventory -> {
                for(int i = 0; i < inventory.getSlots(); i++){
                    ItemStack itemStack2 = inventory.getStackInSlot(i);

                    if(!itemStack2.getItem().equals(Blocks.AIR.asItem())){
                        returnVal.set(returnVal.get() + GetRadiationVal.getStackVal(itemStack2));
                    }
                }
            });

            return returnVal.get();
        }



        else {
            return 0;
        }
    }



    /** Formats tooltips of radioactive items
     * Handles automatically so don't call this unless necessary **/
    public static void tooltipHandler(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();

        double radiationVal = GetRadiationVal.getVal(itemStack);
        if(radiationVal != 0){
            Component tooltip;

            event.getToolTip().add(Component.translatable("tooltip.radiated.radiation.radioactive").withStyle(ChatFormatting.GREEN));

            tooltip = Component.literal(
                            Double.toString(radiationVal)).append(Component.translatable("tooltip.radiated.radiation.rad_s").getString())
                    .withStyle(ChatFormatting.YELLOW);
            event.getToolTip().add(tooltip);


            int count = itemStack.getCount();
            if(count > 1){
                tooltip = Component.translatable("tooltip.radiated.radiation.stack")
                        .append(Double.toString(GetRadiationVal.getStackVal(itemStack)))
                        .append(Component.translatable("tooltip.radiated.radiation.rad_s").getString())
                        .withStyle(ChatFormatting.YELLOW);
                event.getToolTip().add(tooltip);
            }
        }
    }
}


