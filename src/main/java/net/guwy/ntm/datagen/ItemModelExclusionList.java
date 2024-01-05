package net.guwy.ntm.datagen;

import net.guwy.ntm.index.NTMResourcesAndParts;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class ItemModelExclusionList {
    public static List<RegistryObject<Item>> get(){
         List<RegistryObject<Item>> list = new ArrayList<>();

         list.add(NTMResourcesAndParts.STIRLING_GEAR);
         list.add(NTMResourcesAndParts.STIRLING_GEAR_STEEL);
         list.add(NTMResourcesAndParts.SAWMILL_SAW);
         list.add(NTMResourcesAndParts.POWDER_ENERGY);

         return list;
    }
}
