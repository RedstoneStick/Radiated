package net.guwy.radiated.mechanics.gasmask;

import net.guwy.radiated.utils.ItemTagUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public interface IVisorItem {



    /** Handling of variables for screen visuals
     * Range: 0.0 - 1.0 **/

    public static String TAG_INNER_GUNK = "inner_gunk";     // Player puking in the helmet
    public static String TAG_INNER_BLOOD = "inner_blood";   // Player's blood splattering inside the helmet

    public static String TAG_OUTER_SAND = "outer_sand";     // Environmental sand/dust accumulation on the helmet
    public static String TAG_OUTER_DIRT = "outer_dirt";     // Environmental dirt accumulation on the helmet
    public static String TAG_OUTER_MUD = "outer_mud";     // Environmental mud accumulation on the helmet
    public static String TAG_OUTER_SOOT = "outer_soot";     // Environmental soot (from coal) accumulation on the helmet
    public static String TAG_OUTER_BLOOD = "outer_blood";   // Blood of the entity that the player damages from close distance
    public static String TAG_OUTER_WATER = "outer_water";   // Water droplets that show up after the player leaves a body of water


    public static void setInnerGunk(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_INNER_GUNK, clamp(modifier));
    }
    public static void addInnerGunk(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_INNER_GUNK, clamp(getInnerGunk(itemStack) + modifier));
    }
    public static double getInnerGunk(ItemStack itemStack){
        return ItemTagUtils.getDouble(itemStack, TAG_INNER_GUNK);
    }

    public static void setInnerBlood(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_INNER_BLOOD, clamp(modifier));
    }
    public static void addInnerBlood(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_INNER_BLOOD, clamp(getInnerBlood(itemStack) + modifier));
    }
    public static double getInnerBlood(ItemStack itemStack){
        return ItemTagUtils.getDouble(itemStack, TAG_INNER_BLOOD);
    }


    public static void setOuterSand(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_SAND, clamp(modifier));
    }
    public static void addOuterSand(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_SAND, clamp(getOuterSand(itemStack) + modifier));
    }
    public static double getOuterSand(ItemStack itemStack){
        return ItemTagUtils.getDouble(itemStack, TAG_OUTER_SAND);
    }

    public static void setOuterDirt(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_DIRT, clamp(modifier));
    }
    public static void addOuterDirt(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_DIRT, clamp(getOuterDirt(itemStack) + modifier));
    }
    public static double getOuterDirt(ItemStack itemStack){
        return ItemTagUtils.getDouble(itemStack, TAG_OUTER_DIRT);
    }

    public static void setOuterMud(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_MUD, clamp(modifier));
    }
    public static void addOuterMud(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_MUD, clamp(getOuterMud(itemStack) + modifier));
    }
    public static double getOuterMud(ItemStack itemStack){
        return ItemTagUtils.getDouble(itemStack, TAG_OUTER_MUD);
    }

    public static void setOuterSoot(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_SOOT, clamp(modifier));
    }
    public static void addOuterSoot(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_SOOT, clamp(getOuterSoot(itemStack) + modifier));
    }
    public static double getOuterSoot(ItemStack itemStack){
        return ItemTagUtils.getDouble(itemStack, TAG_OUTER_SOOT);
    }

    public static void setOuterBlood(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_BLOOD, clamp(modifier));
    }
    public static void addOuterBlood(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_BLOOD, clamp(getOuterBlood(itemStack) + modifier));
    }
    public static double getOuterBlood(ItemStack itemStack){
        return ItemTagUtils.getDouble(itemStack, TAG_OUTER_BLOOD);
    }

    public static void setOuterWater(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_WATER, clamp(modifier));
    }
    public static void addOuterWater(ItemStack itemStack, double modifier){
        ItemTagUtils.putDouble(itemStack, TAG_OUTER_WATER, clamp(getOuterWater(itemStack) + modifier));
    }
    public static double getOuterWater(ItemStack itemStack){
        return ItemTagUtils.getDouble(itemStack, TAG_OUTER_WATER);
    }

    // A function to return the sum of all gunk for easy use in other classes
    public static double getOuterGunkSum(ItemStack itemStack){
        return getOuterSand(itemStack) + getOuterMud(itemStack) + getOuterDirt(itemStack) + getOuterSoot(itemStack);
    }


    // A basic function to clamp the entered number between 1 and 0
    private static double clamp(double val){
        return Math.max(0, Math.min(1, val));
    }


    public static void WipeVisor(Player player){
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
        double CLEANING_PERCENTAGE = 0.2;
        double gunkSum = getOuterGunkSum(helmet);

        if(player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty() ){

            // General Call for animations and alike
            if(getOuterWater(helmet) > 0 || gunkSum > CLEANING_PERCENTAGE){
                //Lazy Animation :D
                player.swing(InteractionHand.MAIN_HAND, true);

                player.getLevel().playSound(null, player, SoundEvents.ARMOR_EQUIP_LEATHER, SoundSource.PLAYERS, 100, 0.8f);
            }
            // Cleans the visor completely if it is wet
            if(getOuterWater(helmet) > 0){
                setOuterSand(helmet, 0);
                setOuterMud(helmet, 0);
                setOuterDirt(helmet, 0);
                setOuterSoot(helmet, 0);
                setOuterWater(helmet, 0);
            }
            // Otherwise cleans it partially
            else if(gunkSum > CLEANING_PERCENTAGE){
                double gunk;

                gunk = getOuterSand(helmet);
                addOuterSand(helmet, -gunk * CLEANING_PERCENTAGE);

                gunk = getOuterMud(helmet);
                addOuterMud(helmet, -gunk * CLEANING_PERCENTAGE);

                gunk = getOuterDirt(helmet);
                addOuterDirt(helmet, -gunk * CLEANING_PERCENTAGE);

                gunk = getOuterSoot(helmet);
                addOuterSoot(helmet, -gunk * CLEANING_PERCENTAGE);

                //Lazy Animation :D
                player.swing(InteractionHand.MAIN_HAND, true);
            }
        }
    }

    static List<Component> VisorGunkTooltip(ItemStack pStack){
        List<Component> pTooltipComponents = new ArrayList<Component>();

        double totalVisorGunk = IVisorItem.getOuterGunkSum(pStack);
        double visorWater = IVisorItem.getOuterWater(pStack);

        if(visorWater > 0){
            pTooltipComponents.add(Component.translatable("tooltip.radiated.visor.outer.water"));
        } else if (totalVisorGunk > 0.2){
            pTooltipComponents.add(Component.translatable("tooltip.radiated.visor.outer.gunk"));
        }

        if(visorWater > 0 || totalVisorGunk > 0.2){
            pTooltipComponents.add(Component.translatable("tooltip.radiated.visor.outer.wipe"));

            pTooltipComponents.add(Component.literal(""));  // Formatting
        }

        return pTooltipComponents;
    }
}
