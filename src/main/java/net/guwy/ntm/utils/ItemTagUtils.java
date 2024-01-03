package net.guwy.ntm.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class ItemTagUtils {
    public static void putString(ItemStack itemStack, String tagKey, String element){
        CompoundTag nbt = new CompoundTag();
        if(itemStack.getTag() != null)  nbt = itemStack.getTag();
        nbt.putString(tagKey, element);
        itemStack.setTag(nbt);
    }

    public static void putInt(ItemStack itemStack, String tagKey, int element){
        CompoundTag nbt = new CompoundTag();
        if(itemStack.getTag() != null)  nbt = itemStack.getTag();
        nbt.putInt(tagKey, element);
        itemStack.setTag(nbt);
    }

    public static void putLong(ItemStack itemStack, String tagKey, long element){
        CompoundTag nbt = new CompoundTag();
        if(itemStack.getTag() != null)  nbt = itemStack.getTag();
        nbt.putLong(tagKey, element);
        itemStack.setTag(nbt);
    }

    public static void putDouble(ItemStack itemStack, String tagKey, double element){
        CompoundTag nbt = new CompoundTag();
        if(itemStack.getTag() != null)  nbt = itemStack.getTag();
        nbt.putDouble(tagKey, element);
        itemStack.setTag(nbt);
    }

    public static void putBoolean(ItemStack itemStack, String tagKey, boolean element){
        CompoundTag nbt = new CompoundTag();
        if(itemStack.getTag() != null)  nbt = itemStack.getTag();
        nbt.putBoolean(tagKey, element);
        itemStack.setTag(nbt);
    }

    public static void putUUID(ItemStack itemStack, String tagKey, UUID element){
        CompoundTag nbt = new CompoundTag();
        if(itemStack.getTag() != null)  nbt = itemStack.getTag();
        nbt.putUUID(tagKey, element);
        itemStack.setTag(nbt);
    }



    public static String getString(ItemStack itemStack, String tagKey){
        if(itemStack.getTag() != null) return itemStack.getTag().getString(tagKey);
        else return null;
    }

    public static int getInt(ItemStack itemStack, String tagKey){
        if(itemStack.getTag() != null) return itemStack.getTag().getInt(tagKey);
        else return 0;
    }

    public static long getLong(ItemStack itemStack, String tagKey){
        if(itemStack.getTag() != null) return itemStack.getTag().getLong(tagKey);
        else return 0;
    }

    public static double getDouble(ItemStack itemStack, String tagKey){
        if(itemStack.getTag() != null) return itemStack.getTag().getDouble(tagKey);
        else return 0;
    }

    public static boolean getBoolean(ItemStack itemStack, String tagKey){
        if(itemStack.getTag() != null) return itemStack.getTag().getBoolean(tagKey);
        else return false;
    }

    public static UUID getUUID(ItemStack itemStack, String tagKey){
        if(itemStack.getTag() != null) return itemStack.getTag().getUUID(tagKey);
        else return null;
    }
}
