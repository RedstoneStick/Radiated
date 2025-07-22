package net.guwy.hbm.datagen.tags.item;

import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.List;

public class GemTags {
    private static void addTags() {
        register("cinnabar", NTMResourcesNParts.CINNEBAR.get());
    }


    private static HashMap<List<TagKey<Item>>, Item[]> itemTags = new HashMap<>();

    private static void register(TagKey<Item> tagKey, Item... item) {
        itemTags.put(List.of(tagKey, TagKey.create(Registries.ITEM, ResourceLocation.parse("c:gems"))), item);
    }
    private static void register(String tagKey, Item... item) {
        register(TagKey.create(Registries.ITEM, ResourceLocation.parse("c:gems/" + tagKey)), item);
    }

    public static HashMap<List<TagKey<Item>>, Item[]> getMap() {
        addTags();
        return itemTags;
    }
}
