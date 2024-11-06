package net.guwy.hbm.index;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {


        private static TagKey<Block> tag(String tag) {
            return createTag("c", tag);
        }
        private static TagKey<Block> createTag(String id, String tag) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(id, tag));
        }
    }

    public static class Items {


        private static TagKey<Item> tag(String tag) {
            return createTag("c", tag);
        }
        private static TagKey<Item> createTag(String id, String tag) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(id, tag));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> IS_SWAMP = createTag("hbm","is_swamp");

        private static TagKey<Biome> createTag(String id, String tag) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(id, tag));
        }
    }
}
