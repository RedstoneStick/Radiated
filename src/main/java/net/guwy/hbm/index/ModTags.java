package net.guwy.hbm.index;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static TagKey<Block> ORES = tag("ores");
        public static TagKey<Block> ORES_ALUMINIUM = tag("ores/aluminium");
        public static TagKey<Block> ORES_ASBESTOS = tag("ores/asbestos");
        public static TagKey<Block> ORES_AUSTRALIUM = tag("ores/australium");
        public static TagKey<Block> ORES_BERYLLIUM = tag("ores/beryllium");
        public static TagKey<Block> ORES_CINNABAR = tag("ores/cinnabar");
        public static TagKey<Block> ORES_COAL = tag("ores/coal");
        public static TagKey<Block> ORES_COBALT = tag("ores/cobalt");
        public static TagKey<Block> ORES_COLTAN = tag("ores/coltan");
        public static TagKey<Block> ORES_FLUORITE = tag("ores/fluorite");
        public static TagKey<Block> ORES_LEAD = tag("ores/lead");
        public static TagKey<Block> ORES_LIGNITE = tag("ores/lignite");
        public static TagKey<Block> ORES_NITER = tag("ores/niter");
        public static TagKey<Block> ORES_OIL = tag("ores/oil");
        public static TagKey<Block> ORES_RARE_EARTH = tag("ores/rare_earth");
        public static TagKey<Block> ORES_SULFUR = tag("ores/sulfur");
        public static TagKey<Block> ORES_THORIUM = tag("ores/thorium");
        public static TagKey<Block> ORES_TITANIUM = tag("ores/titanium");
        public static TagKey<Block> ORES_TUNGSTEN = tag("ores/tungsten");
        public static TagKey<Block> ORES_URANIUM = tag("ores/uranium");

        public static TagKey<Block> STORAGE_BLOCKS = tag("storage_blocks");
        public static TagKey<Block> STORAGE_BLOCKS_RAW_ALUMINIUM = tag("storage_blocks/raw_aluminium");
        public static TagKey<Block> STORAGE_BLOCKS_RAW_AUSTRALIUM = tag("storage_blocks/raw_australium");
        public static TagKey<Block> STORAGE_BLOCKS_RAW_BERYLLIUM = tag("storage_blocks/raw_beryllium");
        public static TagKey<Block> STORAGE_BLOCKS_RAW_COBALT = tag("storage_blocks/raw_cobalt");
        public static TagKey<Block> STORAGE_BLOCKS_RAW_LEAD = tag("storage_blocks/raw_lead");
        public static TagKey<Block> STORAGE_BLOCKS_RAW_THORIUM = tag("storage_blocks/raw_thorium");
        public static TagKey<Block> STORAGE_BLOCKS_RAW_TITANIUM = tag("storage_blocks/raw_titanium");
        public static TagKey<Block> STORAGE_BLOCKS_RAW_TUNGSTEN = tag("storage_blocks/raw_tungsten");
        public static TagKey<Block> STORAGE_BLOCKS_RAW_URANIUM = tag("storage_blocks/raw_uranium");

        public static TagKey<Block> STORAGE_BLOCKS_SULFUR = tag("storage_blocks/sulfur");
        public static TagKey<Block> STORAGE_BLOCKS_NITER = tag("storage_blocks/niter");
        public static TagKey<Block> STORAGE_BLOCKS_FLUORITE = tag("storage_blocks/fluorite");
        public static TagKey<Block> STORAGE_BLOCKS_COLTAN = tag("storage_blocks/coltan");
        public static TagKey<Block> STORAGE_BLOCKS_ASBESTOS = tag("storage_blocks/asbestos");
        public static TagKey<Block> STORAGE_BLOCKS_TITANIUM = tag("storage_blocks/titanium");
        public static TagKey<Block> STORAGE_BLOCKS_STEEL = tag("storage_blocks/steel");
        public static TagKey<Block> STORAGE_BLOCKS_COBALT = tag("storage_blocks/cobalt");



        private static TagKey<Block> createTag(String id, String tag) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(id, tag));
        }
        private static TagKey<Block> tag(String tag) {
            return createTag("c", tag);
        }
    }

    public static class Items {

        /// BLOCK ITEM TAGS
        public static TagKey<Item> ORES = tag("ores");
        public static TagKey<Item> ORES_ALUMINIUM = tag("ores/aluminium");
        public static TagKey<Item> ORES_ASBESTOS = tag("ores/asbestos");
        public static TagKey<Item> ORES_AUSTRALIUM = tag("ores/australium");
        public static TagKey<Item> ORES_BERYLLIUM = tag("ores/beryllium");
        public static TagKey<Item> ORES_CINNABAR = tag("ores/cinnabar");
        public static TagKey<Item> ORES_COAL = tag("ores/coal");
        public static TagKey<Item> ORES_COBALT = tag("ores/cobalt");
        public static TagKey<Item> ORES_COLTAN = tag("ores/coltan");
        public static TagKey<Item> ORES_FLUORITE = tag("ores/fluorite");
        public static TagKey<Item> ORES_LEAD = tag("ores/lead");
        public static TagKey<Item> ORES_LIGNITE = tag("ores/lignite");
        public static TagKey<Item> ORES_NITER = tag("ores/niter");
        public static TagKey<Item> ORES_OIL = tag("ores/oil");
        public static TagKey<Item> ORES_RARE_EARTH = tag("ores/rare_earth");
        public static TagKey<Item> ORES_SULFUR = tag("ores/sulfur");
        public static TagKey<Item> ORES_THORIUM = tag("ores/thorium");
        public static TagKey<Item> ORES_TITANIUM = tag("ores/titanium");
        public static TagKey<Item> ORES_TUNGSTEN = tag("ores/tungsten");
        public static TagKey<Item> ORES_URANIUM = tag("ores/uranium");

        public static TagKey<Item> STORAGE_BLOCKS = tag("storage_blocks");
        public static TagKey<Item> STORAGE_BLOCKS_RAW_ALUMINIUM = tag("storage_blocks/raw_aluminium");
        public static TagKey<Item> STORAGE_BLOCKS_RAW_AUSTRALIUM = tag("storage_blocks/raw_australium");
        public static TagKey<Item> STORAGE_BLOCKS_RAW_BERYLLIUM = tag("storage_blocks/raw_beryllium");
        public static TagKey<Item> STORAGE_BLOCKS_RAW_COBALT = tag("storage_blocks/raw_cobalt");
        public static TagKey<Item> STORAGE_BLOCKS_RAW_LEAD = tag("storage_blocks/raw_lead");
        public static TagKey<Item> STORAGE_BLOCKS_RAW_THORIUM = tag("storage_blocks/raw_thorium");
        public static TagKey<Item> STORAGE_BLOCKS_RAW_TITANIUM = tag("storage_blocks/raw_titanium");
        public static TagKey<Item> STORAGE_BLOCKS_RAW_TUNGSTEN = tag("storage_blocks/raw_tungsten");
        public static TagKey<Item> STORAGE_BLOCKS_RAW_URANIUM = tag("storage_blocks/raw_uranium");

        public static TagKey<Item> STORAGE_BLOCKS_SULFUR = tag("storage_blocks/sulfur");
        public static TagKey<Item> STORAGE_BLOCKS_NITER = tag("storage_blocks/niter");
        public static TagKey<Item> STORAGE_BLOCKS_FLUORITE = tag("storage_blocks/fluorite");
        public static TagKey<Item> STORAGE_BLOCKS_COLTAN = tag("storage_blocks/coltan");
        public static TagKey<Item> STORAGE_BLOCKS_ASBESTOS = tag("storage_blocks/asbestos");
        public static TagKey<Item> STORAGE_BLOCKS_TITANIUM = tag("storage_blocks/titanium");
        public static TagKey<Item> STORAGE_BLOCKS_STEEL = tag("storage_blocks/steel");
        public static TagKey<Item> STORAGE_BLOCKS_COBALT = tag("storage_blocks/cobalt");

        /// ITEM TAGS
        // INGOTS //
        public static TagKey<Item> INGOTS = tag("ingots");
        public static TagKey<Item> INGOTS_COBALT = tag("ingots/cobalt");
        public static TagKey<Item> INGOTS_TITANIUM = tag("ingots/titanium");
        public static TagKey<Item> INGOTS_STEEL = tag("ingots/steel");
        public static TagKey<Item> INGOTS_ASBESTOS = tag("ingots/asbestos");
        public static TagKey<Item> INGOTS_RARE_EARTH = tag("ingots/rare_earth");
        public static TagKey<Item> INGOTS_COLTAN = tag("ingots/coltan");

        // RAW MATERIALS //
        public static TagKey<Item> RAW_MATERIALS = tag("raw_materials");
        public static TagKey<Item> RAW_MATERIALS_ALUMINIUM = tag("raw_materials/aluminium");
        public static TagKey<Item> RAW_MATERIALS_AUSTRALIUM = tag("raw_materials/australium");
        public static TagKey<Item> RAW_MATERIALS_BERYLLIUM = tag("raw_materials/beryllium");
        public static TagKey<Item> RAW_MATERIALS_COBALT = tag("raw_materials/cobalt");
        public static TagKey<Item> RAW_MATERIALS_LEAD = tag("raw_materials/lead");
        public static TagKey<Item> RAW_MATERIALS_THORIUM = tag("raw_materials/thorium");
        public static TagKey<Item> RAW_MATERIALS_TITANIUM = tag("raw_materials/titanium");
        public static TagKey<Item> RAW_MATERIALS_TUNGSTEN = tag("raw_materials/tungsten");
        public static TagKey<Item> RAW_MATERIALS_URANIUM = tag("raw_materials/uranium");

        // DUSTS //
        public static TagKey<Item> DUSTS = tag("dusts");
        public static TagKey<Item> DUSTS_SULFUR = tag("dusts/sulfur");
        public static TagKey<Item> DUSTS_SALTPETER = tag("dusts/saltpeter");
        public static TagKey<Item> DUSTS_NITER = tag("dusts/niter");
        public static TagKey<Item> DUSTS_FLUORITE = tag("dusts/fluorite");

        // GEMS //
        public static TagKey<Item> GEMS = tag("gems");
        public static TagKey<Item> GEMS_CINNABAR = tag("gems/cinnabar");

        // BILLETS //
        public static TagKey<Item> BILLETS = tag("billets");
        public static TagKey<Item> BILLETS_COBALT = tag("billets/cobalt");

        // NUGGETS //
        public static TagKey<Item> NUGGETS = tag("nuggets");
        public static TagKey<Item> NUGGETS_COBALT = tag("nuggets/cobalt");



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
