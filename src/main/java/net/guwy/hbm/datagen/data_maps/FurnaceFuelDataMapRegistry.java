package net.guwy.hbm.datagen.data_maps;

import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.util.HashMap;

public class FurnaceFuelDataMapRegistry {

    public static void init() {
        register(NTMResourcesNParts.LIGNITE, 1200);  // 1 item
        register(NTMResourcesNParts.POWDER_ASH_COAL, 200);  // 1 item
        register(NTMResourcesNParts.POWDER_ASH_WOOD, 100);  // 0.5 item
        register(NTMResourcesNParts.POWDER_ASH_MISC, 100);  // 0.5 item
        register(NTMResourcesNParts.POWDER_ASH_FLY, 200);   // 1 item
        register(NTMResourcesNParts.POWDER_ASH_SOOT, 100);  // 0.5 item
    }

    public static HashMap<Holder<Item>, Integer> itemlikeFurnaceFuelMap = new HashMap<>();

    private static void register(Holder<Item> item, int burnDuration) {
        itemlikeFurnaceFuelMap.put(item, burnDuration);
    }
}
