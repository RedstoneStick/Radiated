package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.sticky_foundations.StickyFoundations;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ModTags {
    public static class Blocks {
        //public static final TagKey<Block> NATURAL_SOIL = tag("natural_soil");

        public static final TagKey<Block> MASK_SAND = tag("mask_sand");
        public static final TagKey<Block> MASK_DIRT = tag("mask_dirt");
        public static final TagKey<Block> MASK_MUD = tag("mask_mud");
        public static final TagKey<Block> MASK_SOOTH = tag("mask_sooth");



        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Radiated.MOD_ID, name));
        }

        private static TagKey<Block> forgeTags(String name){
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        //public static final TagKey<Item> PLANKS = minecraftTags("planks");

        public static final TagKey<Item> HAZMAT_HELMETS = tag("hazmat_helmets");


        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(Radiated.MOD_ID, name));
        }

        private static TagKey<Item> forgeTags(String name){
            return ItemTags.create(new ResourceLocation("forge", name));
        }

        private static TagKey<Item> minecraftTags(String name){
            return ItemTags.create(new ResourceLocation("minecraft", name));
        }
    }



    public static boolean isItemPresentInTag(ItemStack itemStack, TagKey<Item> tagKey){
        return itemStack.is(tagKey);
    }

    public static boolean isBlockPresentInTag(BlockState state, TagKey<Block> tagKey){
        return state.is(tagKey);
    }
}
