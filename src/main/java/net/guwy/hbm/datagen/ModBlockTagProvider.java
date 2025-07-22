package net.guwy.hbm.datagen;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.datagen.tags.block.*;
import net.guwy.hbm.datagen.tags.block.mineable.MineableWithPickaxeTags;
import net.guwy.hbm.datagen.tags.item.IngotTags;
import net.guwy.hbm.datagen.tags.item.RawMaterialTags;
import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NTMMain.MODID, existingFileHelper);
    }


    // What happens when a snake eats a snake that ate a snake which ate the rabbit
    // Very messy, but i can't think of a better way to register multiple blocks to multiple tags using one line
    public static final List<HashMap<List<TagKey<Block>>, Block[]>> multiTagRegistryMapList =  List.of(
            StorageBlockTags.getMap(),
            OreTags.getMap()
    );


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Add Simple Tags
        tag(BlockTags.WOOL).add(NTMOresNBlocks.BLOCK_ASBESTOS.get());



        // Add Mining Tags
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addAll(MineableWithPickaxeTags.getList());

        tag(BlockTags.NEEDS_STONE_TOOL).addAll(NeedsStoneToolTags.getList());
        tag(BlockTags.NEEDS_IRON_TOOL).addAll(NeedsIronToolTags.getList());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).addAll(NeedsDiamondToolTags.getList());



        // Add Multi Registry Tags
        multiTagRegistryMapList.forEach((map) -> {
            map.forEach((tagKeyList, blockArray) -> {
                tagKeyList.forEach((tagKey) -> {
                    List.of(blockArray).forEach((block) -> {
                        tag(tagKey).add(block);
                    });
                });
            });
        });
    }
}
