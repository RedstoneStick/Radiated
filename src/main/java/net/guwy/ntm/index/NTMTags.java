package net.guwy.ntm.index;

import net.guwy.ntm.NTM;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class NTMTags {
    public static class Blocks {
        //public static final TagKey<Block> NATURAL_SOIL = tag("natural_soil");



        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(NTM.MOD_ID, name));
        }

        private static TagKey<Block> forgeTags(String name){
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        //public static final TagKey<Item> PLANKS = minecraftTags("planks");

        // Mod Tags
        public static final TagKey<Item> HAZMAT_HELMETS = tag("hazmat_helmets");

        // Forge Tags
        public static final TagKey<Item> URANIUM_INGOT = forgeTags("ingots/uranium");
        public static final TagKey<Item> URANIUM_NUGGET = forgeTags("nuggets/uranium");
        public static final TagKey<Item> URANIUM_RAW = forgeTags("raw_materials/uranium");
        public static final TagKey<Item> URANIUM_PLATE = forgeTags("plates/uranium");
        public static final TagKey<Item> URANIUM_DUST = forgeTags("dusts/uranium");
        public static final TagKey<Item> URANIUM_ORE = forgeTags("ores/uranium");
        public static final TagKey<Item> URANIUM_BLOCK = forgeTags("storage_blocks/uranium");
        public static final TagKey<Item> URANIUM_BLOCK_RAW = forgeTags("storage_blocks/raw_uranium");
        public static final TagKey<Item> THORIUM_INGOT = forgeTags("ingots/thorium");
        public static final TagKey<Item> THORIUM_NUGGET = forgeTags("nuggets/thorium");
        public static final TagKey<Item> THORIUM_RAW = forgeTags("raw_materials/thorium");
        public static final TagKey<Item> THORIUM_PLATE = forgeTags("plates/thorium");
        public static final TagKey<Item> THORIUM_DUST = forgeTags("dusts/thorium");
        public static final TagKey<Item> THORIUM_ORE = forgeTags("ores/thorium");
        public static final TagKey<Item> THORIUM_BLOCK = forgeTags("storage_blocks/thorium");
        public static final TagKey<Item> THORIUM_BLOCK_RAW = forgeTags("storage_blocks/raw_thorium");


        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(NTM.MOD_ID, name));
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
