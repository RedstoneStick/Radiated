package net.guwy.radiated.world.feature;

import com.google.common.base.Suppliers;
import net.guwy.radiated.index.RDTResources;
import net.guwy.sticky_foundations.StickyFoundations;
import net.guwy.sticky_foundations.index.SFMinerals;
import net.guwy.sticky_foundations.index.SFTags;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, StickyFoundations.MOD_ID);

    private static final RuleTest NATURAL_SOIL = new TagMatchTest(SFTags.Blocks.NATURAL_SOIL);
    private static final RuleTest NATURAL_FOLIAGE = new TagMatchTest(SFTags.Blocks.NATURAL_FOLIAGE);
    private static final RuleTest SNOW_LAYER = new BlockMatchTest(Blocks.SNOW);
    private static final RuleTest GRASS = new BlockMatchTest(Blocks.GRASS);



    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BERYLLIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RDTResources.BERYLLIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RDTResources.BERYLLIUM_ORE_DEEPSLATE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BERYLLIUM_ORE = CONFIGURED_FEATURES.register("beryllium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_BERYLLIUM_ORES.get(),6)));



    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
