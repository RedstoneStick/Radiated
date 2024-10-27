package net.guwy.hbm.datagen;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.datagen.tags.block.NeedsDiamondTool;
import net.guwy.hbm.datagen.tags.block.NeedsIronTool;
import net.guwy.hbm.datagen.tags.block.NeedsStoneTool;
import net.guwy.hbm.datagen.tags.block.mineable.MineableWithPickaxe;
import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NTMMain.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addAll(MineableWithPickaxe.getList());

        tag(BlockTags.NEEDS_STONE_TOOL).addAll(NeedsStoneTool.getList());
        tag(BlockTags.NEEDS_IRON_TOOL).addAll(NeedsIronTool.getList());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).addAll(NeedsDiamondTool.getList());
    }
}
