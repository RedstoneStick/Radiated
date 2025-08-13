package net.guwy.hbm.datagen.tags.item;

import net.guwy.hbm.index.NTMArmors;
import net.guwy.hbm.index.NTMTools;
import net.guwy.hbm.index.NTMWeapons;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.List;

public class MinecraftTags {
    // minecraft:shovels, minecraft:pickaxes, minecraft:axes, minecraft:hoes, minecraft:swords
    private static void addTags() {
        register(ItemTags.SWORDS,
                NTMWeapons.REDSTONE_SWORD.get(), NTMWeapons.BIG_SWORD.get(), NTMWeapons.STEEL_SWORD.get(), NTMWeapons.TITANIUM_SWORD.get(), NTMWeapons.COBALT_SWORD.get());
        register(ItemTags.SHOVELS,
                NTMTools.STEEL_SHOVEL.get(), NTMTools.TITANIUM_SHOVEL.get(), NTMTools.COBALT_SHOVEL.get());
        register(ItemTags.PICKAXES,
                NTMTools.STEEL_PICKAXE.get(), NTMTools.TITANIUM_PICKAXE.get(), NTMTools.COBALT_PICKAXE.get());
        register(ItemTags.AXES,
                NTMTools.STEEL_AXE.get(), NTMTools.TITANIUM_AXE.get(), NTMTools.COBALT_AXE.get());
        register(ItemTags.HOES,
                NTMTools.STEEL_HOE.get(), NTMTools.TITANIUM_HOE.get(), NTMTools.COBALT_HOE.get());

        register(ItemTags.HEAD_ARMOR,
                NTMArmors.STEEL_HELMET.get(), NTMArmors.TITANIUM_HELMET.get(), NTMArmors.COBALT_HELMET.get());
        register(ItemTags.CHEST_ARMOR,
                NTMArmors.STEEL_PLATE.get(), NTMArmors.TITANIUM_PLATE.get(), NTMArmors.COBALT_PLATE.get());
        register(ItemTags.LEG_ARMOR,
                NTMArmors.STEEL_LEGS.get(), NTMArmors.TITANIUM_LEGS.get(), NTMArmors.COBALT_LEGS.get());
        register(ItemTags.FOOT_ARMOR,
                NTMArmors.STEEL_BOOTS.get(), NTMArmors.TITANIUM_BOOTS.get(), NTMArmors.COBALT_BOOTS.get());
    }


    private static HashMap<List<TagKey<Item>>, Item[]> itemTags = new HashMap<>();

    private static void register(TagKey<Item> tagKey, Item... item) {
        itemTags.put(List.of(tagKey), item);
    }
    private static void register(String tagKey, Item... item) {
        register(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:" + tagKey)), item);
    }

    public static HashMap<List<TagKey<Item>>, Item[]> getMap() {
        addTags();
        return itemTags;
    }
}
