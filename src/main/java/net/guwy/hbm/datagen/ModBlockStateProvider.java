package net.guwy.hbm.datagen;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NTMMain.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(NTMOresNBlocks.ORE_URANIUM);

        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_URANIUM, "hbm:block/21/ore/ore_uranium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_THORIUM, "hbm:block/21/ore/ore_thorium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_TITANIUM, "hbm:block/21/ore/ore_titanium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_SULFUR, "hbm:block/21/ore/ore_sulfur");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_NITER, "hbm:block/21/ore/ore_niter");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_TUNGSTEN, "hbm:block/21/ore/ore_tungsten");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_ALUMINIUM, "hbm:block/21/ore/ore_aluminium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_FLUORITE, "hbm:block/21/ore/ore_fluorite");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_BERYLLIUM, "hbm:block/21/ore/ore_beryllium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_LEAD, "hbm:block/21/ore/ore_lead");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_OIL, "hbm:block/21/ore/ore_oil");
        orientableBlockWithItem(NTMOresNBlocks.ORE_LIGNITE, "hbm:block/21/ore/ore_lignite_side", "hbm:block/21/ore/ore_lignite_side", "hbm:block/21/ore/ore_lignite_top", "hbm:block/21/ore/ore_lignite_top");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_ASBESTOS, "hbm:block/21/ore/ore_asbestos");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_AUSTRALIUM, "hbm:block/21/ore/ore_australium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_RARE, "hbm:block/21/ore/ore_rare");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_COBALT, "hbm:block/21/ore/ore_cobalt");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_CINNEBAR, "hbm:block/21/ore/ore_cinnebar");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_COLTAN, "hbm:block/21/ore/ore_coltan");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.CLUSTER_IRON, "hbm:block/21/ore/cluster_iron");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.CLUSTER_TITANIUM, "hbm:block/21/ore/cluster_titanium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.CLUSTER_ALUMINIUM, "hbm:block/21/ore/cluster_aluminium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.CLUSTER_COPPER, "hbm:block/21/ore/cluster_copper");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_COAL_OIL, "hbm:block/21/ore/ore_coal_oil");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_COAL_OIL_BURNING, "hbm:block/21/ore/ore_coal_oil_burning");

        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_URANIUM, "hbm:block/21/ore/deepslate_ore_uranium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_THORIUM, "hbm:block/21/ore/deepslate_ore_thorium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_TITANIUM, "hbm:block/21/ore/deepslate_ore_titanium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_SULFUR, "hbm:block/21/ore/deepslate_ore_sulfur");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_NITER, "hbm:block/21/ore/deepslate_ore_niter");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_TUNGSTEN, "hbm:block/21/ore/deepslate_ore_tungsten");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_ALUMINIUM, "hbm:block/21/ore/deepslate_ore_aluminium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_FLUORITE, "hbm:block/21/ore/deepslate_ore_fluorite");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_BERYLLIUM, "hbm:block/21/ore/deepslate_ore_beryllium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_LEAD, "hbm:block/21/ore/deepslate_ore_lead");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_OIL, "hbm:block/21/ore/deepslate_ore_oil");
        orientableBlockWithItem(NTMOresNBlocks.DEEPSLATE_ORE_LIGNITE, "hbm:block/21/ore/deepslate_ore_lignite_side", "hbm:block/21/ore/deepslate_ore_lignite_side", "hbm:block/21/ore/deepslate_ore_lignite_top", "hbm:block/21/ore/deepslate_ore_lignite_top");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_ASBESTOS, "hbm:block/21/ore/deepslate_ore_asbestos");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_AUSTRALIUM, "hbm:block/21/ore/deepslate_ore_australium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_RARE, "hbm:block/21/ore/deepslate_ore_rare");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_COBALT, "hbm:block/21/ore/deepslate_ore_cobalt");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_CINNEBAR, "hbm:block/21/ore/deepslate_ore_cinnebar");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_COLTAN, "hbm:block/21/ore/deepslate_ore_coltan");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_CLUSTER_IRON, "hbm:block/21/ore/deepslate_cluster_iron");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_CLUSTER_TITANIUM, "hbm:block/21/ore/deepslate_cluster_titanium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_CLUSTER_ALUMINIUM, "hbm:block/21/ore/deepslate_cluster_aluminium");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_CLUSTER_COPPER, "hbm:block/21/ore/deepslate_cluster_copper");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_COAL_OIL, "hbm:block/21/ore/deepslate_ore_coal_oil");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.DEEPSLATE_ORE_COAL_OIL_BURNING, "hbm:block/21/ore/deepslate_ore_coal_oil_burning");

        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.BLOCK_RAW_URANIUM, "hbm:block/21/block_raw_uranium_2");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.BLOCK_RAW_THORIUM, "hbm:block/21/block_raw_thorium_2");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.BLOCK_RAW_TITANIUM, "hbm:block/21/block_raw_titanium_2");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.BLOCK_RAW_TUNGSTEN, "hbm:block/21/block_raw_tungsten_2");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.BLOCK_RAW_ALUMINIUM, "hbm:block/21/block_raw_aluminium_2");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.BLOCK_RAW_BERYLLIUM, "hbm:block/21/block_raw_beryllium_2");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.BLOCK_RAW_LEAD, "hbm:block/21/block_raw_lead_2");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.BLOCK_RAW_AUSTRALIUM, "hbm:block/21/block_raw_australium_2");
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.BLOCK_RAW_COBALT, "hbm:block/21/block_raw_cobalt_2");

        blockWithItem(NTMOresNBlocks.BLOCK_SULFUR);
        blockWithItem(NTMOresNBlocks.BLOCK_NITER);
        blockWithItem(NTMOresNBlocks.BLOCK_FLUORITE);
        blockWithItem(NTMOresNBlocks.BLOCK_COLTAN);
        blockWithItem(NTMOresNBlocks.BLOCK_ASBESTOS);
    }

    /**
     * For a block that has the same texture on all sides. Creates a block state and model and its respective item models.
     */
    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    /**
     * For a block that has the same texture on all sides that has a special file location. Creates a block state and model and its respective item models.
     */
    private void blockWithItemWithSpecialTextureLoc(DeferredBlock<?> deferredBlock, String texture) {
        Block block = deferredBlock.get();
        simpleBlockWithItem(deferredBlock.get(), models().cubeAll(BuiltInRegistries.BLOCK.getKey(block).getPath(), ResourceLocation.parse(texture)));
    }

    private void orientableBlockWithItem(DeferredBlock<?> deferredBlock, String sideTexture, String frontTexture, String bottomTexture, String topTexture) {
        Block block = deferredBlock.get();
        simpleBlockWithItem(deferredBlock.get(), models().orientableWithBottom(BuiltInRegistries.BLOCK.getKey(block).getPath(),
                ResourceLocation.parse(sideTexture), ResourceLocation.parse(frontTexture), ResourceLocation.parse(bottomTexture), ResourceLocation.parse(topTexture)));
    }
}
