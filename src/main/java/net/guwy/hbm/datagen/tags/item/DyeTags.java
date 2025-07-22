package net.guwy.hbm.datagen.tags.item;

import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;

import java.util.HashMap;
import java.util.List;

public class DyeTags {
    private static void addTags() {
        //register(Tags.Items.DYES_BLACK);
        register(Tags.Items.DYES_RED, NTMResourcesNParts.CINNEBAR.get());
        //register(Tags.Items.DYES_GREEN);
        //register(Tags.Items.DYES_BROWN);
        //register(Tags.Items.DYES_BLUE);
        //register(Tags.Items.DYES_PURPLE);
        //register(Tags.Items.DYES_CYAN);
        //register(Tags.Items.DYES_LIGHT_GRAY);
        //register(Tags.Items.DYES_GRAY);
        //register(Tags.Items.DYES_PINK);
        //register(Tags.Items.DYES_LIME);
        register(Tags.Items.DYES_YELLOW, NTMResourcesNParts.SULFUR.get());
        //register(Tags.Items.DYES_LIGHT_BLUE);
        //register(Tags.Items.DYES_MAGENTA);
        //register(Tags.Items.DYES_ORANGE);
        register(Tags.Items.DYES_WHITE, NTMResourcesNParts.FLUORITE.get());
    }


    private static HashMap<List<TagKey<Item>>, Item[]> itemTags = new HashMap<>();

    private static void register(TagKey<Item> tagKey, Item... item) {
        itemTags.put(List.of(tagKey, TagKey.create(Registries.ITEM, ResourceLocation.parse("c:dyes"))), item);
    }
    private static void register(String tagKey, Item... item) {
        register(TagKey.create(Registries.ITEM, ResourceLocation.parse("c:dyes/" + tagKey)), item);
    }

    public static HashMap<List<TagKey<Item>>, Item[]> getMap() {
        addTags();
        return itemTags;
    }
}
