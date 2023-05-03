package net.guwy.radiated.mechanics.gasmask;

import net.guwy.radiated.utils.ItemTagUtils;
import net.minecraft.world.item.ItemStack;

public interface VisorItem {



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


    // A basic function to clamp the entered number between 1 and 0
    private static double clamp(double val){
        return Math.max(0, Math.min(1, val));
    }
}
