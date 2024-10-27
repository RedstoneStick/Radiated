package net.guwy.hbm.datagen.tags.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.HashMap;

public class IngotTags {
    private static void init() {
        //register(Items.IRON_AXE, "uranium");
    }

    private static HashMap<Item, TagKey<Item>> ingotTags = new HashMap<>();

    private static void register(Item item, TagKey<Item> tagKey) {
        ingotTags.put(item, tagKey);
    }
    private static void register(Item item, String tagKey) {
        register(item, TagKey.create(Registries.ITEM, ResourceLocation.parse("c:ingots/" + tagKey)));
    }

    public static HashMap<Item, TagKey<Item>> getMap() {
        init();
        return ingotTags;
    }
}
