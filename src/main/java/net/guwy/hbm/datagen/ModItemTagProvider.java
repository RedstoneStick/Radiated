package net.guwy.hbm.datagen;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.datagen.tags.item.*;
import net.guwy.hbm.index.ModTags;
import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, NTMMain.MODID, existingFileHelper);
    }


    // What happens when a snake eats a snake that ate a snake which ate the rabbit
    // Very messy, but i can't think of a better way to register multiple items to multiple tags using one line
    public static final List<HashMap<List<TagKey<Item>>, Item[]>> multiTagRegistryMapList = List.of(
            IngotTags.getMap(),
            RawMaterialTags.getMap(),
            DustTags.getMap(),
            DyeTags.getMap(),
            GemTags.getMap(),
            BilletTags.getMap(),
            NuggetTags.getMap(),
            MinecraftTags.getMap()
    );

    /**
     * Will copy all the block tags listed here onto item tags with the same location
     */
    public static final List<TagKey<Block>> blockToItemTagCopyList = List.of(
            ModTags.Blocks.ORES,
            ModTags.Blocks.ORES_ALUMINIUM,
            ModTags.Blocks.ORES_ASBESTOS,
            ModTags.Blocks.ORES_AUSTRALIUM,
            ModTags.Blocks.ORES_BERYLLIUM,
            ModTags.Blocks.ORES_CINNABAR,
            ModTags.Blocks.ORES_COAL,
            ModTags.Blocks.ORES_COBALT,
            ModTags.Blocks.ORES_COLTAN,
            ModTags.Blocks.ORES_FLUORITE,
            ModTags.Blocks.ORES_LEAD,
            ModTags.Blocks.ORES_LIGNITE,
            ModTags.Blocks.ORES_NITER,
            ModTags.Blocks.ORES_OIL,
            ModTags.Blocks.ORES_RARE_EARTH,
            ModTags.Blocks.ORES_SULFUR,
            ModTags.Blocks.ORES_THORIUM,
            ModTags.Blocks.ORES_TITANIUM,
            ModTags.Blocks.ORES_TUNGSTEN,
            ModTags.Blocks.ORES_URANIUM,

            ModTags.Blocks.STORAGE_BLOCKS,
            ModTags.Blocks.STORAGE_BLOCKS_RAW_ALUMINIUM,
            ModTags.Blocks.STORAGE_BLOCKS_RAW_AUSTRALIUM,
            ModTags.Blocks.STORAGE_BLOCKS_RAW_BERYLLIUM,
            ModTags.Blocks.STORAGE_BLOCKS_RAW_COBALT,
            ModTags.Blocks.STORAGE_BLOCKS_RAW_LEAD,
            ModTags.Blocks.STORAGE_BLOCKS_RAW_THORIUM,
            ModTags.Blocks.STORAGE_BLOCKS_RAW_TITANIUM,
            ModTags.Blocks.STORAGE_BLOCKS_RAW_TUNGSTEN,
            ModTags.Blocks.STORAGE_BLOCKS_RAW_URANIUM,
            ModTags.Blocks.STORAGE_BLOCKS_SULFUR,
            ModTags.Blocks.STORAGE_BLOCKS_NITER,
            ModTags.Blocks.STORAGE_BLOCKS_FLUORITE,
            ModTags.Blocks.STORAGE_BLOCKS_COLTAN,
            ModTags.Blocks.STORAGE_BLOCKS_ASBESTOS,
            ModTags.Blocks.STORAGE_BLOCKS_TITANIUM,
            ModTags.Blocks.STORAGE_BLOCKS_STEEL,
            ModTags.Blocks.STORAGE_BLOCKS_COBALT
    );


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Add Simple Tags
        tag(ItemTags.WOOL).add(NTMOresNBlocks.BLOCK_ASBESTOS.get().asItem());



        // Copy block tags to item tags
        blockToItemTagCopyList.forEach((blockTagKey -> {
            TagKey<Item> itemTagKey = ItemTags.create(blockTagKey.location());
            copy(blockTagKey, itemTagKey);
        }));



        // Add Multi Registry Tags
        multiTagRegistryMapList.forEach((map) -> {
            map.forEach((tagKeyList, itemArray) -> {
                tagKeyList.forEach((tagKey) -> {
                    List.of(itemArray).forEach((item) -> {
                        tag(tagKey).add(item);
                    });
                });
            });
        });
    }
}
