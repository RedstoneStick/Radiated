package net.guwy.hbm.datagen;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.datagen.tags.block.*;
import net.guwy.hbm.datagen.tags.block.mineable.MineableWithPickaxeTags;
import net.guwy.hbm.datagen.tags.item.IngotTags;
import net.guwy.hbm.datagen.tags.item.RawMaterialTags;
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

    public static final List<HashMap<List<TagKey<Block>>, Block[]>> multiTagRegistryMapList =  List.of(
            StorageBlockTags.getMap(),
            OreTags.getMap()
    );

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addAll(MineableWithPickaxeTags.getList());

        tag(BlockTags.NEEDS_STONE_TOOL).addAll(NeedsStoneToolTags.getList());
        tag(BlockTags.NEEDS_IRON_TOOL).addAll(NeedsIronToolTags.getList());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).addAll(NeedsDiamondToolTags.getList());



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
