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
        blockWithItemWithSpecialTextureLoc(NTMOresNBlocks.ORE_LIGNITE, "hbm:block/21/ore/ore_lignite");
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
        simpleBlock(block, models().cubeAll(BuiltInRegistries.BLOCK.getKey(block).getPath(), ResourceLocation.parse(texture)));
        simpleBlockItem(block, models().cubeAll(BuiltInRegistries.BLOCK.getKey(block).getPath(), ResourceLocation.parse(texture)));
    }
}
