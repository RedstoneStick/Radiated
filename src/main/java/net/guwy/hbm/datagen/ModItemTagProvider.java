package net.guwy.hbm.datagen;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.datagen.tags.block.OreTags;
import net.guwy.hbm.datagen.tags.block.StorageBlockTags;
import net.guwy.hbm.datagen.tags.item.IngotTags;
import net.guwy.hbm.datagen.tags.item.RawMaterialTags;
import net.guwy.hbm.index.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, NTMMain.MODID, existingFileHelper);
    }


    // What happens when a snake eats a snake that ate a snake which ate the rabbit
    // Very messy, but i can't think of a better way to register multiple blocks to multiple tags using one line
    public static final List<HashMap<List<TagKey<Item>>, Item[]>> multiTagRegistryMapList = List.of(
            IngotTags.getMap(),
            RawMaterialTags.getMap()
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
            ModTags.Blocks.STORAGE_BLOCKS_ALUMINIUM,
            ModTags.Blocks.STORAGE_BLOCKS_AUSTRALIUM,
            ModTags.Blocks.STORAGE_BLOCKS_BERYLLIUM,
            ModTags.Blocks.STORAGE_BLOCKS_COBALT,
            ModTags.Blocks.STORAGE_BLOCKS_LEAD,
            ModTags.Blocks.STORAGE_BLOCKS_THORIUM,
            ModTags.Blocks.STORAGE_BLOCKS_TITANIUM,
            ModTags.Blocks.STORAGE_BLOCKS_TUNGSTEN,
            ModTags.Blocks.STORAGE_BLOCKS_URANIUM
            );


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //tag(ItemTags.PICKAXES).add(Items.TRIAL_KEY);

        // Copy block tags to item tags
        blockToItemTagCopyList.forEach((blockTagKey -> {
            TagKey<Item> itemTagKey = ItemTags.create(blockTagKey.location());
            copy(blockTagKey, itemTagKey);
        }));



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
