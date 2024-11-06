package net.guwy.hbm.datagen.tags.item;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.HashMap;
import java.util.List;

public class RawMaterialTags {
    private static void addTags() {
        register("uranium", NTMResourcesNParts.RAW_URANIUM.get());
        register("thorium", NTMResourcesNParts.RAW_THORIUM.get());
        register("titanium", NTMResourcesNParts.RAW_TITANIUM.get());
        register("tungsten", NTMResourcesNParts.RAW_TUNGSTEN.get());
        register("aluminium", NTMResourcesNParts.RAW_ALUMINIUM.get());
        register("beryllium", NTMResourcesNParts.RAW_BERYLLIUM.get());
        register("lead", NTMResourcesNParts.RAW_LEAD.get());
        register("australium", NTMResourcesNParts.RAW_AUSTRALIUM.get());
        register("cobalt", NTMResourcesNParts.RAW_COBALT.get());
    }


    private static HashMap<List<TagKey<Item>>, Item[]> itemTags = new HashMap<>();

    private static void register(TagKey<Item> tagKey, Item... item) {
        itemTags.put(List.of(tagKey, TagKey.create(Registries.ITEM, ResourceLocation.parse("c:raw_materials"))), item);
    }
    private static void register(String tagKey, Item... item) {
        register(TagKey.create(Registries.ITEM, ResourceLocation.parse("c:raw_materials/" + tagKey)), item);
    }

    public static HashMap<List<TagKey<Item>>, Item[]> getMap() {
        addTags();
        return itemTags;
    }
}
