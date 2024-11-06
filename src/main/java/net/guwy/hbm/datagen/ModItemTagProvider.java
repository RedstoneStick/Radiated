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

    public static final List<HashMap<List<TagKey<Item>>, Item[]>> multiTagRegistryMapList = List.of(
            IngotTags.getMap(),
            RawMaterialTags.getMap()
    );

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //tag(ItemTags.PICKAXES).add(Items.TRIAL_KEY);



        multiTagRegistryMapList.forEach((map) -> {
            map.forEach((tagKeyList, itemArray) -> {
                tagKeyList.forEach((tagKey) -> {
                    List.of(itemArray).forEach((item) -> {
                        tag(tagKey).add(item);
                    });
                });
            });
        });

        ModBlockTagProvider.multiTagRegistryMapList.forEach((map) -> {
            map.forEach((tagKeyList, blockArray) -> {
                tagKeyList.forEach((tagKey) -> {
                    List.of(blockArray).forEach((block) -> {
                        tag(ItemTags.create(tagKey.location())).add(block.asItem());
                    });
                });
            });
        });
    }
}
