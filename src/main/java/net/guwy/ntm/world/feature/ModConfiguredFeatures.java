package net.guwy.ntm.world.feature;

import net.guwy.ntm.NTM;
import net.guwy.sticky_foundations.index.SFTags;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, NTM.MOD_ID);

    private static final RuleTest NATURAL_SOIL = new TagMatchTest(SFTags.Blocks.NATURAL_SOIL);
    private static final RuleTest NATURAL_FOLIAGE = new TagMatchTest(SFTags.Blocks.NATURAL_FOLIAGE);
    private static final RuleTest SNOW_LAYER = new BlockMatchTest(Blocks.SNOW);
    private static final RuleTest GRASS = new BlockMatchTest(Blocks.GRASS);



    // public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BERYLLIUM_ORES = Suppliers.memoize(() -> List.of(
    //         OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RDTResources.BERYLLIUM_ORE.get().defaultBlockState()),
    //         OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RDTResources.BERYLLIUM_ORE_DEEPSLATE.get().defaultBlockState())));
    // public static final RegistryObject<ConfiguredFeature<?, ?>> BERYLLIUM_ORE = CONFIGURED_FEATURES.register("beryllium_ore",
    //         () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_BERYLLIUM_ORES.get(),12)));



    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
