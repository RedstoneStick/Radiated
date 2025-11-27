package net.guwy.hbm.datagen.tags.item;

import net.guwy.hbm.index.ModTags;
import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.List;

public class BasicItemTags {
    private static void addTags() {
        register(ItemTags.WOOL, NTMOresNBlocks.BLOCK_ASBESTOS.asItem());
        register(ModTags.Items.LIGNITE, NTMResourcesNParts.LIGNITE.get());
    }


    private static HashMap<List<TagKey<Item>>, Item[]> itemTags = new HashMap<>();

    private static void register(TagKey<Item> tagKey, Item... item) {
        itemTags.put(List.of(tagKey), item);
    }
    private static void register(String tagKey, Item... item) {
        itemTags.put(List.of(TagKey.create(Registries.ITEM, ResourceLocation.parse("c:" + tagKey))), item);
    }

    public static HashMap<List<TagKey<Item>>, Item[]> getMap() {
        addTags();
        return itemTags;
    }
}
